# Modelo Entidade-Relacionamento (ME-R)

## Entidades e Atributos

### Entidade
- <u>id</u> (PK)
- dano
- vida

### Sala
- <u>nome</u> (PK)

### Protagonista
- <u>nickname</u> (PK)

### NPC
- <u>nome</u> (PK)
- tipo

### Arma
- <u>nome</u> (PK)
- dano
- velocidade
- nivel
- maxmuni
- temporecarga

### Inventário
- <u>id</u> (PK)

### Item
- <u>id</u> (PK)
- nome
- descricao
- valor
- tipo

### Missão
- <u>id</u> (PK)
- multiplicador

### Mapa
- <u>nome</u> (PK) 

## Relacionamentos

### Está
- Entidade está na Sala
- Entidade ↔ Sala
- Cardinalidade: (0,N) ↔ (1,1)

### Possui
- Entidade possui Inventário
- Entidade ↔ Inventário
- Cardinalidade: (1,1) ↔ (1,1)

### Faz
- Protagonista faz Missão
- Protagonista ↔ Missão
- Cardinalidade: (0,1) ↔ (0,N)

### Recompensa
- Missão oferece Recompensa (Item)
- Missão ↔ Item
- Cardinalidade: (0,N) ↔ (1,N)

### Possui
- Inventário possui Item
- Inventário ↔ Item
- Cardinalidade: (0,N) ↔ (1,N)

### Possui
- Protagonista possui Arma
- Protagonista ↔ Arma
- Cardinalidade: (1,N) ↔ (1,N)

### Está
- Protagonista está na Sala
- Protagonista ↔ Sala
- Cardinalidade: (0,N) ↔ (1,1)

### Está
- NPC está na Sala
- NPC ↔ Sala
- Cardinalidade: (0,N) ↔ (1,1)

### Possui
- Sala possui Mapa
- Sala ↔ Mapa
- Cardinalidade: (1,1) ↔ (1,1)


## Histórico de Versão
 | Versão |     Descrição      |                     Autor(es)                     |    Data    |
| :----: | :----------------: | :-----------------------------------------------: | :--------: |
|  1.0   | Criação | [Breno Yuri](https://github.com/YuriBre) | 24/11/2024 |