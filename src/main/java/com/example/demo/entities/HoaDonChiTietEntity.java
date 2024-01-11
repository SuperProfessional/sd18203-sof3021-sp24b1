package com.example.demo.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table
public class HoaDonChiTietEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(
            name = "hoa_don_id",
            referencedColumnName = "id"
    )
    private HoaDonEntity hoaDonEntity;

    @OneToOne
    @JoinColumn(
            name = "spct_id",
            referencedColumnName = "id"
    )
    private SanPhamChiTietEntity sanPhamChiTietEntity;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "don_gia")
    private Double donGia;

    @Column(name = "trang_thai")
    private String trangThai;
}
