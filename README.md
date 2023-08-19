# **Sobre o Projeto**

O projeto se trata de uma API REST desenvolvida com o intuito de solidificar e aprimorar minha compreensão em Java e no framework Spring. Foi concebido com o propósito duplo de fortalecer minhas habilidades e compreender as complexidades de utilizar o Git durante todo o processo de desenvolvimento. Através dessa iniciativa, meu objetivo é não apenas aprofundar meu conhecimento nessas tecnologias, mas também criar uma aplicação funcional e prática que demonstre meu progresso e proficiência nessa área.

# **Descrição do projeto**

A aplicação consiste em disponibilizar uma lista de jogos API Rest no qual o usuário poderá utilizar em outras aplicações.  
O projeto foi desenvolvido em Java, utilizando a arquitetura em camadas e o framework Spring utilizando as dependências Spring Web, Spring Data JPA e o H2 Database (banco em memória). A figura abaixo ilustra a arquitetura do projeto

![Arquitetura em camadas do projeto](https://i.imgur.com/YsLu5Ll.png)

## **Explicação**

**Camada de acesso a dados:** É a camada que se comunica com o banco de dados H2 através da técnica ORM (Object-Relational Mapping), que mapeia os objetos do programa com as tabelas do banco H2, executando as operações de consulta e manipulação de dados. Essas operações são feitas pelos objetos chamados de Repository no sistema;  
**Camada de serviço:** É a camada que coordena e organiza as operações e que implementa as regras de negócio do sistema. Essa camada utiliza os DTOs (Data Transfer Objects) para enviar e receber os dados para as outras camadas;  
**Controladores REST:** Usam a camada de serviço para retornar uma resposta à camada cliente. Eles são responsáveis por definir os endpoints (caminho da aplicação/ URL) do sistema.

### O Script Python

Em 19 de agosto de 2023, foi incluído no projeto o script *create_short_description.py* como parte do desafio do Bootcamp de Ciência de Dados DIO+Santander. Esse script utiliza o processo ETL (Extração, Transformação e Carregamento) para extrair da API os dados de jogos com os IDs especificados em um arquivo CSV. Ele utiliza a API do Chat-GPT para gerar descrições para esses jogos e, em seguida, atualiza a API por meio do método HTTP PUT.

**Observação:** Devido ao uso gratuito limitado no tempo da API da OpenAI, utilizei o arquivo CSV para processar apenas alguns jogos de forma a tornar a execução do script eficiente.

**Nota:** Para usar o script, basta inserir a chave da API do Chat-GPT.

# **Status do Projeto**  
🚧🚧**Em desenvolvimento** 🚧🚧  
. No momento, o projeto só está com o perfil de testes. Futuramente, pretendo criar a parte front-end do projeto e criar os perfis de desenvolvedor (conexão com o PostgresDB) e de produção (para hospedar o projeto na nuvem utilizando o Railway).


# **Tecnologias utilizadas**
**Eclipse IDE**  

**Maven:** É uma ferramenta de gerenciamento e construção baseado em um modelo de projeto para Java e que permite gerar as dependências, plugins e configurações de construção da comunicação entre a aplicação e o banco de dados;  

**Spring:**  É um framework de desenvolvimento para Java que facilita a criação de aplicações com a utilização de diversos módulos independentes. Para o projeto, utilizei as seguintes dependências, adicionadas ao projeto a partir do Spring Initializr:

![Imgur](https://i.imgur.com/NU1cLaY.png)

# **Como utilizar**
Ao executar o projeto, o Spring Boot configura o servidor web para ser acessado localmente na máquina através do domínio localhost:8080.  
Uma vez com o projeto rodando, basta acessar os endpoints configurados no projeto, que são:  
* **localhost:8080/games** -> Disponibiliza as informações dos jogos que estão disponíveis pelo sistema. É possível incluir o id no final da URL para ter acesso a apenas um objeto da aplicação (Ex.: localhost:8080/games/2);  
* **localhost:8080/lists** -> Exibe o nome das listas de jogos eletrônicos de acordo com o gênero (no momento, há duas listas: Jogos de plataforma e jogos de Aventura e RPG);
* **localhost:8080/lists/{id}/games** -> Exibe os jogos de acordo com o gênero, informado através do id. O id da lista de aventura e RPG é 1 e de jogos de plataforma é 2.

# Autor
**Guilherme Vaiano Nogueira Mendonça**  
LinkedIn: https://www.linkedin.com/in/guilherme-vaiano/