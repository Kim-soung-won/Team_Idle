package com.idle.shoppingmall.mapper;


import com.idle.shoppingmall.Entity.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ProductMapper {

    void saveProduct(@Param("product")Product productDTO);

    Product findById(Long productId);
} // end interface
