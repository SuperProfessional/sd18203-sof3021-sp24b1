package com.example.demo.controllers;

import com.example.demo.dto.MauSacDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Controller()
@RequestMapping(value = "/mau-sac")
public class MauSacController {

    private List<MauSacDto> mauSacDtoList = new ArrayList<>();

    @GetMapping(value = "/index")
    public String index() {
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
            Model model,
            MauSacDto dto
    ) {
        this.mauSacDtoList.add(dto);
        model.addAttribute("mauSacList", this.mauSacDtoList);
        return "admin/ql-mau-sac/create";
    }

    @PostMapping(value = "/edit")
    public String edit(
            Model mode,
            MauSacDto dto
    ) {
        this.mauSacDtoList.add(dto);
        mode.addAttribute("mauSacList", this.mauSacDtoList);
        return "admin/ql-mau-sac/index";
    }

    @PostMapping(value = "/update")
    public String update(MauSacDto dto) {

        this.mauSacDtoList.forEach(
                mauSacDto -> {
                    if (Objects.equals(mauSacDto.getId(), dto.getId())) {
                        mauSacDto.setMa(dto.getMa());
                        mauSacDto.setTen(dto.getTen());
                    }
                }
        );
        return "admin/ql-mau-sac/index";
    }

    @PostMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") String id) {
        boolean isDelete = this.mauSacDtoList.removeIf(
                mauSacDto -> Objects.equals(mauSacDto.getId(), id)
        );
        return "admin/ql-mau-sac/index";
    }
}
