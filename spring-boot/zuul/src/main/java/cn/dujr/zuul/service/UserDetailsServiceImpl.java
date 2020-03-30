package cn.dujr.zuul.service;

import cn.dujr.zuul.entity.JWTUser;
import cn.dujr.zuul.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if("admin".equals(username)) {
            JWTUser user = new JWTUser();
            user.setId("1");
            user.setUsername(username);
            user.setPassword(new BCryptPasswordEncoder().encode("123456"));
            user.setRole("myRole");
            return user;
        }else{
            return null;
//            throw new UsernameNotFoundException("admin account access only!");
        }
    }
}
