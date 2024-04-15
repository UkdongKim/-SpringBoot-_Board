package com.sergio.jwt.backend.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {
    /*보통 mybatis 에서 dao 라고 불리는 db layer 접근자
     * jpa에서는 Repository 라고 부르며 인터페이스로 생성함.
     * 생성 후 JpaRepository<Entity클래스, pk타입> 을 상속하면
     * 기본적인 crud 메소드가 자동으로 생성됨.
     * Entity클래스 와 Repository 는 같은곳에 위치해야함. 밀접한 관계
     * */

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
