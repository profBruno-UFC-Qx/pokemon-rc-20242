public class Main {
  public static void main(String[] args) {
    Pokemon pikachu = new Pokemon("Pikachu");
    System.out.println(pikachu);
    Pokemon eevee = new Pokemon("Eevee", 100);
    System.out.println(eevee);

    pikachu.recuperarVida(100);
    System.out.println(pikachu);
    System.out.println(eevee);

  }
}