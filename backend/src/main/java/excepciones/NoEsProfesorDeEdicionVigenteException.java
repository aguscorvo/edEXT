package excepciones;

public class NoEsProfesorDeEdicionVigenteException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public NoEsProfesorDeEdicionVigenteException(String string) {
        super(string);
    }
}
