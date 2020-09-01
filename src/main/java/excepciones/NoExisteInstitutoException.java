package excepciones;

public class NoExisteInstitutoException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NoExisteInstitutoException(String string) {
        super(string);
    }

}
