package com.algaworks.algafood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ItemPedido extends BaseEntity {

	private Integer quantidade;

	private BigDecimal precoUnitario;

	private BigDecimal precoTotal;

	private String observacao;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Pedido pedido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Produto produto;

}
