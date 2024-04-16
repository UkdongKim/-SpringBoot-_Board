//package com.sergio.jwt.backend.services;
//
//import com.sergio.jwt.backend.domain.comments.CommentRepository;
//import com.sergio.jwt.backend.domain.posts.Posts;
//import com.sergio.jwt.backend.domain.posts.PostsRepository;
//import com.sergio.jwt.backend.domain.user.Users;
//import com.sergio.jwt.backend.domain.user.UsersRepository;
//import com.sergio.jwt.backend.dtos.comment.CommentRequestDto;
//import com.sergio.jwt.backend.domain.user.User;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//@RequiredArgsConstructor
//@Service
//public class CommentService {
//
//    private final CommentRepository commentRepository;
//    private final UsersRepository usersRepository;
//    private final PostsRepository postsRepository;
//
//    // create
//    @Transactional
//    public Long commentSave(Long memberId, Long postId, CommentRequestDto dto){
//
//        User users = usersRepository.findById(memberId).orElseThrow(()->
//                new IllegalArgumentException("댓글 쓰기 실패 : 존재 하지 않는 회원입니다."));
//        Posts posts = postsRepository.findById(postId).orElseThrow(()->
//                new IllegalArgumentException("댓글 쓰기 실패 : 해당 게시글이 존재하지 않습니다."));
//
//
//
//    }
//}
