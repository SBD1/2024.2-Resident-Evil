package application;

import bancoDados.DatabasePool;
import retaguarda.Game;
import vanguarda.Mapa;
import vanguarda.Menu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import static java.lang.System.exit;

public class Program {
    public static void main(String[] args) throws InterruptedException, IOException {
        while(true) {
            Scanner input = new Scanner(System.in);
            Menu.criarInicio();
            Thread.sleep(1250);
            Menu.limparTerminal();

            Menu.criarMenu();
            int opcao = input.nextInt();
            switch(opcao){
                case 1:
                    System.out.println("Iniciando novo jogo...");
                    Game.newgame();
                    break;

                case 2:
                    System.out.println("Carregando jogo...");
                    break;

                case 0:
                    System.out.println("Saindo do jogo...");
                    Thread.sleep(500);
                    exit(0);
            }
        }
    }
}
