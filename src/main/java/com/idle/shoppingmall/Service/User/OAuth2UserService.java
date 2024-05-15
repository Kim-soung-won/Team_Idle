package com.idle.shoppingmall.Service.User;

import com.idle.shoppingmall.Config.Security.PrincipalDetail;
import com.idle.shoppingmall.Entity.User.OAuth2CustomUserDetails;
import com.idle.shoppingmall.Entity.User.UserAccount;
import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.mapper.User.UserAccountMapper;
import com.idle.shoppingmall.mapper.User.UserInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class OAuth2UserService extends DefaultOAuth2UserService {

    private final UserAccountMapper userAccountMapper;
    private final UserInfoMapper userInfoMapper;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        String email = (String) super.loadUser(userRequest).getAttributes().get("email");
        String name = (String) super.loadUser(userRequest).getAttributes().get("sub");

        OAuth2User oAuth2User = super.loadUser(userRequest);

        Map<String, Object> attributes = oAuth2User.getAttributes();

        // Additional details like id and role can be added here\
        UserAccount user = isExist(email, name);
        String nickname = userInfoMapper.getUserInfoById(user.getUser_id()).getName();

        return new PrincipalDetail(user, attributes,nickname);
    }

    @Transactional
    public UserAccount isExist(String email, String name) {
        UserAccount user = userAccountMapper.getUserByEmail(email);
        if(user == null){
            userAccountMapper.saveUserAccount(UserAccount.builder()
                    .user_email(email)
                    .user_password(new BCryptPasswordEncoder().encode(name))
                    .user_role(UserAccount.UserRole.USER)
                    .user_pnum("010-0000-0000")
                    .build());
            user = userAccountMapper.getUserByEmail(email);
        }
        return user;
    }
}