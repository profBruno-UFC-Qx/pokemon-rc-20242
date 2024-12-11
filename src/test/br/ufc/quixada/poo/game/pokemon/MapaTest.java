package br.ufc.quixada.poo.game.pokemon;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class MapaTest {


  @Test
  void posicaoCentral() {
    Mapa mapa = new Mapa(5, 5);
    assertTrue(mapa.posicaoValida(2, 2));
  }

  @Test
  void posicaoNegativaNoX() {
    Mapa mapa = new Mapa(5, 5);
    assertFalse(mapa.posicaoValida(-2, 2));
  }

  @Test
  void posicaoNegativaNoY() {
    Mapa mapa = new Mapa(5, 5);
    assertFalse(mapa.posicaoValida(2, -2));
  }

  @Test
  void posicaoNaBordaX() {
    Mapa mapa = new Mapa(5, 5);
    assertTrue(mapa.posicaoValida(0, 2));
    assertTrue(mapa.posicaoValida(4, 2));
  }

  @Test
  void posicaoNaBordaY() {
    Mapa mapa = new Mapa(5, 5);
    assertTrue(mapa.posicaoValida(2, 4));
    assertTrue(mapa.posicaoValida(2, 0));
  }
}