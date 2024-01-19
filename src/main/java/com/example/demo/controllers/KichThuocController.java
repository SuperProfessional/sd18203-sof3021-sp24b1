package com.example.demo.controllers;

import java.util.List;
import java.util.Objects;

import com.example.demo.dto.KichThuocDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping(value = "/kich-thuoc")
@RequiredArgsConstructor
public class KichThuocController {

    private final List<KichThuocDto> kichThuocDtoList;

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("kichThuocList", this.kichThuocDtoList);
        return "admin/ql-kich-thuoc/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("kichThuoc", new KichThuocDto());
        return "admin/ql-kich-thuoc/create";
    }

    @PostMapping(value = "/store")
    public String store(
            @ModelAttribute(name = "kichThuoc") KichThuocDto dto
    ) {
        this.kichThuocDtoList.add(dto);
        return "redirect:/kich-thuoc/create";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name = "id") Integer id) {

        KichThuocDto kichThuocDto =
                this.kichThuocDtoList.stream()
                        .filter(
                                dto -> Objects.equals(dto.getId(), id)
                        )
                        .findFirst()
                        .orElse(new KichThuocDto());

        model.addAttribute("kichThuoc", kichThuocDto);
        return "admin/ql-kich-thuoc/edit";
    }

    @PostMapping(value = "/update/{id}")
    public String update(
            @PathVariable Integer id,
            @ModelAttribute(name = "kichThuoc") KichThuocDto dto
    ) {
        this.kichThuocDtoList.forEach(
                kichThuocDto -> {
                    if (Objects.equals(kichThuocDto.getId(), id)) {
                        kichThuocDto.setMa(dto.getMa());
                        kichThuocDto.setTen(dto.getTen());
                    }
                }
        );
        return "redirect:/kich-thuoc/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        this.kichThuocDtoList.removeIf(
                kichThuocDto -> Objects.equals(kichThuocDto.getId(), id)
        );
        return "redirect:/kich-thuoc/index";
    }
}
