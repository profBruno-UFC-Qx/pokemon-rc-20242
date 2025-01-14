package br.ufc.quixada.poo.game.pokemon.pokebola;

import br.ufc.quixada.poo.game.pokemon.Pokemon;

public class Pokebola {

  protected float getBonus(Pokemon pokemon) {
    return 1;
  }

  protected float getTaxaDeCaptura(Pokemon pokemon) {
    return (3*pokemon.getHpMax() - 2*pokemon.getHpAtual())/(3*pokemon.getHpMax())
            * pokemon.getTaxaDeCaptura() * getBonus(pokemon) * 1;
  }

  public boolean capturar(Pokemon p) {
    float taxaDeCaptura = getTaxaDeCaptura(p);
    double sorte = Math.random();
    System.out.println("Você tem " + taxaDeCaptura*100 + "% de chances captura");
    System.out.println(sorte);
    return sorte < taxaDeCaptura;
  }
}
