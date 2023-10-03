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

## Descrição do funcionamento
### Produtores
Existem 3 tipos de mensagens que serão produzidas Chat, Email e Voz, cada tipo de mensagem será criada por uma classe diferente, mas todas fazem a implementação de uma mesma interface a interface Message. Todas as mensagens que serão geradas possuem um range de valores em seu Id diferentes uma das outras são elas:
* Mensagens do tipo Chat serão possuiram valor de Id entre 10000 e 19999, elas são geradas pelas classe ChatMessage.
* Mensagens do tipo Email serão possuiram valor de Id entre 20000 e 29999, elas são geradas pelas classe EmailMessage.
* Mensagens do tipo Voz serão possuiram valor de Id maior que 30000, elas são geradas pelas classe VozMessage.
Obs.: Nessa implementação se considera que não serão geradas mais do que 10000 mensagens.

A geração de mensagens é gerenciada pela classe MessageFactory o metodo generateMessages recebe como parametro o tipo da messagem que sera gerada, caso receba 0 sera gerada uma mensagem do tipo chat, caso receba 1 sera gerada uma mensagem do tipo email e caso receba outro valor sera gerado uma mensagem do tipo voz. Para auxiliar no controle dos tipos de mensagem foi criado o enum MessageType, com os tipos possiveis de mensagem.

A produção ira se iniciar quando uma thread for criada atraves da classe Producer, nessa classe um numero aleatorio entre 0 e 2 é gerado para criar uma mensagem com um tipo determinado de forma aleatoria, as mensagens são criadas ate a fila que é gerenciada pela classe MessageQueue estar cheia.  

### Consumidores
Serão consumidas 3 tipos de mensagem to tipo Chat, Email e Voz, cada tipo de mensagem tera uma classe que implementa uma interface diferente, o consumo de mensagens foi interpretado como uma possivel interação com o banco de dados, considerando cada tipo de mensagem como uma tabela diferente, por isso nesse caso cada tipo tem uma interface diferente. 
