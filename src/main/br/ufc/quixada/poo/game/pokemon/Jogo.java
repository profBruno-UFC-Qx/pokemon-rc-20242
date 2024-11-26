package br.ufc.quixada.poo.game.pokemon;

import java.util.Scanner;

public class Jogo {

  private Mapa mapa;
  private Treinador treinador;

  public Jogo(String nome) {
    treinador = new Treinador(nome);
    mapa = new Mapa(10, 10);
  }

  public void iniciar() {
    Scanner scanner = new Scanner(System.in);
    String opcao = "";
    do {
      mapa.exibirMapa(treinador.getX(), treinador.getY());
      System.out.println("Para onde quer ir? c, b, f, t ou sair");
      opcao = scanner.nextLine();
      alteraPosicaoTreinador(opcao);
    } while(!opcao.equals("sair"));

  }

  private void alteraPosicaoTreinador(String direcao) {
    int x = treinador.getX();
    int y = treinador.getY();

    switch (direcao) {
      case "c":
        y--;
        break;
      case "b":
        y++;
        break;
      case "t":
        x--;
        break;
      case "f":
        x++;
        break;
      case "sair":
        System.exit(0);
      default:
        System.out.println("Direção inválida");
        break;
    }
    if (mapa.posicaoValida(x, y)) {
      treinador.setPosicao(x, y);
    }
  }
}
