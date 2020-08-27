package interfaces;
import java.util.List;

import datatype.DtEdicionExp;

public interface IControladorAltaEdicion {
	public List<String> ingresarInstituto(String instituto);
	public void seleccionarCurso(String curso);
	public boolean ingresarDtEdicion(DtEdicionExp edicion);
	public void confirmarAltaEdicion();
	public void cancelarAltaEdicion();
}
