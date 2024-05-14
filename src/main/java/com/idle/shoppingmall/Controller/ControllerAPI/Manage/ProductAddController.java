package com.idle.shoppingmall.Controller.ControllerAPI.Manage;

import com.idle.shoppingmall.Controller.ControllerAPI.Manage.Storage.UploadImages;
import com.idle.shoppingmall.Entity.User.CustomUserDetails;
import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.RequestDTO.Product.Add.ProductAddRequest;
import com.idle.shoppingmall.ResponseDTO.Common.CommonResponse;
import com.idle.shoppingmall.Service.Product.ProductAddService;
import com.idle.shoppingmall.Service.User.UserInfoService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductAddController {
    private final UserInfoService userInfoService;
    private final ProductAddService productAddService;
    private final UploadImages uploadImages;

    @PostMapping("/api/POST/manage/productAdd")
    public ResponseEntity<CommonResponse> productAdd(@ModelAttribute ProductAddRequest request,
                                                     Authentication authentication){

        System.out.println(request.getProduct_name());
        System.out.println(request.getSizes().get(1).getSize());
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        if(user==null){
            return ResponseEntity.ok().body(new CommonResponse(666,"로그인이 필요합니다."));
        }
        Long id = productAddService.addProduct(request, user.getId());
        if(request.getImages()!=null) {
            uploadImages.productUploadImages(request.getImages(), id);
        }
        return id == null ? ResponseEntity.ok().body(new CommonResponse(600, "상품 등록 실패")) :
                ResponseEntity.ok().body(new CommonResponse(200, "상품 등록 성공"));
    }
}
