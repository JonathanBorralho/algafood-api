package com.algaworks.algafood.domain.model;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Cozinha extends BaseEntity {
	private String nome;
}
