package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import com.example.demo.dto.MauSacDto;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping(value = "/mau-sac")
public class MauSacController {

    private final List<MauSacDto> mauSacDtoList;

    public MauSacController() {
        this.mauSacDtoList = new ArrayList<>();
        this.mauSacDtoList.add(new MauSacDto(1, "MS01", "Red"));
        this.mauSacDtoList.add(new MauSacDto(2, "MS02", "Yellow"));
        this.mauSacDtoList.add(new MauSacDto(3, "MS03", "Green"));
        this.mauSacDtoList.add(new MauSacDto(4, "MS04", "Black"));
        this.mauSacDtoList.add(new MauSacDto(5, "MS05", "Red"));
    }

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("mauSacList", this.mauSacDtoList);
        return "admin/ql-mau-sac/index";
    }

    @GetMapping(value = "/show/{id}")
    public String show(
            Model model,
            @PathVariable(name = "id") Integer id) {
        return "admin/ql-mau-sac/index";
    }

    @GetMapping(value = "/create")
    public String create() {
        return "admin/ql-mau-sac/create";
    }

    @PostMapping(value = "/store")
    public String store(
            @Valid @ModelAttribute(name = "mauSac") MauSacDto dto
    ) {
        this.mauSacDtoList.add(dto);
        return "admin/ql-mau-sac/create";
    }

    @PostMapping(value = "/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name = "id") Integer id) {
        model.addAttribute(
                "mauSac",
                this.mauSacDtoList.stream()
                        .filter(
                                mauSacDto -> Objects.equals(mauSacDto.getId(), id)
                        )
                        .findFirst()
        );
        return "admin/ql-mau-sac/index";
    }

    @PostMapping(value = "/update")
    public String update(MauSacDto dto) {

        return "admin/ql-mau-sac/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        this.mauSacDtoList.removeIf(
                mauSacDto -> Objects.equals(mauSacDto.getId(), id)
        );
        return "redirect:/mau-sac/index";
    }
}
