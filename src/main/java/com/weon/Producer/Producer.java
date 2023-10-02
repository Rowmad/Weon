package com.weon.Producer;

import com.weon.Utils.MessageQueue;
import com.weon.Producer.Message.Message;
import com.weon.Producer.Message.MessageFactory;

import java.util.Random;

//Classe criada para adicionar mensagens na fila de mensagens
public class Producer extends Thread {
    //Pega a unica instancia de MessageFactory
    private final MessageFactory messageFactory = MessageFactory.getInstance();
    //Pega a unica instancia de MessageQueue
    private final MessageQueue messageQueue = MessageQueue.getInstance();

    @Override
    public void run(){
        synchronized(this){
            Random radom = new Random();
            while(!messageQueue.isQueueFull()){
                //gera uma nova mensagem com o tipo aleatorio
                Message message = messageFactory.generateMessages(radom.nextInt(3));
                //insere mensagem na fila
                messageQueue.insertMessage(message);
            }
        }
    }
}