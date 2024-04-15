package com.sergio.jwt.backend.dtos.comment;

import com.sergio.jwt.backend.domain.comments.Comment;
import com.sergio.jwt.backend.domain.posts.Posts;
import com.sergio.jwt.backend.domain.user.Users;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {

    private Long id;
    private String comment;

    private Users users;
    private Posts posts;


    // Dto -> Entity
    public Comment toEntity(){
        Comment comments = Comment.builder()
                .id(id)
                .comment(comment)
                .users(users)
                .posts(posts)
                .build();

        return comments;
    }
}
