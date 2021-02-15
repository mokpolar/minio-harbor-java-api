package com.sk.airuntime.modelrepository.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter // 클래스 내 모든 필드의 Getter 메소드를 자동 생성.
@NoArgsConstructor // 기본 생성자 자동 추가. public Posts(){} 와 같은 효과.
@Entity // 테이블과 링크될 클래스임을 나타냄. 기본값으로 클래스의 카멜케이스 이름을 언더스코어 네이밍으로 테이블 이름을 매칭.
public class Posts {

    @Id // 해당 테이블의 Primary Key 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK의 생성 규칙. 스프링부트2.0에서는 IDENTITY 옵션을 추가해야만 auto_increment가 됨.
    private Long id;

    @Column(length = 500, nullable = false) // 테이블의 컬럼을 나타내며 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 컬럼이됨. 문자열은 VARCHAR(255)가 기본값.
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) // 이건 타입으 TEXT로 변경하고 싶은 경우. @Column으로 변경 가능.
    private String content;

    private String author;

    @Builder // 해당 클래스에 빌더 패턴 클래스를 생성. 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함.
    public Posts(String title, String content, String author) {

        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;

    }


}
