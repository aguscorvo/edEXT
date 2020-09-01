package interfaces;
import java.util.List;

import datatype.DtEdicionExp;
import excepciones.EdicionRepetidaException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;

public interface IControladorAltaEdicion {
	
	public List<String> ingresarInstituto(String instituto) throws NoExisteInstitutoException;
	
	public void seleccionarCurso(String curso) throws NoExisteCursoException;
	
	public void ingresarDtEdicion(DtEdicionExp edicion) throws EdicionRepetidaException;
	
	public void confirmarAltaEdicion();
	
	public void cancelarAltaEdicion();

}
