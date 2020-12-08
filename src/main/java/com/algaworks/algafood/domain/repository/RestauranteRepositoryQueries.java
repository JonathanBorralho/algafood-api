package com.algaworks.algafood.domain.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.filter.RestauranteFilter;

public interface RestauranteRepositoryQueries {
	Page<Restaurante> paginar(Pageable pageable, RestauranteFilter filter);
}
