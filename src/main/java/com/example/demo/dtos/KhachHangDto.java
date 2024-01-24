package com.example.demo.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KhachHangDto {
    @NotNull
    private Integer id;
    @NotBlank
    private String ten;
    @NotBlank
    private String sdt;
    @NotBlank
    private String maKH;
    private Boolean trangThai;
}
