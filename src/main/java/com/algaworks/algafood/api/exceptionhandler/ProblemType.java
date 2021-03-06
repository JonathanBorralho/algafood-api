package com.algaworks.algafood.api.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {
	MENSAGEM_NAO_LEGIVEL("/mensagem-nao-legivel", "Mensagem não legível"),
	ENTIDADE_NAO_ENCONTRADA("/entidade-nao-encontrada", "Entidade não encontrada"),
	ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
	ERRO_NEGOCIO("/erro-negocio", "Violação de regra de negócio");

	private String path;
	private String title;

	ProblemType(String path, String title) {
		this.path = "https://algafood.com.br" + path;
		this.title = title;
	}
}
