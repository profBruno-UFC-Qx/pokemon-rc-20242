package br.ufc.quixada.poo.game.pokemon;

public class Pokemon {

  private String nome;
  private int nivel;
  private final int hpBase;
  private final int hpMax;
  private int hpAtual;
  private float altura;
  private int velocidade;
  private int ataque;
  private float peso;
  private int taxaDeCaptura;
  private int amizade = 0;

  public Pokemon(String nome) {
    this(nome, 1);
  }

  public Pokemon(String nome, int nivel) {
    this(nome, nivel, 100);
  }

  public Pokemon(String nome, int nivel, int hpBase) {
    this.nome = nome;
    this.hpBase = hpBase;
    this.nivel = nivel;
    this.hpMax = calcularHP(nivel); // Nível 1
  }

  private int calcularHP(int nivel) {
    return ((2 * hpBase * nivel) / 100) + nivel + 10;
  }

  public String getNome() {
    return nome;
  }

  public int getNivel() {
    return this.nivel;
  }

  public String falar() {
    if(estaVivo()) {
      return nome + " " + this.nome;
    } else {
      return "to morto";
    }
  }

  private boolean estaVivo() {
    return hpAtual != 0;
  }

  public void recuperarVida(int vida) {
    setHpAtual(vida);
  }

  public void setHpAtual(int hp) {
    hpAtual = hp + hpAtual;

    if(hpAtual > hpMax) {
      hpAtual = hpMax;
    }

    if (hpAtual < 0) {
      hpAtual = 0;
    }
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
            ", hpAtuak=" + hpAtual +
            '}';
  }

  public int getHpMax() {
    return this.hpMax;
  }

  public int getHpAtual() {
    return this.hpAtual;
  }

  public int getTaxaDeCaptura() {
    return this.taxaDeCaptura;
  }

  public int getVelocidade() {
    return this.velocidade;
  }

  public float getPeso() {
    return this.peso;
  }

  public void setAmizade(int amizade) {
    this.amizade = amizade;
  }
}
