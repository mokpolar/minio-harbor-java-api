package com.sk.airuntime.modelrepository.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class) // 테스틀를 진행할 때 JUnit에 내장된 실행자 외에 다른 실행자를 실행
// 여기서는 SpringRunner 라는 스프링 실행자를 사용
// 즉 스프링 부트 테스트와 JUnit 사이에 연결자 역할을 함.
@WebMvcTest(controllers = HelloController.class) // 스프링 어노테이션 중 Web(Spring MVC)에 집중할 수 있는 어노테이션
public class HelloControllerTest {
//선언시 @Controller @ControllerAdvice 등을 사용 가능
    @Autowired // 스프링이 관리하는 빈 (BEAN)을 주입 받음.
    private MockMvc mvc; // 웹 API를 테스트. 스프링 MVC 테스트의 시작점. 이 클래스로 HTTP GET POST API 테스트

    @Test
    public void A_return() throws Exception {
        String hello = "hello is returned";

        mvc.perform(get("/hello"))// MockMvc를 통해 heello 주소로 HTTP GET 요청, 체이닝이 지원되어 연속 가능
                .andExpect(status().isOk()) // mvc.perform의 결과 검증. HTTP Header의 Status를 검증. 200..
                .andExpect(content().string(hello)); // mvc.perform의 결과를 검증. 응답 본문의 내용을 검증. Controller에서 Hello를 리턴하기 때문에 이 값 검증.
    }

    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                .param("name", name) // param API 테스트할 때 사용될 요청 파라미터를 설정. 단, 값은 String만 허용.
                .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) // jsonPath는 JSON응답값을 필드별로 검증할 수 있는 메소드. $를 기준으로 필드명을 명시. 여기서는 name과 ㅁmount
        .andExpect(jsonPath("$.amount", is(amount)));

        System.out.println("hellodto 테스트 완료");



    }
}
