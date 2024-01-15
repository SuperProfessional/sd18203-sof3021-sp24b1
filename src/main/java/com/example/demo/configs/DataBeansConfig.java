package com.example.demo.configs;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.dto.HoaDonDto;
import com.example.demo.dto.KhachHangDto;
import com.example.demo.dto.NhanVienDto;
import com.example.demo.dto.SanPhamDto;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class DataBeansConfig {

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    List<NhanVienDto> dataNhanVienDto(){

        List<NhanVienDto> nhanVienDtoList = new ArrayList<>();
        nhanVienDtoList.add(new NhanVienDto(1, "Nguyen Hoan", "PH17070","hoannvph17079","1234",Boolean.TRUE));
        nhanVienDtoList.add(new NhanVienDto(2, "Nguyen Hoan", "PH17071","hoannvph17079","1234",Boolean.TRUE));
        nhanVienDtoList.add(new NhanVienDto(3, "Nguyen Hoan", "PH17072","hoannvph17079","1234",Boolean.TRUE));
        nhanVienDtoList.add(new NhanVienDto(4, "Nguyen Hoan", "PH17073","hoannvph17079","1234",Boolean.TRUE));
        nhanVienDtoList.add(new NhanVienDto(5, "Nguyen Hoan", "PH17074","hoannvph17079","1234",Boolean.TRUE));

        return nhanVienDtoList;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    List<KhachHangDto> dataKhachHangDto(){

        List<KhachHangDto> khachHangDtoList = new ArrayList<>();
        khachHangDtoList.add(new KhachHangDto(1, "Nguyen Hoan", "0961496837","PH17079",Boolean.TRUE));
        khachHangDtoList.add(new KhachHangDto(2, "Nguyen Hoan", "0961496837","PH27079",Boolean.TRUE));
        khachHangDtoList.add(new KhachHangDto(3, "Nguyen Hoan", "0961496837","PH37079",Boolean.TRUE));
        khachHangDtoList.add(new KhachHangDto(4, "Nguyen Hoan", "0961496837","PH47079",Boolean.TRUE));
        khachHangDtoList.add(new KhachHangDto(5, "Nguyen Hoan", "0961496837","PH57079",Boolean.TRUE));

        return khachHangDtoList;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    List<SanPhamDto> dataSanPhamDto(){

        List<SanPhamDto> sanPhamDtoList = new ArrayList<>();
        sanPhamDtoList.add(new SanPhamDto(1, "MS01", "Ao",Boolean.TRUE));
        sanPhamDtoList.add(new SanPhamDto(2, "MS02", "Quan",Boolean.TRUE));
        sanPhamDtoList.add(new SanPhamDto(3, "MS03", "Vay",Boolean.TRUE));
        sanPhamDtoList.add(new SanPhamDto(4, "MS04", "Giay",Boolean.TRUE));
        sanPhamDtoList.add(new SanPhamDto(5, "MS05", "Dep",Boolean.TRUE));

        return sanPhamDtoList;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    List<HoaDonDto> dataHoaDonDto(){

        List<HoaDonDto> hoaDonDtoList = new ArrayList<>();
        hoaDonDtoList.add(new HoaDonDto(1, 1, 1, LocalDateTime.now(),Boolean.TRUE));
        hoaDonDtoList.add(new HoaDonDto(2, 2, 2,LocalDateTime.now(),Boolean.TRUE));
        hoaDonDtoList.add(new HoaDonDto(3, 3, 3,LocalDateTime.now(),Boolean.TRUE));

        return hoaDonDtoList;
    }
}
