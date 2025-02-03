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

INSERT INTO entidade(identidade, tipo)
VALUES
    (1,'npc'),
    (2, 'npc'),
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

INSERT INTO protagonista(id_entidade, nickname, killcount, dinheirorecebido,fk_sala_numero, vida, dano)
VALUES
    (17,"brunoc",0,0,1,100,0);

INSERT INTO npc(id_entidade, tipo)
VALUES
    (1,  'vendedor'),
    (2,  'zumbi'),
    (3,  'zumbi'),
    (4,  'zumbi'),
    (5,  'zumbi'),
    (6,  'plaga'),
    (7,  'cachorro_zumbi'),
    (8,  'chefe'),
    (9, 'chefe'),
    (10,  'chefe'),
    (11,  'chefe'),
    (12,  'chefe'),
    (13,  'zumbi'),
    (14,  'plaga'),
    (15,  'chefe'),
    (16,  'Zumbi'),
    (19,  'chefe');


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
    ("El gigante","dupla"),
    ("Las Plagas","assassinato"),
    ("Chefe da Vila","assassinato"),
    ("Armaduras","assassinato"),
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
