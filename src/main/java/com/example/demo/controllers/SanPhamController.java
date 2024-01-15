package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.demo.dto.SanPhamDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping(value = "/san-pham")
@RequiredArgsConstructor
public class SanPhamController {

    private final List<SanPhamDto> sanPhamDtoList;

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("sanPhamList", this.sanPhamDtoList);
        return "admin/ql-san-pham/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("sanPham", new SanPhamDto());
        return "admin/ql-san-pham/create";
    }

    @PostMapping(value = "/store")
    public String store(
            @Valid @ModelAttribute(name = "sanPham") SanPhamDto dto
    ) {
        this.sanPhamDtoList.add(dto);
        return "redirect:/san-pham/create";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name = "id") Integer id) {

        SanPhamDto sanPhamDto =
                this.sanPhamDtoList.stream()
                        .filter(
                                dto -> Objects.equals(dto.getId(), id)
                        )
                        .findFirst()
                        .orElse(new SanPhamDto());

        model.addAttribute("sanPham", sanPhamDto);
        return "admin/ql-san-pham/edit";
    }

    @PostMapping(value = "/update/{id}")
    public String update(
            @PathVariable Integer id,
            @Valid @ModelAttribute(name = "sanPham") SanPhamDto dto
    ) {
        this.sanPhamDtoList.forEach(
                sanPhamDto -> {
                    if (Objects.equals(sanPhamDto.getId(), id)) {
                        sanPhamDto.setMa(dto.getMa());
                        sanPhamDto.setTen(dto.getTen());
                    }
                }
        );
        return "redirect:/san-pham/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        this.sanPhamDtoList.removeIf(
                sanPhamDto -> Objects.equals(sanPhamDto.getId(), id)
        );
        return "redirect:/san-pham/index";
    }
}
