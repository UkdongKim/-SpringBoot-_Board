//package com.sergio.jwt.backend.controllers;
//
//import com.sergio.jwt.backend.dtos.comment.CommentRequestDto;
//import com.sergio.jwt.backend.services.CommentService;
//import lombok.RequiredArgsConstructor;
//import org.hibernate.annotations.Comments;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RequiredArgsConstructor
//@RestController
//public class CommentController {
//
//    private final CommentService commentService;
//
//
////    댓글 생성
//    @PostMapping("/posts/{id}/comments")
//    public ResponseEntity commentSave(Long memberId,
//                                      @PathVariable Long postId,
//                                      @RequestBody CommentRequestDto dto
//                                      ){
//        return ResponseEntity.ok(commentService.commentSave(memberId,, dto));
//
//    }
//
//}
