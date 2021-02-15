package com.sk.airuntime.modelrepository.service;

import com.sk.airuntime.modelrepository.domain.posts.PostsRepository;
import com.sk.airuntime.modelrepository.web.dto.PostsResponseDto;
import com.sk.airuntime.modelrepository.web.dto.PostsSaveRequestDto; // 확인필요


import com.sk.airuntime.modelrepository.domain.posts.Posts; // 확인필요

import com.sk.airuntime.modelrepository.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return id;
    }

    public PostsResponseDto findById (Long id) {
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id= " + id));

        return new PostsResponseDto(entity);
    }
}

