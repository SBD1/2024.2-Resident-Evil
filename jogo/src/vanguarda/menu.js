class Menu {
    limparTerminal() {
        process.stdout.write('\x1Bc')
    }

    criarInicio() {
        console.log("-----------------------");
        console.log("|                     |");
        console.log("|    Resident Evil    |");
        console.log("|                     |");
        console.log("-----------------------");
    }
    
    criarMenu() {
        console.log("-----------------------");
        console.log("|    1 - Novo Jogo    |");
        console.log("|  2 - Carregar Jogo  |");
        console.log("|      0 - Sair       |");
        console.log("-----------------------");
    }

    
}

module.exports = new Menu();
