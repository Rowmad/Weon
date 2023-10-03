package com.weon.Controller;

import com.weon.DAO.*;
import com.weon.Model.Chat;
import com.weon.Model.Email;
import com.weon.Model.Voz;
import com.weon.Producer.Message.Message;

//Classe para controlar o consumo das mensagens
public class Controller {
    private ChatDAO chatDAO;
    private EmailDAO emailDAO;
    private VozDAO vozDAO;
    //controla a quantidade de menssagens que foi consumida
    private int qtdConsumida;

    private static final Controller controller = new Controller();

    private Controller() {
        qtdConsumida = 0;
        chatDAO = new ChatDAOImpl();
        emailDAO = new EmailDAOImpl();
        vozDAO = new VozDAOImpl();
    }

    public static Controller getInstance() {
        return controller;
    }

    //Metodo para consumir as mensagens
    public void consume(Message message){
        //Caso a mensagem seja maior que ou igual a 30000 é uma mensagem de voz
        if (message.getId()>=30000) {
            Voz voz = new Voz(message.getId(),message.getOrigin(), message.getDestination(), message.getDate());
            vozDAO.consumeVoz(voz);
        }
        //caso a mensagem seja menor que 3000 e mais ou igual a 20000 é uma mensagem de Email
        if (message.getId()<30000 && message.getId()>=20000 ) {
            Email email = new Email(message.getId(), message.getOrigin(), message.getDestination(), message.getDate());
            emailDAO.consumeEmail(email);
        }

        //caso a mensagem seja menor que 20000
        if (message.getId()<20000) {
            Chat chat = new Chat(message.getId(), message.getOrigin(), message.getDestination(), message.getDate());
            chatDAO.consumeChat(chat);
        }

        qtdConsumida++;
    }
}
