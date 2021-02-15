package com.sk.airuntime.modelrepository.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;


public class HelloResponseDtoTest {

    @Test
    public void lombok_test(){
        //given

        String name = "test";
        int amount = 1000;

        //when
        HelloResponseDto dto = new HelloResponseDto(name, amount); // dto 객체 생성. name과 amount를 인자로 받음.

        //then Getter 가 제대로 생겼다면 getName 이라는 Getter에서 이름을 잘 갖고 오겠지? 그러니까 equal to로 비교하면 되는거지. 아래도 마찬가지.
        assertThat(dto.getName()).isEqualTo(name); // assertj라는 테스트 검증 라이브러리의 검증 메소드, 검증 대상을 인자로 받음. Getter 가 제대로 생겼음을 의미.
        assertThat(dto.getAmount()).isEqualTo(amount); // assertj의 동등 비교 메소드.

        System.out.println("테스트가 잘 수행되었습니다. ");
    }
}
