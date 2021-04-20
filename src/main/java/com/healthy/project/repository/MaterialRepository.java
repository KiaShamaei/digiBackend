package com.healthy.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.healthy.project.model.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {

}
