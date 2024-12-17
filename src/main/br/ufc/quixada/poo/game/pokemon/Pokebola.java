package br.ufc.quixada.poo.game.pokemon;

public class Pokebola {
  protected float taxaBase = 0.4f;

  private float getTaxaDeCaptura(Pokemon pokemon) {
    return taxaBase - taxaBase*(pokemon.getNivel()/100f) + 0.05f;
  }

  public boolean capturar(Pokemon p) {
    float taxaDeCaptura = getTaxaDeCaptura(p);
    double sorte = Math.random();
    System.out.println("Você tem " + taxaDeCaptura*100 + "% de chances captura");
    System.out.println(sorte);
    return sorte < taxaDeCaptura;
  }
}
