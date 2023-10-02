package com.weon.Model;

import java.time.LocalDate;

public class Chat {

	private int id;
	private String usuarioOrigem;
	private String usuarioDestino;
	private LocalDate data;

	public Chat(int id, String usuarioOrigem, String usuarioDestino, LocalDate data) {
		this.id = id;
		this.usuarioOrigem = usuarioOrigem;
		this.usuarioDestino = usuarioDestino;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuarioOrigem() {
		return usuarioOrigem;
	}

	public void setUsuarioOrigem(String usuarioOrigem) {
		this.usuarioOrigem = usuarioOrigem;
	}

	public String getUsuarioDestino() {
		return usuarioDestino;
	}

	public void setUsuarioDestino(String usuarioDestino) {
		this.usuarioDestino = usuarioDestino;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Mensagem de chat com id = " + id;
	}
}