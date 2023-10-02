package com.weon.Consumer;

import com.weon.Controller.Controller;
import com.weon.Producer.Message.Message;
import com.weon.Utils.MessageQueue;

//Classe criada para consumir mensagens da fila de mensagens
public class Consumer extends Thread {

    //Pega a unica instancia de MessageQueue
    MessageQueue messageQueue = MessageQueue.getInstance();
    //usado para consumir as mensagens
    Controller controller = Controller.getInstance();

    @Override
    public void run(){
        synchronized(this){
            /*vai tentar consumir enquanto ainda for possivel produzir, se a fila nao estiver cheia
            ou enquanto ainda restar mensagens a serem consumidas */
            while(!messageQueue.isQueueFull() || !messageQueue.isQueueEmpty()){
                //remove a mensagem da fila
                Message messageConsume = messageQueue.removeMessage();

                //consome a mensagem se nao for nula
                if (messageConsume != null)
                    controller.consume(messageConsume);
            }
        }
    }
}