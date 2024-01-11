package com.example.demo.entities;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Entity
@Table(name = "san_pham_chi_tiet")
public class SanPhamChiTietEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ma_spct")
    private String maSPCT;

    @OneToMany(mappedBy = "sanPhamChiTietEntity")
    @JoinColumn(name = "kich_thuoc_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<KichThuocEntity> kichThuocEntityList;

    @OneToMany(mappedBy = "sanPhamChiTietEntity")
    @JoinColumn(name = "mau_sac_id")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private Collection<MauSacEntity> mauSacEntityList;

    @OneToOne
//    @JoinColumn(
//            name =
//    )
    private SanPhamEntity sanPhamEntity;

    @Column(name = "so_luong")
    private Integer soLuong;

    @Column(name = "don_gia")
    private Double donGia;

    @Column(name = "trang_thai")
    private String trangThai;
}
