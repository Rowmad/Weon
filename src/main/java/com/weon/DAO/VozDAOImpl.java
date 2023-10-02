package com.weon.DAO;

import com.weon.Model.Voz;

/* Classe criada para implementar o consumo de mensagem de voz ou
* qualquer eventual interacao com o banco de dados*/
public class VozDAOImpl implements VozDAO {

	//consume mensagem de voz
	@Override
	public void consumeVoz(Voz voz) {
		System.out.println("Mensagem de voz consumida: "+voz);
	}
}