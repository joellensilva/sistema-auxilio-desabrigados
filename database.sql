CREATE TABLE centros_distribuicao (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    endereco VARCHAR(100) NOT NULL
);

CREATE TABLE tipos_itens (
    id SERIAL PRIMARY KEY,
    tipo VARCHAR(50) NOT NULL
);

CREATE TABLE itens (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(255) NOT NULL,
    quantidade INT,
    tipo_id INT NOT NULL,
    centro_id INT NOT NULL,
    FOREIGN KEY (tipo_id) REFERENCES tipos_itens(id),
    FOREIGN KEY (centro_id) REFERENCES centros_distribuicao(id)
    -- PRIMARY KEY(id, centro_id)
);

CREATE TABLE roupas (
    item_id INT PRIMARY KEY,
    genero VARCHAR(1),
    tamanho VARCHAR(2),
    -- PRIMARY KEY(item_id, centro_id),
    FOREIGN KEY (item_id) REFERENCES itens(id)
);

CREATE TABLE alimentos (
    item_id INT PRIMARY KEY,
    unidade_medida VARCHAR(10),
    validade DATE,
    -- PRIMARY KEY(item_id, centro_id),
    FOREIGN KEY (item_id) REFERENCES itens(id)
);

INSERT INTO centros_distribuicao (nome, endereco) VALUES 
('Centro de Distribuição Esperança', 'Av. Boqueirão, 2450 - Igara, Canoas - RS, 92032-420'),
('Centro de Distribuição Prosperidade', 'Av. Borges de Medeiros, 1501 – Cidade Baixa, Porto Alegre - RS, 90119-900'),
('Centro de Distribuição Reconstrução', 'R. Dr. Décio Martins Costa, 312 - Vila Eunice Nova, Cachoeirinha - RS, 94920-170');

INSERT INTO tipos_itens (tipo) VALUES ('Alimento'), ('Produto de Higiene'), ('Roupa'); 
