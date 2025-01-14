package br.ufc.quixada.poo.game.pokemon.pokebola;

import br.ufc.quixada.poo.game.pokemon.Pokemon;

public class HealBall extends PokebolaAfetaPokemon {
  @Override
  protected void aplicarEfeito(Pokemon pokemon) {
    pokemon.recuperarVida(pokemon.getHpMax());
  }
}
