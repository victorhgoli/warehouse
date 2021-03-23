package com.wms.warehouse.domain.repository;

import com.wms.warehouse.domain.model.enderecos.Endereco;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long>{
    
}
