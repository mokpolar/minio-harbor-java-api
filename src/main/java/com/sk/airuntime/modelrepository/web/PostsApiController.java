package com.sk.airuntime.modelrepository.web;

import com.sk.airuntime.modelrepository.service.PostsService;
import com.sk.airuntime.modelrepository.web.dto.PostsResponseDto;
import com.sk.airuntime.modelrepository.web.dto.PostsSaveRequestDto; // 확인 필요.

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }
}
