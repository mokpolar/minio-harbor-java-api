package com.sk.airuntime.modelrepository.web.dto;

import com.sk.airuntime.modelrepository.domain.posts.Posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor // 기본 생성자 자동 추가. public Posts(){} 와 같은 효과.
public class PostsSaveRequestDto {

    // Entity 클래스와 거의 유사한 형태이지만 Dto 클래스를 추가로 생성.
    // 절대로 Entity 클래스를 Request/Response 클래스로 사용해서는 안됨

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestDto(String title, String content, String author){

        this.title = title;
        this.content = content;
        this.author = author;
    }
// Posts가 Entity의 역할을 하니,
// Entity 는 데이터 베이스와 맞닿은 핵심 클래스이며, 그를 기준으로 테이블이 생성되고, 스키마가 변경.
// 화면 변경은 사소한 변경인데 이를 위해 Entity Class 를 변경하는 건 너무 큼.
    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }

}
