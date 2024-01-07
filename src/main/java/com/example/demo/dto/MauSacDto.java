package com.example.demo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class MauSacDto {
    private final Integer id;
    private final String ma;
    private final String ten;
}
