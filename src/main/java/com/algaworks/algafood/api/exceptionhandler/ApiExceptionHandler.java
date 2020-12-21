package com.algaworks.algafood.api.exceptionhandler;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.algaworks.algafood.domain.exception.EntidadeEmUsoException;
import com.algaworks.algafood.domain.exception.EntidadeNaoEncontradaException;
import com.algaworks.algafood.domain.exception.NegocioException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ProblemType type = ProblemType.MENSAGEM_NAO_LEGIVEL;
		String detail = "O corpo da requisição está inválido. Verifique erro de sintaxe";
		
		Problem problem = createProblemBuilder(status, type, detail).build();
		
		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}

	@ExceptionHandler(EntidadeNaoEncontradaException.class)
	public ResponseEntity<?> handleEntidadeNaoEncontradaExcetion(Exception ex, WebRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		ProblemType type = ProblemType.ENTIDADE_NAO_ENCONTRADA;
		String detail = ex.getMessage();

		Problem problem = createProblemBuilder(status, type, detail).build();

		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}

	@ExceptionHandler(EntidadeEmUsoException.class)
	public ResponseEntity<?> handleEntidadeEmUsoException(Exception ex, WebRequest request) {
		HttpStatus status = HttpStatus.CONFLICT;
		ProblemType type = ProblemType.ENTIDADE_EM_USO;
		String detail = ex.getMessage();

		Problem problem = createProblemBuilder(status, type, detail).build();

		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}

	@ExceptionHandler(NegocioException.class)
	public ResponseEntity<?> handleNegocioExcetion(Exception ex, WebRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		ProblemType type = ProblemType.ERRO_NEGOCIO;
		String detail = ex.getMessage();

		Problem problem = createProblemBuilder(status, type, detail).build();

		return handleExceptionInternal(ex, problem, new HttpHeaders(), status, request);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		if (body == null) {
			body = Problem.builder()
					.status(status.value())
					.detail(status.getReasonPhrase()).build();
		} else if (body instanceof String) {
			body = Problem.builder()
					.status(status.value())
					.detail((String) body).build();
		}

		return super.handleExceptionInternal(ex, body, headers, status, request);
	}
	
	private Problem.ProblemBuilder createProblemBuilder(HttpStatus status, ProblemType type, String detail) {
		return Problem.builder()
				.status(status.value())
				.type(type.getPath())
				.title(type.getTitle())
				.detail(detail);
	}

}
