//package com.sergio.jwt.backend.dtos.comment;
//
//import com.sergio.jwt.backend.domain.comments.Comment;
//import com.sergio.jwt.backend.domain.posts.Posts;
//import com.sergio.jwt.backend.domain.user.User;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Builder
//public class CommentRequestDto {
//
//    private Long id;
//    private String comment;
//
//    private User user;
//    private Posts posts;
//
//
//    // Dto -> Entity
//    public Comment toEntity(){
//        Comment comments = Comment.builder()
//                .id(id)
//                .comment(comment)
//                .user(user)
//                .posts(posts)
//                .build();
//
//        return comments;
//    }
//}
