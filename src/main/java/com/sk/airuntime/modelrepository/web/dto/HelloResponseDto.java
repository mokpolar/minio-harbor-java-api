package com.sk.airuntime.modelrepository.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

// Data Transfer Obejct. 이 오브젝트는 보통 Getter와 Setter 만으로 구성이 되는듯.
@Getter // 선언된 모든 필드의 get 메소드를 생성해줌.
@RequiredArgsConstructor // 선언된 모든 파이널 필드가 포함된 생성자를 생성해줌. 파이널이 없는 필드는 생성자에 포함되지 않음.
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
