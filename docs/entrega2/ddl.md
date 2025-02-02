# DDL - Data Definition Language

Linguagem de definição de dados: São comandos que interagem com objetos dentro de um banco de dados (views, functions, procedures, sendo as tabelas os mais comuns). Os comandos DDL permitem que a gente interaja com esses objetos. As principais formas de interagir com esses objetos é por meio dos comandos:

- **CREATE**: Cria um novo objeto.
- **ALTER**: Altera um objeto existente.
- **DROP**: Exclui um objeto, como uma tabela ou banco de dados.

### CREATE

```sql
CREATE TABLE sala (
    numero int PRIMARY KEY,
    nome varchar(30),
    nome_mapa varchar(30)
);

CREATE TABLE mercado (
    fk_sala_numero int,
    fk_protagonista_fk_entidade_identidade int
);

CREATE TABLE entidade (
    identidade int auto_increment PRIMARY KEY,
    vida int,
    dano int
);

CREATE TABLE protagonista (
    id_entidade int PRIMARY KEY,
    nickname varchar(25),
    killcount int,
    dinheirorecebido int,
    fk_sala_numero int
);

CREATE TABLE npc (
    nome varchar(20),
    tipo enum('chefe', 'vendedor', 'zumbi', 'plaga', 'cachorro_zumbi'),
    id_entidade int PRIMARY KEY
);

CREATE TABLE item (
    iditem int auto_increment PRIMARY KEY,
    nome varchar(30),
    descricao varchar(150),
    valor int,
    peso int,
    tipo enum('arma','consumivel','equipamento','dinheiro')
);

CREATE TABLE inventario (
    idinventario int auto_increment PRIMARY KEY,
    pesomax int,
    id_entidade int,
    id_instancianpc int
);

CREATE TABLE arma (
    nome varchar(50),
    dano int,
    nivel int,
    chanceerro int,
    chancecritico int,
    maxmuni int,
    id_item int PRIMARY KEY
);

CREATE TABLE missao (
    nome varchar(30) PRIMARY KEY,
    multiplicador int,
    completa bool,
    tipo enum('assassinato','recuperacao','dupla'),
    missao_TIPO INT,
    nome_mapa varchar(30),
    descricao varchar(150)
);

CREATE TABLE equipamento (
    defesa int,
    nivel int,
    id_item int PRIMARY KEY
);

CREATE TABLE instancianpc (
    idinstancianpc int auto_increment PRIMARY KEY,
    id_entidadenpc int,
    fk_sala_numero int,
    missao_nome varchar(30),
    id_protagonista int
);

CREATE TABLE zumbi (
    id_entidade int PRIMARY KEY
);

CREATE TABLE cachorro_zumbi (
    id_entidade int PRIMARY KEY
);

CREATE TABLE plaga (
    id_entidade int PRIMARY KEY
);

CREATE TABLE consumivel (
    efeito varchar(50),
    id_item int PRIMARY KEY
);

CREATE TABLE instanciaitem (
    idinstanciaitem int auto_increment PRIMARY KEY,
    id_item int,
    id_inventaro int,
    nome_missao varchar(30)
);

CREATE TABLE dinheiro (
    valor int,
    id_item int PRIMARY KEY
);

CREATE TABLE mapa (
    nome varchar(30) PRIMARY KEY
);

CREATE TABLE vendedor (
    id_entidade int PRIMARY KEY
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
    id_entidade int PRIMARY KEY
);

CREATE TABLE usa (
    id_entidade int PRIMARY KEY,
    nome_habilidade varchar(50),
    nivel int,
    ultimo_uso DATETIME
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
    FOREIGN KEY (id_entidade)
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

ALTER TABLE missao ADD CONSTRAINT FK_missao_2
    FOREIGN KEY (nome_mapa)
    REFERENCES mapa (nome)
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
    FOREIGN KEY (id_inventaro)
    REFERENCES inventario (idinventario)
    ON DELETE SET NULL;

ALTER TABLE instanciaitem ADD CONSTRAINT FK_instanciaitem_3
    FOREIGN KEY (nome_missao, nome_missao)
    REFERENCES missao (nome, nome)
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

```

| Versão |       Descrição        |                                       Autor(es)                                       |    Data    |
| :----: | :--------------------: | :-----------------------------------------------------------------------------------: | :--------: |
|  1.0   |        Criação         | [Bruno Cruz](https://github.com/Brunocrzz) e [Breno Yuri](https://github.com/YuriBre) | 08/01/2025 |
|  1.1   | Inserção de informação |                     [José Oliveira](https://github.com/Jose1277)                      | 13/01/2025 |
|  1.2   |       Alterações       |                  [Anne de Capdeville](https://github.com/nanecapde)                   | 13/01/2025 |
|  1.3   |       Alterações       |                     [José Oliveira](https://github.com/jose1277)                      | 31/01/2025 |
