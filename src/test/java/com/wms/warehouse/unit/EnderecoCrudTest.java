package com.wms.warehouse.unit;

import com.wms.warehouse.domain.model.enderecos.Endereco;
import com.wms.warehouse.domain.model.enderecos.EnderecoPicking;
import com.wms.warehouse.domain.service.EnderecoService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnderecoCrudTest {

    @Autowired
    EnderecoService enderecoService;

    @Test
    public void adiciona_picking() {
        Endereco ed = new EnderecoPicking();
        ed.setDescricao("pk-1");
        enderecoService.criaEndereco(ed);
    }

}
