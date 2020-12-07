package com.algaworks.algafood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import com.algaworks.algafood.domain.model.Restaurante;

public interface RestauranteRepository
		extends JpaRepository<Restaurante, Long>, QuerydslPredicateExecutor<Restaurante>, RestauranteRepositoryQueries {

}
