package com.betrybe.consultafilmes;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptyMap;
import static java.util.Collections.emptySet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Queries {

  private final Collection<Movie> movies;

  public Queries(Collection<Movie> movies) {
    this.movies = movies;
  }

  /**
   * Consulta 1: a partir da coleção de filmes desta classe, este método retorna o conjunto
   * de atores que interpretaram a si próprios em pelo menos um desses filmes.
   *
   * <p>Considera-se "atores que interpretaram a si próprios" aqueles que têm o seu nome como
   * uma das chaves do Map `atoresPorPersonagem` e também como um dos itens pertencentes ao
   * conjunto associado a esta mesma chave.</p>
   */
  public Set<String> actorsThatInterpretThemselves() {
    return movies.stream()
        .flatMap(movie -> movie.getActorsByCharacters().entrySet().stream())
        .filter(entry -> entry.getValue().contains(entry.getKey()))
        .map(Map.Entry::getKey)
        .collect(Collectors.toSet());
  }

  /**
   * Consulta 2: a partir da coleção de filmes desta classe, este método retorna a lista de atores
   * que atuaram em pelo menos um filme de um determinado diretor. A lista retornada está disposta
   * em ordem alfabética.
   *
   * <p>Considera-se que um ator tenha atuado em um filme de um determinado diretor se ele tem o
   * seu nome como um dos itens do campo `atores`, ao mesmo tempo em que o diretor em questão
   * tem o seu nome como um dos itens do campo `directors` do mesmo filme.</p>
   */
  public List<String> actorsThatActedInMoviesOfDirectorInAlphabeticOrder(String diretor) {
    return movies.stream()
        .filter(movie -> movie.getDirectors().contains(diretor))
        .flatMap(movie -> movie.getActors().stream()).distinct().sorted()
        .toList();
  }

  /**
   * Consulta 3: a partir da coleção de filmes desta classe, este método retorna a lista de filmes
   * em que pelo menos um dos directors tenha atuado. A lista retornada está disposta em ordem de
   * lançamento, com os filmes mais recentes no início.
   *
   * <p>Considera-se "filmes em que pelo menos um dos directors tenha atuado" aqueles em que
   * pelo menos um dos itens do campo `directors` também é um item do campo `atores`.</p>
   */
  public List<Movie> moviesWithAtLeastOneDirectorActedMostRecentFirst() {
    return movies.stream()
        .filter(movie -> movie.getActors().stream().anyMatch(movie.getDirectors()::contains))
        .sorted(Comparator.comparingInt(Movie::getReleaseYear).reversed()).distinct()
        .toList();
  }

  /**
   * Consulta 4: a partir da coleção de filmes desta classe, este método retorna um Map contendo
   * all os filmes lançados em um determinado ano agrupados por categoria.
   *
   * <p>Cada chave do Map representa uma categoria, enquanto cada valor representa o
   * conjunto de filmes que se encaixam na categoria da chave correspondente.</p>
   */
  public Map<String, Set<Movie>> moviesReleasedInYearGroupedByCategory(int ano) {
    List<Movie> filteredMovies = movies.stream()
        .filter(movie -> movie.getReleaseYear() == ano)
        .toList();

    List<String> filteredCategories = filteredMovies.stream()
        .flatMap(movie -> movie.getCategories().stream()).distinct()
        .toList();

    Map<String, Set<Movie>> result = new HashMap<>();

    for (String categoty : filteredCategories) {
      Set<Movie> moviesByCategory = filteredMovies.stream()
              .filter(movie -> movie.getCategories().contains(categoty))
                  .collect(Collectors.toSet());
      result.put(categoty, moviesByCategory);
    }

    return result;
  }
}
