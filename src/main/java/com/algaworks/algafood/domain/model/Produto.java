package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Produto extends BaseEntity {
	
	private String nome;
	
	private String descricao;
	
	private BigDecimal preco;
	
	private Boolean ativo;
	
	@ManyToOne
	private Restaurante restaurante;
}
