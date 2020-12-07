package com.algaworks.algafood.api.controller.dtos;

import java.math.BigDecimal;

import org.openapitools.jackson.nullable.JsonNullable;

import com.algaworks.algafood.domain.model.Cozinha;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RestauranteUpdate {
	private JsonNullable<String> nome = JsonNullable.undefined();
	private JsonNullable<BigDecimal> taxaFrete = JsonNullable.undefined();
	private JsonNullable<Cozinha> cozinha = JsonNullable.undefined();
}
