package retaguarda.mercador;

import retaguarda.protagonista.Protagonista;
import retaguarda.protagonista.ProtagonistaService;
import retaguarda.item.Arma;
import retaguarda.item.ArmaService;
import retaguarda.item.Equipamento;
import retaguarda.item.EquipamentoService;
import java.util.List;
import java.util.Scanner;

public class MercadorService {

    public static void conversarComMercador(Protagonista protagonista) {
        Scanner input = new Scanner(System.in);
        boolean emConversa = true;
        while(emConversa) {
            System.out.println("\n---- Conversa com o Mercador ----");
            System.out.println("1. Comprar Arma");
            System.out.println("2. Comprar Equipamento");
            System.out.println("3. Melhorar Arma");
            System.out.println("4. Melhorar Equipamento");
            System.out.println("5. Sair da conversa");
            System.out.print("Opção: ");
            int opcao = input.nextInt();
            input.nextLine();
            switch(opcao) {
                case 1:
                    comprarArma(protagonista);
                    break;
                case 2:
                    comprarEquipamento(protagonista);
                    break;
                case 3:
                    melhorarArma(protagonista);
                    break;
                case 4:
                    melhorarEquipamento(protagonista);
                    break;
                case 5:
                    emConversa = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    public static void comprarArma(Protagonista protagonista) {
        List<Arma> armas = ArmaService.listarArmasDisponiveis();
        if(armas.isEmpty()){
            System.out.println("Nenhuma arma disponível para compra.");
            return;
        }
        System.out.println("\n--- Armas Disponíveis ---");
        for(Arma a : armas) {
            System.out.println("ID: " + a.getIdItem() + " - " + a.getNome() + " (Valor: " + a.getValor() + ")");
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o ID da arma que deseja comprar (ou 0 para cancelar): ");
        int idArma = input.nextInt();
        input.nextLine();
        if(idArma == 0) return;
        Arma armaEscolhida = null;
        for(Arma a : armas) {
            if(a.getIdItem() == idArma) {
                armaEscolhida = a;
                break;
            }
        }
        if(armaEscolhida == null) {
            System.out.println("Arma não encontrada.");
            return;
        }
        if(protagonista.getDinheiroRecebido() < armaEscolhida.getValor()){
            System.out.println("Dinheiro insuficiente para comprar esta arma.");
            return;
        }
        int novoDinheiro = protagonista.getDinheiroRecebido() - armaEscolhida.getValor();
        ProtagonistaService.atualizarDinheiro(protagonista.getId(), novoDinheiro);
        protagonista.setArmaEquipada(armaEscolhida);
        System.out.println("Você comprou e equipou a arma: " + armaEscolhida.getNome());
    }

    public static void comprarEquipamento(Protagonista protagonista) {
        List<Equipamento> equipamentos = EquipamentoService.listarEquipamentosDisponiveis();
        if(equipamentos.isEmpty()){
            System.out.println("Nenhum equipamento disponível para compra.");
            return;
        }
        System.out.println("\n--- Equipamentos Disponíveis ---");
        for(Equipamento e : equipamentos) {
            System.out.println("ID: " + e.getIdItem() + " - " + e.getNome() + " (Valor: " + e.getValor() + ")");
        }
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o ID do equipamento que deseja comprar (ou 0 para cancelar): ");
        int idEquip = input.nextInt();
        input.nextLine();
        if(idEquip == 0) return;
        Equipamento equipEscolhido = null;
        for(Equipamento e : equipamentos) {
            if(e.getIdItem() == idEquip) {
                equipEscolhido = e;
                break;
            }
        }
        if(equipEscolhido == null) {
            System.out.println("Equipamento não encontrado.");
            return;
        }
        if(protagonista.getDinheiroRecebido() < equipEscolhido.getValor()){
            System.out.println("Dinheiro insuficiente para comprar este equipamento.");
            return;
        }
        int novoDinheiro = protagonista.getDinheiroRecebido() - equipEscolhido.getValor();
        ProtagonistaService.atualizarDinheiro(protagonista.getId(), novoDinheiro);
        protagonista.setEquipamentoEquipada(equipEscolhido);
        System.out.println("Você comprou e equipou o equipamento: " + equipEscolhido.getNome());
    }

    public static void melhorarArma(Protagonista protagonista) {
        if(protagonista.getArmaEquipada() == null) {
            System.out.println("Você não possui uma arma equipada para melhorar.");
            return;
        }
        int custoUpgrade = 50;
        if(protagonista.getDinheiroRecebido() < custoUpgrade) {
            System.out.println("Dinheiro insuficiente para melhorar a arma.");
            return;
        }
        Arma arma = protagonista.getArmaEquipada();
        arma.setNivel(arma.getNivel() + 1);
        arma.setDano(arma.getDano() + 20);
        int novoDinheiro = protagonista.getDinheiroRecebido() - custoUpgrade;
        ProtagonistaService.atualizarDinheiro(protagonista.getId(), novoDinheiro);
        ArmaService.atualizarArma(arma);
        System.out.println("Sua arma foi melhorada para o nível " + arma.getNivel() + " com dano " + arma.getDano());
    }

    public static void melhorarEquipamento(Protagonista protagonista) {
        if(protagonista.getEquipamentoEquipada() == null) {
            System.out.println("Você não possui equipamento equipado para melhorar.");
            return;
        }
        int custoUpgrade = 50;
        if(protagonista.getDinheiroRecebido() < custoUpgrade) {
            System.out.println("Dinheiro insuficiente para melhorar o equipamento.");
            return;
        }
        Equipamento equip = protagonista.getEquipamentoEquipada();
        equip.setNivel(equip.getNivel() + 1);
        equip.setDefesa(equip.getDefesa() + 3);
        int novoDinheiro = protagonista.getDinheiroRecebido() - custoUpgrade;
        ProtagonistaService.atualizarDinheiro(protagonista.getId(), novoDinheiro);
        EquipamentoService.atualizarEquipamento(equip);
        System.out.println("Seu equipamento foi melhorado para o nível " + equip.getNivel() + " com defesa " + equip.getDefesa());
    }

    public static void venderItem(Protagonista protagonista){

    }
}
