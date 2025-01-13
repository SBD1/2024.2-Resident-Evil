# DML - Data Manipulation Language

Linguagem de manipulação de dados: São comandos que interagem com os dados dentro das tabelas. Os comandos DML incluem:


+ **INSERT**: Adiciona um novo dado ao banco.
+ **UPDATE**: Atualiza os valores das linhas de uma tabela.
+ **DELETE**: Exclui dados de uma tabela.

Nesse projeto, os comandos DML usados foram:

'''

INSERT INTO arma(nome, dano, nivel, chanceacerto, chanceerro, chancecritico, maxmuni)
VALUES

INSERT INTO usa_arma(fk_arma_nome, fk_entidade_identidade)
VALUES

INSERT INTO entidade(identidade, vida, dano, fk_sala_numero)
VALUES

INSERT INTO equipamento(nome, defesa, nivel)
VALUES

INSERT INTO usa_equipamento(fk_equipamento_nome, fk_entidade_identidade)
VALUES

INSERT INTO protagonista(fk_entidade_identidade, nickname, killcount, dinheirorecebido)
VALUES

INSERT INTO sala(numero, nome, fk_mapa_nome)
VALUES

INSERT INTO npc(fk_entidade_identidade, nome, tipo)
VALUES

INSERT INTO mercado(fk_sala_numero, fk_protagonista_fk_entidade_identidade)
VALUES


INSERT INTO missao(nome, multiplicador, completa, fk_mapa_nome, fk_protagonista_fk_entidade_identidade)
VALUES

INSERT INTO inventario(idinventario, pesomax, fk_entidade_identidade, fk_mercado_fk_sala_numero)
VALUES

INSERT INTO  recompensa (fk_missao_nome, fk_item_iditem)
VALUES

INSERT INTO possui (fk_inventario_idinventario, fk_item_iditem, quantidade)
VALUES

INSERT INTO item (iditem, nome, descricao, valor, peso, tipo)
VALUES

INSERT INTO mapa (nome)
VALUES

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

'''

| Versão |     Descrição      |                     Autor(es)                     |    Data    |
| :----: | :----------------: | :-----------------------------------------------: | :--------: |
|  1.0   | Criação | [Bruno Cruz](https://github.com/Brunocrzz) | 08/01/2025 |