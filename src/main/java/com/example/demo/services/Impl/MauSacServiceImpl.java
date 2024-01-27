package com.example.demo.services.Impl;


import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.dtos.MauSacDto;
import com.example.demo.repositories.MauSacRepository;
import com.example.demo.services.MauSacService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MauSacServiceImpl implements MauSacService {

    private final MauSacRepository mauSacRepository;

    @Override
    public List<MauSacDto> findAll() {
        return this.mauSacRepository.findAll().stream()
                .map(
                        entity -> new MauSacDto(
                                entity.getId(),
                                entity.getMa(),
                                entity.getTen(),
                                entity.getTrangThai()
                        )
                )
                .collect(Collectors.toList());
    }

    @Override
    public MauSacDto getById(Integer id) {
        return null;
    }
}
