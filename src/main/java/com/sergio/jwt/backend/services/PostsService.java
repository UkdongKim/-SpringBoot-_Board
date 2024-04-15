package com.sergio.jwt.backend.services;

import com.sergio.jwt.backend.domain.posts.Posts;
import com.sergio.jwt.backend.domain.posts.PostsRepository;
import com.sergio.jwt.backend.dtos.post.PostsListResponseDto;
import com.sergio.jwt.backend.dtos.post.PostsResponseDto;
import com.sergio.jwt.backend.dtos.post.PostsSaveRequestDto;
import com.sergio.jwt.backend.dtos.post.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostsService {
    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id = " + id));

        /*
         * 영속성 컨텍스트로 업데이트 처리하기!
         * */
        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new
                        IllegalArgumentException("해당 게시글이 없습니다. id = " + id));
        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 글이 없습니다. id =" + id));

        postsRepository.delete(posts);
    }
}
