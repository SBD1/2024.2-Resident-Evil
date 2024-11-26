
# Modelo Entidade-Relacionamento (ME-R)

## Entidades e Atributos

### Entidade
- <u>identidade</u> (PK)
- velocidade
- dano
- vida

### Sala
- <u>numero</u> (PK)
- nome

### instanciaNPC
- <u>idinstancianpc</u> (PK)

#### Herdeiros de InstanciaNPC, T.E
- **Zumbi**
- **Plaga**
- **Cachorro Zumbi**

### Protagonista (Herdeiro de entidade, T.E)
- nickname
- killcount
- dinheirorecebido

### NPC (Herdeiro de entidade, T.E)
- nome
- tipo

### Arma
- <u>nome</u> (PK)
- dano
- nivel
- maxmuni
- precisao{chanceacerto, chanceerro,chancecritico}

### Equipamento
- <u>nome</u> (PK)
- defesa
- nivel

### Equipamento
- <u>nome</u> (PK)
- defesa
- nivel

### Inventário
- <u>idinventario</u> (PK)
- pesomax

### Mercado (Herdeiro de sala, P.E)

### Item
- <u>iditem</u> (PK)
- nome
- descrição
- valor
- tipo
- peso

### Missão
- <u>nome</u> (PK)
- multiplicador
- completa

### Mapa
- <u>nome</u> (PK)

## Relacionamentos

### Usa (Entidade ↔ Arma)
- A `Entidade` usa `Arma`.
- Cardinalidade: `(0,N) ↔ (1,N)`.

### Usa (Entidade ↔ Equipamento)
- A `Entidade` usa `Equipamento`.
- Cardinalidade: `(0,N) ↔ (0,N)`.

### Está (Entidade ↔ Sala)
- A `Entidade` está em `Sala`.
- Cardinalidade: `(0,N) ↔ (1,1)`.

### Está (InstanciaNPC ↔ Sala)
- A `InstanciaNPC` está em uma `Sala`.
- Cardinalidade: `(0,N) ↔ (0,N)`.

### Possui (npc ↔ InstanciaNPC)
- A `npc` possui `InstanciaNPC`.
- Cardinalidade: `(1,1) ↔ (0,1)`.

### Possui (Entidade ↔ Inventário)
- A `Entidade` possui um `Inventário`.
- Cardinalidade: `(1,1) ↔ (1,1)`.

### Faz (Protagonista ↔ Missão)
- O `Protagonista` faz `Missão`.
- Cardinalidade: `(0,1) ↔ (0,N)`.

### Recompensa (Missão ↔ Item)
- `Missão` oferece `Recompensa`, que é um `Item`.
- Cardinalidade: `(0,N) ↔ (0,N)`.

### Possui (Inventário ↔ Item)
- O `Inventário` possui `Item`.
- Cardinalidade: `(0,N) ↔ (0,N)`.

### Contém (Mercado ↔ Item)
- O `Mercado` contém `Itens`.
- Cardinalidade: `(1,1) ↔ (1,1)`.

### Compra (Protagonista ↔ Mercado)
- O `Protagonista` pode comprar no `Mercado`.
- Cardinalidade: `(0,1) ↔ (0,N)`.

### Possui (Mapa ↔ Sala)
- `mapa` possui `sala`.
- Cardinalidade: `(1,1) ↔ (1,N`.

### Possui (Item ↔ Sala)
-  `item` está em `sala`.
- Cardinalidade: `(0,N) ↔ (0,N)`.

### Possui (Mapa ↔ Missão)
- O `mapa` possui `missão`.
- Cardinalidade: `(1,1) ↔ (0,1)`.

### Possui (Sala ↔ Mapa)
- Sala possui Mapa.
- Cardinalidade: (1,N) ↔ (1,1)

## Histórico de Versão
 | Versão |     Descrição      |                     Autor(es)                     |    Data    |
| :----: | :----------------: | :-----------------------------------------------: | :--------: |
|  1.0   | Criação | [Breno Yuri](https://github.com/YuriBre) | 24/11/2024 |
|  2.0   | Atualizações | [Breno Yuri](https://github.com/YuriBre) | 25/11/2024 |
