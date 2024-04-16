//package com.sergio.jwt.backend.domain.comments;
//
//import com.sergio.jwt.backend.domain.BaseTimeEntity;
//import com.sergio.jwt.backend.domain.posts.Posts;
//import com.sergio.jwt.backend.domain.user.User;
//import jakarta.persistence.*;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//
//@Builder
//@AllArgsConstructor
//@NoArgsConstructor
//@Getter
//@Entity
//@Table(name = "comments")
//public class Comment extends BaseTimeEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @Column(columnDefinition = "TEXT", nullable = false)
//    private String comment;
//
//    @ManyToOne
//    @JoinColumn(name = "posts_id")
//    private Posts posts;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;
//}
