package com.algaworks.algafood.domain.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Grupo extends BaseEntity {

	private String nome;

	@ManyToMany
	@JoinTable(name = "grupo_permissao", inverseJoinColumns = @JoinColumn(name = "permissao_id"))
	private List<Permissao> permissoes;
}
