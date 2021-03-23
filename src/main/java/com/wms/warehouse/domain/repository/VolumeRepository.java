package com.wms.warehouse.domain.repository;

import com.wms.warehouse.domain.model.Volume;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VolumeRepository extends JpaRepository<Volume, Long>{
    
}
