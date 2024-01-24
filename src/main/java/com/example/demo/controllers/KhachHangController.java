package com.example.demo.controllers;

import java.util.List;
import java.util.Objects;

import com.example.demo.dtos.KhachHangDto;
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
@RequestMapping(value = "/khach-hang")
@RequiredArgsConstructor
public class KhachHangController {

    private final List<KhachHangDto> khachHangDtoList;

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("khachHangList", this.khachHangDtoList);
        return "admin/ql-khach-hang/index";
    }

    @GetMapping(value = "/show/{id}")
    @ResponseBody
    public String show(@PathVariable(name = "id") Integer id) {

        KhachHangDto khachHangDto =
                this.khachHangDtoList.stream()
                        .filter(
                                dto -> Objects.equals(dto.getId(), id)
                        )
                        .findFirst()
                        .orElse(new KhachHangDto());

        return "ID: " + khachHangDto.getId() + "<br>" +
                "Ten: " + khachHangDto.getTen() + "<br>" +
                "SDT: " + khachHangDto.getSdt() + "<br>" +
                "MaKH: " + khachHangDto.getMaKH() + "<br>";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("khachHang", new KhachHangDto());
        return "admin/ql-khach-hang/create";
    }

    @PostMapping(value = "/store")
    public String store(
            @ModelAttribute(name = "khachHang") KhachHangDto dto
    ) {
        this.khachHangDtoList.add(dto);
        return "redirect:/khach-hang/create";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name = "id") Integer id) {

        KhachHangDto khachHangDto =
                this.khachHangDtoList.stream()
                        .filter(
                                dto -> Objects.equals(dto.getId(), id)
                        )
                        .findFirst()
                        .orElse(new KhachHangDto());

        model.addAttribute("khachHang", khachHangDto);
        return "admin/ql-khach-hang/edit";
    }

    @PostMapping(value = "/update/{id}")
    public String update(
            @PathVariable Integer id,
            @ModelAttribute(name = "khachHang") KhachHangDto dto
    ) {
        this.khachHangDtoList.forEach(
                khachHangDto -> {
                    if (Objects.equals(khachHangDto.getId(), id)) {
                        khachHangDto.setTen(dto.getTen());
                        khachHangDto.setSdt(dto.getSdt());
                        khachHangDto.setMaKH(dto.getMaKH());
                    }
                }
        );
        return "redirect:/khach-hang/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        this.khachHangDtoList.removeIf(
                khachHangDto -> Objects.equals(khachHangDto.getId(), id)
        );
        return "redirect:/khach-hang/index";
    }
}
