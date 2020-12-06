package com.algaworks.algafood.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.CozinhaRepository;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {
	
	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	public Restaurante salvar(Restaurante restaurante) {
		final Long cozinhaId = restaurante.getCozinha().getId();
		final Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);
		
		if (cozinha.isEmpty()) {
			throw new EntidadeNaoEncontradaException(String.format("Não existe cadastro de cozinha com código %d", cozinhaId));
		}
		return restauranteRepository.save(restaurante);
	}
	
}
