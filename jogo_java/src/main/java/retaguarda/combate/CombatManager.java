package retaguarda.combate;

import retaguarda.item.*;
import retaguarda.npc.InstanciaNpc;
import retaguarda.protagonista.Protagonista;
import retaguarda.protagonista.ProtagonistaService;
import retaguarda.npc.InstanciaNpcService;

import java.util.List;
import java.util.Scanner;

public class CombatManager {

    public static void iniciarCombate(Protagonista protagonista, int idInstanciaNpc) {
        InstanciaNpc enemy = InstanciaNpcService.carregarInstanciaNpc(idInstanciaNpc);
        if (enemy == null) {
            System.out.println("Inimigo não encontrado. Combate abortado.");
            return;
        }
        Scanner input = new Scanner(System.in);
        boolean emCombate = true;
        System.out.println("\n--- Iniciando Combate ---");
        while (emCombate) {
            System.out.println("\nSeu status: Vida = " + protagonista.getVida());
            System.out.println("Inimigo (" + enemy.getTipo() + ") status: Vida = " + enemy.getVidaAtual());
            System.out.println("\nEscolha uma ação:");
            System.out.println("1. Atacar");
            System.out.println("2. Usar Consumível");
            System.out.println("3. Fugir");
            System.out.print("Opção: ");
            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    int danoProtagonista = protagonista.getDano();
                    Arma arma = protagonista.getArmaEquipada();
                    if (arma != null) {
                        danoProtagonista += arma.getDanoEfetivo();
                    }
                    System.out.println("Você ataca e causa " + danoProtagonista + " de dano.");
                    enemy.setVidaAtual(enemy.getVidaAtual() - danoProtagonista);
                    InstanciaNpcService.atualizarVidaInstancia(enemy.getIdInstancia(), enemy.getVidaAtual());
                    if (enemy.getVidaAtual() <= 0) {
                        System.out.println("Você derrotou o inimigo!");
                        ProtagonistaService.incrementarKillCount(protagonista.getId());
                        InstanciaNpcService.removerInstanciaNpc(enemy.getIdInstancia());
                        emCombate = false;
                        break;
                    }
                    int danoInimigo = enemy.getBaseDamage();
                    Equipamento equip = protagonista.getEquipamentoEquipada();
                    if (equip != null) {
                        danoInimigo -= equip.getDefesa();
                        if (danoInimigo < 0) {
                            danoInimigo = 0;
                        }
                    }
                    System.out.println("O inimigo ataca e causa " + danoInimigo + " de dano.");
                    int novaVida = protagonista.getVida() - danoInimigo;
                    if (novaVida < 0) {
                        novaVida = 0;
                    }
                    ProtagonistaService.atualizarVida(protagonista.getId(), novaVida);
                    protagonista.setVida(novaVida);
                    if (novaVida < 1) {
                        System.out.println("Você foi derrotado...");
                        ProtagonistaService.removerProtagonista(protagonista.getId());
                    }
                    break;
                case 2:
                    List<InstanciaItem> itensInventario = protagonista.getInventario().listarItens();
                    boolean temConsumivel = false;
                    System.out.println("Consumíveis disponíveis no inventário:");
                    for (InstanciaItem itemInst : itensInventario) {
                        if (itemInst.getItem().getTipo() == Tipo.consumivel) {
                            System.out.println("ID: " + itemInst.getIdInstanciaItem() + " - " + itemInst.getItem().getNome());
                            temConsumivel = true;
                        }
                    }
                    if (!temConsumivel) {
                        System.out.println("Nenhum consumível disponível no inventário.");
                        break;
                    }
                    System.out.print("Digite o ID do consumível que deseja usar: ");
                    int idConsumivel = input.nextInt();
                    input.nextLine();
                    ProtagonistaService.consumirConsumivel(protagonista.getId(), idConsumivel, protagonista);
                    break;
                case 3:
                    System.out.println("Você fugiu do combate!");
                    emCombate = false;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
