package com.idle.shoppingmall.Controller.ControllerAPI;


import com.idle.shoppingmall.Entity.Key.LoveKey;
import com.idle.shoppingmall.Entity.Love;
import com.idle.shoppingmall.Entity.Product.Product;
import com.idle.shoppingmall.Entity.User.CustomUserDetails;
import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.Entity.User.UserLog;
import com.idle.shoppingmall.RequestDTO.Love.LoveAddRequest;
import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import com.idle.shoppingmall.Service.LoveService;
import com.idle.shoppingmall.Service.Product.ProductService;
import com.idle.shoppingmall.Service.User.UserLogService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class LoveController {

    private final LoveService loveService;
    private final ProductService productService;
    private final UserLogService userLogService;

    @PostMapping("/api/POST/addLove")
    public ResponseEntity<CommonResponse> AddLove(@RequestBody @Valid LoveAddRequest request,
                                                  Authentication authentication){
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();

        if (user == null) {
            return ResponseEntity.ok().body(new CommonResponse(666,"좋아요는 로그인이 필요합니다."));
        }

        Product product = productService.findById(request.getProduct_id());
        if (product == null) {
            return ResponseEntity.ok().body(new CommonResponse(500,"존재하지 않는 상품입니다."));
        }

        LoveKey loveKey = new LoveKey(request.getProduct_id(), user.getId());
        Love love = loveService.findLove(loveKey);

        if (love == null) {
            // 좋아요 추가 로직
            loveService.addLove(Love.builder()
                    .product_id(request.getProduct_id())
                    .created_who(user.getId())
                    .created_at(LocalDateTime.now())
                    .build());
            userLogService.insertUserLog(UserLog.builder()
                    .created_who(user.getId())
                    .name(user.getName())
                    .created_at(LocalDateTime.now())
                    .doit("LOVE")
                    .product_id(request.getProduct_id())
                    .build());
            return ResponseEntity.ok().body(new CommonResponse(200,"좋아요!!"));
        } else {
            // 좋아요 취소 로직
            loveService.delLove(love);
            return ResponseEntity.ok().body(new CommonResponse(200,"좋아요를 취소했습니다."));
        }
    }
}
