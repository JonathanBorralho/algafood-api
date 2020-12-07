package com.algaworks.algafood.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {
	Page<Restaurante> paginar(Pageable pageable, String nome);
}
