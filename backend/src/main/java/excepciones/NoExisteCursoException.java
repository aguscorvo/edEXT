package excepciones;

public class NoExisteCursoException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NoExisteCursoException(String string) {
        super(string);
    }

}
