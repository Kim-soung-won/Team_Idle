package com.idle.shoppingmall.Service.User;

import com.idle.shoppingmall.Config.Security.PrincipalDetail;
import com.idle.shoppingmall.Entity.User.CustomUserDetails;
import com.idle.shoppingmall.Entity.User.UserAccount;
import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.mapper.User.UserAccountMapper;
import com.idle.shoppingmall.mapper.User.UserInfoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailService implements UserDetailsService {

    private final UserAccountMapper userAccountMapper;
    private final UserInfoMapper userInfoMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount user = userAccountMapper.getUserByEmail(username);
        UserInfo userInfo = userInfoMapper.getUserInfoById(user.getUser_id());
        System.out.println("user = " + user.getUser_role().toString());
        //User = Security에서 제공해주는 객체
        return new PrincipalDetail(user, userInfo.getName());
    }
}
