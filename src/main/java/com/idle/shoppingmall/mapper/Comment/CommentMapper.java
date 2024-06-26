package com.idle.shoppingmall.mapper.Comment;

import com.idle.shoppingmall.Controller.ControllerView.ProductViews.DTO.CommentListResponse;
import com.idle.shoppingmall.Entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {

    Long saveComment(@Param("comment") Comment comment);

    List<CommentListResponse> findCommentList(@Param("id") Long id, @Param("startPage") int startPage, @Param("endPage") int endPage);

    List<String> findUrl(@Param("id") Long id);

    Integer deleteComment(@Param("id") Long id);
}
