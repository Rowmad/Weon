package com.weon.DAO;

import com.weon.Model.Email;

/* Classe criada para implementar o consumo ou
* qualquer eventual interacao com o banco de dados*/
public class EmailDAOImpl implements EmailDAO {

	//consume mensagem de voz
	@Override
	public void consumeEmail(Email email) {
		System.out.println("Email consumido: "+email);
	}
}