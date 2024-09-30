CREATE TABLE venda (
       id SERIAL PRIMARY KEY,
       veiculo_placa VARCHAR(7) NOT NULL,
       vendedor_cpf VARCHAR(14) NOT NULL,
       cliente_cpf VARCHAR(14) NOT NULL,
       data_venda VARCHAR(10) NOT NULL,
       FOREIGN KEY (veiculo_placa) REFERENCES Veiculo(placa),
       FOREIGN KEY (vendedor_cpf) REFERENCES Vendedor(cpf),
       FOREIGN KEY (cliente_cpf) REFERENCES Cliente(cpf)
);