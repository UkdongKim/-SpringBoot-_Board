package com.sergio.jwt.backend.dtos.comment;

import com.sergio.jwt.backend.domain.comments.Comment;
import com.sergio.jwt.backend.domain.posts.Posts;
import com.sergio.jwt.backend.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {

    private Long postId;
    private String comment;
    private User user;
    private Posts posts;

    // Dto -> Entity
    public Comment toEntity(){
        Comment comments = Comment.builder()
                .comment(comment)
                .user(user)
                .posts(posts)
                .build();

        return comments;
    }
}
