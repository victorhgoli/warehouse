package com.wms.warehouse.domain.repository;

import com.wms.warehouse.domain.model.ProdutoVolume;
import com.wms.warehouse.domain.model.ProdutoVolumePK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoVolumeRepository extends JpaRepository<ProdutoVolume, ProdutoVolumePK>{
    
}
