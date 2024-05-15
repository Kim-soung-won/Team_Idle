package com.idle.shoppingmall.Config.Security;

import com.idle.shoppingmall.Entity.User.CustomUserDetails;
import com.idle.shoppingmall.Service.LoginService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private final LoginService loginService;
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        System.out.println("login 성공");
        response.setStatus(HttpServletResponse.SC_OK);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("{\"success\": true}");
        System.out.println("Just Principal : "+ authentication.getPrincipal().getClass());
        System.out.println("authentication.getAuthorities() "+authentication.getAuthorities());
//        loginService.setSession(email, request.getSession());
        System.out.println("role :: :: "+authentication.getAuthorities().toString());
        List<String> authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)  // GrantedAuthority 객체에서 권한 문자열을 추출
                .toList();  // List<String> 형태로 변환
        if(authorities.contains("ROLE_MANAGER")) response.sendRedirect("/manage");
        else response.sendRedirect("/main");
    }
}
