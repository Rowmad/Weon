package com.weon.DAO;

import com.weon.Model.Chat;

/* Classe criada para implementar o consumo Chats ou
* qualquer eventual interacao com o banco de dados*/
public class ChatDAOImpl implements ChatDAO {

	//consume mensagem de voz
	@Override
	public void consumeChat(Chat chat) {
		System.out.println("Chat consumido: "+chat);
	}
}