package excepciones;

public class NoExisteUsuarioException extends Exception {

	private static final long serialVersionUID = 1L;

	public NoExisteUsuarioException(String string) {
		super(string);
	}	

}
