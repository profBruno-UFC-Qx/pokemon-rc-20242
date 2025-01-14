package br.ufc.quixada.poo.game.pokemon.pokebola;

import br.ufc.quixada.poo.game.pokemon.Pokemon;

public class FriendBall extends PokebolaAfetaPokemon{
  @Override
  protected void aplicarEfeito(Pokemon pokemon) {
    pokemon.setAmizade(200);
  }
}
