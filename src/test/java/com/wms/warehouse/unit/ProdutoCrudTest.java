package com.wms.warehouse.unit;

import java.util.Arrays;
import java.util.List;

import com.wms.warehouse.domain.model.Produto;
import com.wms.warehouse.domain.model.ProdutoVolume;
import com.wms.warehouse.domain.model.ProdutoVolumePK;
import com.wms.warehouse.domain.model.Volume;
import com.wms.warehouse.domain.repository.ProdutoRepository;
import com.wms.warehouse.domain.repository.ProdutoVolumeRepository;
import com.wms.warehouse.domain.repository.VolumeRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProdutoCrudTest {

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

    Produto pSabao = new Produto();
    pSabao.setNome("Sabao");

    Produto pCopo = new Produto();
    pCopo.setNome("Copo");

    ProdutoVolume prodVolSabao = new ProdutoVolume();
    prodVolSabao.setId(new ProdutoVolumePK());
    prodVolSabao.setProduto(pSabao);
    prodVolSabao.setVolume(un);
    prodVolSabao.setCodBarras(Arrays.asList("0101", "01"));

    ProdutoVolume prodVolCopo = new ProdutoVolume();
    prodVolCopo.setId(new ProdutoVolumePK());
    prodVolCopo.setProduto(pSabao);
    prodVolCopo.setVolume(un);
    prodVolCopo.setCodBarras(Arrays.asList("0202", "02"));


    produtoRepository.save(pSabao);
    produtoRepository.save(pCopo);
    volumeRepository.save(un);
    volumeRepository.save(cx);
    volumeRepository.save(cx12);
    produtoVolumeRepository.save(prodVolSabao);
    produtoVolumeRepository.save(prodVolCopo);
  }


  @Test
  public void valida_busca_por_codigo_barras(){

    String codigoDeBarras = "0101";


     List<ProdutoVolume> pv = produtoVolumeRepository.findByCodBarras(codigoDeBarras);

    System.out.println("-----------------------------");

  }

 
}
