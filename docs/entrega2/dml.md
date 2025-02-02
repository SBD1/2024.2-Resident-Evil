# DML - Data Manipulation Language

Linguagem de manipulação de dados: São comandos que interagem com os dados dentro das tabelas. Os comandos DML incluem:

- **INSERT**: Adiciona um novo dado ao banco.
- **UPDATE**: Atualiza os valores das linhas de uma tabela.
- **DELETE**: Exclui dados de uma tabela.

Nesse projeto, os comandos DML usados foram:

```

INSERT INTO sala(numero, nome, nome_mapa)
VALUES
    (1, 'Entrada da Vila', 'Vila'),
    (2, 'Praça Principal da Vila', 'Vila'),
    (3, 'Cabana de Luis', 'Vila'),
    (4, 'Igreja', 'Vila'),
    (5, 'Torre de Vigia', 'Vila'),
    (6, 'Caminho para o Lago', 'Vila'),
    (7, 'Lago', 'Vila'),
    (8, 'Casa do Chefe Bitores Mendez', 'Vila'),
    (9, 'Cabana Abandonada', 'Vila'),
    (10, 'Caminho para o Castelo', 'Vila'),

    (11, 'Entrada do Castelo', 'Castelo'),
    (12, 'Salão Principal', 'Castelo'),
    (13, 'Sala de Armaduras', 'Castelo'),
    (14, 'Jardim do Castelo', 'Castelo'),
    (15, 'Sala de Tortura', 'Castelo'),
    (16, 'Salão de Banquete', 'Castelo'),
    (17, 'Câmara de Salazar', 'Castelo'),
    (18, 'Caminho para o Elevador', 'Castelo'),
    (19, 'Sala do Elevador', 'Castelo'),
    (20, 'Área do Chefe Salazar', 'Castelo'),

    (21, 'Praia da Ilha', 'Ilha'),
    (22, 'Área de Contêineres', 'Ilha'),
    (23, 'Fábrica de Armas', 'Ilha'),
    (24, 'Laboratório de Experimentos', 'Ilha'),
    (25, 'Câmara de Tortura', 'Ilha'),
    (26, 'Armazém', 'Ilha'),
    (27, 'Sala de Controle', 'Ilha'),
    (28, 'Caverna Subterrânea', 'Ilha'),
    (29, 'Área do Helicóptero', 'Ilha'),
    (30, 'Elevador', 'Ilha'),
    (31, 'Área do Chefe Saddler', 'Ilha'),
    (32, 'Porto', 'Ilha'),

    (33, 'Mercado', 'Vila'),
    (34, 'Mercado', 'Castelo'),
    (35, 'Mercado', 'Ilha'),
    (36, 'Mercado', 'Ilha');

INSERT INTO entidade(identidade, vida, dano)
VALUES
    (1,10,0),
    (2,100,10),
    (3,100,15),
    (4,100,12),
    (5,100,12),
    (6,150,15),
    (7,150,15),
    (8,300,20),
    (9,350,20),
    (10,400,25),
    (11,500,25),
    (12,300,20),
    (13,200,15),
    (14,200,15),
    (15,400,15),
    (16,150,15),
    (17,100,0),
    (18,100,0),
    (19,350,25);


INSERT INTO protagonista(id_entidade, nickname, killcount, dinheirorecebido,fk_sala_numero)
VALUES
    (17,"brunoc",0,0,1);

INSERT INTO npc(id_entidade, nome, tipo)
VALUES
    (1, 'Mercador', 'vendedor'),
    (2, 'Ganado', 'zumbi'),
    (3, 'Ganado do Castelo', 'zumbi'),
    (4, 'Ganado com Machado', 'zumbi'),
    (5, 'Ganado com Foice', 'zumbi'),
    (6, 'Plaga', 'plaga'),
    (7, 'Cachorro Zumbi', 'cachorro_zumbi'),
    (8, 'El Gigante', 'chefe'),
    (9, 'Verdugo', 'chefe'),
    (10, 'Salazar', 'chefe'),
    (11, 'Saddler', 'chefe'),
    (12, 'Regenerator', 'chefe'),
    (13, "El salvador", "zumbi"),
    (14, "Armadura", "plaga"),
    (15, "Krauser", "chefe"),
    (16, "Soldado", "Zumbi"),
    (19, 'Bitores Mendez', 'chefe');

INSERT INTO item (iditem, nome, descricao, valor, peso, tipo)
VALUES
    (1,"Chave Igreja","Chave para a abrir a Igreja na Vila",0,0,"consumivel"),
    (2,"Chave da Câmara","Chave para a câmara de Salazar no Castelo",0,0,"consumivel"),
    (3,"Cartão de acesso","Cartão de acesso para a Sala de Controle na Ilha",0,0,"consumivel"),
    (4,"Erva Verde","Erva medicinal que pode curar 25 de vida.",10,5,"consumivel"),
    (5,"Spray Medicinal","Spray, cura toda a vida",20,5,"consumivel"),
    (6,"Ovo Branco","Ovo Branco de galinha, cura 5 de vida",5,1,"consumivel"),
    (7,"Ovo Marrom","Ovo marrom de galinha, cura 15 de vida",10,1,"consumivel"),
    (8,"Ovo Dourado","Ovo Dourado, cura 30 de vida",30,1,"consumivel"),
    (9,"Esmeralda","Pedra de Esmeralda",15,5,"dinheiro"),
    (10,"Rubi","Pedra de Rubi",15,5,"dinheiro"),
    (11,"Diamante","Pedra de Diamante",25,10,"dinheiro"),
    (12,"Máscara Elegante","Uma máscara com jóias",50,15,"dinheiro"),
    (13,"Baú de moedas","Baú com muitas moedas",50,0,"dinheiro"),
    (14,"Saco de moedas","Saco com várias moedas",25,0,"dinheiro"),
    (15,"Moeda","Moeda usada para compra de armas e equipamentos",1,0,"dinheiro"),
    (16,"Faca de Combate","Faca de combate. Esta faca foi dada a você como um presente da sua falecida mãe, e voce nunca mais saiu sem ela.",0,0,"arma"),
    (17,"Pistola","Pistola SG-09, feita especialmente para você para realizar sua missão",100,5,"arma"),
    (18,"Escopeta","W-870, calibre 12 com ação de bombeamento",150,15,"arma"),
    (19,"Rifle","TMP, leve e pequena, tem um ótimo desempenho",300,10,"arma"),
    (20,"Sniper","Stingray, peças reforçadas com fibra de carbono o tornam leve e robusto.",400,20,"arma"),
    (21,"Lança Foguete","Lanca-foguetes sem recuo de uso único. Leve e de fácil manuseio, é uma arma de alta potência",800,20,"arma"),
    (22,"colete balistico","Colete corportal capaz de reduzir o dano recebido em 10%",200,15,"equipamento"),
    (23,"capacete","Um capacete capaz de reduzir o dano recebido em 5%",150,5,"equipamento"),
    (24,"colar","Colar de ouro com pedras",50,10,"dinheiro");


INSERT INTO mapa (nome)
VALUES
    ("Vila"),
    ("Castelo"),
    ("Ilha");

INSERT INTO missao(nome, multiplicador, completa, tipo, missao_TIPO, nome_mapa, descricao)
VALUES
    ("Boas vindas",1,0,"assassinato",1,"Vila","Mate seu primeiro Ganado"),
    ("A Procura",1,0,"recuperacao",2,"Vila","Entre na igreja, e encontre Ashley"),
    ("El gigante",2,0,"dupla",3,"Vila","Mate o El Gigante e recupere a chave da igreja"),
    ("Las Plagas",1,0,"assassinato",1,"Vila","Mate duas plagas"),
    ("Chefe da Vila",3,0,"assassinato",1,"Vila","Mate Bitores Mendez"),
    ("Armaduras",2,0,"assassinato",1,"Castelo","Mate as 3 armaduras e entre na câmara de Salazar"),
    ("Recuperacao",2,0,"recuperacao",2,"Castelo","Pegue a chave da câmara na sala de tortura"),
    ("Verdugo",3,0,"dupla",3,"Castelo","Mate o Verdugo e recupere a chave da câmara"),
    ("Salazar",4,0,"assassinato",1,"Castelo","Mate Salazar"),
    ("Antigos Aliados",5,0,"assassinato",1,"Ilha","Derrote Krauser"),
    ("Controle",5,0,"dupla",3,"Ilha","Mate o regenerator e recupere a o cartão de acesso à sala de controle"),
    ("Soldados!",3,0,"assassinato",1,"Ilha","Mate todos os 6 soldados que estão na Fábrica de Armas"),
    ("Fim do culto",6,0,"assassinato",1,"Ilha","Mate o chefe do Los Illuminados e acabe com o culto");

INSERT INTO instanciaNPC (idinstancianpc, id_entidadenpc, fk_sala_numero, missao_nome, id_protagonista)
VALUES
    (1,1,33,NULL, NULL),
    (2,1,34,NULL, NULL),
    (3,1,35,NULL, NULL),
    (4,1,36,NULL, NULL),
    (11,19,8,'Chefe da Vila', NULL),
    (10,15,29,'Antigos Aliados', NULL),
    (9,12,24,'Controle', NULL),
    (8,11,31,'Fim do culto', NULL),
    (7,10,20,'Salazar', NULL),
    (6,9,15,'Verdugo', NULL),
    (5,8,5,'El gigante', NULL);

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

INSERT INTO arma(id_item, nome, dano, nivel, chanceerro, chancecritico, maxmuni)
VALUES
    (16,"Faca de Combate",10,1,0.00,10.00,NULL),
    (17,"Pistola",15,1,10.00,20.00,15),
    (18,"Escopeta",40,1,30.00,5.00,8),
    (19,"Rifle",35,1,8.00,10.00,30),
    (20,"Sniper",60,1,3.00,25.00,5),
    (21,"Lança Foguete",200,1,30.00,10.00,1);


INSERT INTO equipamento (id_item, defesa, nivel)
VALUES
    (22,15,1),
    (23,5,1);


INSERT INTO consumivel (id_item, efeito)
VALUES
    (4,"Cura 25 de vida"),
    (5,"Cura toda a vida"),
    (6,"Cura 5 de vida"),
    (7,"Cura 15 de vida"),
    (8,"Cura 30 de vida");

INSERT INTO dinheiro (id_item,valor)
VALUES
    (8,10),
    (9,15),
    (10,15),
    (11,25),
    (12,50),
    (13,50),
    (14,25),
    (15,1);

INSERT INTO vendedor(id_entidade)
VALUES
    (1);

INSERT INTO reputacao (id_entidade, nivel_reputacao)
VALUES
    (17,1);

INSERT INTO habilidade (nome,tempo_recarga_turno,tempo_recarga_tempo,dano)
VALUES
    ("Chute rasteiro",2,30,50);

INSERT INTO chefe(id_entidade)
VALUES
    (8),
    (9),
    (10),
    (11),
    (12),
    (15),
    (19);

INSERT INTO usa (id_entidade,nome_habilidade,nivel,ultimo_uso)
VALUES
    (17,"chute rasteiro",1,null);


INSERT INTO instanciaitem(idinstanciaitem, id_item, id_inventario, nome_missao)
VALUES
    (1, 16, 5, NULL),
    (2, 1, 6, 'El gigante'),
    (3, 2, 7, 'Verdugo'),
    (4, 3, 8, 'Controle');

INSERT INTO zumbi (id_entidade)
VALUES
    (2),
    (3),
    (4),
    (5),
    (13),
    (16);

INSERT INTO cachorro_zumbi (id_entidade)
VALUES
    (7);

INSERT INTO plaga (id_entidade)
VALUES
    (6),
    (14);

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

```

