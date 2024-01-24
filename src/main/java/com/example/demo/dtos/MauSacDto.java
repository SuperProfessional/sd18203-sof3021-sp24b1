package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MauSacDto {
    @NotNull
    private Integer id;
    @NotBlank
    private String ma;
    @NotBlank
    private String ten;

    private Integer trangThai;
}
