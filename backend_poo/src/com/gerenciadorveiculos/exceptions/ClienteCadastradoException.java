package src.com.gerenciadorveiculos.exceptions;

public class ClienteCadastradoException extends Exception {
    public ClienteCadastradoException() {
        super("Cliente já cadastrado");
    }
}
