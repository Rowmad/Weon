package com.weon.Model;

import java.time.LocalDate;

public class Voz {

	private int id;
	private String telefoneOrigem;
	private String telefoneDestino;
	private LocalDate data;

	public Voz(int id, String telefoneOrigem, String telefoneDestino, LocalDate data) {
		this.id = id;
		this.telefoneOrigem = telefoneOrigem;
		this.telefoneDestino = telefoneDestino;
		this.data = data;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTelefoneOrigem() {
		return telefoneOrigem;
	}

	public void setTelefoneOrigem(String telefoneOrigem) {
		this.telefoneOrigem = telefoneOrigem;
	}

	public String getTelefoneDestino() {
		return telefoneDestino;
	}

	public void setTelefoneDestino(String telefoneDestino) {
		this.telefoneDestino = telefoneDestino;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Mensagem de Voz com id = " + id;
	}
}