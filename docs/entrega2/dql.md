# DQL - Data Query Language

Linguagem para consulta de dados: São comandos que utilizamos para realizar consultas no banco de dados e extrair informações armazenadas.  
Na prática, o comando **SELECT** é o principal representante dessa categoria. Alguns dos principais comandos usados para a consulta são:

- **SELECT**: Seleciona dados de uma tabela.
- **FROM**: Especifica a tabela da qual se deseja selecionar dados.
- **WHERE**: Define critérios para filtrar os resultados.
- **GROUP BY**: Agrupa os resultados com base em uma ou mais colunas.
- **HAVING**: Define condições para grupos criados pelo GROUP BY.
- **ORDER BY**: Classifica os resultados em ordem crescente ou decrescente.

---

## Exemplos de Consultas DQL

### 1. Listar todas as armas disponíveis no jogo e seus atributos:
```sql
SELECT * 
FROM arma;
```

### 2. Buscar o nome das armas com dano maior que 50(exemplo):
```sql
SELECT nome, dano 
FROM arma
WHERE dano > 50;
```

### 3. Listar as salas disponíveis e os mapas a que pertencem:
```sql
SELECT numero, nome, fk_mapa_nome 
FROM sala;
```

### 4. Encontrar os NPCs hostis no jogo:
```sql
SELECT nome, tipo 
FROM npc
WHERE tipo = 'Hostil';
```

### 5. Exibir as entidades que estão em uma sala específica (ex.: sala 12):
```sql
SELECT identidade, vida, dano 
FROM entidade
WHERE fk_sala_numero = 12;
```

### 6. Consultar os itens que estão no inventário específico (ex.: inventário 1):
```sql
SELECT item.nome, item.descricao, possui.quantidade 
FROM item
JOIN possui ON item.iditem = possui.fk_item_iditem
WHERE possui.fk_inventario_idinventario = 1;
```

### 7. Listar os itens e as salas em que estão disponíveis:
```sql
SELECT item.nome AS item_nome, sala.nome AS sala_nome
FROM esta_item
JOIN item ON esta_item.fk_item_iditem = item.iditem
JOIN sala ON esta_item.fk_sala_numero = sala.numero;
```

### 8. Listar todas as missões e se estão completas:
```sql
SELECT nome, completa 
FROM missao;
```

### 9. Exibir os NPCs em uma sala específica (ex.: sala 8):
```sql
SELECT npc.nome, sala.nome AS sala_nome
FROM npc
JOIN esta_npc ON npc.fk_entidade_identidade = esta_npc.fk_instanciaNPC_idinstancianpc
JOIN sala ON esta_npc.fk_sala_numero = sala.numero
WHERE sala.numero = 8;
```

### 10. Exibir todos os mercados e os itens disponíveis neles:
```sql
SELECT mercado.fk_sala_numero AS mercado_numero, item.nome AS item_nome
FROM mercado
JOIN inventario ON mercado.fk_sala_numero = inventario.fk_mercado_fk_sala_numero
JOIN possui ON inventario.idinventario = possui.fk_inventario_idinventario
JOIN item ON possui.fk_item_iditem = item.iditem;
```

---

## Histórico de Versões

| Versão |     Descrição      |                     Autor(es)                     |    Data    |
| :----: | :----------------: | :-----------------------------------------------: | :--------: |
|  1.0   | Criação | [Bruno Cruz](https://github.com/Brunocrzz) | 08/01/2025 |
|  2.0   | Acrescentando o DQL | [Breno Yuri](https://github.com/YuriBre) | 13/01/2025 |
