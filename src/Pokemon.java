public class Pokemon {

  String nome;
  int nivel;
  String tipo;
  float peso;
  float altura;
  int vida;
  int velocidade;
  int ataque;

  Pokemon(String nome) {
    ataque =   (int) (Math.random()*100);
    this.nome = nome;
    this.vida = 1000;
  }

  Pokemon(String nome, int nivel) {
    this(nome);
    this.nivel = nivel;
  }

  Pokemon(String nome, int nivel,float peso, float altura) {
    this(nome,nivel);
    this.peso = peso;
    this.altura = altura;
  }



  String falar() {
    if(estaVivo()) {
      return nome + " " + this.nome;
    } else {
      return "to morto";
    }
  }

  boolean estaVivo() {
    return vida != 0;
  }

  void recuperarVida(int vida) {
    this.vida += vida;
  }

  void atacar(int movimento, Pokemon alvo) {
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
