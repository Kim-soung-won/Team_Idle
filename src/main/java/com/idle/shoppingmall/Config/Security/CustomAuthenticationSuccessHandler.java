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

import java.io.IOException;

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
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        System.out.println("authentication.getAuthorities() "+authentication.getAuthorities());
        String email = authentication.getName();
//        loginService.setSession(email, request.getSession());
        if(authentication.getAuthorities().toString().equals("[ROLE_MANAGER]")) response.sendRedirect("/manage");
        else response.sendRedirect("/main");
    }
}
