package com.wms.warehouse.domain.model.enderecos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("picking")
@Entity
public class EnderecoPicking extends Endereco{
    
}
