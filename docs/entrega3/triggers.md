# Triggers e Stored Procedures

## Introdução

De acordo com Silberschatz et al., os triggers são uma ferramenta importante em bancos de dados, permitindo a execução automática de ações em resposta a eventos, como inserções, atualizações ou exclusões. Esses gatilhos são úteis para garantir integridade referencial, além de automatizar tarefas como o controle de estoque ou o monitoramento de alterações em dados críticos. Funções, por outro lado, oferecem uma maneira de encapsular lógicas complexas em operações reutilizáveis, frequentemente integradas diretamente na execução das consultas SQL, aumentando a flexibilidade e a eficiência dos SGBDs modernos .

## Stored Procedures

```
CREATE PROCEDURE inserirProtagonista(IN nickname VARCHAR(255))
BEGIN
    INSERT INTO entidade (vida, dano) VALUES (100, 10);

    SET @id_entidade = LAST_INSERT_ID();

    INSERT INTO protagonista (id_entidade, nickname, killcount, dinheirorecebido)
    VALUES (@id_entidade, nickname, 0, 0);
END;


```

| Versão | Descrição |                 Autor(es)                  |    Data    |
| :----: | :-------: | :----------------------------------------: | :--------: |
|  1.0   |  Criação  | [Bruno Cruz](https://github.com/Brunocrzz) | 08/01/2025 |