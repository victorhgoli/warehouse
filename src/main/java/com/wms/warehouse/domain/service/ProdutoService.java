package com.wms.warehouse.domain.service;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.wms.warehouse.domain.model.Produto;
import com.wms.warehouse.domain.model.ProdutoVolume;
import com.wms.warehouse.domain.repository.ProdutoRepository;
import com.wms.warehouse.domain.repository.ProdutoVolumeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;


    ProdutoVolumeRepository produtoVolumeRepository;

    @Transactional
    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Transactional
    public void excluir(Long produtoId) {
        produtoRepository.deleteById(produtoId);
    }

    public Produto findByCodBarras(String codBarras) {
     //   ProdutoVolume produtoVolme = produtoVolumeRepository.findByCodBarras(codBarras);


        return null;
    }

}
