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
public class Usuario extends BaseEntityAuditable {

	private String nome;
	private String email;
	private String senha;

	@ManyToMany
	@JoinTable(name = "usuario_grupo", inverseJoinColumns = @JoinColumn(name = "grupo_id"))
	private List<Grupo> grupos;
}
