package br.ufc.quixada.poo.game.pokemon.pokebola;

import br.ufc.quixada.poo.game.pokemon.Pokemon;

public class GreatBall extends PokebolaAfetaTaxa {


  @Override
  protected float getBonus(Pokemon pokemon) {
    return 1.5f;
  }
}
