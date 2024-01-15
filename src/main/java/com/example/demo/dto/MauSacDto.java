package com.example.demo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MauSacDto {
    @NotNull
    private Integer id;
    @NotBlank
    private String ma;
    @NotBlank
    private String ten;
    private Boolean trangThai;
}
