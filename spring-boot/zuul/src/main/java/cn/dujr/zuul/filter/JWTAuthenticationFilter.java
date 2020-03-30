package cn.dujr.zuul.filter;

import cn.dujr.zuul.JWTUtils;
import cn.dujr.zuul.entity.JWTUser;
import cn.dujr.zuul.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private AuthenticationManager authenticationManager;

    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
        super.setFilterProcessesUrl("/login");
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
                                                HttpServletResponse response) throws AuthenticationException {

        User loginUser = null;

        // 从输入流中获取到登录的信息
        try {
            loginUser = new ObjectMapper().readValue(request.getInputStream(), User.class);

            if(loginUser == null){
                Map map = request.getParameterMap();
                loginUser.setUsername(map.get("username").toString());
                loginUser.setPassword(map.get("password").toString());
            }

            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword())
            );
        } catch (Exception e) {
            e.printStackTrace();

            if(loginUser == null){
                Map map = request.getParameterMap();
                loginUser.setUsername(map.get("username").toString());
                loginUser.setPassword(map.get("password").toString());
            }

            throw new UsernameNotFoundException("user not found");
//            return authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginUser.getUsername(), loginUser.getPassword())
//            );
//            try {
//                response.setCharacterEncoding("UTF-8");
//                response.getWriter().write("authentication failed");
//            }catch (IOException e1){
//                e.printStackTrace();
//            }
        }
    }

    // 成功验证后调用的方法
    // 如果验证成功，就生成token并返回
    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

        JWTUser jwtUser = (JWTUser) authResult.getPrincipal();
        System.out.println("jwtUser:" + jwtUser.toString());

        String role = "";
        Collection<? extends GrantedAuthority> authorities = jwtUser.getAuthorities();
        for (GrantedAuthority authority : authorities){
            role = authority.getAuthority();
        }

        String token = JWTUtils.createToken(jwtUser.getUsername(), role);
        //String token = JwtTokenUtils.createToken(jwtUser.getUsername(), false);
        // 返回创建成功的token
        // 但是这里创建的token只是单纯的token
        // 按照jwt的规定，最后请求的时候应该是 `Bearer token`
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        String tokenStr = JWTUtils.TOKEN_PREFIX + token;
        response.setHeader("token",tokenStr);
        response.getWriter().write(tokenStr);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.getWriter().write("authentication failed, reason: " + failed.getMessage());
    }
}
