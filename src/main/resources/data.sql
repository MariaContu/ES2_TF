-- Create tables
CREATE TABLE IF NOT EXISTS aplicativo (
    codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    custo_mensal FLOAT NOT NULL
);

CREATE TABLE IF NOT EXISTS cliente (
    codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL
);

CREATE TABLE IF NOT EXISTS assinatura (
    codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
    cod_app BIGINT,
    cod_cli BIGINT,
    inicio_vigencia DATE,
    fim_vigencia DATE,
    FOREIGN KEY (cod_app) REFERENCES aplicativo(codigo),
    FOREIGN KEY (cod_cli) REFERENCES cliente(codigo)
);

CREATE TABLE IF NOT EXISTS pagamento (
    codigo BIGINT AUTO_INCREMENT PRIMARY KEY,
    cod_assinatura BIGINT,
    valor_pago FLOAT,
    data_pagamento DATE,
    FOREIGN KEY (cod_assinatura) REFERENCES assinatura(codigo)
);

-- Insert Aplicativos
INSERT INTO aplicativo (nome, custo_mensal) VALUES 
('Netflix', 15.99), 
('Microsoft Office 365', 29.99),
('Fitbit Premium', 12.99),
('Spotify', 9.99),
('Coursera', 19.99);

-- Insert Clientes
INSERT INTO cliente (nome, email) VALUES 
('Alice Wonderland', 'alice.w@example.com'),
('Bob Builder', 'bob.builder@example.com'),
('Charlie Chocolate', 'charlie.choco@example.com'),
('Daisy Dream', 'daisy.dream@example.com'),
('Ethan Hunt', 'ethan.h@example.com'),
('Fiona Fly', 'fiona.fly@example.com'),
('George Green', 'george.green@example.com'),
('Hannah Hart', 'hannah.hart@example.com'),
('Ivy Ink', 'ivy.ink@example.com'),
('Jack Frost', 'jack.frost@example.com');

-- Insert Assinaturas
INSERT INTO assinatura (cod_app, cod_cli, inicio_vigencia, fim_vigencia) VALUES
((SELECT codigo FROM aplicativo WHERE nome = 'Netflix'), (SELECT codigo FROM cliente WHERE nome = 'Alice Wonderland'), CURRENT_DATE, DATEADD('MONTH', 1, CURRENT_DATE)),
((SELECT codigo FROM aplicativo WHERE nome = 'Microsoft Office 365'), (SELECT codigo FROM cliente WHERE nome = 'Bob Builder'), CURRENT_DATE, DATEADD('MONTH', 1, CURRENT_DATE)),
((SELECT codigo FROM aplicativo WHERE nome = 'Fitbit Premium'), (SELECT codigo FROM cliente WHERE nome = 'Charlie Chocolate'), CURRENT_DATE, DATEADD('MONTH', 1, CURRENT_DATE)),
((SELECT codigo FROM aplicativo WHERE nome = 'Spotify'), (SELECT codigo FROM cliente WHERE nome = 'Daisy Dream'), CURRENT_DATE, DATEADD('MONTH', 1, CURRENT_DATE)),
((SELECT codigo FROM aplicativo WHERE nome = 'Coursera'), (SELECT codigo FROM cliente WHERE nome = 'Ethan Hunt'), CURRENT_DATE, DATEADD('MONTH', 1, CURRENT_DATE)),
((SELECT codigo FROM aplicativo WHERE nome = 'Netflix'), (SELECT codigo FROM cliente WHERE nome = 'Fiona Fly'), CURRENT_DATE, DATEADD('MONTH', 1, CURRENT_DATE)),
((SELECT codigo FROM aplicativo WHERE nome = 'Microsoft Office 365'), (SELECT codigo FROM cliente WHERE nome = 'George Green'), CURRENT_DATE, DATEADD('MONTH', 1, CURRENT_DATE)),
((SELECT codigo FROM aplicativo WHERE nome = 'Fitbit Premium'), (SELECT codigo FROM cliente WHERE nome = 'Hannah Hart'), CURRENT_DATE, DATEADD('MONTH', 1, CURRENT_DATE)),
((SELECT codigo FROM aplicativo WHERE nome = 'Spotify'), (SELECT codigo FROM cliente WHERE nome = 'Ivy Ink'), CURRENT_DATE, DATEADD('MONTH', 1, CURRENT_DATE)),
((SELECT codigo FROM aplicativo WHERE nome = 'Coursera'), (SELECT codigo FROM cliente WHERE nome = 'Jack Frost'), CURRENT_DATE, DATEADD('MONTH', 1, CURRENT_DATE));

-- Insert Pagamentos
INSERT INTO pagamento (cod_assinatura, valor_pago, data_pagamento) VALUES
((SELECT codigo FROM assinatura WHERE cod_app = (SELECT codigo FROM aplicativo WHERE nome = 'Netflix') AND cod_cli = (SELECT codigo FROM cliente WHERE nome = 'Alice Wonderland')), 15.99, CURRENT_DATE),
((SELECT codigo FROM assinatura WHERE cod_app = (SELECT codigo FROM aplicativo WHERE nome = 'Microsoft Office 365') AND cod_cli = (SELECT codigo FROM cliente WHERE nome = 'Bob Builder')), 29.99, CURRENT_DATE),
((SELECT codigo FROM assinatura WHERE cod_app = (SELECT codigo FROM aplicativo WHERE nome = 'Fitbit Premium') AND cod_cli = (SELECT codigo FROM cliente WHERE nome = 'Charlie Chocolate')), 12.99, CURRENT_DATE),
((SELECT codigo FROM assinatura WHERE cod_app = (SELECT codigo FROM aplicativo WHERE nome = 'Spotify') AND cod_cli = (SELECT codigo FROM cliente WHERE nome = 'Daisy Dream')), 9.99, CURRENT_DATE),
((SELECT codigo FROM assinatura WHERE cod_app = (SELECT codigo FROM aplicativo WHERE nome = 'Coursera') AND cod_cli = (SELECT codigo FROM cliente WHERE nome = 'Ethan Hunt')), 19.99, CURRENT_DATE),
((SELECT codigo FROM assinatura WHERE cod_app = (SELECT codigo FROM aplicativo WHERE nome = 'Netflix') AND cod_cli = (SELECT codigo FROM cliente WHERE nome = 'Fiona Fly')), 15.99, CURRENT_DATE),
((SELECT codigo FROM assinatura WHERE cod_app = (SELECT codigo FROM aplicativo WHERE nome = 'Microsoft Office 365') AND cod_cli = (SELECT codigo FROM cliente WHERE nome = 'George Green')), 29.99, CURRENT_DATE),
((SELECT codigo FROM assinatura WHERE cod_app = (SELECT codigo FROM aplicativo WHERE nome = 'Fitbit Premium') AND cod_cli = (SELECT codigo FROM cliente WHERE nome = 'Hannah Hart')), 12.99, CURRENT_DATE),
((SELECT codigo FROM assinatura WHERE cod_app = (SELECT codigo FROM aplicativo WHERE nome = 'Spotify') AND cod_cli = (SELECT codigo FROM cliente WHERE nome = 'Ivy Ink')), 9.99, CURRENT_DATE),
((SELECT codigo FROM assinatura WHERE cod_app = (SELECT codigo FROM aplicativo WHERE nome = 'Coursera') AND cod_cli = (SELECT codigo FROM cliente WHERE nome = 'Jack Frost')), 19.99, CURRENT_DATE);