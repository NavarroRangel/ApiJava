-- Conteúdo para o arquivo V2__create_table_cadastro.sql

CREATE TABLE tb_cadastro (
                             id BIGSERIAL PRIMARY KEY,
                             nome VARCHAR(255) NOT NULL,
                             email VARCHAR(255) UNIQUE NOT NULL,
                             img_url VARCHAR(255),
                             idade INTEGER,
                             rank VARCHAR(255),
                             missoes_id BIGINT,
                             CONSTRAINT fk_missoes FOREIGN KEY (missoes_id) REFERENCES tb_missoes(id)
);