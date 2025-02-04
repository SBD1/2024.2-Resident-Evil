package vanguarda;

public class Mapa {
    public static void criarVilaAscii(){
        System.out.print("                                                                              |>>>\n" +
                "                                      _                      _                |\n" +
                "                       ____________ .' '.    _____/----/-\\ .' './========\\   / \\\n" +
                "                      //// ////// /V_.-._\\  |.-.-.|===| _ |-----| u    u |  /___\\\n" +
                "                     // /// // ///==\\ u |.  || | ||===||||| |T| |   ||   | .| u |_ _ _ _ _ _\n" +
                "                    ///////-\\////====\\==|:::::::::::::::::::::::::::::::::::|u u| U U U U U\n" +
                "                    |----/\\u |--|++++|..|'''''''''''::::::::::::::''''''''''|+++|+-+-+-+-+-+\n" +
                "                    |u u|u | |u ||||||..|              '::::::::'           |===|>=== _ _ ==\n" +
                "                    |===|  |u|==|++++|==|              .::::::::.           | T |....| V |..\n" +
                "                    |u u|u | |u ||HH||         \\|/    .::::::::::.\n" +
                "                    |===|_.|u|_.|+HH+|_              .::::::::::::.              _\n" +
                "                                    __(_)___         .::::::::::::::.         ___(_)__\n" +
                "                    ---------------/  / \\  /|       .:::::;;;:::;;:::.       |\\  / \\  \\-------\n" +
                "                    ______________/_______/ |      .::::::;;:::::;;:::.      | \\_______\\________\n" +
                "                    |       |     [===  =] /|     .:::::;;;::::::;;;:::.     |\\ [==  = ]   |\n" +
                "                    |_______|_____[ = == ]/ |    .:::::;;;:::::::;;;::::.    | \\[ ===  ]___|____\n" +
                "                         |       |[  === ] /|   .:::::;;;::::::::;;;:::::.   |\\ [=  ===] |\n" +
                "                    _____|_______|[== = =]/ |  .:::::;;;::::::::::;;;:::::.  | \\[ ==  =]_|______\n" +
                "                     |       |    [ == = ] /| .::::::;;:::::::::::;;;::::::. |\\ [== == ]      |\n" +
                "                    _|_______|____[=  == ]/ |.::::::;;:::::::::::::;;;::::::.| \\[  === ]______|_\n" +
                "                       |       |  [ === =] /.::::::;;::::::::::::::;;;:::::::.\\ [===  =]   |\n" +
                "                    ___|_______|__[ == ==]/.::::::;;;:::::::::::::::;;;:::::::.\\[=  == ]___|_____");
    }

    public static void criarVila() throws InterruptedException {

        System.out.println("Você está na vila ");

        Thread.sleep(500);
        System.out.println("Aqui você pode encontrar a delegacia, a loja de armas, a farmácia e a mansão.");
        Thread.sleep(500);
        System.out.println("Para onde deseja ir?");
        Thread.sleep(1000);
        System.out.println("1 - Delegacia");
        System.out.println("2 - Loja de Armas");
        System.out.println("3 - Farmácia");
        System.out.println("4 - Mansão");
    }
}
