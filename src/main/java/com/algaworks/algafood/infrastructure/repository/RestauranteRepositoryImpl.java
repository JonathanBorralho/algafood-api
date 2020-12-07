package com.algaworks.algafood.infrastructure.repository;

import static com.algaworks.algafood.domain.model.QRestaurante.restaurante;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepositoryQueries;
import com.querydsl.core.BooleanBuilder;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {
	
	@Autowired @Lazy
	private RestauranteRepository restauranteRepository;

	@Override
	public Page<Restaurante> paginar(Pageable pageable, String nome) {
		final BooleanBuilder builder = new BooleanBuilder();
		if (StringUtils.hasText(nome)) {
			builder.and(restaurante.nome.containsIgnoreCase(nome));
		}
		return restauranteRepository.findAll(builder, pageable);
	}

}
