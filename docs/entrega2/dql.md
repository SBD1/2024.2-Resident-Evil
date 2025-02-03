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
SELECT nome, tipo 
FROM npc
WHERE tipo <> 'vendedor';
```

### 5. Exibir as entidades que estão em uma sala específica (ex.: sala 12):
```sql
SELECT e.identidade, e.vida, e.dano
FROM instanciaNPC i
JOIN entidade e ON i.id_entidadenpc = e.identidade
WHERE i.fk_sala_numero = 12;
```

### 6. Consultar os itens que estão no inventário específico (ex.: inventário 1):
```sql
SELECT itemi.iditem, item.nome, item.descricao, item.valor, item.peso, item.tipo
FROM instanciaitem 
JOIN item ON instanciaitem.id_item = item.iditem
JOIN inventario ON instanciaitem.id_inventario = inventario.idinventario
WHERE inventario.idinventario = 1;
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
SELECT npc.nome, npc.tipo, instanciaNPC.idinstancianpc
FROM instanciaNPC 
JOIN npc ON instanciaNPC.id_entidadenpc = npc.id_entidade
WHERE instanciaNPC.fk_sala_numero = 8;

```

### 10. Exibir todos os mercados e os itens disponíveis neles:
```sql
SELECT n.nome AS vendedor, i.nome AS item, i.descricao, i.valor, i.peso, i.tipo,
       ROW_NUMBER() OVER(PARTITION BY n.nome ORDER BY i.iditem) AS item_numero
FROM vendedor v
JOIN npc n ON v.id_entidade = n.id_entidade
JOIN inventario inv ON v.id_entidade = inv.id_instancianpc
JOIN instanciaitem ii ON inv.idinventario = ii.id_inventario
JOIN item i ON ii.id_item = i.iditem;

```

---

## Histórico de Versões

| Versão |      Descrição      |                                       Autor(es)                                       |    Data    |
| :----: | :-----------------: | :-----------------------------------------------------------------------------------: | :--------: |
|  1.0   |       Criação       | [Bruno Cruz](https://github.com/Brunocrzz) e [Breno Yuri](https://github.com/YuriBre) | 08/01/2025 |
|  2.0   | Acrescentando o DQL |                       [Breno Yuri](https://github.com/YuriBre)                        | 13/01/2025 |
|  2.1   |       Ajuste        |                      [Bruno Cruz](https://github.com/Brunocrzz)                       | 02/02/2025 |
