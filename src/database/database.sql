-- 1. Tabela CLIENTE
CREATE TABLE Cliente (
    idCliente INT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    senha VARCHAR(255) NOT NULL,
    endereco VARCHAR(255) NOT NULL
);

-- 2. Tabela DRONE
CREATE TABLE Drone (
    idDrone INT PRIMARY KEY AUTO_INCREMENT,
    statusBateria VARCHAR(10) NOT NULL,
    capacidadeCarga INT NOT NULL
);

-- 3. Tabela ATRIBUICAO
CREATE TABLE Atribuicao (
    idAtribuicao INT PRIMARY KEY AUTO_INCREMENT,
    idCliente INT NOT NULL,
    idDrone INT NOT NULL,
    capacidadeCarga INT,
    statusBateria VARCHAR(10),
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
    FOREIGN KEY (idDrone) REFERENCES Drone(idDrone)
);

-- 4. Tabela HISTORICO_ENTREGA
CREATE TABLE HistoricoEntrega (
    idHistorico INT PRIMARY KEY AUTO_INCREMENT,
    idCliente INT NOT NULL,
    idDrone INT NOT NULL,
    dataEntrega DATETIME DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (idCliente) REFERENCES Cliente(idCliente),
    FOREIGN KEY (idDrone) REFERENCES Drone(idDrone)
);
-- Testes
-- Inserindo clientes
INSERT INTO Cliente (nome, email, senha, endereco)
VALUES
('João Silva', 'joao@email.com', '123456', 'Rua A, 100'),
('Maria Souza', 'maria@email.com', 'abcdef', 'Rua B, 200');

-- Inserindo drones
INSERT INTO Drone (statusBateria, capacidadeCarga)
VALUES
('ALTO', 10),
('MEDIO', 5),
('BAIXO', 3);

-- Criando uma atribuição (João pega o drone 1)
INSERT INTO Atribuicao (idCliente, idDrone, capacidadeCarga, statusBateria)
VALUES
(1, 1, 10, 'ALTO');

-- Criando outra atribuição (Maria pega o drone 2)
INSERT INTO Atribuicao (idCliente, idDrone, capacidadeCarga, statusBateria)
VALUES
(2, 2, 5, 'MEDIO');

-- Registrando histórico de entrega
INSERT INTO HistoricoEntrega (idCliente, idDrone)
VALUES
(1, 1),
(2, 2);

-- ------------------------------------------------------
-- TESTES DE CONSULTA
-- ------------------------------------------------------

-- Ver todos os clientes
SELECT * FROM Cliente;

-- Ver todos os drones
SELECT * FROM Drone;

-- Ver atribuições
SELECT a.idAtribuicao, c.nome AS Cliente, d.idDrone, a.statusBateria, a.capacidadeCarga
FROM Atribuicao a
JOIN Cliente c ON a.idCliente = c.idCliente
JOIN Drone d ON a.idDrone = d.idDrone;

-- Ver histórico de entregas
SELECT h.idHistorico, c.nome AS Cliente, d.idDrone, h.dataEntrega
FROM HistoricoEntrega h
JOIN Cliente c ON h.idCliente = c.idCliente
JOIN Drone d ON h.idDrone = d.idDrone;
