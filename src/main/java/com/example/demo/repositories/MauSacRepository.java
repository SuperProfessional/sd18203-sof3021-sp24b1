package com.example.demo.repositories;

import com.example.demo.entities.MauSacEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MauSacRepository extends JpaRepository<MauSacEntity, Integer> {
}
