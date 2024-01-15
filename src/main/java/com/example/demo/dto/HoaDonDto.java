package com.example.demo.dto;

import java.time.LocalDateTime;

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
public class HoaDonDto {

    @NotNull
    private Integer id;
    @NotNull
    private Integer nhanVienId;
    @NotNull
    private Integer khachHangId;
    private LocalDateTime ngayMuaHang;
    private Boolean trangThai;
}
