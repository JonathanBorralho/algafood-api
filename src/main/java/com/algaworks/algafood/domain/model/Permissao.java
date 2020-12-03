package com.algaworks.algafood.domain.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Permissao extends BaseEntity {
	private String nome;
	private String descricao;
}
