package com.gerenciadorveiculos.exceptions;

public class ClienteNaoCadastradoException extends Exception {
    public ClienteNaoCadastradoException() {
        super("Cliente não cadastrado");
    }
}
