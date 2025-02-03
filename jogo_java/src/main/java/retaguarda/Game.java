package retaguarda;

import retaguarda.protagonista.ProtagonistaService;

import java.util.Scanner;

public class Game {
    static Scanner input = new Scanner(System.in);

    public static void load() {
        System.out.println("Digite o nome do seu protagonista salvo:");
        String protagonista = input.nextLine();
        System.out.println("Carregando jogo com " + protagonista + "...");

    }
    public static void newgame() {
        System.out.println("Digite o nome do protagonista:");
        String protagonista = input.nextLine();
        System.out.println("Iniciando novo jogo com " + protagonista + "...");
        ProtagonistaService.criarProtagonista(protagonista);


    }
}
