# Introdução

A álgebra relacional é uma linguagem formal utilizada para realizar operações sobre bancos de dados relacionais. Ela descreve as manipulações de dados por meio de um conjunto de operadores que atuam sobre relações (ou tabelas), retornando novas relações como resultado. Esses operadores formam a base para a construção de consultas em bancos de dados relacionais, sendo a estrutura fundamental para a linguagem SQL.

Entre os operadores principais da álgebra relacional, destacam-se:

- **Seleção(σ)**: Permite filtrar as linhas de uma tabela com base em condições específicas, ou seja, seleciona subconjuntos de dados que atendem a determinados critérios.
- **Projeção(π)**: Foca em selecionar colunas específicas de uma tabela, descartando as demais.
- **Junção(⨝)**: Combina duas ou mais tabelas a partir de um critério de correspondência entre suas colunas, criando uma nova tabela com as informações relacionadas.
- **Operações de conjunto (União, Diferença, Interseção)**: Permitem combinar ou comparar resultados de consultas diferentes, gerando novos conjuntos de dados.

A álgebra relacional é uma maneira precisa e matemática de expressar as operações de manipulação de dados em bancos de dados, sendo essencial para entender a lógica por trás das consultas em sistemas relacionais. Ela garante que as operações realizadas sejam eficientes e que os dados possam ser consultados e manipulados de forma estruturada e sem ambiguidade.

### 1. Listar todas as armas disponíveis no jogo e seus atributos:

```sql
σ(arma)
```

### 2. Buscar o nome das armas com dano maior que 50(exemplo):

```sql
π(nome, dano)(σ(dano > 50)(arma))

```

### 3. Listar as salas disponíveis e os mapas a que pertencem:

```sql
π(numero, nome, fk_mapa_nome)(sala)

```

### 4. Encontrar os NPCs hostis no jogo:

```sql
π(nome, tipo)(σ(tipo = 'Hostil')(npc))

```

### 5. Exibir as entidades que estão em uma sala específica (ex.: sala 12):

```sql
π(identidade, vida, dano)(σ(fk_sala_numero = 12)(entidade))

```

### 6. Consultar os itens que estão no inventário específico (ex.: inventário 1):

```sql
π(item.nome, item.descricao, possui.quantidade)
(item ⨝ possui ⨝ σ(fk_inventario_idinventario = 1)(possui))

```

### 7. Listar os itens e as salas em que estão disponíveis:

```sql
π(item.nome AS item_nome, sala.nome AS sala_nome)
(esta_item ⨝ item ⨝ sala)

```

### 8. Listar todas as missões e se estão completas:

```sql
π(nome, completa)(missao)

```

### 9. Exibir os NPCs em uma sala específica (ex.: sala 8):

```sql
π(npc.nome, sala.nome AS sala_nome)
(npc ⨝ esta_npc ⨝ sala)
σ(sala.numero = 8)(sala)

```

### 10. Exibir todos os mercados e os itens disponíveis neles:

```sql
π(mercado.fk_sala_numero AS mercado_numero, item.nome AS item_nome)
(mercado ⨝ inventario ⨝ possui ⨝ item)
```

---

## Histórico de Versões

| Versão |       Descrição        |                     Autor(es)                      |    Data    |
| :----: | :--------------------: | :------------------------------------------------: | :--------: |
|  1.0   | Criação e documentação | [Anne de Capdeville](https://github.com/nanecapde) | 13/01/2025 |
