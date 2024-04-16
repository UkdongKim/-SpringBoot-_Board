package com.sergio.jwt.backend.dtos.post;

import com.sergio.jwt.backend.domain.posts.Posts;
import com.sergio.jwt.backend.dtos.comment.CommentResponseDto;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostsListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;
    private List<CommentResponseDto> comments;

    public PostsListResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
        this.comments = entity.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());

    }
}
