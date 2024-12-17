package br.ufc.quixada.poo.game.pokemon;

public class Pokemon {

  private String nome;
  private int nivel;
  private float peso;
  private float altura;
  private int vida;
  private int velocidade;
  private int ataque;
  static int contador = 0;

  public Pokemon(String nome) {
    ataque =   (int) (Math.random()*100);
    this.nome = nome;
    this.vida = 1000;
    this.nivel = 5;
    Pokemon.contador++;
  }

  public Pokemon(String nome, int nivel) {
    this(nome);
    this.nivel = nivel;
  }

  public Pokemon(String nome, int nivel,float peso, float altura) {
    this(nome,nivel);
    this.peso = peso;
    this.altura = altura;
  }

  public String getNome() {
    return nome;
  }

  public int getNivel() {
    return this.nivel;
  }

  public static int getContador() {
    return contador;
  }

  public String falar() {
    if(estaVivo()) {
      return nome + " " + this.nome;
    } else {
      return "to morto";
    }
  }

  private boolean estaVivo() {
    return vida != 0;
  }

  public void recuperarVida(int vida) {
    this.vida += vida;
  }

  public void atacar(int movimento, Pokemon alvo) {
    System.out.println("Atacando o pokemon " + alvo.nome + " com ataque numero " + movimento);
  }

  @Override
  public String toString() {
    return "Pokemon{" +
            "nome='" + nome + '\'' +
            ", nivel=" + nivel +
            ", ataque='" + ataque + '\'' +
            ", vida=" + vida +
            '}';
  }
}