| Versão | Descrição |                                                                 Autor(es)                                                                  |    Data    |
| :----: | :-------: | :----------------------------------------------------------------------------------------------------------------------------------------: | :--------: |
|  1.0   |  Criação  |                                                 [Bruno Cruz](https://github.com/Brunocrzz)                                                 | 08/01/2025 |
|  1.1   | Alteração |                                                 [Pablo Cunha](https://github.com/pabloo8)                                                  | 13/01/2025 |
|  1.2   | Alteração |                           [Bruno Cruz](https://github.com/Brunocrzz) e [Pablo Cunha](https://github.com/pabloo8)                           | 13/01/2025 |
|  1.3   | Alteração |                       [Pablo Cunha](https://github.com/pabloo8) e [Anne de Capdeville](https://github.com/nanecapde)                       | 13/01/2025 |
|  2.0   | Alteração |                                                 [Bruno Cruz](https://github.com/Brunocrzz)                                                 | 01/02/2025 |
|  2.1   | Alteração |                                             [Anne de Capdeville](https://github.com/nanecapde)                                             | 02/02/2025 |
|  3.0   | DML final | [Anne de Capdeville](https://github.com/nanecapde), [Bruno Cruz](https://github.com/Brunocrzz) e [Pablo Cunha](https://github.com/pabloo8) | 02/02/2025 |
