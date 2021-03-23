package com.wms.warehouse.domain.model.enderecos;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@DiscriminatorValue("sintetico")
@Entity
public class EnderecoSintetico extends Endereco{
    
}
