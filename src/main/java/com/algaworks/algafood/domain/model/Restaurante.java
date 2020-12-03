package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Restaurante extends BaseEntity {

	private String nome;

	@Column(name = "taxa_frete")
	private BigDecimal taxaFrete;

	@ManyToOne
	private Cozinha cozinha;
}
