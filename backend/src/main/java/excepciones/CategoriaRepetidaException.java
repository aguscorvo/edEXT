package excepciones;

public class CategoriaRepetidaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CategoriaRepetidaException(String string) {
        super(string);
    }

}