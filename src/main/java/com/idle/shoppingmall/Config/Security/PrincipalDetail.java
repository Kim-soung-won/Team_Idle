package com.idle.shoppingmall.Config.Security;


import com.idle.shoppingmall.Entity.User.UserAccount;
import com.idle.shoppingmall.Entity.User.UserInfo;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
public class PrincipalDetail implements UserDetails, OAuth2User {

    private UserAccount user;
    private Map<String, Object> attributes;
    private String name;

    //일반 로그인
    public PrincipalDetail(UserAccount user, String name) {
        this.user = user;
        this.name = name;
    }

    //OAuth 로그인
    public PrincipalDetail(UserAccount user, Map<String, Object> attributes, String name) {
        this.user = user;
        this.attributes = attributes;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> collect = new ArrayList<>();
        collect.add(new GrantedAuthority() {
            @Override
            public String getAuthority() {
                return "ROLE_"+user.getUser_role().toString();
            }
        });
        return collect;
    }

    @Override
    public String getPassword() {
        return this.user.getUser_password();
    }

    @Override
    public String getUsername() {
        return this.user.getUser_email();
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
