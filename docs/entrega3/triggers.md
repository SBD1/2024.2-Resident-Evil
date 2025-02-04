# Triggers e Stored Procedures

## Introdução

De acordo com Silberschatz et al., os triggers são uma ferramenta importante em bancos de dados, permitindo a execução automática de ações em resposta a eventos, como inserções, atualizações ou exclusões. Esses gatilhos são úteis para garantir integridade referencial, além de automatizar tarefas como o controle de estoque ou o monitoramento de alterações em dados críticos. Funções, por outro lado, oferecem uma maneira de encapsular lógicas complexas em operações reutilizáveis, frequentemente integradas diretamente na execução das consultas SQL, aumentando a flexibilidade e a eficiência dos SGBDs modernos .

## Stored Procedures

```
DELIMITER $$

CREATE TRIGGER check_exclusividade_entidade
BEFORE INSERT ON entidade
FOR EACH ROW
BEGIN
    DECLARE count_tipo INT;
    IF NEW.tipo = 'npc' THEN
        SELECT COUNT(*) INTO count_tipo FROM entidade WHERE tipo = 'protagonista' 
                        AND identidade = NEW.identidade;
        IF count_tipo > 0 THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Entidade não pode ser um NPC 
                            e um Protagonista ao mesmo tempo';
        END IF;
    END IF;
    IF NEW.tipo = 'protagonista' THEN
        SELECT COUNT(*) INTO count_tipo FROM entidade WHERE tipo = 'npc' 
        AND identidade = NEW.identidade;
        IF count_tipo > 0 THEN
            SIGNAL SQLSTATE '45000'
            SET MESSAGE_TEXT = 'Entidade não pode ser um Protagonista 
                                            e um NPC ao mesmo tempo';
        END IF;
    END IF;
END$$


CREATE TRIGGER check_npc_tipo
BEFORE INSERT ON npc
FOR EACH ROW
BEGIN
    DECLARE count_tipos INT;
    SELECT COUNT(*) INTO count_tipos FROM (
        SELECT id_entidade FROM zumbi WHERE id_entidade = NEW.id_entidade
        UNION ALL
        SELECT id_entidade FROM chefe WHERE id_entidade = NEW.id_entidade
        UNION ALL
        SELECT id_entidade FROM cachorro_zumbi WHERE id_entidade = NEW.id_entidade
	UNION ALL
        SELECT id_entidade FROM plaga WHERE id_entidade = NEW.id_entidade
	UNION ALL
        SELECT id_entidade FROM vendedor WHERE id_entidade = NEW.id_entidade
    ) AS subclasses;
    IF  count_tipos = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cada NPC deve ser pelo menos de um tipo 
                    (zumbi, chefe, cachorro_zumbi,plaga,vendedor)';
    END IF;
END$$


CREATE TRIGGER check_item_tipo
BEFORE INSERT ON item
FOR EACH ROW
BEGIN
    DECLARE count_tipos INT;
    SELECT COUNT(*) INTO count_tipos FROM (
        SELECT id_item FROM equipamento WHERE id_item = NEW.id_item
        UNION ALL
        SELECT id_item FROM arma WHERE id_item = NEW.id_item
        UNION ALL
        SELECT id_item FROM consumivel WHERE id_item = NEW.id_item
        UNION ALL
        SELECT id_item FROM dinheiro WHERE id_item = NEW.id_item
    ) AS subclasses;
    IF  count_tipos = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cada item deve pertencer a pelo menos um tipo 
                            (equipamento, arma, consumível ou dinheiro)';
    END IF;
END$$


CREATE TRIGGER check_missao_tipo
BEFORE INSERT ON missao
FOR EACH ROW
BEGIN
    DECLARE count_tipos INT;
    SELECT COUNT(*) INTO count_tipos FROM (
        SELECT nome FROM assassinato WHERE nome = NEW.nome
        UNION ALL
        SELECT nome FROM recuperacao WHERE nome = NEW.nome
    ) AS subclasses;
    IF  count_tipos = 0 THEN
        SIGNAL SQLSTATE '45000'
        SET MESSAGE_TEXT = 'Cada missão deve pertencer a pelo menos um 
                                    tipo (assassinato ou recuperação)';
    END IF;
END$$


CREATE TRIGGER check_vida_protagonista
BEFORE UPDATE ON protagonista
FOR EACH ROW
BEGIN
    IF NEW.vida > 100 THEN
        SET NEW.vida = 100;
    END IF;
END$$



CREATE PROCEDURE combateTurno(
    IN p_id_protagonista INT,
    IN p_id_inimigo INT,
    IN p_enemyType VARCHAR(20)
)
BEGIN
    DECLARE p_baseDamage INT DEFAULT 0;
    DECLARE p_life INT DEFAULT 0;
    DECLARE e_baseDamage INT DEFAULT 0;
    DECLARE e_life INT DEFAULT 0;
    DECLARE p_totalAttack INT DEFAULT 0;
    DECLARE e_totalAttack INT DEFAULT 0;
    DECLARE effectiveDamage INT DEFAULT 0;
    DECLARE round INT DEFAULT 1;
    
    SELECT dano, vida INTO p_baseDamage, p_life
    FROM protagonista
    WHERE id_entidade = p_id_protagonista;
    
    SET p_totalAttack = p_baseDamage; 
    
    IF p_enemyType = 'vendedor' THEN
        SELECT dano, vida INTO e_baseDamage, e_life
        FROM vendedor
        WHERE id_entidade = p_id_inimigo;
    ELSEIF p_enemyType = 'chefe' THEN
        SELECT dano, vida INTO e_baseDamage, e_life
        FROM chefe
        WHERE id_entidade = p_id_inimigo;
    ELSEIF p_enemyType = 'zumbi' THEN
        SELECT dano, vida INTO e_baseDamage, e_life
        FROM zumbi
        WHERE id_entidade = p_id_inimigo;
    ELSEIF p_enemyType = 'cachorro_zumbi' THEN
        SELECT dano, vida INTO e_baseDamage, e_life
        FROM cachorro_zumbi
        WHERE id_entidade = p_id_inimigo;
    ELSEIF p_enemyType = 'plaga' THEN
        SELECT dano, vida INTO e_baseDamage, e_life
        FROM plaga
        WHERE id_entidade = p_id_inimigo;
    ELSE
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Tipo de inimigo inválido';
    END IF;
    
    SET e_totalAttack = e_baseDamage; 
    
    combat_loop: WHILE p_life > 0 AND e_life > 0 DO
        SET effectiveDamage = p_totalAttack;
        SET e_life = e_life - effectiveDamage;
        IF e_life < 0 THEN SET e_life = 0; END IF;
        
        IF p_enemyType = 'vendedor' THEN
            UPDATE vendedor SET vida = e_life WHERE id_entidade = p_id_inimigo;
        ELSEIF p_enemyType = 'chefe' THEN
            UPDATE chefe SET vida = e_life WHERE id_entidade = p_id_inimigo;
        ELSEIF p_enemyType = 'zumbi' THEN
            UPDATE zumbi SET vida = e_life WHERE id_entidade = p_id_inimigo;
        ELSEIF p_enemyType = 'cachorro_zumbi' THEN
            UPDATE cachorro_zumbi SET vida = e_life WHERE id_entidade = p_id_inimigo;
        ELSEIF p_enemyType = 'plaga' THEN
            UPDATE plaga SET vida = e_life WHERE id_entidade = p_id_inimigo;
        END IF;
        
        IF e_life = 0 THEN
            UPDATE protagonista SET killcount = killcount + 1
            WHERE id_entidade = p_id_protagonista;
            DELETE FROM npc WHERE id_entidade = p_id_inimigo;
            LEAVE combat_loop;
        END IF;
       
        SET effectiveDamage = e_totalAttack; 
        SET p_life = p_life - effectiveDamage;
        IF p_life < 0 THEN SET p_life = 0; END IF;
        
        UPDATE protagonista SET vida = p_life WHERE id_entidade = p_id_protagonista;
        
        IF p_life = 0 THEN
            LEAVE combat_loop;
        END IF;
        
        SET round = round + 1;
    END WHILE;
    
    IF e_life = 0 THEN
        SELECT CONCAT('Combate encerrado. Protagonista venceu em ', round, ' turno(s).') AS Resultado;
    ELSEIF p_life = 0 THEN
        SELECT CONCAT('Combate encerrado. Protagonista foi derrotado em ', round, ' turno(s).') AS Resultado;
    END IF;
END$$


CREATE PROCEDURE inserirProtagonista(IN pNickname VARCHAR(25))
BEGIN
    INSERT INTO entidade (vida, dano) VALUES (100, 10);
    SET @id_ent = LAST_INSERT_ID();
    
    INSERT INTO protagonista (id_entidade, nickname, killcount, dinheirorecebido, fk_sala_numero)
    VALUES (@id_ent, pNickname, 0, 0, 1);
END$$


CREATE PROCEDURE resetarVidaBoss(
    IN p_idInstancia INT
)
BEGIN
    DECLARE p_idEnt INT;
    DECLARE p_tipo VARCHAR(20);
    DECLARE p_vidaMax INT DEFAULT 0;
    
    -- Obtém o id_entidadenpc e o tipo do NPC para a instância informada
    SELECT i.id_entidadenpc, n.tipo
      INTO p_idEnt, p_tipo
      FROM instancianpc i
      JOIN npc n ON i.id_entidadenpc = n.id_entidade
      WHERE i.idinstancianpc = p_idInstancia;
      
    -- Verifica se o tipo é de boss ("chefe") e obtém a vida máxima da tabela chefe
    IF p_tipo = 'chefe' THEN
        SELECT vida INTO p_vidaMax FROM chefe WHERE id_entidade = p_idEnt;
    ELSE
        SIGNAL SQLSTATE '45000' 
            SET MESSAGE_TEXT = 'O tipo do NPC não é chefe.';
    END IF;
    
    -- Atualiza a instância do boss com o valor máximo de vida
    UPDATE instancianpc
       SET vida_atual = p_vidaMax
     WHERE idinstancianpc = p_idInstancia;
     
    SELECT CONCAT('Vida do boss (instância ', p_idInstancia, ') resetada para ', p_vidaMax) AS Resultado;
END $$

DELIMITER ;
```



| Versão |    Descrição    |                 Autor(es)                  |    Data    |
| :----: | :-------------: | :----------------------------------------: | :--------: |
|  1.0   |     Criação     | [Bruno Cruz](https://github.com/Brunocrzz) | 03/02/2025 |
|  2.0   | Alteração Final | [Bruno Cruz](https://github.com/Brunocrzz) | 03/02/2025 |