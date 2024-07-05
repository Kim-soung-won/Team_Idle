package com.idle.shoppingmall.Entity.User;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.*;

@Getter
public class OAuth2CustomUserDetails extends DefaultOAuth2User {

    private Long id;
    private String role;

    public OAuth2CustomUserDetails(Collection<? extends GrantedAuthority> authorities,
                                   Map<String, Object> attributes, String nameAttributeKey,
                                   Long id, String role) {
        super(authorities, attributes, nameAttributeKey);
        this.id = id;
        this.role = role;
    }
}
