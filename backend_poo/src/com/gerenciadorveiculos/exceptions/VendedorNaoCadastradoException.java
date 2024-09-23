package src.com.gerenciadorveiculos.exceptions;

public class VendedorNaoCadastradoException extends Exception {
    public VendedorNaoCadastradoException() {
        super("Vendedor não cadastrado");
    }
}
