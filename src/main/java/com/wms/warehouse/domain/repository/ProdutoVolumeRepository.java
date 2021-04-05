package com.wms.warehouse.domain.repository;

import com.wms.warehouse.domain.model.Produto;
import com.wms.warehouse.domain.model.ProdutoVolume;
import com.wms.warehouse.domain.model.ProdutoVolumePK;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoVolumeRepository extends JpaRepository<ProdutoVolume, ProdutoVolumePK> {

    @Query("select p.produto from ProdutoVolume p where :codbarras in elements(p.codBarras)")
    Produto findByCodBarras(@Param("codbarras") String codBarras);
}
