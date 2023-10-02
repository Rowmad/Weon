package com.weon;

import com.weon.Consumer.Consumer;
import com.weon.Producer.Producer;
import com.weon.Utils.InitialLoad;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Properties;

@SpringBootApplication
public class TesteWeonApplication {

	public static void main(String[] args) throws IOException {
		Properties properties = InitialLoad.getProp();
		int numberProducers = Integer.parseInt((String) properties.get("prop.numero.produtores"));
		int numberConsumers = Integer.parseInt((String) properties.get("prop.numero.consumidores"));

		System.out.println("Numero de producers: "+numberProducers);
		System.out.println("Numero de consumidores: "+numberConsumers);

		for (int i =0; i<numberProducers;i++)
			new Producer().start();

		for (int i =0; i<numberConsumers;i++)
			new Consumer().start();
	}
}
