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
        HelloResponseDto dto = new HelloResponseDto(name, amount);

        //then
        assertThat(dto.getName()).isEqualTo(name); // 자동으로 lombok을 이용해 어노테이션으로 Getter를 생성하는지 확인하는 테스트
        assertThat(dto.getAmount()).isEqualTo(amount);

        System.out.println("테스트가 잘 수행되었습니다. ");
    }
}
