package com.example.demo.services;

import java.util.List;

import com.example.demo.dtos.MauSacDto;
import org.springframework.stereotype.Service;

@Service
public interface MauSacService {

    List<MauSacDto> findAll();

    MauSacDto getById(Integer id);
}
