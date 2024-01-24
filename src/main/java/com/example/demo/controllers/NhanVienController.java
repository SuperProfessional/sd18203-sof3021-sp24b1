package com.example.demo.controllers;

import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.demo.dtos.NhanVienDto;
import com.example.demo.entities.NhanVienEntity;
import com.example.demo.repositories.NhanVienRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller()
@RequestMapping(value = "/nhan-vien")
@RequiredArgsConstructor
public class NhanVienController {

    private final NhanVienRepository nhanVienRepository;

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("nhanVienList",
                this.nhanVienRepository.findAll()
                        .stream()
                        .map(
                                entity -> NhanVienDto.builder()
                                        .id(entity.getId())
                                        .ten(entity.getTen())
                                        .maNV(entity.getMa())
                                        .tenDangNhap(entity.getTenDangNhap())
                                        .matKhau(entity.getMatKhau())
                                        .trangThai(entity.getTrangThai())
                                        .build()
                        )
                .collect(Collectors.toList())
        );
        return "admin/ql-nhan-vien/index";
    }

    @GetMapping(value = "/show/{id}")
    @ResponseBody
    public String show(@PathVariable(name = "id") Integer id) {

        NhanVienDto nhanVienDto =
                this.nhanVienRepository.findAll().stream()
                        .filter(
                                entity -> Objects.equals(entity.getId(), id)
                        )
                        .findFirst()
                        .map(
                                entity -> NhanVienDto.builder()
                                        .id(entity.getId())
                                        .ten(entity.getTen())
                                        .maNV(entity.getMa())
                                        .tenDangNhap(entity.getTenDangNhap())
                                        .matKhau(entity.getMatKhau())
                                        .trangThai(entity.getTrangThai())
                                        .build()
                        )
                        .orElse(new NhanVienDto());

        return "ID: " + nhanVienDto.getId() + "<br>" +
                "Ten: " + nhanVienDto.getTen() + "<br>" +
                "MaNV: " + nhanVienDto.getMaNV() + "<br>" +
                "Ten Dang Nhap: " + nhanVienDto.getTenDangNhap() + "<br>";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("nhanVien", new NhanVienDto());
        return "admin/ql-nhan-vien/create";
    }

    @PostMapping(value = "/store")
    public String store(@ModelAttribute(name = "nhanVien") NhanVienDto dto) {
        this.nhanVienRepository.save(
                NhanVienEntity.builder()
                        .id(dto.getId())
                        .ten(dto.getTen())
                        .ma(dto.getMaNV())
                        .tenDangNhap(dto.getTenDangNhap())
                        .matKhau(dto.getMatKhau())
                        .trangThai(dto.getTrangThai())
                        .build()
        );
        return "redirect:/nhan-vien/create";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name = "id") Integer id) {

        model.addAttribute("nhanVien",
                this.nhanVienRepository.findById(id)
                        .map(
                                entity -> NhanVienDto.builder()
                                        .id(entity.getId())
                                        .ten(entity.getTen())
                                        .maNV(entity.getMa())
                                        .tenDangNhap(entity.getTenDangNhap())
                                        .matKhau(entity.getMatKhau())
                                        .trangThai(entity.getTrangThai())
                                        .build()
                        )
                        .orElse(new NhanVienDto())
        );
        return "admin/ql-nhan-vien/edit";
    }

    @PostMapping(value = "/update/{id}")
    public String update(
            @PathVariable Integer id,
            @ModelAttribute(name = "nhanVien") NhanVienDto dto
    ) {
        this.nhanVienRepository.findById(id)
                .ifPresent(
                        entity -> {
                            entity.setId(id);
                            entity.setTen(dto.getTen());
                            entity.setMa(dto.getMaNV());
                            entity.setTenDangNhap(dto.getTenDangNhap());
                            entity.setMatKhau(dto.getMatKhau());

                            this.nhanVienRepository.save(entity);
                        }
                );
        return "redirect:/nhan-vien/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        this.nhanVienRepository.deleteById(id);
        return "redirect:/nhan-vien/index";
    }
}
