package cn.dujr.zuul.entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JWTUser extends User implements UserDetails {

    private Collection<? extends GrantedAuthority> authorities;

//    public JWTUser(User user) {
//        this.id = user.getId();
//        this.username = user.getUsername();
//        this.password = user.getPassword();
//        authorities = Collections.singleton(new SimpleGrantedAuthority(user.getRole()));
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List list = new ArrayList();
        list.add(new SimpleGrantedAuthority(this.getRole()));
        return list;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
