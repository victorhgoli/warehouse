package com.wms.warehouse.domain.model;

import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ProdutoVolume {

    @EmbeddedId
    private ProdutoVolumePK id;

    @MapsId("produtoId")
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(name = "fk_produto_volume_produto"))
    private Produto produto;

    @MapsId("volumeId")
    @ManyToOne
    @JoinColumn(name = "volume_id", nullable = false, foreignKey = @ForeignKey(name = "fk_produto_volume_volume"))
    private Volume volume;

    @ElementCollection
    @CollectionTable(name = "produto_codbarras", joinColumns = {
            @JoinColumn(name = "produto_id", nullable = false, foreignKey = @ForeignKey(name = "fk_produto_codbarras")),
            @JoinColumn(name = "volume_id", nullable = false, foreignKey = @ForeignKey(name = "fk_volume_codbarras")) })
    @Column(name = "codigo_barra")
    private List<String> codBarras;

    private double altura;
    private double largura;
    private double profundidade;
    public void save(ProdutoVolume prodVol) {
    }

}
