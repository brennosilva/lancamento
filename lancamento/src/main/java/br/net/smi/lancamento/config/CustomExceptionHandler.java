package br.net.smi.lancamento.config;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.net.smi.lancamento.model.MensagemDeErro;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = { IllegalArgumentException.class, IllegalStateException.class })
	protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {

		MensagemDeErro erro = new MensagemDeErro();
		erro.setMensagem("Parâmetros inválidos na requisição");
		erro.setDateTime(LocalDateTime.now());
		return handleExceptionInternal(ex, erro, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}
	
	
	@ExceptionHandler(value = { RecursoNaoEncontradoException.class })
	protected ResponseEntity<Object> recursoNaoEncontradoHandler(RuntimeException ex, WebRequest request) {

		MensagemDeErro erro = new MensagemDeErro();
		erro.setMensagem("O recurso não existe");
		erro.setDateTime(LocalDateTime.now());
		return handleExceptionInternal(ex, erro, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}
}
