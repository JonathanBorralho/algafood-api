package com.algaworks.algafood.domain.repository.filter;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class RestauranteFilter {
	private String nome;
	private BigDecimal taxaFreteInicial;
	private BigDecimal taxaFreteFinal;
	private Long cozinha;
}
