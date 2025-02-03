const frontMenuFunctions = require('./vanguarda/menu');
const backMenuFunctions = require('./retaguarda/menu');
const frontMapaFunctions = require('./vanguarda/mapa');

async function main() {
    frontMenuFunctions.criarInicio();
    await new Promise(resolve => setTimeout(resolve, 2000));
    frontMenuFunctions.limparTerminal();
    
    frontMenuFunctions.criarMenu();
    await new Promise(resolve => setTimeout(resolve, 2000));
    await backMenuFunctions.escolherOpcao();

    frontMenuFunctions.limparTerminal();

    frontMapaFunctions.criarVilaAscii();
    await new Promise(resolve => setTimeout(resolve, 2000));
    frontMapaFunctions.criarVila();
}

main();
