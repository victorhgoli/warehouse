package com.wms.warehouse.domain.model.enderecos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("pulmao")
@Entity
public class EnderecoPulmao extends Endereco{
    
}
