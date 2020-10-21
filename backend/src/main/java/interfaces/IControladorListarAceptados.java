package interfaces;

import excepciones.NoEsProfesorDeEdicionVigenteException;
import excepciones.NoExisteEdicionVigenteException;

public interface IControladorListarAceptados {
	
	public String[] getInstitutos();

    public String[] ingresarInstituto(String instituto);
		
	public String ingresarCurso(String curso, String docente) throws NoExisteEdicionVigenteException, NoEsProfesorDeEdicionVigenteException;
		
	public String obtenerDatosBasicosEd();
		
	public String getEstudiantesAceptados();
	
}
