package com.wms.warehouse.unit;

import com.wms.warehouse.domain.model.enderecos.Endereco;
import com.wms.warehouse.domain.model.enderecos.EnderecoPicking;
import com.wms.warehouse.domain.model.enderecos.EnderecoPulmao;
import com.wms.warehouse.domain.model.enderecos.EnderecoSintetico;
import com.wms.warehouse.domain.repository.EnderecoRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EnderecoCrudTest {

    @Autowired
  private EnderecoRepository enderecoRepository;

    @Test
  public void insere_endereco_com_hierarquia() {
    Endereco armazem = new EnderecoSintetico();
    armazem.setCodigo("01");
    armazem.setDescricao("Armazem do Zezim");

    enderecoRepository.save(armazem);

    Endereco rua1 = new EnderecoSintetico();
    rua1.setCodigo("01.01");
    rua1.setDescricao("rua 01");
    rua1.setEnderecoPai(armazem);

    enderecoRepository.save(rua1);

    Endereco predio1 = new EnderecoSintetico();
    predio1.setCodigo("01.01.01");
    predio1.setDescricao("predio 01");
    predio1.setEnderecoPai(rua1);

    enderecoRepository.save(predio1);

    Endereco nivel0 = new EnderecoSintetico();
    nivel0.setCodigo("01.01.01.00");
    nivel0.setDescricao("nivel 00");
    nivel0.setEnderecoPai(predio1);

    enderecoRepository.save(nivel0);

    Endereco edPk = new EnderecoPicking();
    edPk.setCodigo("01.01.01.00.01");
    edPk.setDescricao("Picking 01");
    edPk.setEnderecoPai(nivel0);

    enderecoRepository.save(edPk);

    Endereco nivel1 = new EnderecoSintetico();
    nivel1.setCodigo("01.01.01.01");
    nivel1.setDescricao("nivel 01");
    nivel1.setEnderecoPai(predio1);

    enderecoRepository.save(nivel1);

    Endereco pulmao = new EnderecoPulmao();
    pulmao.setCodigo("01.01.01.01.01");
    pulmao.setDescricao("Pulmao 01");
    pulmao.setEnderecoPai(nivel1);

    enderecoRepository.save(pulmao);
  }

}
