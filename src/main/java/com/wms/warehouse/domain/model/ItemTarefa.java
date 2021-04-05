package com.wms.warehouse.domain.model;

import java.math.BigDecimal;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemTarefa {

    @EmbeddedId
    private ItemTarefaPk id;

    @MapsId("tarefaId")
    @ManyToOne
    @JoinColumn(name = "tarefa_id", nullable = false, foreignKey = @ForeignKey(name = "fk_item_tarefa_tarefa"))
    private Tarefa tarefa;

    @MapsId("origemId")
    @ManyToOne
    @JoinColumn(name = "origem_id", nullable = false, foreignKey = @ForeignKey(name = "fk_item_tarefa_origem"))
    Estoque origem;

    @MapsId("destinoId")
    @ManyToOne
    @JoinColumn(name = "destino_id", nullable = false, foreignKey = @ForeignKey(name = "fk_item_tarefa_destino"))
    Estoque destino;

    BigDecimal quantidade;

    @Enumerated(EnumType.STRING)
    private States estado;
}
