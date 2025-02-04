package retaguarda;

import retaguarda.combate.CombatManager;
import retaguarda.inventario.InventarioService;
import retaguarda.mapa.CaminhoService;
import retaguarda.mapa.Sala;
import retaguarda.mapa.SalaItemService;
import retaguarda.mapa.SalaService;
import retaguarda.mercador.MercadorService;
import retaguarda.npc.InstanciaNpc;
import retaguarda.npc.InstanciaNpcService;
import retaguarda.protagonista.Protagonista;
import retaguarda.protagonista.ProtagonistaService;
import retaguarda.mapa.SalaItemService;
import retaguarda.item.Arma;
import retaguarda.item.ArmaService;
import retaguarda.item.Equipamento;
import retaguarda.item.EquipamentoService;
import retaguarda.item.InstanciaItem;
import retaguarda.item.ItemSala;
import retaguarda.item.Tipo;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Game {
    private static Scanner input = new Scanner(System.in);

    public static void load() {
        System.out.println("Digite o nome do seu protagonista salvo:");
        String nome = input.nextLine();
        Protagonista protagonista = ProtagonistaService.carregarProtagonista(nome);
        if (protagonista != null) {
            System.out.println("Jogo carregado com sucesso!");
            jogoPrincipal(protagonista);
        } else {
            System.out.println("Protagonista não encontrado.");
        }
    }

    public static void newgame() throws SQLException {
        System.out.println("Digite o nome do protagonista:");
        String nome = input.nextLine();
        System.out.println("Iniciando novo jogo com " + nome + "...");
        ProtagonistaService.criarProtagonista(nome);
        Protagonista protagonista = ProtagonistaService.carregarProtagonista(nome);
        if (protagonista != null) {
            if (protagonista.getArmaEquipada() == null) {
                Arma faca = ArmaService.getArmaById(16);
                protagonista.setArmaEquipada(faca);
            }
            jogoPrincipal(protagonista);
        } else {
            System.out.println("Erro ao criar o protagonista. Tente novamente.");
        }
    }

    public static void jogoPrincipal(Protagonista protagonista) {
        boolean executando = true;
        while (executando) {
            Sala salaAtual = SalaService.getSalaPorNumero(protagonista.getSala());
            System.out.println("\n--------------------------------------------------");
            if (salaAtual != null) {
                System.out.println("Você está na sala: " + salaAtual.getNome());
                if(salaAtual.getDescricao() != null){
                    String novaDescricao = salaAtual.getDescricao().replace("Leon", protagonista.getNickname());
                    System.out.println("Descrição: " + novaDescricao);
                }
            } else {
                System.out.println("Você está em uma sala desconhecida.");
            }
            System.out.println("--------------------------------------------------");


            List<Integer> instancias = InstanciaNpcService.listarInstanciasPorSala(protagonista.getSala());
            boolean inimigoPresente = !instancias.isEmpty();

            Integer bossInstancia = InstanciaNpcService.obterInstanciaBossNaSala(protagonista.getSala());
            if (bossInstancia != null) {
                System.out.println("Um boss foi detectado nesta sala! Resetando a vida do boss...");
                InstanciaNpcService.resetarVidaInstancia(bossInstancia);
                System.out.println("Iniciando combate automático contra o boss...");
                CombatManager.iniciarCombate(protagonista, bossInstancia);
                continue;
            }

            boolean temMercador = false;
            if (salaAtual != null && "Mercado".equalsIgnoreCase(salaAtual.getNome())) {
                temMercador = true;
            } else if (salaAtual != null) {
                temMercador = InstanciaNpcService.salaPossuiMercador(salaAtual.getNumero());
            }

            System.out.println("Escolha uma ação:");
            if (temMercador) {
                System.out.println("1. Ver status");
                System.out.println("2. Mover para outra sala");
                System.out.println("3. Vasculhar a sala");
                System.out.println("4. Conversar com o Mercador");
                System.out.println("5. Equipar item do inventário");
                System.out.println("6. Iniciar combate" + (inimigoPresente ? "" : " (Nenhum inimigo presente)"));
                System.out.println("7. Sair do jogo");
            } else {
                System.out.println("1. Ver status");
                System.out.println("2. Mover para outra sala");
                System.out.println("3. Vasculhar a sala");
                System.out.println("4. Equipar item do inventário");
                System.out.println("5. Iniciar combate" + (inimigoPresente ? "" : " (Nenhum inimigo presente)"));
                System.out.println("6. Sair do jogo");
            }
            System.out.print("Opção: ");
            int opcao = input.nextInt();
            input.nextLine();

            if (temMercador) {
                switch (opcao) {
                    case 1:
                        exibirStatus(protagonista);
                        break;
                    case 2:
                        moverSala(protagonista);
                        break;
                    case 3:
                        vasculharSala(protagonista);
                        break;
                    case 4:
                        if (temMercador) {
                            MercadorService.conversarComMercador(protagonista);
                        } else {
                            System.out.println("Não há mercador nesta sala.");
                        }
                        break;
                    case 5:
                        equiparItem(protagonista);
                        break;
                    case 6:
                        iniciarCombate(protagonista, inimigoPresente);
                        break;
                    case 7:
                        System.out.println("Saindo do jogo...");
                        executando = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            } else {
                switch (opcao) {
                    case 1:
                        exibirStatus(protagonista);
                        break;
                    case 2:
                        moverSala(protagonista);
                        break;
                    case 3:
                        vasculharSala(protagonista);
                        break;
                    case 4:
                        equiparItem(protagonista);
                        break;
                    case 5:
                        iniciarCombate(protagonista, inimigoPresente);
                        break;
                    case 6:
                        System.out.println("Saindo do jogo...");
                        executando = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
        }
    }

    private static void exibirStatus(Protagonista protagonista) {
        System.out.println("===== STATUS DO PROTAGONISTA =====");
        System.out.println("Nome: " + protagonista.getNickname());
        System.out.println("Vida: " + protagonista.getVida());
        System.out.println("Dano base: " + protagonista.getDano());
        System.out.println("Killcount: " + protagonista.getKillcount());
        System.out.println("Dinheiro: " + protagonista.getDinheiroRecebido());
        if (protagonista.getArmaEquipada() != null) {
            System.out.println("Arma equipada: " + protagonista.getArmaEquipada().getNome() +
                    " (Dano adicional: " + protagonista.getArmaEquipada().getDano() + ")");
        } else {
            System.out.println("Arma equipada: Nenhuma");
        }
        if (protagonista.getEquipamentoEquipada() != null) {
            System.out.println("Equipamento equipado: " + protagonista.getEquipamentoEquipada().getNome() +
                    " (Defesa: " + protagonista.getEquipamentoEquipada().getDefesa() + ")");
        } else {
            System.out.println("Equipamento equipado: Nenhum");
        }
        System.out.println("==================================");
    }

    private static void moverSala(Protagonista protagonista) {
        List<Integer> salasDisponiveis = CaminhoService.listarSalasConectadas(protagonista.getSala());
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
            System.out.print("Digite o número da sala para a qual deseja ir: ");
            int novaSala = input.nextInt();
            input.nextLine();
            if (salasDisponiveis.contains(novaSala)) {
                protagonista.moverParaSala(novaSala);
            } else {
                System.out.println("Sala inválida. Operação cancelada.");
            }
        }
    }

    private static void vasculharSala(Protagonista protagonista) {
        List<InstanciaItem> itensSala = SalaItemService.listarItensDaSala(protagonista.getSala());
        if (itensSala.isEmpty()) {
            System.out.println("Nenhum item encontrado nesta sala.");
        } else {
            System.out.println("Itens encontrados nesta sala:");
            for (InstanciaItem itemInst : itensSala) {
                System.out.println("ID: " + itemInst.getIdInstanciaItem() + " - " +
                        itemInst.getItem().getNome());
            }
            System.out.print("Digite o ID do item que deseja pegar (ou 0 para cancelar): ");
            int idEscolhido = input.nextInt();
            input.nextLine();
            if (idEscolhido != 0) {
                InstanciaItem itemEscolhido = null;
                for (InstanciaItem itemInst : itensSala) {
                    if (itemInst.getIdInstanciaItem() == idEscolhido) {
                        itemEscolhido = itemInst;
                        break;
                    }
                }
                if (itemEscolhido != null) {
                    InventarioService.pegarItemProtagonista(protagonista.getId(), itemEscolhido.getItem().getIdItem());
                    if (SalaItemService.removerItemDaSala(idEscolhido)) {
                        System.out.println("Item retirado da sala e adicionado ao inventário.");
                    } else {
                        System.out.println("Não foi possível remover o item da sala.");
                    }
                } else {
                    System.out.println("Item inválido. Operação cancelada.");
                }
            }
        }
    }

    private static void equiparItem(Protagonista protagonista) {
        List<InstanciaItem> itensInventario = protagonista.getInventario().listarItens();
        if (itensInventario.isEmpty()) {
            System.out.println("Inventário vazio.");
        } else {
            System.out.println("Itens no Inventário:");
            for (InstanciaItem inst : itensInventario) {
                System.out.println("ID: " + inst.getIdInstanciaItem() + " - " +
                        inst.getItem().getNome() + " (" + inst.getItem().getTipo() + ")");
            }
            System.out.print("Digite o ID do item que deseja equipar (ou 0 para cancelar): ");
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
                            protagonista.setArmaEquipada(arma);
                            System.out.println("Arma " + arma.getNome() + " equipada!");
                        } else {
                            System.out.println("Erro ao equipar a arma.");
                        }
                    } else if (itemSelecionado.getItem().getTipo() == Tipo.equipamento) {
                        Equipamento equipamento = EquipamentoService.getEquipamentoById(itemSelecionado.getItem().getIdItem());
                        if (equipamento != null) {
                            protagonista.setEquipamentoEquipada(equipamento);
                            System.out.println("Equipamento " + equipamento.getNome() + " equipado!");
                        } else {
                            System.out.println("Erro ao equipar o equipamento.");
                        }
                    } else {
                        System.out.println("Este item não pode ser equipado.");
                    }
                } else {
                    System.out.println("Item não encontrado no inventário.");
                }
            }
        }
    }

    private static void iniciarCombate(Protagonista protagonista, boolean inimigoPresente) {
        if (!inimigoPresente) {
            System.out.println("Nenhum inimigo presente nesta sala.");
            return;
        }
        List<Integer> instancias = InstanciaNpcService.listarInstanciasPorSala(protagonista.getSala());
        if (instancias.size() > 1) {
            System.out.println("Instâncias de inimigos nesta sala:");
            for (Integer idInst : instancias) {
                InstanciaNpc npcInst = InstanciaNpcService.carregarInstanciaNpc(idInst);
                if (npcInst != null) {
                    System.out.println("ID: " + npcInst.getIdInstancia() +
                            " - Tipo: " + npcInst.getTipo() +
                            " - Vida: " + npcInst.getVidaAtual());
                }
            }
            System.out.print("Digite o ID da instância que deseja enfrentar: ");
            int idInstNpc = input.nextInt();
            input.nextLine();
            CombatManager.iniciarCombate(protagonista, idInstNpc);
        } else {
            CombatManager.iniciarCombate(protagonista, instancias.get(0));
        }
    }

    private static void iniciarCombate(Protagonista protagonista, int idInstNpc) {
        CombatManager.iniciarCombate(protagonista, idInstNpc);
    }
}
