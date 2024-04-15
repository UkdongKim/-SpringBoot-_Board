package com.sergio.jwt.backend.controllers;

import com.sergio.jwt.backend.dtos.post.PostsListResponseDto;
import com.sergio.jwt.backend.dtos.post.PostsResponseDto;
import com.sergio.jwt.backend.dtos.post.PostsSaveRequestDto;
import com.sergio.jwt.backend.dtos.post.PostsUpdateRequestDto;
import com.sergio.jwt.backend.services.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    /**
     * 전체 게시글 조회
     * */
    @GetMapping("/api/v1/posts")
    public ResponseEntity<List<PostsListResponseDto>> findAll(){
        List<PostsListResponseDto> postsList = postsService.findAllDesc();
        return ResponseEntity.ok().body(postsList);
    }

    /**
     * 게시글 저장
     * */
    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);
    }



    /**
     * 특정 게시글 조회
     * */
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }


    /**
     * 특정 게시글 수정
     * */
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }


    /**
     * 특정 게시글 삭제
     * */
    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

}