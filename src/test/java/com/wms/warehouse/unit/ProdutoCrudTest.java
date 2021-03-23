package com.wms.warehouse.unit;

import java.util.Arrays;

import com.wms.warehouse.domain.model.Produto;
import com.wms.warehouse.domain.model.ProdutoVolume;
import com.wms.warehouse.domain.model.ProdutoVolumePK;
import com.wms.warehouse.domain.model.Volume;
import com.wms.warehouse.domain.model.enderecos.Endereco;
import com.wms.warehouse.domain.model.enderecos.EnderecoPicking;
import com.wms.warehouse.domain.model.enderecos.EnderecoPulmao;
import com.wms.warehouse.domain.model.enderecos.EnderecoSintetico;
import com.wms.warehouse.domain.repository.EnderecoRepository;
import com.wms.warehouse.domain.repository.ProdutoRepository;
import com.wms.warehouse.domain.repository.ProdutoVolumeRepository;
import com.wms.warehouse.domain.repository.VolumeRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoCrudTest {


  @Autowired
  private EnderecoRepository enderecoRepository;

  @Autowired
  private ProdutoRepository produtoRepository;

  @Autowired
  private VolumeRepository volumeRepository;

  @Autowired
  private ProdutoVolumeRepository produtoVolumeRepository;

  @Test
  public void insere_produto_com_unidade() {
    Volume un = new Volume();
    un.setVolume("UN");
    un.setMultiplo(1.0);

    Volume cx = new Volume();
    cx.setVolume("CX");
    cx.setMultiplo(10.0);

    Volume cx12 = new Volume();
    cx12.setVolume("CX-12");
    cx12.setMultiplo(12.0);

    Produto p = new Produto();
    p.setNome("prim");

    ProdutoVolume prodVol = new ProdutoVolume();
    prodVol.setId(new ProdutoVolumePK());
    prodVol.setProduto(p);
    prodVol.setVolume(un);
    prodVol.setCodBarras(Arrays.asList("0101", "01"));

    produtoRepository.save(p);
    volumeRepository.save(un);
    volumeRepository.save(cx);
    volumeRepository.save(cx12);
    produtoVolumeRepository.save(prodVol);
  }

  @Test
  public void insere_endereco_com_hierarquia() {
    Endereco armazem = new EnderecoSintetico();
    armazem.setCodigo("01");
    armazem.setDescricao("Armazem do Zezim");

    Endereco rua1 = new EnderecoSintetico();
    rua1.setCodigo("01.01");
    rua1.setDescricao("rua 01");
    rua1.setEnderecoPai(armazem);

    Endereco predio1 = new EnderecoSintetico();
    predio1.setCodigo("01.01.01");
    predio1.setDescricao("predio 01");
    predio1.setEnderecoPai(rua1);

    Endereco nivel0 = new EnderecoSintetico();
    nivel0.setCodigo("01.01.01.00");
    nivel0.setDescricao("nivel 00");
    nivel0.setEnderecoPai(predio1);
    
    Endereco edPk = new EnderecoPicking();
    edPk.setDescricao("01.01.01.00.01");
    edPk.setEnderecoPai(nivel0);

    Endereco nivel1 = new EnderecoSintetico();
    nivel1.setCodigo("01.01.01.01");
    nivel1.setDescricao("nivel 01");
    nivel1.setEnderecoPai(predio1);

    Endereco pulmao = new EnderecoPulmao();
    pulmao.setCodigo("01.01.01.01.01");
    pulmao.setEnderecoPai(nivel1);

    enderecoRepository.save(armazem);
  }

  /*
   * @Test public void insere_produto_com_multiplas_unidade() { Produto p = new
   * Produto(); p.setNome("sec");
   * 
   * Unidade un = new Unidade(); un.setId(new UnidadePk("UN")); un.setProduto(p);
   * un.setMultiplo(1.0);
   * 
   * Unidade cx = new Unidade(); cx.setId(new UnidadePk("CX")); cx.setProduto(p);
   * cx.setMultiplo(10.0);
   * 
   * p.setUnidades(Arrays.asList(un, cx));
   * 
   * produtoRepository.save(p); }
   */
}
