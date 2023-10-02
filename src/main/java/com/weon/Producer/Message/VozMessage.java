package com.weon.Producer.Message;

import java.time.LocalDate;

// Classe criada para implementar a producacao de mensagens do tipo Voz
public class VozMessage implements Message {

	private final int id;
	private final String telefoneOrigem;
	private final String telefoneDestino;
	private final LocalDate data;

	/*Uso do construtor para especificar os valores de para o tipo mensagem de voz,
	 *nesse caso os Ids estarao entre 3000 e 3999*/
	public VozMessage(int id) {
		this.id = 3000+id;
		this.telefoneOrigem = this.id+"-"+this.id;
		this.telefoneDestino = this.id+"-"+this.id;
		this.data = LocalDate.now();
	}

	public int getId() {
		return id;
	}

	public String getOrigin() {
		return telefoneOrigem;
	}

	public String getDestination() {
		return telefoneDestino;
	}

	public LocalDate getDate() {
		return data;
	}
}