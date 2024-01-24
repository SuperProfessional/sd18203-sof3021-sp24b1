package com.example.demo.controllers;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.example.demo.dtos.HoaDonDto;
import com.example.demo.dtos.KhachHangDto;
import com.example.demo.dtos.NhanVienDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller()
@RequestMapping(value = "/hoa-don")
@RequiredArgsConstructor
public class HoaDonController {

    private final List<HoaDonDto> hoaDonDtoList;
    private final List<NhanVienDto> nhanVienDtoList;
    private final List<KhachHangDto> khachHangDtoList;

    @GetMapping(value = "/index")
    public String index(Model model) {
        Map<Integer, String> nhanVienMap = this.hoaDonDtoList.stream()
                .collect(
                        Collectors.toMap(
                                HoaDonDto::getNhanVienId,
                                hoaDonDto -> this.nhanVienDtoList.stream()
                                           .filter(
                                                   nhanVienDto ->
                                                           Objects.equals(
                                                                   hoaDonDto.getNhanVienId(),
                                                                   nhanVienDto.getId()
                                                           )
                                           )
                                           .findFirst()
                                           .map(
                                                   NhanVienDto::getMaNV
                                           )
                                           .toString()
                        )
                );

        model.addAttribute("nhanVienMap", nhanVienMap);
        model.addAttribute("hoaDonList", this.hoaDonDtoList);

        return "admin/ql-hoa-don/index";
    }

    @GetMapping(value = "/create")
    public String create(Model model) {

        model.addAttribute("hoaDon", new HoaDonDto());
        model.addAttribute("nhanVienList", this.nhanVienDtoList);
        model.addAttribute("khachHangList", this.khachHangDtoList);

        return "admin/ql-hoa-don/create";
    }

    @GetMapping(value = "/test/{id}")
    public ResponseEntity<?> test(
            Model model,
            @PathVariable(name = "id") Integer id
    ) {

        HoaDonDto hoaDonDto =
                this.hoaDonDtoList.stream()
                        .filter(
                                dto -> Objects.equals(dto.getId(), id)
                        )
                        .findFirst()
                        .orElse(new HoaDonDto());

        Map<String, String> options = new HashMap<>();
        options.put("nhanVienId", hoaDonDto.getNhanVienId().toString());
        options.put(
                "maNV",
                this.nhanVienDtoList.stream()
                        .filter(
                                nv -> Objects.equals(nv.getId(), hoaDonDto.getNhanVienId())
                        )
                        .findFirst()
                        .orElse(new NhanVienDto())
                        .getMaNV()
        );
        options.put("khachHangId", hoaDonDto.getKhachHangId().toString());
        options.put(
                "maKH",
                this.khachHangDtoList.stream()
                        .filter(
                                kh -> Objects.equals(kh.getId(), hoaDonDto.getKhachHangId())
                        )
                        .findFirst()
                        .orElse(new KhachHangDto())
                        .getMaKH()
        );

        model.addAttribute("options", options);
        model.addAttribute("hoaDon", new HoaDonDto());
        model.addAttribute("nhanVienList", this.nhanVienDtoList);
        model.addAttribute("khachHangList", this.khachHangDtoList);

        return ResponseEntity.ok(model);
    }

    @PostMapping(value = "/store")
    public String store(@ModelAttribute(name = "hoaDon") HoaDonDto dto) {
        dto.setNgayMuaHang(LocalDateTime.now());
        this.hoaDonDtoList.add(dto);

        return "redirect:/hoa-don/create";
    }

    @GetMapping(value = "/edit/{id}")
    public String edit(
            Model model,
            @PathVariable(name = "id") Integer id) {

        HoaDonDto hoaDonDto =
                this.hoaDonDtoList.stream()
                        .filter(
                                dto -> Objects.equals(dto.getId(), id)
                        )
                        .findFirst()
                        .orElse(new HoaDonDto());

        Map<String, String> options = new HashMap<>();
        options.put("nhanVienId", hoaDonDto.getNhanVienId().toString());
        options.put(
                "maNV",
                this.nhanVienDtoList.stream()
                        .filter(
                                nv -> Objects.equals(nv.getId(), hoaDonDto.getNhanVienId())
                        )
                        .findFirst()
                        .orElse(new NhanVienDto())
                        .getMaNV()
        );
        options.put("khachHangId", hoaDonDto.getKhachHangId().toString());
        options.put(
                "maKH",
                this.khachHangDtoList.stream()
                        .filter(
                                kh -> Objects.equals(kh.getId(), hoaDonDto.getKhachHangId())
                        )
                        .findFirst()
                        .orElse(new KhachHangDto())
                        .getMaKH()
        );

        model.addAttribute("options", options);
        model.addAttribute("hoaDon", hoaDonDto);
        model.addAttribute("nhanVienList", this.nhanVienDtoList);
        model.addAttribute("khachHangList", this.khachHangDtoList);

        return "admin/ql-hoa-don/edit";
    }

    @PostMapping(value = "/update/{id}")
    public String update(
            @PathVariable Integer id,
            @ModelAttribute(name = "hoaDon") HoaDonDto dto
    ) {

        boolean isExistMaNV =
                this.nhanVienDtoList.stream()
                        .anyMatch(
                                nhanVien -> Objects.equals(dto.getNhanVienId(), nhanVien.getId())
                        );

        boolean isExistMaKH =
                this.khachHangDtoList.stream()
                        .anyMatch(
                                khachHang -> Objects.equals(dto.getKhachHangId(), khachHang.getId())
                        );

        if (!(isExistMaNV && isExistMaKH)) {
            return "redirect:/hoa-don/edit/" + id;
        }

        this.hoaDonDtoList.forEach(
                hoaDonDto -> {
                    if (Objects.equals(hoaDonDto.getId(), id)) {
                        hoaDonDto.setNhanVienId(dto.getNhanVienId());
                        hoaDonDto.setKhachHangId(dto.getKhachHangId());
                    }
                }
        );
        return "redirect:/hoa-don/index";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id) {
        this.hoaDonDtoList.removeIf(
                hoaDonDto -> Objects.equals(hoaDonDto.getId(), id)
        );
        return "redirect:/hoa-don/index";
    }
}
