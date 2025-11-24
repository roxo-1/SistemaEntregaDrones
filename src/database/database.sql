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
    statusBateria ENUM('ALTO','MEDIO','BAIXO') NOT NULL,
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