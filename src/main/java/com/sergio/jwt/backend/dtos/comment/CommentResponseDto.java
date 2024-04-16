package com.sergio.jwt.backend.dtos.comment;

import com.sergio.jwt.backend.domain.comments.Comment;
import lombok.Getter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
public class CommentResponseDto {

    private Long id;
    private String comment;

    private LocalDateTime createdDate;
    private LocalDateTime modifiedDate;


    private String loginId;
    private Long postsId;

    // Entity -> Dto
    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.createdDate = comment.getCreatedDate();
        this.modifiedDate = comment.getModifiedDate();
        this.loginId = comment.getUser().getLogin();
        this.postsId = comment.getPosts().getId();
    }

}
