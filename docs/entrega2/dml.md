# DML - Data Manipulation Language

Linguagem de manipulação de dados: São comandos que interagem com os dados dentro das tabelas. Os comandos DML incluem:


+ **INSERT**: Adiciona um novo dado ao banco.
+ **UPDATE**: Atualiza os valores das linhas de uma tabela.
+ **DELETE**: Exclui dados de uma tabela.

Nesse projeto, os comandos DML usados foram:

```

INSERT INTO arma(nome, dano, nivel, chanceerro, chancecritico, maxmuni)
VALUES
("Faca de Combate",10,1,0.00,10.00,null),
("Pistola",15,1,10.00,20.00,15),
("Escopeta",40,1,30.00,5.00,8),
("Rifle",35,1,8.00,10.00,30),
("Sniper",60,1,3.00,25.00,5),
("Lança Foguete",150,1,30.00,10.00,1);

INSERT INTO usa_arma(fk_arma_nome, fk_entidade_identidade)
VALUES
("Faca de Combate", 18),
("Pistola", 4),
("Pistola", 2);

INSERT INTO entidade(identidade, vida, dano, fk_sala_numero)
VALUES
(1,10,0,3),
(2,100,0,3),
(3,100,0,4),
(4,100,0,12),
(5,100,10,2),
(6,100,15,12),
(7,100,12,2),
(8,100,12,2),
(9,150,15,9),
(10,150,15,6),
(11,300,20,5),
(12,350,20,15),
(13,500,25,17),
(14,500,25,8),
(15,300,20,24),
(16,200,15,2),
(17,200,15,13),
(18,100,0,1);

INSERT INTO equipamento(nome, defesa, nivel)
VALUES

INSERT INTO usa_equipamento(fk_equipamento_nome, fk_entidade_identidade)
VALUES


INSERT INTO protagonista(fk_entidade_identidade, nickname, killcount, dinheirorecebido)
VALUES


INSERT INTO sala(numero, nome, fk_mapa_nome)
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
    (30, 'Área do Chefe Saddler', 'Ilha');
    (31, 'Mercado', 'Vila');
    (32, 'Mercado', 'Castelo');
    (33, 'Mercado', 'Ilha');

INSERT INTO npc(fk_entidade_identidade, nome, tipo)
VALUES
    (1, 'Mercador', 'Pacífico'),
    (2, 'Luis Sera', 'Pacífico'),
    (3, 'Ashley Graham', 'Pacífico'),
    (4, 'Ada Wong', 'Pacífico'),
    (5, 'Ganado', 'Hostil'),
    (6, 'Ganado do Castelo', 'Hostil'),
    (7, 'Ganado com Machado', 'Hostil'), 
    (8, 'Ganado com Foice', 'Hostil'), 
    (9, 'Plaga', 'Hostil'), 
    (10, 'Cachorro Zumbi', 'Hostil'), 
    (11, 'El Gigante', 'Hostil'),  
    (12, 'Verdugo', 'Hostil'), 
    (13, 'Salazar', 'Hostil'), 
    (14, 'Saddler', 'Hostil'), 
    (15, 'Regenerator', 'Hostil'), 
    (16, "El salvador", "hostil"),  
    (16, "Armadura", "hostil");     

INSERT INTO mercado(fk_sala_numero, fk_protagonista_fk_entidade_identidade)
VALUES
(31,NULL);
(32,NULL);
(33,NULL);

INSERT INTO missao(nome, multiplicador, completa, fk_mapa_nome, fk_protagonista_fk_entidade_identidade)
VALUES

INSERT INTO inventario(idinventario, pesomax, fk_entidade_identidade, fk_mercado_fk_sala_numero)
VALUES
(1,99999,NULL,31);
(1,99999,NULL,32);
(1,99999,NULL,33);

INSERT INTO recompensa (fk_missao_nome, fk_item_iditem)
VALUES


INSERT INTO possui(fk_inventario_idinventario, fk_item_iditem, quantidade)
VALUES
(31,5,3);
(31,4,5);
(32,5,3);
(32,4,5);
(33,5,3);
(33,4,5);

INSERT INTO item (iditem, nome, descricao, valor, peso, tipo)
VALUES
(1,"Chave Igreja","Chave para a abrir a igreja no mapa da vila",0,0,"chave"),
(2,"Chave --","Chave para a abrir algo no Castelo",0,0,"chave"),
(3,"Chave DASD","Chave para a abrir algo na Ilha",0,0,"chave"),
(4,"Erva Verde","Erva medicinal que pode curar 25 de vida.",10,5,"cura"),
(5,"Spray Medicinal","Spray, cura toda a vida",20,5,"cura"),
(6,"Ovo Branco","Ovo Branco de galinha, cura 5 de vida",5,1,"cura"),
(7,"Ovo Marrom","Ovo marrom de galinha, cura 10 de vida",10,1,"cura"),
(8,"Ovo Dourado","Ovo Dourado, cura 15 de vida",15,1,"cura"),
(8,"Colar","Colar de ouro com pedras",50,10,"dinheiro"),
(9,"Esmeralda","Pedra de Esmeralda",15,5,"dinheiro"),
(10,"Rubi","Pedra de Rubi",15,5,"dinheiro"),
(11,"Diamante","Pedra de Diamante",25,10,"dinheiro"),
(12,"Máscara Elegante","Uma máscara com jóias",50,15,"dinheiro"),
(13,"Baú de moedas","Baú com muitas moedas",50,0,"dinheiro"),
(14,"Saco de moedas","Saco com várias moedas",25,0,"dinheiro"),
(15,"Moeda","Moeda usada para compra de armas e equipamentos",1,0,"dinheiro");

INSERT INTO mapa (nome)
VALUES
("Vila"),
("Castelo"),
("Ilha");

INSERT INTO zumbi (fk_instanciaNPC_idinstancianpc)
VALUES

INSERT INTO instanciaNPC (idinstancianpc, fk_npc_fk_entidade_identidade)
VALUES

INSERT INTO plaga (fk_instanciaNPC_idinstancianpc)
VALUES

INSERT INTO cachorro_zumbi (fk_instanciaNPC_idinstancianpc)
VALUES

INSERT INTO esta_npc (fk_instanciaNPC_idinstancianpc, fk_sala_numero)
VALUES

INSERT INTO esta_item (fk_item_iditem, fk_sala_numero)
VALUES

```

| Versão | Descrição |                 Autor(es)                  |    Data    |
| :----: | :-------: | :----------------------------------------: | :--------: |
|  1.0   |  Criação  | [Bruno Cruz](https://github.com/Brunocrzz) | 08/01/2025 |
|  1.1   | Alteração | [Pablo Cunha](https://github.com/pabloo8)  | 13/01/2025 |
|  1.2   | Alteração | [Bruno Cruz](https://github.com/Brunocrzz) e [Pablo Cunha](https://github.com/pabloo8)  | 13/01/2025 |
