# DDL - Data Definition Language

Linguagem de definição de dados: São comandos que interagem com objetos dentro de um banco de dados (views, functions, procedures, sendo as tabelas os mais comuns). Os comandos DDL permitem que a gente interaja com esses objetos. As principais formas de interagir com esses objetos é por meio dos comandos:

+ **CREATE**: Cria um novo objeto.
+ **ALTER**: Altera um objeto existente.
+ **DROP**: Exclui um objeto, como uma tabela ou banco de dados.

### CREATE

```sql

CREATE TABLE sala (
    idsala INT auto_increment,
    nome VARCHAR(30),
    nome_mapa VARCHAR(30)
);

CREATE TABLE entidade (
    identidade INT auto_increment,
    vida INT,
    dano INT,
    id_sala INT
);

CREATE TABLE protagonista (
    id_entidade INT,
    nickname VARCHAR(25),
    killcount INT,
    dinheirorecebido INT
);

CREATE TABLE npc (
    id_entidade INT,
    nome VARCHAR(25),
    tipo ENUM('hostil', 'pacifico')
);

CREATE TABLE mapa (
    nome VARCHAR(30)
);

CREATE TABLE item (
    iditem INT auto_increment,
    nome VARCHAR(20),
    descricao VARCHAR(255),
    valor INT,
    peso INT,
    tipo VARCHAR(20)
);

CREATE TABLE inventario (
    idinventario INT auto_increment,
    pesomax INT,
    id_entidade INT,
    id_mercado INT
);

CREATE TABLE arma (
    nome VARCHAR(20),
    dano INT,
    nivel INT,
    chanceacerto DECIMAL(4,2),
    chanceerro DECIMAL(4,2),
    chancecritico DECIMAL(4,2),
    maxmuni INT
);

CREATE TABLE missao (
    nome VARCHAR(30),
    multiplicador INT,
    completa BOOLEAN,
    nome_mapa VARCHAR(30),
    id_protagonista INT
);

CREATE TABLE instanciaNPC (
    idinstancianpc INT auto_increment,
    id_entidade INT
);

CREATE TABLE Zumbi (
    id_instanciaNPC INT
);

CREATE TABLE Cachorro_Zumbi (
    id_instanciaNPC INT
);

CREATE TABLE Plaga (
    id_instanciaNPC INT
);

CREATE TABLE mercado (
    id_sala INT,
    id_entidade INT
);

CREATE TABLE possui (
    id_inventario INT,
    id_item INT,
    quantidade INT
);

CREATE TABLE esta_item (
    id_item INT,
    id_sala INT
);

CREATE TABLE usa_arma (
    nome_arma VARCHAR(20),
    id_entidade INT,
    PRIMARY KEY (nome_arma, id_entidade)
);

CREATE TABLE recompensa (
    nome_missao VARCHAR(30),
    id_item INT
);

CREATE TABLE esta_npc (
    id_instanciaNPC INT,
    id_sala INT,
    PRIMARY KEY (id_instanciaNPC, id_sala)
);

```
### ALTER

