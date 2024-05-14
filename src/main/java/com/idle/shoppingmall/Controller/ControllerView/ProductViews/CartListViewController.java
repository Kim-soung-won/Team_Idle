package com.idle.shoppingmall.Controller.ControllerView.ProductViews;

import com.idle.shoppingmall.Entity.User.CustomUserDetails;
import com.idle.shoppingmall.ResponseDTO.Cart.CartListResponse;
import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.Service.CartService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartListViewController {
    private final CartService cartService;

    @PostMapping("/api/view/cartList")
    public ResponseEntity<List<CartListResponse>> getCartList(Authentication authentication){
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        return user == null ? ResponseEntity.ok().body(null) : ResponseEntity.ok().body(cartService.findByCartList(user.getId()));
    }
}
