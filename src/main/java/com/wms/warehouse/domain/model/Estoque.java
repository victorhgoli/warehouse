package com.wms.warehouse.domain.model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.wms.warehouse.domain.model.enderecos.Endereco;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Estoque {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Produto produto;

    @ManyToOne
    private Endereco endereco;

    @ManyToOne
    private Volume volume;

    private String controle;

    @Column(name = "data_vencimento")
    private LocalDate dtVencimento;

    @Column(name = "data_entrada_estoque")
    private LocalDateTime dhEntradaEstoque;

    private BigDecimal quantidade;

}
