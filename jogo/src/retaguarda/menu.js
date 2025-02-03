const readline = require('readline').createInterface({
    input: process.stdin,
    output: process.stdout
});

class Menu{
    async escolherOpcao(){
        const opcao = await readline.question();

        if(opcao == 1){
            console.log("Iniciando novo jogo...");
            await new Promise(resolve => setTimeout(resolve, 1000));
        }

        else if(opcao == 2){
            console.log("Carregando jogo...");
            await new Promise(resolve => setTimeout(resolve, 1000));
        }

        else if(opcao == 0){
            console.log("Saindo do jogo...");
            await new Promise(resolve => setTimeout(resolve, 1000));
            return;
        }
        else {
            console.log("Opção inválida. Tente novamente.");
            await new Promise(resolve => setTimeout(resolve, 1000));
            await this.escolherOpcao();
        }
    }
}

module.exports = new Menu();