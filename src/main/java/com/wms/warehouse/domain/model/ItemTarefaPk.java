package com.wms.warehouse.domain.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Embeddable
public class ItemTarefaPk implements Serializable {
    private static final long serialVersionUID = 1L;

    @EqualsAndHashCode.Include
    @Column(name = "tarefa_id")
    private Long tarefaId;

    @EqualsAndHashCode.Include
    @Column(name = "origem_id")
    private Long origemId;

    @EqualsAndHashCode.Include
    @Column(name = "destino_id")
    private Long destinoId;

}
