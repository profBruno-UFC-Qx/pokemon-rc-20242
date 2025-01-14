package br.ufc.quixada.poo.game.pokemon.pokebola;

import br.ufc.quixada.poo.game.pokemon.Pokemon;

public class UltraBall extends PokebolaAfetaTaxa {


  @Override
  protected float getBonus(Pokemon pokemon) {
    return 2.0f;
  }
}
