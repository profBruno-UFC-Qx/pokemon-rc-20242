package br.ufc.quixada.poo.game.pokemon.batalha;

import br.ufc.quixada.poo.game.pokemon.Pokemon;
import br.ufc.quixada.poo.game.pokemon.Treinador;
import br.ufc.quixada.poo.game.pokemon.pokebola.Pokebola;

import java.util.Scanner;

public class Batalha {
  private final Treinador treinador;
  private final Pokemon pokemon;
  private boolean terminou;

  public Batalha(Treinador treinador, Pokemon pokemon) {
    this.treinador = treinador;
    this.pokemon = pokemon;
  }


  public void iniciar() {
    System.out.println("Você encontrou um " + pokemon.getNome() + "!");
    treinador.getPokedex().registrarEncontro(pokemon);
  }

  public boolean terminou() {
    return terminou;
  }

  public void proximoTurno() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Escolha uma ação:");
    System.out.println("1. Tentar Capturar");
    System.out.println("2. Fugir");

    String escolha = scanner.nextLine();

    switch (escolha) {
      case "1":
        //Recuperar Pokebola e tentar captura
        Pokebola pokebola = treinador.arremessarPokebola();
        boolean capturou = false;
        if(pokebola == null) {
          System.out.println("Você não tem mais pokebola. O pokemo escapou!");
          terminou = true;
        } else {
          capturou = tentarCaptura(pokebola);
          terminou = capturou;
        }
        break;
      case "2":
        System.out.println("Você fugiu da batalha!");
        terminou = true;
        break;
      default:
        System.out.println("Escolha inválida.");
        break;
    }
  }

  private boolean tentarCaptura(Pokebola pokebola) {
    System.out.println("Tentando capturar " + pokemon.getNome() + " com " + pokebola.getClass().getSimpleName());
    //System.out.println("Chance de captura: " + chanceCaptura + "%");

    if (pokebola.capturar(pokemon)) {
        treinador.getPokedex().registrarCaptura(pokemon);
        System.out.println("Parabéns! Você capturou " + pokemon.getNome());
        return true;
    } else {
      System.out.println("A captura falhou! O Pokémon quebrou a pokebola.");
      return false;
    }
  }
}

