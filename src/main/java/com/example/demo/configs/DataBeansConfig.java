//package com.example.demo.configs;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//
//import com.example.demo.dtos.HoaDonDto;
//import com.example.demo.dtos.KhachHangDto;
//import com.example.demo.dtos.MauSacDto;
//import com.example.demo.dtos.NhanVienDto;
//import com.example.demo.dtos.SanPhamDto;
//import org.springframework.beans.factory.config.ConfigurableBeanFactory;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;
//
//@Configuration
//public class DataBeansConfig {
//
//    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    List<MauSacDto> dataMauSacDto(){
//
//        List<MauSacDto> mauSacDtoList = new ArrayList<>();
////        mauSacDtoList.add(new MauSacDto(1, "#FF0000", "White",Boolean.TRUE));
////        mauSacDtoList.add(new MauSacDto(2, "#00008B", "Black",Boolean.TRUE));
////        mauSacDtoList.add(new MauSacDto(3, "00FF00", "Green",Boolean.TRUE));
////        mauSacDtoList.add(new MauSacDto(4, "FF00FF", "Olive",Boolean.TRUE));
////        mauSacDtoList.add(new MauSacDto(5, "ADD8E6", "Orange",Boolean.TRUE));
//
//        return mauSacDtoList;
//    }
//
//    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    List<NhanVienDto> dataNhanVienDto(){
//
//        List<NhanVienDto> nhanVienDtoList = new ArrayList<>();
//        nhanVienDtoList.add(new NhanVienDto(1, "Nguyen Hoan", "NV01","hoannvph17079","1234",Boolean.TRUE));
//        nhanVienDtoList.add(new NhanVienDto(2, "Nguyen Hoan", "NV02","hoannvph17079","1234",Boolean.TRUE));
//        nhanVienDtoList.add(new NhanVienDto(3, "Nguyen Hoan", "NV03","hoannvph17079","1234",Boolean.TRUE));
//        nhanVienDtoList.add(new NhanVienDto(4, "Nguyen Hoan", "NV04","hoannvph17079","1234",Boolean.TRUE));
//        nhanVienDtoList.add(new NhanVienDto(5, "Nguyen Hoan", "NV05","hoannvph17079","1234",Boolean.TRUE));
//
//        return nhanVienDtoList;
//    }
//
//    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    List<KhachHangDto> dataKhachHangDto(){
//
//        List<KhachHangDto> khachHangDtoList = new ArrayList<>();
//        khachHangDtoList.add(new KhachHangDto(1, "Nguyen Hoan", "0961496837","KH01",Boolean.TRUE));
//        khachHangDtoList.add(new KhachHangDto(2, "Nguyen Hoan", "0961496837","KH02",Boolean.TRUE));
//        khachHangDtoList.add(new KhachHangDto(3, "Nguyen Hoan", "0961496837","KH03",Boolean.TRUE));
//        khachHangDtoList.add(new KhachHangDto(4, "Nguyen Hoan", "0961496837","KH04",Boolean.TRUE));
//        khachHangDtoList.add(new KhachHangDto(5, "Nguyen Hoan", "0961496837","KH05",Boolean.TRUE));
//
//        return khachHangDtoList;
//    }
//
//    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    List<SanPhamDto> dataSanPhamDto(){
//
//        List<SanPhamDto> sanPhamDtoList = new ArrayList<>();
//        sanPhamDtoList.add(new SanPhamDto(1, "MS01", "Ao",Boolean.TRUE));
//        sanPhamDtoList.add(new SanPhamDto(2, "MS02", "Quan",Boolean.TRUE));
//        sanPhamDtoList.add(new SanPhamDto(3, "MS03", "Vay",Boolean.TRUE));
//        sanPhamDtoList.add(new SanPhamDto(4, "MS04", "Giay",Boolean.TRUE));
//        sanPhamDtoList.add(new SanPhamDto(5, "MS05", "Dep",Boolean.TRUE));
//
//        return sanPhamDtoList;
//    }
//
//    @Bean
//    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//    List<HoaDonDto> dataHoaDonDto(){
//
//        List<HoaDonDto> hoaDonDtoList = new ArrayList<>();
//        hoaDonDtoList.add(new HoaDonDto(1, 1, 1, LocalDateTime.now(),Boolean.TRUE));
//        hoaDonDtoList.add(new HoaDonDto(2, 2, 2,LocalDateTime.now(),Boolean.TRUE));
//        hoaDonDtoList.add(new HoaDonDto(3, 3, 3,LocalDateTime.now(),Boolean.TRUE));
//
//        return hoaDonDtoList;
//    }
//}