```sql
ALTER TABLE sala
  ADD PRIMARY KEY (idsala);

ALTER TABLE entidade
  ADD PRIMARY KEY (identidade);

ALTER TABLE protagonista
  ADD PRIMARY KEY (id_entidade);

ALTER TABLE npc
  ADD PRIMARY KEY (id_entidade);

ALTER TABLE mapa
  ADD PRIMARY KEY (nome);

ALTER TABLE item
  ADD PRIMARY KEY (iditem);

ALTER TABLE inventario
  ADD PRIMARY KEY (idinventario);

ALTER TABLE arma
  ADD PRIMARY KEY (nome);

ALTER TABLE missao
  ADD PRIMARY KEY (nome);

ALTER TABLE instanciaNPC
  ADD PRIMARY KEY (idinstancianpc);

ALTER TABLE Zumbi
  ADD PRIMARY KEY (id_instanciaNPC);

ALTER TABLE Cachorro_Zumbi
  ADD PRIMARY KEY (id_instanciaNPC);

ALTER TABLE Plaga
  ADD PRIMARY KEY (id_instanciaNPC);

ALTER TABLE mercado
  ADD PRIMARY KEY (id_entidade);

ALTER TABLE possui
  ADD PRIMARY KEY (id_inventario, id_item);

ALTER TABLE esta_item
  ADD PRIMARY KEY (id_item, id_sala);

ALTER TABLE entidade
  ADD CONSTRAINT fk_entidade_sala
      FOREIGN KEY (id_sala)
      REFERENCES sala (idsala);

ALTER TABLE protagonista
  ADD CONSTRAINT fk_protagonista_entidade
      FOREIGN KEY (id_entidade)
      REFERENCES entidade (identidade);

ALTER TABLE npc
  ADD CONSTRAINT fk_npc_entidade
      FOREIGN KEY (id_entidade)
      REFERENCES entidade (identidade);

ALTER TABLE missao
  ADD CONSTRAINT fk_missao_protagonista
      FOREIGN KEY (id_protagonista)
      REFERENCES protagonista (id_entidade);

ALTER TABLE missao
  ADD CONSTRAINT fk_missao_mapa
      FOREIGN KEY (nome_mapa)
      REFERENCES mapa (nome);

ALTER TABLE inventario
  ADD CONSTRAINT fk_inventario_entidade
      FOREIGN KEY (id_entidade)
      REFERENCES entidade (identidade);

ALTER TABLE instanciaNPC
  ADD CONSTRAINT fk_instanciaNPC_entidade
      FOREIGN KEY (id_entidade)
      REFERENCES entidade (identidade);

ALTER TABLE Zumbi
  ADD CONSTRAINT fk_zumbi_instanciaNPC
      FOREIGN KEY (id_instanciaNPC)
      REFERENCES instanciaNPC (idinstancianpc);

ALTER TABLE Plaga
  ADD CONSTRAINT fk_plaga_instanciaNPC
      FOREIGN KEY (id_instanciaNPC)
      REFERENCES instanciaNPC (idinstancianpc);

ALTER TABLE Cachorro_Zumbi
  ADD CONSTRAINT fk_cachorro_zumbi_instanciaNPC
      FOREIGN KEY (id_instanciaNPC)
      REFERENCES instanciaNPC (idinstancianpc);

ALTER TABLE mercado
  ADD CONSTRAINT fk_mercado_sala
      FOREIGN KEY (id_sala)
      REFERENCES sala (idsala);

ALTER TABLE mercado
  ADD CONSTRAINT fk_mercado_entidade
      FOREIGN KEY (id_entidade)
      REFERENCES entidade (identidade);

ALTER TABLE possui
  ADD CONSTRAINT fk_possui_inventario
      FOREIGN KEY (id_inventario)
      REFERENCES inventario (idinventario);

ALTER TABLE possui
  ADD CONSTRAINT fk_possui_item
      FOREIGN KEY (id_item)
      REFERENCES item (iditem);

ALTER TABLE esta_item
  ADD CONSTRAINT fk_esta_item_item
      FOREIGN KEY (id_item)
      REFERENCES item (iditem);

ALTER TABLE esta_item
  ADD CONSTRAINT fk_esta_item_sala
      FOREIGN KEY (id_sala)
      REFERENCES sala (idsala);

ALTER TABLE usa_arma
  ADD CONSTRAINT fk_usa_arma_arma
      FOREIGN KEY (nome_arma)
      REFERENCES arma (nome);

ALTER TABLE usa_arma
  ADD CONSTRAINT fk_usa_arma_entidade
      FOREIGN KEY (id_entidade)
      REFERENCES entidade (identidade);

ALTER TABLE recompensa
  ADD CONSTRAINT fk_recompensa_missao
      FOREIGN KEY (nome_missao)
      REFERENCES missao (nome);

ALTER TABLE recompensa
  ADD CONSTRAINT fk_recompensa_item
      FOREIGN KEY (id_item)
      REFERENCES item (iditem);

ALTER TABLE esta_npc
  ADD CONSTRAINT fk_esta_npc_instanciaNPC
      FOREIGN KEY (id_instanciaNPC)
      REFERENCES instanciaNPC (idinstancianpc);

ALTER TABLE esta_npc
  ADD CONSTRAINT fk_esta_npc_sala
      FOREIGN KEY (id_sala)
      REFERENCES sala (idsala);
```

| Versão |     Descrição      |                     Autor(es)                     |    Data    |
| :----: | :----------------: | :-----------------------------------------------: | :--------: |
|  1.0   | Criação | [Bruno Cruz](https://github.com/Brunocrzz) | 08/01/2025 |
|  1.1   | Inserção de informação | [José Oliveira](https://github.com/Jose1277) | 13/01/2025 |
|  1.2   | Alterações | [Anne de Capdeville](https://github.com/nanecapde) | 13/01/2025 |
