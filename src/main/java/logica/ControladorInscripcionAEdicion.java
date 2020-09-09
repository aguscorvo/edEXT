package logica;

import java.util.Date;
import java.util.List;

import interfaces.IControladorInscripcionAEdicion;

public class ControladorInscripcionAEdicion implements IControladorInscripcionAEdicion {
	private String instituto;
	private String curso;
	private String nick;
	private Date fecha;
	
	public List<String> ingresarInstituto(String instituto){}
	public String ingresarCurso(String curso) {}
	public boolean ingresarEstudiante(String nick, Date fecha) {}
	public void confirmarInscripcionAEdicion() {}
	public void cancelarInscripcionAEdicion() {}
}
