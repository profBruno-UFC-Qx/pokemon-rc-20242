package br.ufc.quixada.poo.game.pokemon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PokedexManager {

  public static Pokedex carregarPokedex() {
    Pokedex pokedex = new Pokedex(carregarCapturados(), carregarVistos());
    return pokedex;
  }

  private static int[] carregarVistos() {
    int ocorrencias[] = new int[151];
    try(BufferedReader br = new BufferedReader(new FileReader("vistos.csv"))) {
      String linha;
      int i = 0;
      while ((linha = br.readLine()) != null) {
        ocorrencias[i] = Integer.parseInt(linha);
        i++;
      }
    } catch (IOException  e) {
      System.out.println("Criando uma nova pokedex");
    }
    return ocorrencias;
  }

  private static List<Pokemon> carregarCapturados() {
    List<Pokemon> capturados = new ArrayList<Pokemon>();
    try(BufferedReader br = new BufferedReader(new FileReader("pokedex.csv"))) {
      br.readLine();
      String linha;
      while ((linha = br.readLine()) != null) {
        String[] dados = linha.split(",");
        Pokemon p = new Pokemon(Integer.parseInt(dados[0]),
          dados[1],
          Integer.parseInt(dados[2]),
          Integer.parseInt(dados[3]),
          Integer.parseInt(dados[4]),
          Integer.parseInt(dados[5]),
          Integer.parseInt(dados[6]),
          Double.parseDouble(dados[7]),
          Integer.parseInt(dados[8]));
        capturados.add(p);
      }
    } catch (IOException  e) {
      System.out.println("Criando uma nova pokedex");
    }
    return capturados;
  }

  public static void salverPokedex(Pokedex pokedex) {
    salvarCapturados(pokedex);
    salvarVistos(pokedex);
  }

  private static void salvarVistos(Pokedex pokedex) {
    try (FileWriter fw = new FileWriter("vistos.csv");){
      for(int ocorrencia: pokedex.getOcorrencias()) {
        fw.write(ocorrencia + "\n");
      }
    } catch (IOException e) {
      System.out.println("Erro ao gravar arquivo de pokedex");
    }
  }

  private static void salvarCapturados(Pokedex pokedex) {
    try (FileWriter fw = new FileWriter("pokedex.csv");){
      fw.write("especie,nome,hpBase,ataque,defesa,velocidade,amizade,peso,taxaDeCaptura\n");
      for(Pokemon p: pokedex.getCapturados()) {
        fw.write(String.format("%d,%s,%d,%d,%d,%d,%d,%.2f,%d\n",
                p.getEspecie(), p.getNome(), p.getHpBase(), p.getAtaqueBase(), p.getDefesaBase(),
                p.getVelocidade(), p.getAmizade(), p.getPeso(), p.getTaxaDeCaptura()));
      }
    } catch (IOException e) {
      System.out.println("Erro ao gravar arquivo de pokedex");
    }
  }
}
