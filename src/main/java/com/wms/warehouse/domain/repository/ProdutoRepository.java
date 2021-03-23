package com.wms.warehouse.domain.repository;

import com.wms.warehouse.domain.model.Produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long>{
    
}
