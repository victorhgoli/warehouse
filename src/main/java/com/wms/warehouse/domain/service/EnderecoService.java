package com.wms.warehouse.domain.service;

import com.wms.warehouse.domain.model.enderecos.Endereco;
import com.wms.warehouse.domain.repository.EnderecoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {

    @Autowired
    EnderecoRepository enderecoRepository;

    public void criaEndereco(Endereco ed) {

        enderecoRepository.save(ed);

    }

}
