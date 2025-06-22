-- TABELA USUÁRIO
CREATE TABLE IF NOT EXISTS usuario (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    login VARCHAR(50) UNIQUE NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL
);

-- TABELA TIPO_PESSOA
CREATE TABLE IF NOT EXISTS tipo_pessoa (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL UNIQUE,
    usuario_id INTEGER NOT NULL,
    CONSTRAINT fk_usuario_tipo_pessoa FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

-- TABELA PESSOA
CREATE TABLE IF NOT EXISTS pessoa (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    data_nascimento DATE,
    cpf VARCHAR(14) UNIQUE,
    email VARCHAR(100) UNIQUE,
    tipo_pessoa_id INT NOT NULL,
    usuario_id INTEGER NOT NULL,
    CONSTRAINT fk_tipo_pessoa FOREIGN KEY (tipo_pessoa_id) REFERENCES tipo_pessoa(id),
    CONSTRAINT fk_usuario_pessoa FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

-- TABELA TIPO_TELEFONE
CREATE TABLE IF NOT EXISTS tipo_telefone (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL UNIQUE,
    usuario_id INTEGER NOT NULL,
    CONSTRAINT fk_usuario_tipo_telefone FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

-- TABELA TELEFONE
CREATE TABLE IF NOT EXISTS telefone (
    id SERIAL PRIMARY KEY,
    numero VARCHAR(20) NOT NULL,
    pessoa_id INT NOT NULL,
    tipo_telefone_id INT NOT NULL,
    usuario_id INTEGER NOT NULL,
    CONSTRAINT fk_pessoa_telefone FOREIGN KEY (pessoa_id) REFERENCES pessoa(id) ON DELETE CASCADE,
    CONSTRAINT fk_tipo_telefone FOREIGN KEY (tipo_telefone_id) REFERENCES tipo_telefone(id),
    CONSTRAINT fk_usuario_telefone FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

-- TABELA TIPO_ENDERECO
CREATE TABLE IF NOT EXISTS tipo_endereco (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL UNIQUE,
    usuario_id INTEGER NOT NULL,
    CONSTRAINT fk_usuario_tipo_endereco FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);

-- TABELA ENDERECO
CREATE TABLE IF NOT EXISTS endereco (
    id SERIAL PRIMARY KEY,
    rua VARCHAR(150) NOT NULL,
    bairro VARCHAR(100),
    cidade VARCHAR(100),
    estado VARCHAR(50),
    cep VARCHAR(20),
    numero VARCHAR(20),
    complemento VARCHAR(100),
    pessoa_id INT NOT NULL,
    tipo_endereco_id INT NOT NULL,
    usuario_id INTEGER NOT NULL,
    CONSTRAINT fk_pessoa_endereco FOREIGN KEY (pessoa_id) REFERENCES pessoa(id) ON DELETE CASCADE,
    CONSTRAINT fk_tipo_endereco FOREIGN KEY (tipo_endereco_id) REFERENCES tipo_endereco(id),
    CONSTRAINT fk_usuario_endereco FOREIGN KEY (usuario_id) REFERENCES usuario(id)
);
