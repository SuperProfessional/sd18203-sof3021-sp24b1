package com.example.demo.controllers;

import com.example.demo.dto.MauSacDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller()
@RequestMapping(value = "/mau-sac")
public class MauSacController {

    private List<MauSacDto> mauSacDtoList = new ArrayList<>();

    @GetMapping(value = "/index")
    public String index(){
        return "admin/ql-mau-sac/index";
    }

    @GetMapping(value = "/show")
    public String show(){
        return "admin/ql-mau-sac/index";
    }

    @GetMapping(value = "/create")
    public String create(){
        return "admin/ql-mau-sac/create";
    }

    @PostMapping(value = "/store")
    public String store(
            Model model,
            MauSacDto dto
    ){
        return "admin/ql-mau-sac/index";
    }

    @PostMapping(value = "/edit")
    public String edit(
            Model mode,
            MauSacDto dto
    ){
        this.mauSacDtoList.add(dto);
        mode.addAttribute("mauSacList",this.mauSacDtoList);
        return "admin/ql-mau-sac/index";
    }

    @PostMapping(value = "/update")
    public String update(
            Model model,
            MauSacDto dto
    ){
        return "admin/ql-mau-sac/index";
    }

    @PostMapping(value = "/delete")
    public String delete(
            Model model,
            MauSacDto dto
    ){
        return "admin/ql-mau-sac/index";
    }
}
