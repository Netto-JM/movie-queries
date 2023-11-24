# Consulta de Filmes em Java

Este repositório contém um projeto Java que realiza consultas em uma coleção de filmes.

## Estrutura do Projeto

O projeto consiste nas seguintes classes:

1. `Movie`: Representa um filme, contendo informações como título, ano de lançamento, categorias, diretores, atores e personagens.

2. `MovieConstructor`: Usado para construir instâncias da classe `Movie`.

3. `Queries`: Realiza várias consultas em uma coleção de filmes.

4. `Movies`: Onde os filmes são instanciados para a consulta.

5. `Main`: Onde as consultas podem ser executadas.

## Consultas

A classe `Queries` implementa as seguintes consultas:

1. `actorsThatInterpretThemselves()`: Retorna um conjunto de atores que interpretaram a si mesmos em pelo menos um dos filmes na coleção.

2. `actorsThatActedInMoviesOfDirectorInAlphabeticOrder(String diretor)`: Retorna uma lista de atores que atuaram em pelo menos um filme de um determinado diretor. A lista é ordenada alfabeticamente.

3. `moviesWithAtLeastOneDirectorActedMostRecentFirst()`: Retorna uma lista de filmes em que pelo menos um dos diretores atuou. A lista é ordenada por ano de lançamento, com os filmes mais recentes no início.

4. `moviesReleasedInYearGroupedByCategory(int ano)`: Retorna um mapa contendo todos os filmes lançados em um determinado ano, agrupados por categoria.

## Como Usar

Para usar este projeto, você precisa ter o Java instalado em seu sistema. Você pode clonar este repositório e executar o arquivo `Main.java` para ver os resultados das consultas.

## Contribuindo

Contribuições são bem-vindas! Sinta-se à vontade para abrir uma issue ou enviar um pull request.
