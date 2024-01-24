package com.example.demo.controllers;

import com.example.demo.dtos.MauSacDto;
import com.example.demo.entities.MauSacEntity;
import com.example.demo.repositories.MauSacRepository;
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

    private final MauSacRepository mauSacRepository;

    @GetMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("mauSacList", this.mauSacRepository.findAll());
        return "admin/ql-mau-sac/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {
        model.addAttribute("mauSac", new MauSacDto());
        return "admin/ql-mau-sac/create";
    }

    @PostMapping(value = "/store")
    public String store(@ModelAttribute(name = "mauSac") MauSacDto dto) {
        this.mauSacRepository.save(
                MauSacEntity.builder()
                        .ma(dto.getMa())
                        .ten(dto.getTen())
                        .trangThai(1)
                        .build()
        );
        return "redirect:/mau-sac/index";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name = "id") Integer id) {

        model.addAttribute("mauSac",
                this.mauSacRepository.findById(id)
                        .map(entity -> MauSacDto.builder()
                                .id(entity.getId())
                                .ma(entity.getMa())
                                .ten(entity.getTen())
                                .trangThai(entity.getTrangThai())
                                .build()
                        )
                        .orElse(new MauSacDto())
        );
        return "admin/ql-mau-sac/edit";
    }

    @PostMapping(value = "/update/{id}")
    public String update(
            @PathVariable Integer id,
            @ModelAttribute(name = "mauSac") MauSacDto dto
    ) {
        this.mauSacRepository.findById(id)
                .ifPresent(
                        entity -> {

                            entity.setId(id);
                            entity.setMa(dto.getMa());
                            entity.setTen(dto.getTen());
//                            entity.setTrangThai(dto.getTrangThai());

                            this.mauSacRepository.save(entity);
                        }
                );
        return "redirect:/mau-sac/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        this.mauSacRepository.deleteById(id);
        return "redirect:/mau-sac/index";
    }
}
