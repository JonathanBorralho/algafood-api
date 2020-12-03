package com.algaworks.algafood.domain.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cidade extends BaseEntity {

	private String nome;

	@ManyToOne
	private Estado estado;
}
