# TESTE UBOTS

### Instruções para avaliação
Foi criado uma base H2 para realização da tarefa e a documentação foi feita com springDoc
Ao executar o projeto, as URLs estarão disponíveis em:
* [Acesso a base H2](http://localhost:8081/h2-console)
* [Acesso ao Swagger](http://localhost:8081/swagger-ui.html)

### Resumo
* Utilizado Spring Boot, JPA, Lombok, H2 Driver e Scheduler
* A atribuição de atendimentos é feita a cada 30 seg (configurável)
* Ao alterar a coluna solicitacao.st_solicitacao de 'OPEN' para 'CLOSED' o processo irá atribuir uma nova solicitação 
ao usuário que ficou disponível para receber demanda
* Dúvidas? <br>
  allansaturno@gmail.com


