package br.ufc.quixada.poo.game.pokemon.pokebola;

import br.ufc.quixada.poo.game.pokemon.Pokemon;

public class FastBall extends PokebolaAfetaTaxa{

  @Override
  protected float getBonus(Pokemon pokemon) {
    if(pokemon.getVelocidade() >= 100) {
      return 4f;
    }
    return 1;
  }
}
