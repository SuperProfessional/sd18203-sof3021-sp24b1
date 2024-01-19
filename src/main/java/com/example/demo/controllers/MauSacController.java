package com.example.demo.controllers;

import java.util.List;
import java.util.Objects;

import com.example.demo.dto.MauSacDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping(value = "/mau-sac")
@RequiredArgsConstructor
public class MauSacController {

    private final List<MauSacDto> mauSacDtoList;

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("mauSacList", this.mauSacDtoList);
        return "admin/ql-mau-sac/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("mauSac", new MauSacDto());
        return "admin/ql-mau-sac/create";
    }

    @PostMapping(value = "/store")
    public String store(@ModelAttribute(name = "mauSac") MauSacDto dto) {
        this.mauSacDtoList.add(dto);
        return "redirect:/mau-sac/create";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name = "id") Integer id) {

        MauSacDto mauSacDto =
                this.mauSacDtoList.stream()
                        .filter(
                                dto -> Objects.equals(dto.getId(), id)
                        )
                        .findFirst()
                        .orElse(new MauSacDto());

        model.addAttribute("mauSac", mauSacDto);
        return "admin/ql-mau-sac/edit";
    }

    @PostMapping(value = "/update/{id}")
    public String update(
            @PathVariable Integer id,
            @ModelAttribute(name = "mauSac") MauSacDto dto
    ) {
        this.mauSacDtoList.forEach(
                mauSacDto -> {
                    if (Objects.equals(mauSacDto.getId(), id)) {
                        mauSacDto.setMa(dto.getMa());
                        mauSacDto.setTen(dto.getTen());
                    }
                }
        );
        return "redirect:/mau-sac/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        this.mauSacDtoList.removeIf(
                mauSacDto -> Objects.equals(mauSacDto.getId(), id)
        );
        return "redirect:/mau-sac/index";
    }
}
