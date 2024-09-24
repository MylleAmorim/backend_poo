CREATE TABLE Veiculo (
     placa VARCHAR(7) PRIMARY KEY,
     marca VARCHAR(50) NOT NULL,
     modelo VARCHAR(50) NOT NULL,
     ano INT,
     categoria VARCHAR(30),
     descricao TEXT,
     preco DECIMAL(10, 2) NOT NULL
);