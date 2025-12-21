package exception;

public class PetInvalidoException extends RuntimeException {
    public PetInvalidoException(String mensagem) {
        super(mensagem);
    }
}