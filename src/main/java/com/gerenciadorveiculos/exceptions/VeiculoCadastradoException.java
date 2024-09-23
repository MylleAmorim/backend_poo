package com.gerenciadorveiculos.exceptions;

public class VeiculoCadastradoException extends Exception {
    public VeiculoCadastradoException() {
        super("Veículo já cadastrado");
    }
}
