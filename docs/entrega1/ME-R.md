
# Modelo Entidade-Relacionamento (ME-R)

## Entidades e Atributos

### Entidade
- <u>identidade</u> (PK)
- velocidade
- dano
- vida

### Sala
- <u>nome</u> (PK)
- número

### Protagonista
- nickname
- killcount
- dinheirorecebido

### NPC
- nome
- tipo

### Arma
- <u>nome</u> (PK)
- dano
- velocidade
- nível
- maxmuni
- temporecarga

### Equipamento
- <u>nome</u> (PK)
- defesa
- nivel

### Inventário
- <u>idinventario</u> (PK)
- pesomax

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

### Mapa
- <u>nome</u> (PK)

## Relacionamentos

### Usa (Entidade ↔ Arma/Equipamento)
- Entidade usa Arma e Equipamento.
- Cardinalidade:
  - Entidade ↔ Arma: (0,N) ↔ (1,N)
  - Entidade ↔ Equipamento: (0,N) ↔ (0,N)

### Está (Entidade ↔ Sala)
- Entidade está em uma Sala.
- Cardinalidade: (0,N) ↔ (1,1)

### Possui (Entidade ↔ Inventário)
- Entidade possui Inventário.
- Cardinalidade: (1,1) ↔ (1,1)

### Faz (Protagonista ↔ Missão)
- Protagonista realiza Missão.
- Cardinalidade: (0,1) ↔ (0,N)

### Recompensa (Missão ↔ Item)
- Missão oferece Recompensa (Item).
- Cardinalidade: (0,N) ↔ (1,N)

### Possui (Inventário ↔ Item)
- Inventário possui Item.
- Cardinalidade: (0,N) ↔ (0,N)

### Possui (Sala ↔ Mapa)
- Sala possui Mapa.
- Cardinalidade: (1,N) ↔ (1,1)

## Histórico de Versão
 | Versão |     Descrição      |                     Autor(es)                     |    Data    |
| :----: | :----------------: | :-----------------------------------------------: | :--------: |
|  1.0   | Criação | [Breno Yuri](https://github.com/YuriBre) | 24/11/2024 |
|  2.0   | Atualizações | [Breno Yuri](https://github.com/YuriBre) | 25/11/2024 |
