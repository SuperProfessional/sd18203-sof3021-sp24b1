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
public class NhanVienDto {
    @NotNull
    private Integer id;
    @NotBlank
    private String ten;
    @NotBlank
    private String maNV;
    @NotBlank
    private String tenDangNhap;
    @NotBlank
    private String matKhau;
    private Boolean trangThai;
}
