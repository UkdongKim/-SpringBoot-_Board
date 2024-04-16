package com.sergio.jwt.backend.dtos.post;

import com.sergio.jwt.backend.domain.posts.Posts;
//import com.sergio.jwt.backend.dtos.comment.CommentResponseDto;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PostsResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
//    private List<CommentResponseDto> comments;

    public PostsResponseDto(Posts entity) {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
//        this.comments = entity.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}
