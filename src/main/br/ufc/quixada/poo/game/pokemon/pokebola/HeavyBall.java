package br.ufc.quixada.poo.game.pokemon.pokebola;

import br.ufc.quixada.poo.game.pokemon.Pokemon;

public class HeavyBall extends Pokebola {

  private float getBonusPeso(Pokemon pokemon) {
    if(pokemon.getPeso() < 100f) {
      return -20;
    } else if(pokemon.getPeso() >= 100f && pokemon.getPeso() < 200f) {
      return 20;
    } else if (pokemon.getPeso() >= 200f && pokemon.getPeso() < 300f) {
      return 30;
    }
    return 0;
  }

  @Override
  protected float getTaxaDeCaptura(Pokemon pokemon) {
    return super.getTaxaDeCaptura(pokemon) + getBonusPeso(pokemon);
  }
}
