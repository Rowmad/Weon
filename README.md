# Weon

## Configuração
### Configuração da execução
Para ser possivel executar o projeto é necessario ter instalado a versão do Java 17 ou superior, lembre que a versão da sua IDE deve ser compativel com essa versão.
Nas variaveis de ambiente do sistema adicione a variavel JAVA_HOME com o valor do caminho em que o Java foi instalado.

![Javahome](https://github.com/Rowmad/Weon/assets/32908000/5f73c13e-cbdc-4327-842b-a3c86a889235)

Caso seja necessario configure o executor de sua IDE, tambem utilizado uma versão do Java 17 ou superior, como mostra o exemplo:

![Runner](https://github.com/Rowmad/Weon/assets/32908000/905dab91-159c-4737-9c3e-e90a8a6b6b7d)

### Configuração das propriedades
A configuração do projeto é feito no arquivo properties/configuaration.properties, que possue 3 variaveis:
* prop.numero.produtores - Essa variavel derteminara a quantidade de threads de produtores que seram criadas.
* prop.numero.consumidores - Essa variavel derteminara a quantidade de threads de consumidores que seram criadas.
* prop.tamanho.fila - Essa variavel determinara o tamanho da fila que sera criada e uma vez que a produção de mensagens atigir o tamanho da fila a produção sera encerrada.
