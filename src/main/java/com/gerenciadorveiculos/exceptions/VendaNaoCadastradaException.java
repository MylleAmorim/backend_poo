package com.gerenciadorveiculos.exceptions;

public class VendaNaoCadastradaException extends Exception {
    public VendaNaoCadastradaException() {
        super("Venda não cadastrada");
    }
}
