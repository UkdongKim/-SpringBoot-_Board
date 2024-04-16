package com.sergio.jwt.backend.controllers;

import com.sergio.jwt.backend.config.UserAuthenticationProvider;
import com.sergio.jwt.backend.domain.user.User;
import com.sergio.jwt.backend.dtos.comment.CommentRequestDto;
import com.sergio.jwt.backend.services.CommentService;
import com.sergio.jwt.backend.services.UserService;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.Comments;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class CommentController {

    private final CommentService commentService;
    private final UserAuthenticationProvider userAuthenticationProvider;


//    댓글 생성
    @PostMapping("/posts/comments")
    public ResponseEntity commentSave(
                                      @RequestBody CommentRequestDto commentRequestDto,
                                      @RequestHeader("Authorization") String token
                                      ){
        return ResponseEntity.ok(commentService.commentSave(token.replace("Bearer ", ""), commentRequestDto));

    }
}
