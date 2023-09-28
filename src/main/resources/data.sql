-- -----------------------------------------------------
-- Table grupo
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS grupo (
  id_grupo INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ds_grupo VARCHAR(100),
  dt_criacao TIMESTAMP,
  fl_status TINYINT,
  fl_deleted TINYINT
);

-- -----------------------------------------------------
-- Table usuario
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS usuario (
  id_usuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ds_nome VARCHAR(45),
  dt_criacao TIMESTAMP,
  fl_status TINYINT,
  fl_deleted TINYINT,
  id_grupo INT NOT NULL,
  CONSTRAINT fk_usuario_grupo
    FOREIGN KEY (id_grupo)
    REFERENCES grupo (id_grupo)
);

-- -----------------------------------------------------
-- Table solicitacao
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS solicitacao (
  id_solicitacao INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ds_nome_cliente VARCHAR(400),
  ds_solicitacao VARCHAR(2000),
  dt_criacao TIMESTAMP,
  fl_status TINYINT,
  fl_deleted TINYINT,
  id_grupo INT NOT NULL,
  id_usuario INT,
  st_solicitacao VARCHAR(45),
  CONSTRAINT fk_solicitacao_grupo1
    FOREIGN KEY (id_grupo)
    REFERENCES grupo (id_grupo),
  CONSTRAINT fk_solicitacao_usuario1
    FOREIGN KEY (id_usuario)
    REFERENCES usuario (id_usuario)
);

-- DADOS TABELA GRUPO

INSERT INTO grupo (ds_grupo, dt_criacao, fl_status, fl_deleted)
VALUES ('ADMIN', CURRENT_TIMESTAMP, 1, 0);

INSERT INTO grupo (ds_grupo, dt_criacao, fl_status, fl_deleted)
VALUES ('CARTOES', CURRENT_TIMESTAMP, 1, 0);

INSERT INTO grupo (ds_grupo, dt_criacao, fl_status, fl_deleted)
VALUES ('EMPRESTIMOS', CURRENT_TIMESTAMP, 1, 0);

INSERT INTO grupo (ds_grupo, dt_criacao, fl_status, fl_deleted)
VALUES ('OUTROS', CURRENT_TIMESTAMP, 1, 0);

-- DADOS TABELA USUARIO

INSERT INTO usuario (ds_nome, dt_criacao, fl_status, fl_deleted, id_grupo)
VALUES ('ADMIN', CURRENT_TIMESTAMP, 1, 0, 1);

INSERT INTO usuario (ds_nome, dt_criacao, fl_status, fl_deleted, id_grupo)
VALUES ('CARTAO1', CURRENT_TIMESTAMP, 1, 0, 2);

INSERT INTO usuario (ds_nome, dt_criacao, fl_status, fl_deleted, id_grupo)
VALUES ('CARTAO2', CURRENT_TIMESTAMP, 1, 0, 2);

INSERT INTO usuario (ds_nome, dt_criacao, fl_status, fl_deleted, id_grupo)
VALUES ('EMPRESTIMO1', CURRENT_TIMESTAMP, 1, 0, 3);

INSERT INTO usuario (ds_nome, dt_criacao, fl_status, fl_deleted, id_grupo)
VALUES ('EMPRESTIMO2', CURRENT_TIMESTAMP, 1, 0, 3);

INSERT INTO usuario (ds_nome, dt_criacao, fl_status, fl_deleted, id_grupo)
VALUES ('OUTROS1', CURRENT_TIMESTAMP, 1, 0, 4);

INSERT INTO usuario (ds_nome, dt_criacao, fl_status, fl_deleted, id_grupo)
VALUES ('OUTROS2', CURRENT_TIMESTAMP, 1, 0, 4);

-- DADOS TABELA SOLICITACAO
INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente1', 'Solicitação Cartão 1', CURRENT_TIMESTAMP, 1, 0, 2, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente2', 'Solicitação Cartão 2', CURRENT_TIMESTAMP, 1, 0, 2, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente3', 'Solicitação Cartão 3', CURRENT_TIMESTAMP, 1, 0, 2, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente4', 'Solicitação Cartão 4', CURRENT_TIMESTAMP, 1, 0, 2, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente5', 'Solicitação Cartão 5', CURRENT_TIMESTAMP, 1, 0, 2, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente6', 'Solicitação Cartão 6', CURRENT_TIMESTAMP, 1, 0, 2, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente7', 'Solicitação Cartão 7', CURRENT_TIMESTAMP, 1, 0, 2, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente8', 'Solicitação Cartão 8', CURRENT_TIMESTAMP, 1, 0, 2, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente9', 'Solicitação Cartão 9', CURRENT_TIMESTAMP, 1, 0, 2, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente10', 'Solicitação Cartão 10', CURRENT_TIMESTAMP, 1, 0, 2, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente11', 'Solicitação Empréstimo 1', CURRENT_TIMESTAMP, 1, 0, 3, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente12', 'Solicitação Empréstimo 2', CURRENT_TIMESTAMP, 1, 0, 3, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente13', 'Solicitação Empréstimo 3', CURRENT_TIMESTAMP, 1, 0, 3, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente14', 'Solicitação Empréstimo 4', CURRENT_TIMESTAMP, 1, 0, 3, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente15', 'Solicitação Empréstimo 5', CURRENT_TIMESTAMP, 1, 0, 3, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente16', 'Solicitação Empréstimo 6', CURRENT_TIMESTAMP, 1, 0, 3, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente17', 'Solicitação Empréstimo 7', CURRENT_TIMESTAMP, 1, 0, 3, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente18', 'Solicitação Empréstimo 8', CURRENT_TIMESTAMP, 1, 0, 3, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente19', 'Solicitação Empréstimo 9', CURRENT_TIMESTAMP, 1, 0, 3, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente20', 'Solicitação Empréstimo 10', CURRENT_TIMESTAMP, 1, 0, 3, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente21', 'Solicitação OUTROS 1', CURRENT_TIMESTAMP, 1, 0, 4, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente22', 'Solicitação OUTROS 2', CURRENT_TIMESTAMP, 1, 0, 4, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente23', 'Solicitação OUTROS 3', CURRENT_TIMESTAMP, 1, 0, 4, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente24', 'Solicitação OUTROS 4', CURRENT_TIMESTAMP, 1, 0, 4, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente25', 'Solicitação OUTROS 5', CURRENT_TIMESTAMP, 1, 0, 4, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente26', 'Solicitação OUTROS 6', CURRENT_TIMESTAMP, 1, 0, 4, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente27', 'Solicitação OUTROS 7', CURRENT_TIMESTAMP, 1, 0, 4, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente28', 'Solicitação OUTROS 8', CURRENT_TIMESTAMP, 1, 0, 4, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente29', 'Solicitação OUTROS 9', CURRENT_TIMESTAMP, 1, 0, 4, NULL, 'OPEN');

INSERT INTO solicitacao (ds_nome_cliente, ds_solicitacao, dt_criacao, fl_status, fl_deleted, id_grupo, id_usuario, st_solicitacao)
VALUES ('Cliente30', 'Solicitação OUTROS 10', CURRENT_TIMESTAMP, 1, 0, 4, NULL, 'OPEN');
