# DDL - Data Definition Language

Linguagem de definição de dados: São comandos que interagem com objetos dentro de um banco de dados (views, functions, procedures, sendo as tabelas os mais comuns). Os comandos DDL permitem que a gente interaja com esses objetos. As principais formas de interagir com esses objetos é por meio dos comandos:

- **CREATE**: Cria um novo objeto.
- **ALTER**: Altera um objeto existente.
- **DROP**: Exclui um objeto, como uma tabela ou banco de dados.

### CREATE

```sql
CREATE TABLE mapa (
    nome varchar(30) PRIMARY KEY
);

CREATE TABLE sala (
    numero int PRIMARY KEY,
    nome varchar(30),
    nome_mapa varchar(30)
);

CREATE TABLE entidade (
    identidade int auto_increment PRIMARY KEY,
    tipo enum('protagonista', 'npc')
);

CREATE TABLE protagonista (
    id_entidade int PRIMARY KEY,
    nickname varchar(25),
    killcount int,
    dinheirorecebido int,
    fk_sala_numero int,
    vida int,
    dano int
);

CREATE TABLE npc (
    tipo enum('chefe', 'vendedor', 'zumbi', 'plaga', 'cachorro_zumbi'),
    id_entidade int PRIMARY KEY
);


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

CREATE TABLE item (
    iditem int auto_increment PRIMARY KEY,
    tipo enum('arma','consumivel','equipamento','dinheiro')
);

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



CREATE TABLE missao (
    tipo enum('assassinato','recuperacao'),
    nome varchar(30),
    PRIMARY KEY (nome, tipo)
);


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

CREATE TABLE assassinato(
    nome varchar(30) PRIMARY KEY,
    completa bool,
    multiplicador int,
    missao_TIPO INT,
    nome_mapa varchar(30),
    descricao varchar(150)
);

CREATE TABLE recuperacao(
    nome varchar(30) PRIMARY KEY,
    completa bool,
    multiplicador int,
    missao_TIPO INT,
    nome_mapa varchar(30),
    descricao varchar(150)
);

CREATE TABLE instancianpc (
    idinstancianpc int auto_increment PRIMARY KEY,
    id_entidadenpc int,
    fk_sala_numero int,
    missao_nome varchar(30),
    id_protagonista int
);

CREATE TABLE inventario (
    idinventario int auto_increment PRIMARY KEY,
    pesomax int,
    id_protagonista int,
    id_instancianpc int
);


CREATE TABLE arma (
    nome varchar(50),
    dano int,
    nivel int,
    chanceerro int,
    chancecritico int,
    maxmuni int,
    id_item int PRIMARY KEY,
    descricao varchar(150),
    valor int,
    peso int
);


CREATE TABLE equipamento (
    defesa int,
    nivel int,
    id_item int PRIMARY KEY,
    nome varchar(30),
    descricao varchar(150),
    valor int,
    peso int
);


CREATE TABLE consumivel (
    efeito varchar(50),
    id_item int PRIMARY KEY,
    nome varchar(30),
    descricao varchar(150),
    valor int,
    peso int
);


CREATE TABLE dinheiro (
    valor int,
    id_item int PRIMARY KEY,
    nome varchar(30),
    descricao varchar(150),
    peso int
);

CREATE TABLE vendedor (
    id_entidade int PRIMARY KEY,
    nome varchar(20),
    vida int,
    dano int
);

CREATE TABLE reputacao (
    nivel_reputacao int,
    id_entidade int PRIMARY KEY
);

CREATE TABLE habilidade (
    nome varchar(50) PRIMARY KEY,
    tempo_recarga_turno int,
    tempo_recarga_tempo int,
    dano int
);

CREATE TABLE chefe (
    id_entidade int PRIMARY KEY,
    nome varchar(20),
    vida int,
    dano int
);

CREATE TABLE usa (
    id_entidade int PRIMARY KEY,
    nome_habilidade varchar(50),
    nivel int,
    ultimo_uso DATETIME
);


CREATE TABLE instanciaitem (
    idinstanciaitem int auto_increment PRIMARY KEY,
    id_item int,
    id_inventario int,
    nome_missao varchar(30)
);


CREATE TABLE zumbi (
    id_entidade int PRIMARY KEY,
    nome varchar(20),
    vida int,
    dano int
);

CREATE TABLE cachorro_zumbi (
    id_entidade int PRIMARY KEY,
    nome varchar(20),
    vida int,
    dano int
);

CREATE TABLE plaga (
    id_entidade int PRIMARY KEY,
    nome varchar(20),
    vida int,
    dano int
);

CREATE TABLE caminho (
    sala_atual INT,
    prox_sala INT,
    PRIMARY KEY (sala_atual, prox_sala)
);

ALTER TABLE sala ADD CONSTRAINT FK_sala_2
    FOREIGN KEY (nome_mapa)
    REFERENCES mapa (nome)
    ON DELETE RESTRICT;

ALTER TABLE protagonista ADD CONSTRAINT FK_protagonista_2
    FOREIGN KEY (id_entidade)
    REFERENCES entidade (identidade)
    ON DELETE CASCADE;

ALTER TABLE protagonista ADD CONSTRAINT FK_protagonista_3
    FOREIGN KEY (fk_sala_numero)
    REFERENCES sala (numero)
    ON DELETE CASCADE;

ALTER TABLE npc ADD CONSTRAINT FK_npc_2
    FOREIGN KEY (id_entidade)
    REFERENCES entidade (identidade)
    ON DELETE CASCADE;

ALTER TABLE inventario ADD CONSTRAINT FK_inventario_2
    FOREIGN KEY (id_protagonista)
    REFERENCES protagonista (id_entidade)
    ON DELETE RESTRICT;

ALTER TABLE inventario ADD CONSTRAINT FK_inventario_3
    FOREIGN KEY (id_instancianpc)
    REFERENCES instancianpc (idinstancianpc)
    ON DELETE RESTRICT;

ALTER TABLE arma ADD CONSTRAINT FK_arma_2
    FOREIGN KEY (id_item)
    REFERENCES item (iditem)
    ON DELETE CASCADE;

ALTER TABLE assassinato ADD CONSTRAINT FK_assassinato_2
    FOREIGN KEY (nome_mapa)
    REFERENCES mapa (nome)
    ON DELETE CASCADE;

ALTER TABLE assassinato ADD CONSTRAINT FK_assassinato_3
    FOREIGN KEY (nome)
    REFERENCES missao (nome)
    ON DELETE CASCADE;

ALTER TABLE recuperacao ADD CONSTRAINT FK_recuperacao_2
    FOREIGN KEY (nome_mapa)
    REFERENCES mapa (nome)
    ON DELETE CASCADE;

ALTER TABLE recuperacao ADD CONSTRAINT FK_recuperacao_3
    FOREIGN KEY (nome)
    REFERENCES missao (nome)
    ON DELETE CASCADE;

ALTER TABLE equipamento ADD CONSTRAINT FK_equipamento_2
    FOREIGN KEY (id_item)
    REFERENCES item (iditem)
    ON DELETE CASCADE;

ALTER TABLE instancianpc ADD CONSTRAINT FK_instancianpc_2
    FOREIGN KEY (id_entidadenpc)
    REFERENCES npc (id_entidade)
    ON DELETE CASCADE;

ALTER TABLE instancianpc ADD CONSTRAINT FK_instancianpc_3
    FOREIGN KEY (fk_sala_numero)
    REFERENCES sala (numero)
    ON DELETE SET NULL;

ALTER TABLE instancianpc ADD CONSTRAINT FK_instancianpc_4
    FOREIGN KEY (missao_nome)
    REFERENCES missao (nome)
    ON DELETE CASCADE;

ALTER TABLE instancianpc ADD CONSTRAINT FK_instancianpc_5
    FOREIGN KEY (id_protagonista)
    REFERENCES protagonista (id_entidade)
    ON DELETE CASCADE;

ALTER TABLE zumbi ADD CONSTRAINT FK_zumbi_2
    FOREIGN KEY (id_entidade)
    REFERENCES npc (id_entidade)
    ON DELETE CASCADE;

ALTER TABLE cachorro_zumbi ADD CONSTRAINT FK_cachorro_zumbi_2
    FOREIGN KEY (id_entidade)
    REFERENCES npc (id_entidade)
    ON DELETE CASCADE;

ALTER TABLE plaga ADD CONSTRAINT FK_plaga_2
    FOREIGN KEY (id_entidade)
    REFERENCES npc (id_entidade)
    ON DELETE CASCADE;

ALTER TABLE consumivel ADD CONSTRAINT FK_consumivel_2
    FOREIGN KEY (id_item)
    REFERENCES item (iditem)
    ON DELETE CASCADE;

ALTER TABLE instanciaitem ADD CONSTRAINT FK_instanciaitem_1
    FOREIGN KEY (id_item)
    REFERENCES item (iditem)
    ON DELETE CASCADE;

ALTER TABLE instanciaitem ADD CONSTRAINT FK_instanciaitem_2
    FOREIGN KEY (id_inventario)
    REFERENCES inventario (idinventario)
    ON DELETE SET NULL;

ALTER TABLE instanciaitem ADD CONSTRAINT FK_instanciaitem_3
    FOREIGN KEY (nome_missao)
    REFERENCES missao (nome)
    ON DELETE CASCADE;

ALTER TABLE dinheiro ADD CONSTRAINT FK_dinheiro_2
    FOREIGN KEY (id_item)
    REFERENCES item (iditem)
    ON DELETE CASCADE;

ALTER TABLE vendedor ADD CONSTRAINT FK_vendedor_2
    FOREIGN KEY (id_entidade)
    REFERENCES npc (id_entidade)
    ON DELETE CASCADE;

ALTER TABLE reputacao ADD CONSTRAINT FK_reputacao_1
    FOREIGN KEY (id_entidade)
    REFERENCES protagonista (id_entidade)
    ON DELETE RESTRICT;

ALTER TABLE chefe ADD CONSTRAINT FK_chefe_2
    FOREIGN KEY (id_entidade)
    REFERENCES npc (id_entidade)
    ON DELETE CASCADE;

ALTER TABLE usa ADD CONSTRAINT FK_usa_1
    FOREIGN KEY (id_entidade)
    REFERENCES protagonista (id_entidade)
    ON DELETE RESTRICT;

ALTER TABLE usa ADD CONSTRAINT FK_usa_2
    FOREIGN KEY (nome_habilidade)
    REFERENCES habilidade (nome)
    ON DELETE SET NULL;

ALTER TABLE caminho ADD CONSTRAINT FK_caminho_2
    FOREIGN KEY (sala_atual)
    REFERENCES sala (numero)
    ON DELETE CASCADE;

ALTER TABLE caminho ADD CONSTRAINT FK_camihno_3
    FOREIGN KEY (prox_sala)
    REFERENCES sala (numero)
    ON DELETE CASCADE;

```

| Versão |       Descrição        |                                                                 Autor(es)                                                                  |    Data    |
| :----: | :--------------------: | :----------------------------------------------------------------------------------------------------------------------------------------: | :--------: |
|  1.0   |        Criação         |                           [Bruno Cruz](https://github.com/Brunocrzz) e [Breno Yuri](https://github.com/YuriBre)                            | 08/01/2025 |
|  1.1   | Inserção de informação |                                                [José Oliveira](https://github.com/Jose1277)                                                | 13/01/2025 |
|  1.2   |       Alterações       |                                             [Anne de Capdeville](https://github.com/nanecapde)                                             | 13/01/2025 |
|  1.3   |       Alterações       |                                                [José Oliveira](https://github.com/jose1277)                                                | 31/01/2025 |
|  2.0   |       Alterações       |                                                 [Pablo Cunha](https://github.com/pabloo8)                                                  | 02/02/2025 |
|  3.0   |       DDL final        | [Anne de Capdeville](https://github.com/nanecapde), [Bruno Cruz](https://github.com/Brunocrzz) e [Pablo Cunha](https://github.com/pabloo8) | 02/02/2025 |
