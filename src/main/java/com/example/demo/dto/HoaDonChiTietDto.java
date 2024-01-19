package com.example.demo.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HoaDonChiTietDto {

    @NotNull
    private Integer id;
    @NotNull
    private Integer HoaDonId;
    @NotNull
    private Integer SPCTId;
    @NotNull
    private Integer soLuong;
    @NotNull
    private Float donGia;
    private Boolean trangThai;
}
