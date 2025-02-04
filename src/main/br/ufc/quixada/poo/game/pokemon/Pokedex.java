package br.ufc.quixada.poo.game.pokemon;

import br.ufc.quixada.poo.game.pokemon.batalha.Registravel;

import java.util.*;

public class Pokedex implements Registravel {
  private List<Pokemon> capturados = new ArrayList<>();
  private int ocorrencias[] = new int[151];

  @Override
  public void registrarEncontro(Pokemon pokemon) {
    EspeciePokemon especie = EspeciePokemon.valueOf(pokemon.getNome().toUpperCase());
    ocorrencias[especie.ordinal()]++;
  }

  @Override
  public void registrarCaptura(Pokemon pokemon) {
    capturados.add(pokemon);
  }

  public List<EspeciePokemon> getVistos() {
    List<EspeciePokemon> vistos = new ArrayList<>();
    for(int i = 0; i < ocorrencias.length; i++) {
      if(ocorrencias[i] > 0) {
        EspeciePokemon especie = EspeciePokemon.values()[i];
        vistos.add(especie);
      }
    }
    vistos.sort((o1, o2) -> o1.ordinal() - o2.ordinal());
    return vistos;
  }

  public List<Pokemon> getCapturados() {
    capturados.sort((p1, p2) -> p1.getEspecie() - p2.getEspecie());
    return capturados;
  }

  public long contarCapturaPorEspecie(EspeciePokemon especie) {
    return capturados.stream().filter(p -> p.getNome().equals(especie.getNome())).count();
  }

  public long contarVistosPorEspecie(EspeciePokemon especie) {
    return ocorrencias[especie.ordinal()];
  }

  public double taxaDeSucesso(EspeciePokemon especie) {
    return (contarCapturaPorEspecie(especie)/contarVistosPorEspecie(especie))*100;
  }
}









