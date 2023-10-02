package com.weon.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

//classe responsavel por realizar a leitura inicial dos dados necessarios
public class InitialLoad {

    //metodo responsavel por pegar os valores do arquivo configuration.properties
    public static Properties getProp() throws IOException {
        Properties props = new Properties();
        FileInputStream file = new FileInputStream(
                "./properties/configuaration.properties");
        props.load(file);
        return props;
    }
}
