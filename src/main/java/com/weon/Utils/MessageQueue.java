package com.weon.Utils;

import com.weon.Producer.Message.Message;
import java.io.IOException;
import java.util.Properties;

/* Essa classe contola a fila de mensagens, usando os atributos positionAdd e positionRemove
* é possivel controlar o proximo elemento q sera adicionado ou removido,
* garantindo dessa forma que a fila funcione como um FIFO*/
public class MessageQueue {
    //Unica instancia de objeto que sera usada
    private static final MessageQueue messageQueue = new MessageQueue();
    //fila com as menssagens que serao inseridas e removidas
    private Message [] queue;
    //tamanho da fila que sera criada
    private final int queueSize;
    //posicao na fila do proximo elemento q sera adicionado
    private int positionAdd;
    //posicao na fila do proximo elemento q sera removido
    private int positionRemove;

    //Colocando o construtor como privado dessa forma nao havera como criar outra instancia
    private MessageQueue() {
        Properties properties;

        try {
            properties = InitialLoad.getProp();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //carrega o tamanho da fila pelo arquivo configuration.properties
        queueSize = Integer.parseInt((String) properties.get("prop.tamanho.fila"));
        queue = new Message[queueSize];
        //comeca a adicionar mensagens na posicao 0
        positionAdd = 0;
        //comeca a remover mensagens na posicao 0
        positionRemove = 0;
    }

    //Metodo para acessarem a instacia de objeto criada
    public static MessageQueue getInstance(){
        return messageQueue;
    }

    //metodo para acrescentar novas mensagens
    public void insertMessage(Message message) {
        //apenas acresta novos elementos se houver espaco na fila
        if(!isQueueFull()) {
            //adiciona a mensagem na proxima posicao disponivel
            queue[positionAdd] = message;
            positionAdd++;
        }
    }

    //metodo para consumir e remover a proxima mensagem da fila
    public Message removeMessage() {
        //mensagem a removida a ser retornada, se nhuma for removida retorna null
        Message messageRemoved = null;
        //apenas remove a proxima mensagem se houver alguma mensagem na lista
        if (!isQueueEmpty()) {
            messageRemoved = queue[positionRemove];
            //remove a conteudo da mensagem consumida
            queue[positionRemove] = null;
            positionRemove ++;
        }
        return messageRemoved;
    }

    /*verifica se a fila esta cheia, considerando se todas as posicoes
     possiveis ja foram adicionadas */
    public boolean isQueueFull(){
        return positionAdd > queueSize - 1;
    }

    /*verifica se a fila esta vazia, considerando se ja foi adicionado algum valor
    ou se todos os valores da fila ja foram removidos*/
    public boolean isQueueEmpty(){
        return positionAdd == 0 || positionRemove > queueSize -1;
    }
}
