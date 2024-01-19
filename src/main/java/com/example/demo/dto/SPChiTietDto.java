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
public class SPChiTietDto {

    @NotNull
    private Integer id;
    @NotNull
    private String maSPCT;
    @NotNull
    private Integer khichThuocId;
    @NotNull
    private Integer mauSacId;
    @NotNull
    private Integer sanPhamId;
    @NotNull
    private Integer soLuong;
    @NotNull
    private Float donGia;
    private Boolean trangThai;
}
