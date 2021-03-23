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
public class ProdutoVolumePK implements Serializable {

    private static final long serialVersionUID = 1L;

     @EqualsAndHashCode.Include
    @Column(name = "produto_id")
    private Long produtoId;
    
    @EqualsAndHashCode.Include
    @Column(name = "volume_id")
    private Long volumeId; 
}
