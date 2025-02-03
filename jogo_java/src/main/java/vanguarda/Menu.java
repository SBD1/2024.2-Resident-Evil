package vanguarda;

import java.io.IOException;

public class Menu {
    public static void limparTerminal() {
        if (System.console() == null) {
            for (int i = 0; i < 50; i++) {
                System.out.println();
            }
        } else {
            try {
                final String os = System.getProperty("os.name");

                if (os.contains("Windows")) {
                    new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                } else {
                    new ProcessBuilder("clear").inheritIO().start().waitFor();
                }
            } catch (Exception e) {
                System.out.println("Erro ao limpar o terminal: " + e.getMessage());
            }
        }
    }


    public static void criarInicio(){
        System.out.println("-----------------------------");
        System.out.println("|                           |");
        System.out.println("|       Resident Evil       |");
        System.out.println("|                           |");
        System.out.println("-----------------------------");
    }

    public static void criarMenu(){
        System.out.println("-----------------------------");
        System.out.println("|       1 - Novo Jogo       |");
        System.out.println("|     2 - Carregar Jogo     |");
        System.out.println("|         0 - Sair          |");
        System.out.println("-----------------------------");
    }
}
