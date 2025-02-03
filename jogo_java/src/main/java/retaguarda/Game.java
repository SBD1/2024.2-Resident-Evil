package retaguarda;

import retaguarda.item.*;
import retaguarda.mapa.CaminhoService;
import retaguarda.mapa.Sala;
import retaguarda.mapa.SalaService;
import retaguarda.protagonista.Protagonista;
import retaguarda.protagonista.ProtagonistaService;
import retaguarda.inventario.InventarioService;
import retaguarda.mapa.SalaItemService;

import java.util.List;
import java.util.Scanner;

public class Game {
    private static Scanner input = new Scanner(System.in);

    public static void load() {
        System.out.println("Digite o nome do seu protagonista salvo:");
        String protagonistaNome = input.nextLine();
        Protagonista protagonista = ProtagonistaService.carregarProtagonista(protagonistaNome);
        if (protagonista != null) {
            System.out.println("Jogo carregado com sucesso!");
            jogoPrincipal(protagonista);
        } else {
            System.out.println("Protagonista não encontrado.");
        }
    }

    public static void newgame() {
        System.out.println("Digite o nome do protagonista:");
        String protagonistaNome = input.nextLine();
        System.out.println("Iniciando novo jogo com " + protagonistaNome + "...");
        ProtagonistaService.criarProtagonista(protagonistaNome);
        Protagonista protagonista = ProtagonistaService.carregarProtagonista(protagonistaNome);
        if (protagonista != null) {
            jogoPrincipal(protagonista);
        } else {
            System.out.println("Erro ao criar o protagonista. Tente novamente.");
        }
    }

    public static void jogoPrincipal(Protagonista protagonista) {
        System.out.println("\nBem-vindo, " + protagonista.getNickname() + "!");
        while (true) {
            Sala salaAtual = SalaService.getSalaPorNumero(protagonista.getSala());
            System.out.println("\nVocê está na sala: " + (salaAtual != null ? salaAtual.getNome() : "Desconhecida"));
            System.out.println("Escolha uma ação:");
            System.out.println("1. Ver status");
            System.out.println("2. Mover para outra sala");
            System.out.println("3. Vasculhar a sala");
            System.out.println("4. Sair do jogo");
            System.out.println("5. Equipar item do inventário");

            int opcao = input.nextInt();
            input.nextLine();

            switch (opcao) {
                case 1:
                    System.out.println("Status do protagonista:");
                    System.out.println("Vida: " + protagonista.getVida());
                    System.out.println("Dano: " + protagonista.getDano());
                    System.out.println("Dinheiro: " + protagonista.getDinheiroRecebido());
                    System.out.println("Arma equipada: " + (protagonista.getArmaEquipada() != null
                            ? protagonista.getArmaEquipada().getNome() : "Nenhuma"));
                    System.out.println("Equipamento equipado: " + (protagonista.getEquipamentoEquipada() != null
                            ? protagonista.getEquipamentoEquipada().getNome() : "Nenhum"));
                    break;
                case 2:
                    int salaNum = protagonista.getSala();
                    List<Integer> salasDisponiveis = CaminhoService.listarSalasConectadas(salaNum);
                    if (salasDisponiveis.isEmpty()) {
                        System.out.println("Não há salas conectadas a partir daqui.");
                    } else {
                        System.out.println("Salas conectadas:");
                        for (int num : salasDisponiveis) {
                            Sala s = SalaService.getSalaPorNumero(num);
                            if (s != null) {
                                System.out.println(num + " - " + s.getNome());
                            }
                        }
                        System.out.println("Digite o número da sala para a qual deseja ir:");
                        int novaSala = input.nextInt();
                        input.nextLine();
                        if (salasDisponiveis.contains(novaSala)) {
                            protagonista.moverParaSala(novaSala);
                        } else {
                            System.out.println("Sala inválida. Você não pode ir para essa sala.");
                        }
                    }
                    break;
                case 3:
                    int numeroSala = protagonista.getSala();
                    List<ItemSala> itensSala = SalaItemService.listarItensDaSala(numeroSala);
                    if (itensSala.isEmpty()) {
                        System.out.println("Nenhum item encontrado nesta sala.");
                    } else {
                        System.out.println("Itens encontrados nesta sala:");
                        for (ItemSala is : itensSala) {
                            System.out.println("ID: " + is.getId() + " - " + is.getItem().getNome() +
                                    " (Quantidade: " + is.getQuantidade() + ")");
                        }
                        System.out.println("Digite o ID do item que deseja pegar (ou 0 para cancelar):");
                        int idEscolhido = input.nextInt();
                        input.nextLine();
                        if (idEscolhido != 0) {
                            ItemSala itemEscolhido = null;
                            for (ItemSala is : itensSala) {
                                if (is.getId() == idEscolhido) {
                                    itemEscolhido = is;
                                    break;
                                }
                            }
                            if (itemEscolhido != null) {
                                InventarioService.pegarItemProtagonista(protagonista.getId(), itemEscolhido.getItem().getIdItem());
                                if (SalaItemService.removerItemDaSala(idEscolhido)) {
                                    System.out.println("Item retirado da sala.");
                                }
                            } else {
                                System.out.println("Item inválido.");
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Itens no Inventário:");
                    List<InstanciaItem> itensInventario = protagonista.getInventario().listarItens();
                    if (itensInventario.isEmpty()) {
                        System.out.println("Inventário vazio.");
                    } else {
                        for (InstanciaItem inst : itensInventario) {
                            System.out.println("ID: " + inst.getIdInstanciaItem() + " - " +
                                    inst.getItem().getNome() + " (" + inst.getItem().getTipo() + ")");
                        }
                        System.out.println("Digite o ID do item que deseja equipar (ou 0 para cancelar):");
                        int idEquip = input.nextInt();
                        input.nextLine();
                        if (idEquip != 0) {
                            InstanciaItem itemSelecionado = null;
                            for (InstanciaItem inst : itensInventario) {
                                if (inst.getIdInstanciaItem() == idEquip) {
                                    itemSelecionado = inst;
                                    break;
                                }
                            }
                            if (itemSelecionado != null) {
                                if (itemSelecionado.getItem().getTipo() == Tipo.arma) {
                                    Arma arma = ArmaService.getArmaById(itemSelecionado.getItem().getIdItem());
                                    if (arma != null) {
                                        protagonista.equiparArma(arma);
                                        System.out.println("Arma " + arma.getNome() + " equipada!");
                                    } else {
                                        System.out.println("Erro ao buscar os dados da arma.");
                                    }
                                } else if (itemSelecionado.getItem().getTipo() == Tipo.equipamento) {
                                    Equipamento equipamento = EquipamentoService.getEquipamentoById(itemSelecionado.getItem().getIdItem());
                                    if (equipamento != null) {
                                        protagonista.equiparEquipamento(equipamento);
                                        System.out.println("Equipamento " + equipamento.getNome() + " equipado!");
                                    } else {
                                        System.out.println("Erro ao buscar os dados do equipamento.");
                                    }
                                } else {
                                    System.out.println("Este item não pode ser equipado.");
                                }
                            } else {
                                System.out.println("Item não encontrado no inventário.");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println("Saindo do jogo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
