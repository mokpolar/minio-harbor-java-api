package com.sk.airuntime.modelrepository.domain.posts;


import org.springframework.data.jpa.repository.JpaRepository;

// 보통 ibatis 나 MyBatis 등에서 Dao 라고 부르는 DB Layer 접근자.
// JPA에서는 Repository 라고 부르고 인터페이스로 생성.
// 단순 인터페이스 생성 후, JpaRepository<Entity 클래스, PK타입>를 상속하면 기본 CRUD 메소드가 자동으로 생성.
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
