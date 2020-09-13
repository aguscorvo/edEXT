package excepciones;

public class CorreoRepetidoException extends Exception{

	private static final long serialVersionUID = 1L;

	public CorreoRepetidoException(String string) {
        super(string);
    }

}
