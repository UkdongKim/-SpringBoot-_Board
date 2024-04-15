package com.sergio.jwt.backend.dtos.comment;

import com.sergio.jwt.backend.domain.comments.Comment;
import lombok.Getter;

@Getter
public class CommentResponseDto {

    private Long id;
    private String comment;
    private String nickname;
    private Long postsId;

    // Entity -> Dto
    public CommentResponseDto(Comment comment){
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.nickname = comment.getUsers().getName();
        this.postsId = comment.getPosts().getId();
    }

}
