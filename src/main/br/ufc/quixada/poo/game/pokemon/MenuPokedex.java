package br.ufc.quixada.poo.game.pokemon;

import java.util.Scanner;

public class MenuPokedex {

  private Pokedex pokedex;

  public MenuPokedex(Pokedex pokedex) {
    this.pokedex = pokedex;
  }


  private void mostrarOpcoes() {
    System.out.println("Escolha uma das opções abaixo:");
    System.out.println("1. Listar pokemons capturados");
    System.out.println("2. Listar pokemons vistos");
    System.out.println("3. Ver detalhes sobre uma especie");
    System.out.println("4. Voltar");
  }

  public void mostrarMenu() {
    Scanner scanner = new Scanner(System.in);
    String opcao = null;

    do {
      mostrarOpcoes();
      opcao = scanner.nextLine();
      switch (Integer.parseInt(opcao)) {
        case 1:
          listarCapturados();
          break;
        case 2:
          listarVistos();
          break;
        case 3:
          System.out.println("Escolha uma espécie:");
          opcao = scanner.nextLine();
          verDetalhes(opcao);
          break;
      }
    } while(!opcao.equals("4"));
  }

  private void verDetalhes(String opcao) {
    EspeciePokemon especie = EspeciePokemon.valueOf(opcao.toUpperCase());
    long qtdCapturados = pokedex.contarCapturaPorEspecie(especie);
    long qtdVistos = pokedex.contarVistosPorEspecie(especie);
    double taxa = pokedex.taxaDeSucesso(especie);

    System.out.println("Voce capturou " + qtdCapturados + " " + especie.getNome() + " dos " + qtdVistos + " que voce viu. Resultando em uma taxa de " + taxa + "% sucesso.");
  }

  private void listarVistos() {
    for(EspeciePokemon especiePokemon: pokedex.getVistos()) {
      System.out.println(especiePokemon.ordinal() + 1 + ". " + especiePokemon.getNome());
    }
  }

  private void listarCapturados() {
    for(Pokemon pokemon: pokedex.getCapturados()) {
      System.out.println(pokemon);
    }
  }


}
