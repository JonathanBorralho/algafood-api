package com.algaworks.algafood.domain.service;

import static java.lang.String.format;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.domain.model.Restaurante;
import com.algaworks.algafood.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {

	private static final String MSG_RESTAURANTE_NAO_ENCONTRADO = "Não existe cadastro de restaurante com código %d";

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaService cozinhaService;

	public Restaurante salvar(Restaurante restaurante) {
		final Long cozinhaId = restaurante.getCozinha().getId();
		final Cozinha cozinha = cozinhaService.buscarOuFalhar(cozinhaId);
		restaurante.setCozinha(cozinha);
		return restauranteRepository.save(restaurante);
	}

	public Restaurante buscarOuFalhar(Long id) {
		return restauranteRepository.findById(id)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(format(MSG_RESTAURANTE_NAO_ENCONTRADO, id)));
	}

	public void remover(Long id) {
		try {
			restauranteRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(format(MSG_RESTAURANTE_NAO_ENCONTRADO, id));
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					format("Restaurante de código %d não pode ser removido, pois está em uso", id));
		}
	}

}
