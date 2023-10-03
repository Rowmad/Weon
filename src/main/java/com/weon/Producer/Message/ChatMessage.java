package com.weon.Producer.Message;

import java.time.LocalDate;

// Classe criada para implementar a producacao de mensagens do tipo chat
public class ChatMessage implements Message {

	private final int id;
	private final String usuarioOrigem;
	private final String usuarioDestino;
	private final LocalDate data;

	/*Uso do construtor para especificar os valores de para o tipo Chat,
	*nesse caso os Ids estarao entre 1000 e 1999*/
	public ChatMessage(int id) {
		this.id = 10000+id;
		this.usuarioOrigem = "user_origem_"+id;
		this.usuarioDestino = "user_destino_"+id;
		this.data = LocalDate.now();
	}

	public int getId() {
		return id;
	}

	public String getOrigin() {
		return usuarioOrigem;
	}

	public String getDestination() {
		return usuarioDestino;
	}

	public LocalDate getDate() {
		return data;
	}
}