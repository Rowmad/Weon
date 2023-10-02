package com.weon.Model;

import java.time.LocalDate;

public class Email {

	private int id;
	private String emailOrigem;
	private String emailDestino;
	private LocalDate data;

	public Email(int id, String emailOrigem, String emailDestino, LocalDate data) {
		this.id = id;
		this.emailOrigem = emailOrigem;
		this.emailDestino = emailDestino;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailOrigem() {
		return emailOrigem;
	}

	public void setEmailOrigem(String emailOrigem) {
		this.emailOrigem = emailOrigem;
	}

	public String getEmailDestino() {
		return emailDestino;
	}

	public void setEmailDestino(String emailDestino) {
		this.emailDestino = emailDestino;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Mensagem de Email com id = " + id;
	}
}