package com.gerenciadorveiculos.exceptions;

public class VendedorCadastradoException extends Exception {
    public VendedorCadastradoException() {
        super("Vendedor já cadastrado");
    }
}
