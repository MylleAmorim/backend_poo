package com.gerenciadorveiculos.exceptions;

public class VeiculoNaoCadastradoException extends Exception {
    public VeiculoNaoCadastradoException() {
        super("Veículo não cadastrado");
    }
}
