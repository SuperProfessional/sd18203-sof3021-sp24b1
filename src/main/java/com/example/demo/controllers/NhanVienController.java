package com.example.demo.controllers;

import java.util.List;
import java.util.Objects;

import com.example.demo.dto.NhanVienDto;
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

    private final List<NhanVienDto> nhanVienDtoList;

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("nhanVienList", this.nhanVienDtoList);
        return "admin/ql-nhan-vien/index";
    }

    @GetMapping(value = "/show/{id}")
    @ResponseBody
    public String show(@PathVariable(name = "id") Integer id) {

        NhanVienDto nhanVienDto =
                this.nhanVienDtoList.stream()
                        .filter(
                                dto -> Objects.equals(dto.getId(), id)
                        )
                        .findFirst()
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
        this.nhanVienDtoList.add(dto);
        return "redirect:/nhan-vien/create";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name = "id") Integer id) {

        NhanVienDto nhanVienDto =
                this.nhanVienDtoList.stream()
                        .filter(
                                dto -> Objects.equals(dto.getId(), id)
                        )
                        .findFirst()
                        .orElse(new NhanVienDto());

        model.addAttribute("nhanVien", nhanVienDto);
        return "admin/ql-nhan-vien/edit";
    }

    @PostMapping(value = "/update/{id}")
    public String update(
            @PathVariable Integer id,
            @ModelAttribute(name = "nhanVien") NhanVienDto dto
    ) {
        this.nhanVienDtoList.forEach(
                khachHangDto -> {
                    if (Objects.equals(khachHangDto.getId(), id)) {
                        khachHangDto.setTen(dto.getTen());
                        khachHangDto.setMaNV(dto.getMaNV());
                        khachHangDto.setTenDangNhap(dto.getTenDangNhap());
                        khachHangDto.setMatKhau(dto.getMatKhau());
                    }
                }
        );
        return "redirect:/nhan-vien/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        this.nhanVienDtoList.removeIf(
                nhanVienDto -> Objects.equals(nhanVienDto.getId(), id)
        );
        return "redirect:/nhan-vien/index";
    }
}
