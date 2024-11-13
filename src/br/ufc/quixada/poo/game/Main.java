package br.ufc.quixada.poo.game;

import br.ufc.quixada.poo.game.pokemon.Pokemon;
import br.ufc.quixada.poo.game.pokemon.Treinador;

public class Main {

  public static void main(String[] args) {
    Treinador ash = new Treinador("Ash");


    Pokemon pikachu = new Pokemon("Pikachu");
    Pokemon magikarp = new Pokemon("Magikarp");


    ash.capturar(pikachu);
    ash.capturar(magikarp);
    ash.listar();
    System.out.println(Pokemon.getContador());


  }
}