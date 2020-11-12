package interfaces;
import java.util.List;

import datatype.DtEdicionExp;
import excepciones.EdicionRepetidaException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
import logica.Instituto;

public interface IControladorAltaEdicion {
	
	public List<String> ingresarInstituto(String instituto) throws NoExisteInstitutoException;	
	public void seleccionarCurso(String curso) throws NoExisteCursoException;	
	public void ingresarDtEdicion(DtEdicionExp edicion) throws EdicionRepetidaException;	
	public void confirmarAltaEdicion();	
	public void cancelarAltaEdicion();	
	public Instituto getInstituto(String nombre);
	public String[] getInstitutos();
	public String[] getCursos(Instituto nombre);	
	public String [] getCursosNueva(String instituto);//agregada por ultimo
	public boolean existeInstituto(String nombre);	
	public String [] getDocentes();
}
