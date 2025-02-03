# DML - Data Manipulation Language

Linguagem de manipulação de dados: São comandos que interagem com os dados dentro das tabelas. Os comandos DML incluem:

- **INSERT**: Adiciona um novo dado ao banco.
- **UPDATE**: Atualiza os valores das linhas de uma tabela.
- **DELETE**: Exclui dados de uma tabela.

Nesse projeto, os comandos DML usados foram:

```
INSERT INTO mapa (nome)
VALUES
    ("Vila"),
    ("Castelo"),
    ("Ilha");

INSERT INTO sala(numero, nome, nome_mapa, descriçao)
VALUES
    (1, 'Entrada da Vila', 'Vila', NULL),
    (2, 'Praça Principal da Vila', 'Vila', NULL),
    (3, 'Cabana de Luis', 'Vila', 'A cabana é pequena, com paredes de madeira envelhecida e um chão de tábuas rangentes.  No fundo da cabana, há uma porta entreaberta que leva a um pequeno porão. De lá, você ouve o som de algo se movendo. Ao entrar no porão, você se depara com um homem sentado em uma cadeira, fumando um cigarro. 

    - "Luis Serra, certo? Parece que você tem informações que eu preciso."
    - "Whoa, whoa! Calma, amigo. Eu sou um aliado, não um inimigo.
    -  "Depende do que você tem a dizer. O que você sabe sobre essa aldeia? E sobre a garota que foi sequestrada?"
    - "Ah, sim, a filha do presidente... Ashley, certo? Parece que ela se meteu em uma enrascada feia. Sabe, essa aldeia não é o que parece. Os moradores... eles não estão mais no controle de si mesmos."
    - "O que você quer dizer com isso?"
    -  "Há algo dentro deles. Um parasita. Chama-se Las Plagas. É antigo, muito antigo. A seita que controla essa aldeia reviveu essa coisa e está usando-a para transformar as pessoas em... bem, você já viu. Monstros obedientes. Eu tenho os planos da seita. Sei onde eles estão mantendo a garota e como derrotar essas coisas. Você precisa de mim, amigo.".'),
    (4, 'Igreja', 'Vila', NULL),
    (5, 'Torre de Vigia', 'Vila', 'A torre de vigia é uma estrutura alta e precária, feita de madeira envelhecida e amarrada com cordas gastas. Ela se ergue acima das árvores, oferecendo uma vista ampla da vila e dos arredores. Da base da torre, surge uma porta de madeira, porém sem nenhum caminho ou trajeto visível que leve a ela. Ao olhar ao redor,  você percebe que está cercado por paredes de pedras antigas e musgosas, manchas vermelhas de sangue surgem pelo chão de terra batida. Então você percebe que está no centro de uma arena. De repente, um rugido ecoa e o chão treme levemente. El Gigante, uma criatura colossal e deformada, emerge das sombras. Ele é uma massa de músculos retorcidos e pele pálida, com olhos que brilham com uma fúria primitiva.' ),
    (6, 'Caminho para o Lago', 'Vila', NULL),
    (7, 'Lago', 'Vila', NULL),
    (8, 'Casa do Chefe Bitores Mendez', 'Vila', NULL),
    (9, 'Cabana Abandonada', 'Vila', NULL),
    (10, 'Caminho para o Castelo', 'Vila', NULL),
    (11, 'Entrada do Castelo', 'Castelo', NULL),
    (12, 'Salão Principal', 'Castelo', NULL),
    (13, 'Sala de Armaduras', 'Castelo', NULL),
    (14, 'Jardim do Castelo', 'Castelo', NULL),
    (15, 'Sala de Tortura', 'Castelo', NULL),
    (16, 'Salão de Banquete', 'Castelo', NULL),
    (17, 'Câmara de Salazar', 'Castelo', NULL),
    (18, 'Caminho para o Elevador', 'Castelo', NULL),
    (19, 'Sala do Elevador', 'Castelo', NULL),
    (20, 'Área do Chefe Salazar', 'Castelo', NULL),
    (21, 'Praia da Ilha', 'Ilha', NULL),
    (22, 'Área de Contêineres', 'Ilha', NULL),
    (23, 'Fábrica de Armas', 'Ilha', NULL),
    (24, 'Laboratório de Experimentos', 'Ilha', NULL),
    (25, 'Câmara de Tortura', 'Ilha', NULL),
    (26, 'Armazém', 'Ilha', NULL),
    (27, 'Sala de Controle', 'Ilha', NULL),
    (28, 'Caverna Subterrânea', 'Ilha', NULL),
    (29, 'Área do Helicóptero', 'Ilha', NULL),
    (30, 'Elevador', 'Ilha', NULL),
    (31, 'Área do Chefe Saddler', 'Ilha', NULL),
    (32, 'Porto', 'Ilha', NULL),
    (33, 'Mercado', 'Vila', 'No centro do mercado, uma figura se destaca: o Mercador. Ele é um homem enigmático, vestindo um casaco surrado e um chapéu que esconde parcialmente seu rosto. O Mercador fala com uma voz rouca e amigável, sempre pronta para negociar:
    - "Ah, olá, estranho! O que você precisa? Armas? Munição? Ou talvez... algo mais especial?".'),
    (34, 'Mercado', 'Castelo', 'No centro do mercado, uma figura se destaca: o Mercador. Ele é um homem enigmático, vestindo um casaco surrado e um chapéu que esconde parcialmente seu rosto. O Mercador fala com uma voz rouca e amigável, sempre pronta para negociar:
    - "Ah, olá, estranho! O que você precisa? Armas? Munição? Ou talvez... algo mais especial?".'),
    (35, 'Mercado', 'Ilha', 'No centro do mercado, uma figura se destaca: o Mercador. Ele é um homem enigmático, vestindo um casaco surrado e um chapéu que esconde parcialmente seu rosto. O Mercador fala com uma voz rouca e amigável, sempre pronta para negociar:
    - "Ah, olá, estranho! O que você precisa? Armas? Munição? Ou talvez... algo mais especial?".'),
    (36, 'Mercado', 'Ilha', 'No centro do mercado, uma figura se destaca: o Mercador. Ele é um homem enigmático, vestindo um casaco surrado e um chapéu que esconde parcialmente seu rosto. O Mercador fala com uma voz rouca e amigável, sempre pronta para negociar:
    - "Ah, olá, estranho! O que você precisa? Armas? Munição? Ou talvez... algo mais especial?".');

INSERT INTO entidade(identidade, tipo)
VALUES
    (1,'npc'),
    (2,'npc'),
    (3,'npc'),
    (4,'npc'),
    (5,'npc'),
    (6,'npc'),
    (7,'npc'),
    (8,'npc'),
    (9,'npc'),
    (10,'npc'),
    (11,'npc'),
    (12,'npc'),
    (13,'npc'),
    (14,'npc'),
    (15,'npc'),
    (16,'npc'),
    (17,'protagonista'),
    (18,'npc'),
    (19,'npc');

INSERT INTO protagonista(id_entidade, nickname, killcount, dinheirorecebido,fk_sala_numero, vida, dano,arma_equipada,equipamento_equipado)
VALUES
    (17,"brunoc",0,0,1,100,0,NULL,NULL);

INSERT INTO npc(id_entidade, tipo)
VALUES
    (1,'vendedor'),
    (2,'zumbi'),
    (3,'zumbi'),
    (4,'zumbi'),
    (5,'zumbi'),
    (6,'plaga'),
    (7,'cachorro_zumbi'),
    (8,'chefe'),
    (9,'chefe'),
    (10,'chefe'),
    (11,'chefe'),
    (12,'chefe'),
    (13,'zumbi'),
    (14,'plaga'),
    (15,'chefe'),
    (16,'Zumbi'),
    (19,'chefe');

INSERT INTO item (iditem, tipo)
VALUES
    (1,"consumivel"),
    (2,"consumivel"),
    (3,"consumivel"),
    (4,"consumivel"),
    (5,"consumivel"),
    (6,"consumivel"),
    (7,"consumivel"),
    (8,"consumivel"),
    (9,"dinheiro"),
    (10,"dinheiro"),
    (11,"dinheiro"),
    (12,"dinheiro"),
    (13,"dinheiro"),
    (14,"dinheiro"),
    (15,"dinheiro"),
    (16,"arma"),
    (17,"arma"),
    (18,"arma"),
    (19,"arma"),
    (20,"arma"),
    (21,"arma"),
    (22,"equipamento"),
    (23,"equipamento"),
    (24,"dinheiro");

INSERT INTO missao(nome, tipo)
VALUES
    ("Boas vindas","assassinato"),
    ("A Procura","recuperacao"),
    ("El gigante","assassinato"),
    ("El gigante","recuperacao"),
    ("Las Plagas","assassinato"),
    ("Chefe da Vila","assassinato"),
    ("Armaduras","assassinato"),
    ("Recuperacao","recuperacao"),
    ("Verdugo","assassinato"),
    ("Verdugo","recuperacao"),
    ("Salazar","assassinato"),
    ("Antigos Aliados","assassinato"),
    ("Soldados!","assassinato"),
    ("Controle","assassinato"),
    ("Controle","recuperacao"),
    ("Fim do culto","assassinato");

INSERT INTO assassinato(nome, multiplicador, completa, missao_TIPO, nome_mapa, descricao)
VALUES
    ("Boas vindas",1,0,"assassinato","Vila","Mate seu primeiro Ganado"),
    ("El gigante",2,0,"assassinato","Vila","Mate o El Gigante e recupere a chave da igreja"),
    ("Las Plagas",1,0,"assassinato","Vila","Mate duas plagas"),
    ("Chefe da Vila",3,0,"assassinato","Vila","Mate Bitores Mendez"),
    ("Armaduras",2,0,"assassinato","Castelo","Mate as 3 armaduras e entre na câmara de Salazar"),
    ("Verdugo",3,0,"assassinato","Castelo","Mate o Verdugo e recupere a chave da câmara"),
    ("Salazar",4,0,"assassinato","Castelo","Mate Salazar"),
    ("Antigos Aliados",5,0,"assassinato","Ilha","Derrote Krauser"),
    ("Controle",5,0,"assassinato","Ilha","Mate o regenerator e recupere a o cartão de acesso à sala de controle"),
    ("Soldados!",3,0,"assassinato","Ilha","Mate todos os 6 soldados que estão na Fábrica de Armas"),
    ("Fim do culto",6,0,"assassinato","Ilha","Mate o chefe do Los Illuminados e acabe com o culto");

INSERT INTO recuperacao(nome, multiplicador, completa, missao_tipo, nome_mapa, descricao)
VALUES

    ("A Procura",1,0,"recuperacao","Vila","Entre na igreja, e encontre Ashley"),
    ("El gigante",2,0,"recuperacao","Vila","Mate o El Gigante e recupere a chave da igreja"),
    ("Recuperacao",2,0,"recuperacao","Castelo","Pegue a chave da câmara na sala de tortura"),
    ("Verdugo",3,0,"recuperacao","Castelo","Mate o Verdugo e recupere a chave da câmara"),
    ("Controle",5,0,"recuperacao","Ilha","Mate o regenerator e recupere a o cartão de acesso à sala de controle");

INSERT INTO instanciaNPC (idinstancianpc, id_entidadenpc, fk_sala_numero, missao_nome, id_protagonista,vida_atual)
VALUES
    (1,1,33,NULL,NULL,10),
    (2,1,34,NULL,NULL,10),
    (3,1,35,NULL,NULL,10),
    (4,1,36,NULL,NULL,10),
    (5,8,5,'El gigante',NULL,300),
    (6,9,15,'Verdugo',NULL,350),
    (7,10,20,'Salazar',NULL,400),
    (8,11,31,'Fim do culto',NULL,500),
    (9,12,24,'Controle',NULL,300),
    (10,15,29,'Antigos Aliados',NULL,400),
    (11,19,8,'Chefe da Vila',NULL,350);

INSERT INTO inventario(idinventario, pesomax, id_protagonista, id_instancianpc)
VALUES
    (1,99999,NULL,1),
    (2,99999,NULL,2),
    (3,99999,NULL,3),
    (4,99999,NULL,4),
    (5,150,17,NULL),
    (6,150,NULL,5),
    (7,150,NULL,6),
    (8,150,NULL,9);

INSERT INTO arma(id_item, nome, dano, nivel, chanceerro, chancecritico, maxmuni, descricao, valor, peso)
VALUES
    (16,"Faca de Combate",10,1,0.00,10.00,NULL, "Faca de combate. Esta faca foi dada a você como um presente da sua falecida mãe, e voce nunca mais saiu sem ela.",0,0),
    (17,"Pistola",15,1,10.00,20.00,15, "Pistola SG-09, feita especialmente para você para realizar sua missão",100,5),
    (18,"Escopeta",40,1,30.00,5.00,8, "W-870, calibre 12 com ação de bombeamento",150,15),
    (19,"Rifle",35,1,8.00,10.00,30, "TMP, leve e pequena, tem um ótimo desempenho",300,10),
    (20,"Sniper",60,1,3.00,25.00,5, "Stingray, peças reforçadas com fibra de carbono o tornam leve e robusto.",400,20),
    (21,"Lança Foguete",200,1,30.00,10.00,1,"Lanca-foguetes sem recuo de uso único. Leve e de fácil manuseio, é uma arma de alta potência",800,20);

INSERT INTO equipamento (id_item, defesa, nivel, nome, descricao, valor, peso)
VALUES
    (22,15,1,"colete balistico","Colete corportal capaz de reduzir o dano recebido em 10%",200,15),
    (23,5,1, "capacete","Um capacete capaz de reduzir o dano recebido em 5%",150,5);

INSERT INTO consumivel (id_item, efeito, nome, descricao, valor, peso)
VALUES
    (4,"Cura 25 de vida","Erva Verde","Erva medicinal que pode curar 25 de vida.",10,5),
    (5,"Cura toda a vida", "Spray Medicinal","Spray, cura toda a vida",20,5),
    (6,"Cura 5 de vida","Ovo Branco","Ovo Branco de galinha, cura 5 de vida",5,1),
    (7,"Cura 15 de vida","Ovo Marrom","Ovo marrom de galinha, cura 15 de vida",10,1),
    (8,"Cura 30 de vida","Ovo Dourado","Ovo Dourado, cura 30 de vida",30,1);

INSERT INTO dinheiro(id_item, valor, nome, descricao, peso)
VALUES
    (9,15,"Esmeralda","Pedra de Esmeralda",5),
    (10,15,"Rubi","Pedra de Rubi",5),
    (11,25,"Diamante","Pedra de Diamante",10),
    (12,50,"Máscara Elegante","Uma máscara com jóias",15),
    (13,50,"Baú de moedas","Baú com muitas moedas",0),
    (14,25,"Saco de moedas","Saco com várias moedas",0),
    (15,1,"Moeda","Moeda usada para compra de armas e equipamentos",0),
    (24,50,"colar","Colar de ouro com pedras",1);

INSERT INTO vendedor(id_entidade, nome, vida, dano)
VALUES
    (1,'Mercador',10,0);

INSERT INTO reputacao (id_entidade, nivel_reputacao)
VALUES
    (17,1);

INSERT INTO habilidade (nome,tempo_recarga_turno,tempo_recarga_tempo,dano)
VALUES
    ("Chute rasteiro",2,30,50);

INSERT INTO chefe(id_entidade, nome, vida, dano)
VALUES
    (8, 'El gigante', 300, 20),
    (9, 'Verdugo', 350, 20),
    (10, 'Salazar', 400, 25),
    (11, 'Saddler', 500, 25),
    (12, 'Regenerator', 300, 20),
    (15, 'Krauser', 400, 25),
    (19, 'Bitores Mendez', 350, 25);

INSERT INTO usa (id_entidade,nome_habilidade,nivel,ultimo_uso)
VALUES
    (17,"chute rasteiro",1,null);

INSERT INTO instanciaitem(idinstanciaitem, id_item, id_inventario, nome_missao)
VALUES
    (1, 16, 5, NULL),
    (2, 1, 6, 'El gigante'),
    (3, 2, 7, 'Verdugo'),
    (4, 3, 8, 'Controle'),
    (5, 12, NULL, NULL),
    (6, 20, 3, NULL);

INSERT INTO zumbi (id_entidade, nome, vida, dano)
VALUES
    (2, 'Ganado', 100, 10),
    (3, 'Ganado do Castelo', 100, 15),
    (4, 'Ganado com Machado', 100, 12),
    (5, 'Ganado com Foice', 100, 12),
    (13, 'El Salvador', 200, 15),
    (16, 'Soldado', 150, 15);

INSERT INTO cachorro_zumbi (id_entidade, nome, vida, dano)
VALUES
    (7, 'Colmillos', 150, 15);

INSERT INTO plaga (id_entidade, nome, vida, dano)
VALUES
    (6, 'Plaga', 150, 15),
    (14, 'Armadura', 200, 15);

INSERT INTO caminho(sala_atual, prox_sala)
VALUES
    (1,2),
    (2,1),
    (2,3),
    (3,2),
    (2,33),
    (33,2),
    (2,6),
    (6,2),
    (6,7),
    (7,6),
    (7,5),
    (5,7),
    (2,4),
    (4,2),
    (4,9),
    (9,4),
    (9,8),
    (8,9),
    (8,10),
    (10,8),
    (10,11),
    (11,10),
    (11,12),
    (12,11),
    (12,34),
    (34,12),
    (12,14),
    (14,12),
    (13,12),
    (12,13),
    (14,16),
    (16,14),
    (16,18),
    (18,16),
    (18,15),
    (15,18),
    (13,17),
    (17,13),
    (17,20),
    (20,17),
    (20,19),
    (19,20),
    (19,21),
    (21,19),
    (21,22),
    (22,21),
    (22,23),
    (23,22),
    (23,25),
    (25,23),
    (25,35),
    (35,25),
    (25,26),
    (26,25),
    (26,24),
    (24,26),
    (22,27),
    (27,22),
    (27,29),
    (29,27),
    (29,30),
    (30,29),
    (30,36),
    (36,30),
    (30,31),
    (31,30),
    (31,32);

INSERT INTO item_sala (id, fk_sala, id_item, quantidade)
VALUES
    (1,3,5,1);
```

