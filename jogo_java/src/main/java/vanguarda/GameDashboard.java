package vanguarda;

public class GameDashboard {
    public static void dashboard(String protagonista, String arma, int vida) {
        System.out.println("----------------------");
        System.out.println(protagonista);
        System.out.println("Vida: "+ vida+ "       ");
        System.out.println("Arma: "+ arma+ "       ");
        System.out.println("----------------------");
    }
}
