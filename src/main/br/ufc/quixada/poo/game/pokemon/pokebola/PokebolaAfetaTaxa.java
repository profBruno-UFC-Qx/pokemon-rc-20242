package br.ufc.quixada.poo.game.pokemon.pokebola;

import br.ufc.quixada.poo.game.pokemon.Pokemon;

public abstract class PokebolaAfetaTaxa extends Pokebola {

  @Override
  protected abstract float getBonus(Pokemon pokemon);
}
