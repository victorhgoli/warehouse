package com.wms.warehouse.domain.service;

import com.wms.warehouse.domain.model.Produto;
import com.wms.warehouse.domain.repository.ProdutoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;


    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public void excluir(Long produtoId) {
		produtoRepository.deleteById(produtoId);
	}

}
