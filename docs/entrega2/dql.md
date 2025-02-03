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
SELECT numero, nome, nome_mapa 
FROM sala;
```

### 4. Encontrar os NPCs hostis no jogo:
```sql
SELECT n.id_entidade, n.tipo, 
       COALESCE(c.nome, z.nome, cz.nome, p.nome) AS nome_npc
FROM npc n
LEFT JOIN chefe c ON n.id_entidade = c.id_entidade
LEFT JOIN zumbi z ON n.id_entidade = z.id_entidade
LEFT JOIN cachorro_zumbi cz ON n.id_entidade = cz.id_entidade
LEFT JOIN plaga p ON n.id_entidade = p.id_entidade
WHERE n.tipo <> 'vendedor';

```

### 5. Exibir as entidades que estão em uma sala específica (ex.: sala 12):
```sql
SELECT i.idinstancianpc, i.fk_sala_numero, s.nome AS nome_sala, 
       n.id_entidade, n.tipo, 
       c.nome AS nome_chefe, z.nome AS nome_zumbi, 
       cz.nome AS nome_cachorro, p.nome AS nome_plaga
FROM instancianpc i
JOIN sala s ON i.fk_sala_numero = s.numero
JOIN npc n ON i.id_entidadenpc = n.id_entidade
LEFT JOIN chefe c ON n.id_entidade = c.id_entidade
LEFT JOIN zumbi z ON n.id_entidade = z.id_entidade
LEFT JOIN cachorro_zumbi cz ON n.id_entidade = cz.id_entidade
LEFT JOIN plaga p ON n.id_entidade = p.id_entidade
WHERE i.fk_sala_numero = 12;

```

### 6. Consultar os itens que estão no inventário específico (ex.: inventário 1):
```sql
SELECT ii.idinstanciaitem, i.iditem, i.tipo, 
       COALESCE(a.nome, e.nome, c.nome, d.nome, 'Desconhecido') AS nome_item
FROM instanciaitem ii
JOIN item i ON ii.id_item = i.iditem
LEFT JOIN arma a ON i.iditem = a.id_item
LEFT JOIN equipamento e ON i.iditem = e.id_item
LEFT JOIN consumivel c ON i.iditem = c.id_item
LEFT JOIN dinheiro d ON i.iditem = d.id_item
WHERE ii.id_inventario = 1;

```

### 7. Listar os itens e as salas em que estão disponíveis:
```sql
SELECT isala.fk_sala, s.nome AS nome_sala, i.iditem, i.tipo, 
       COALESCE(a.nome, e.nome, c.nome, d.nome) AS nome_item
FROM item_sala isala
JOIN sala s ON isala.fk_sala = s.numero
JOIN item i ON isala.id_item = i.iditem
LEFT JOIN arma a ON i.iditem = a.id_item
LEFT JOIN equipamento e ON i.iditem = e.id_item
LEFT JOIN consumivel c ON i.iditem = c.id_item
LEFT JOIN dinheiro d ON i.iditem = d.id_item;
```

### 8. Listar todas as missões e se estão completas:
```sql
SELECT a.nome, a.completa
FROM assassinato a
UNION ALL
SELECT r.nome, r.completa
FROM recuperacao r;
```

### 9. Exibir todas as salas que tem um chefe em um possível caminho:
```sql
SELECT inv.idinventario AS id_mercado, 
       COALESCE(a.nome, e.nome, c.nome, d.nome, 'Desconhecido') AS nome_item, 
       i.tipo
FROM vendedor v
JOIN instancianpc i_npc ON v.id_entidade = i_npc.id_entidadenpc
JOIN inventario inv ON i_npc.idinstancianpc = inv.id_instancianpc
JOIN instanciaitem ii ON inv.idinventario = ii.id_inventario
JOIN item i ON ii.id_item = i.iditem
LEFT JOIN arma a ON i.iditem = a.id_item
LEFT JOIN equipamento e ON i.iditem = e.id_item
LEFT JOIN consumivel c ON i.iditem = c.id_item
LEFT JOIN dinheiro d ON i.iditem = d.id_item;
```

### 10. Exibir todos os mercados e os itens disponíveis neles:
```sql
SELECT s.numero AS id_mercado, 
       COALESCE(a.nome, e.nome, c.nome, d.nome, 'Desconhecido') AS nome_item, 
       i.tipo
FROM vendedor v
JOIN instancianpc i_npc ON v.id_entidade = i_npc.id_entidadenpc
JOIN sala s ON i_npc.fk_sala_numero = s.numero
JOIN inventario inv ON i_npc.idinstancianpc = inv.id_instancianpc
JOIN instanciaitem ii ON inv.idinventario = ii.id_inventario
JOIN item i ON ii.id_item = i.iditem
LEFT JOIN arma a ON i.iditem = a.id_item
LEFT JOIN equipamento e ON i.iditem = e.id_item
LEFT JOIN consumivel c ON i.iditem = c.id_item
LEFT JOIN dinheiro d ON i.iditem = d.id_item;
```

---

## Histórico de Versões

| Versão |      Descrição      |                                            Autor(es)                                            |    Data    |
| :----: | :-----------------: | :---------------------------------------------------------------------------------------------: | :--------: |
|  1.0   |       Criação       |      [Bruno Cruz](https://github.com/Brunocrzz) e [Breno Yuri](https://github.com/YuriBre)      | 08/01/2025 |
|  2.0   | Acrescentando o DQL |                            [Breno Yuri](https://github.com/YuriBre)                             | 13/01/2025 |
|  2.1   |       Ajuste        |                           [Bruno Cruz](https://github.com/Brunocrzz)                            | 02/02/2025 |
|  3.0   |      DQL Final      | [Bruno Cruz](https://github.com/Brunocrzz) e [Anne de Capdeville](https://github.com/nanecapde) | 03/02/2025 |

