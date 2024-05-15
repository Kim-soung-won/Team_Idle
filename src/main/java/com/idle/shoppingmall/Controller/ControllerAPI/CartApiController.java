package com.idle.shoppingmall.Controller.ControllerAPI;


import com.idle.shoppingmall.Config.Security.PrincipalDetail;
import com.idle.shoppingmall.Entity.Cart;
import com.idle.shoppingmall.Entity.Key.CartKey;
import com.idle.shoppingmall.Entity.Product.ProductDetail;
import com.idle.shoppingmall.Entity.User.CustomUserDetails;
import com.idle.shoppingmall.Entity.User.UserInfo;
import com.idle.shoppingmall.RequestDTO.Cart.CartAddRequest;
import com.idle.shoppingmall.RequestDTO.Cart.CartDeleteRequest;
import com.idle.shoppingmall.RequestDTO.Cart.CartListRequest;
import com.idle.shoppingmall.ResponseDTO.Cart.CartAddResponse;
import com.idle.shoppingmall.ResponseDTO.Cart.CartDeleteResponse;
import com.idle.shoppingmall.Service.CartService;
import com.idle.shoppingmall.Service.Product.ProductDetailService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CartApiController {

    private final CartService cartService;
    private final ProductDetailService productDetailService;

    @PostMapping("/api/POST/addCart")
    public ResponseEntity<CartAddResponse> addCart(@RequestBody @Valid CartAddRequest request,
                                                   Authentication authentication) {
        PrincipalDetail user = (PrincipalDetail) authentication.getPrincipal();
        if(user==null){
            return ResponseEntity.ok().body(new CartAddResponse(666, "로그인이 필요합니다.", null));
        }
        ProductDetail productDetail =  productDetailService.findDetail(request.getProduct_id(), request.getSize());
        if(productDetail == null){
            return ResponseEntity.ok().body(new CartAddResponse(400, "상품이 없습니다.", request.getProduct_id()));
        }
        CartKey key = new CartKey(user.getUser().getUser_id(), request.getProduct_id(), request.getSize());
        Cart cart = cartService.findCart(key);
        if(cart == null){
            cartService.addCart(Cart.builder()
                    .created_who(user.getUser().getUser_id())
                    .product_id(request.getProduct_id())
                    .size(request.getSize())
                    .count(request.getCount())
                    .build());
            return ResponseEntity.ok().body(new CartAddResponse(200, "장바구니 등록에 성공했습니다.", request.getProduct_id()));
        }
        cart.updateCount(request.getCount());
        cartService.updateCart(cart);
        return ResponseEntity.ok().body(new CartAddResponse(200, "수량이 더해졌습니다.", request.getProduct_id()));
    } // addCart


    @PostMapping("/api/DELETE/Cart")
    public ResponseEntity<CartDeleteResponse> delCart(@RequestParam Long id, @RequestParam String size,
                                                      Authentication authentication){

        PrincipalDetail user = (PrincipalDetail) authentication.getPrincipal();

        if(user==null){
            return ResponseEntity.ok().body(new CartDeleteResponse(700, "로그인이 필요합니다.", null));
        } // if

        CartKey key = new CartKey(user.getUser().getUser_id(), id, size);
        Cart cart = cartService.findCart(key);

        if(cart == null) {
            return ResponseEntity.ok().body(new CartDeleteResponse(400,"상품이 없습니다.", id));
        } // if

        cartService.deleteCart(cart);

        return ResponseEntity.ok().body(new CartDeleteResponse(200, "장바구니에서 삭제했습니다.", id));

    } // delCart

    //장바구니 리스트
//    @PostMapping("/api/POST/cartLest")
//    public ResponseEntity<List<Cart>> getCartList(@RequestBody @Valid CartListRequest request) {
//        List<Cart> list = cartService.findByCartList(request.getCreated_who());
//        return ResponseEntity.ok().body(list);
//    }


} // end class
