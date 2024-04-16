package com.sergio.jwt.backend.services;

import com.sergio.jwt.backend.config.UserAuthenticationProvider;
import com.sergio.jwt.backend.domain.comments.Comment;
import com.sergio.jwt.backend.domain.comments.CommentRepository;
import com.sergio.jwt.backend.domain.posts.Posts;
import com.sergio.jwt.backend.domain.posts.PostsRepository;
import com.sergio.jwt.backend.domain.user.UsersRepository;
import com.sergio.jwt.backend.dtos.comment.CommentRequestDto;
import com.sergio.jwt.backend.domain.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UsersRepository usersRepository;
    private final PostsRepository postsRepository;
    private final UserAuthenticationProvider userAuthenticationProvider;

    // create
    @Transactional
    public ResponseEntity commentSave(String token, CommentRequestDto dto) {

        try {
        User user = userAuthenticationProvider.findUserByToken(token);
        Posts post = postsRepository.findById(dto.getPostId()).orElseThrow(() ->
                new IllegalArgumentException("댓글 쓰기 실패 : 해당 게시글이 존재하지 않습니다."));

        dto.setUser(user);
        dto.setPosts(post);
        Comment comment = dto.toEntity();
        commentRepository.save(comment);

        return ResponseEntity.ok("댓글 작성 성공!");
    } catch (IllegalArgumentException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        }
    }
}
