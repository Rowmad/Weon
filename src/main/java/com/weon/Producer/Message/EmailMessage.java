package com.weon.Producer.Message;

import java.time.LocalDate;

// Classe criada para implementar a producacao de mensagens do tipo Email
public class EmailMessage implements Message {

	private final int id;
	private final String emailOrigem;
	private final String emailDestino;
	private final LocalDate data;

	/*Uso do construtor para especificar os valores de para o tipo Email,
	 *nesse caso os Ids estarao entre 2000 e 2999*/
	public EmailMessage(int id) {
		this.id = 2000+id;
		this.emailOrigem = "origem_"+id+"@email.com";
		this.emailDestino = "destino_"+id+"@email.com";
		this.data = LocalDate.now();
	}

	public int getId() {
		return id;
	}

	public String getOrigin() {
		return emailOrigem;
	}

	public String getDestination() {
		return emailDestino;
	}

	public LocalDate getDate() {
		return data;
	}
}