| Versão |   Descrição    |                                                                 Autor(es)                                                                  |    Data    |
| :----: | :------------: | :----------------------------------------------------------------------------------------------------------------------------------------: | :--------: |
|  1.0   |    Criação     |                                                 [Bruno Cruz](https://github.com/Brunocrzz)                                                 | 08/01/2025 |
|  1.1   |   Alteração    |                                                 [Pablo Cunha](https://github.com/pabloo8)                                                  | 13/01/2025 |
|  1.2   |   Alteração    |                           [Bruno Cruz](https://github.com/Brunocrzz) e [Pablo Cunha](https://github.com/pabloo8)                           | 13/01/2025 |
|  1.3   |   Alteração    |                       [Pablo Cunha](https://github.com/pabloo8) e [Anne de Capdeville](https://github.com/nanecapde)                       | 13/01/2025 |
|  2.0   |   Alteração    |                                                 [Bruno Cruz](https://github.com/Brunocrzz)                                                 | 01/02/2025 |
|  2.1   |   Alteração    |                                             [Anne de Capdeville](https://github.com/nanecapde)                                             | 02/02/2025 |
|  2.2   | DML alterações | [Anne de Capdeville](https://github.com/nanecapde), [Bruno Cruz](https://github.com/Brunocrzz) e [Pablo Cunha](https://github.com/pabloo8) | 02/02/2025 |
|  3.0   |   DML Final    |                      [Bruno Cruz](https://github.com/Brunocrzz) e [Anne de Capdeville](https://github.com/nanecapde)                       | 03/02/2025 |
