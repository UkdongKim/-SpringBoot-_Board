package com.sergio.jwt.backend.domain.posts;

import com.sergio.jwt.backend.domain.BaseTimeEntity;
import com.sergio.jwt.backend.domain.comments.Comment;
import com.sergio.jwt.backend.domain.user.Users;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@Entity
public class Posts extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }



    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_id")
    private Users users;

    /*
     * 게시글 입장에서는 일대다 관계이다.
     * cascade 설정을 함으로써 post가 삭제될 때 함께 삭제된다.
     * */
    @OneToMany(mappedBy = "posts", cascade = CascadeType.REMOVE)
    @OrderBy("id asc")
    private List<Comment> comments;

    /*
     * 영속성 컨텍스트로 인하여 자동 업데이트
     * */
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}