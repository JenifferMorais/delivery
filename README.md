# Como executar o projeto delivery

Para executar esse projeto, o primeiro passo é criar uma pasta chamada "test" no disco local (C:) e instalar o firebird. Dentro da pasta do firebird, abra o terminal e execute os seguintes passos:
    1- .\isql.exe
    2- CREATE database 'C:\\test\\DATABASEFDB.FDB' user 'sysdba' password 'masterkey';
    3- CONNECT 'C:\\Users\\test\\DATABASEFDB.FDB'  user 'sysdba' password 'masterkey';
    4- CREATE user sysdba password 'masterkey'

Após, abra a conexão (no meu caso utilizei o dbeaver), com as seguintes informações:
Path: C:\\test\\DATABASEFDB.FDB
Username: SYSDBA
Password: masterkey

Com a conexão criada, rode os scripts que estão no arquivo script do projeto.

Abra o projeto na sua IDE de preferência, e execute o projeto com o seguinte comando:
    	1- mvn spring-boot:run

*** Crie um usuário e faça login, para conseguir realizar outras operações ***

# Roda Auth
Como POST: http://localhost:8080/auth para realizar o login

# Rodas User
Como GET: http://localhost:8080/user para buscar todos os usuários.
Como POST: http://localhost:8080/user para criar um usuário.
Como GET: http://localhost:8080/user/{id} para buscar um usuário passando o id.
Como DELETE: http://localhost:8080/user/{id} para deletar um usuário passando o id.

# Rodas Client
Como GET: http://localhost:8080/client para buscar todos os cliente.
Como POST: http://localhost:8080/client para criar um cliente.
Como GET: http://localhost:8080/client/{id} para buscar um cliente passando o id. 
Como DELETE: http://localhost:8080/client/{id} para deletar um cliente passando o id.

# Rodas Delivery
Como GET: http://localhost:8080/delivery para buscar todas os entregas.
Como POST: http://localhost:8080/delivery para criar uma entrega.
Como GET: http://localhost:8080/delivery/{id} para buscar uma entrega passando o id.
Como DELETE: http://localhost:8080/delivery/{id} para deletar uma entrega passando o id.

# Rodas Order
Como GET: http://localhost:8080/order para buscar todos os pedidos.
Como POST: http://localhost:8080/order para criar um pedido.
Como GET: http://localhost:8080/order/{id} para buscar um pedido passando o id.
Como DELETE: http://localhost:8080/order/{id} para deletar um pedido passando o id.




