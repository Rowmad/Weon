package com.weon.Producer.Message;

import com.weon.Utils.MessageType;

public class MessageFactory {
	/*quantidade de mensagens produzidas,
	*esse valor tambem sera utilizado para incrementar os Ids das mensagens*/
	private int qtdMensagem;
	//Unica instancia de objeto que sera usada
	private static final MessageFactory messageFactory = new MessageFactory();

	//Colocando o construtor como privado dessa forma nao havera como criar outra instancia
	private MessageFactory(){
		qtdMensagem = 0;
	}

	//Metodo usado para retornar a unica instacia criada para MessageFactory
	public static MessageFactory getInstance(){
		return messageFactory;
	}

	/*Gera as mensagens de acordo com o tipo soliciado
	* 0-Chat,  1-Email  outro valor - Voz */
	public Message generateMessages (int messageType) {

		//Cria mensagem do tipo chat se messageType = 1 e incrementa a quantidade de mensagens criadas
		if(messageType == MessageType.Chat.ordinal())
			return new ChatMessage(++qtdMensagem);

		//Cria mensagem do tipo email se messageType = 2 e incrementa a quantidade de mensagens criadas
		if(messageType == MessageType.Email.ordinal())
			return new EmailMessage(++qtdMensagem);

		/*Cria mensagem do tipo Voz se messageType for diferente de 1 e 2
		* incrementa a quantidade de mensagens criadas */
		return new VozMessage(++qtdMensagem);
	}

}