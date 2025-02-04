package application;


import retaguarda.Game;
import vanguarda.Menu;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws InterruptedException, IOException, SQLException {

        Scanner input = new Scanner(System.in);
        Menu.criarInicio();
        Thread.sleep(1250);
        Menu.limparTerminal();

        Menu.criarMenu();
        int opcao = input.nextInt();

        input.nextLine();

        switch(opcao) {

            case 1:
                System.out.println("Iniciando novo jogo...");
                Game.newgame();
                break;

            case 2:
                System.out.println("Carregando jogo...");
                Game.load();
                break;
            case 0:
                System.out.println("Saindo do jogo...");
                Thread.sleep(500);
                System.exit(0);
                break;
            default:
                System.out.println("Opção inválida.");

        }
    }
}
