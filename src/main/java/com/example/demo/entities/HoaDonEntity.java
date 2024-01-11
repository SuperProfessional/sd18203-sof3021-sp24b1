package com.example.demo.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "hoa_don")
public class HoaDonEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nhan_vien_id")
    @ManyToOne
    private NhanVienEntity nhanVienEntity;

    @Column(name = "khac_hang_id")
    @ManyToOne
    private KhachHangEntity khachHangEntity;

    @Column(name = "ngay_mua_hang")
    private LocalDateTime ngayMuaHang;

    @Column(name = "trang_thai")
    private String trangThai;
}
