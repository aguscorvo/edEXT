package interfaces;
import java.util.Date;

import datatype.EstadoInscripcion;
import excepciones.NoExisteEdicionVigenteException;


public interface IControladorInscripcionAEdicion {
	public String [] ingresarInstituto(String instituto);
	public String[] getCategoriasGlobal();
	public String[] getCursosPorCategoria(String categoria);
	public String ingresarCurso(String curso) throws NoExisteEdicionVigenteException;
	public String obtenerDatosBasicosEd();
	public void ingresarEstudiante(String nick, Date fecha);
	public void confirmarInscripcionAEdicion();
	public void cancelarInscripcionAEdicion();
	public String[] getInstitutos();
	public String[] getCursos(String instituto);
	public String [] getEstudiantes(String edicion);
	public EstadoInscripcion chequearEstudianteEdicion();
	public boolean tieneInscripcion ();

}
