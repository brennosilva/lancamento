package br.net.smi.lancamento.model;

import java.time.LocalDateTime;

public class MensagemDeErro {

	private String mensagem;
	private LocalDateTime dateTime;
	
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public LocalDateTime getDateTime() {
		return dateTime;
	}
	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}
}
