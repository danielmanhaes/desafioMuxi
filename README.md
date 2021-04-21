# desafioMuxi
# Nesse projeto estou utilizando o java 11

1 - Para executar o projeto, basta baixar o aquivo desafio-0.0.1-SNAPSHOT.jar que está na pasta desafioMuxi/target/
2 - No diretorio onde se encontra o arquivo, basta executar o commando "java -jar desafio-0.0.1-SNAPSHOT.jar"
3 - As requisiçoes a API devem ser feitas da seguinte maneira via postman:

  a) Adicionar um terminal 
  
  POST localhost:9090/1.0/terminal/insert
  44332211;123;PWWIN;0;F04A2E4088B;4;8.00b3;0;16777216;PWWIN
  
  b) Consultar um terminal 
  GET localhost:9090/1.0/terminal/{logic}
  
  c) Atualizar um terminal adicionado
  PUT localhost:9090/1.0/terminal/{logic}
  
  obs: enviar um objeto JSON no body como exemplo abaixo:
 
  {
    "logic": 44332211,
    "serial": "123",
    "model": "PWWIN",
    "sam": 0,
    "ptid": "F04A2E4088B",
    "plat": 4,
    "version": "8.00b3",
    "mxr": 0,
    "mxf": 16777216,
    "VERFM":”PWWIN"
  }
 
 
 -------------------
 by dmanhaes ;)
