package interfaces;

import datatype.*;

public interface IControladorConsultaUsuario {
	public String[] getUsuarios();
	public DtUsuario seleccionarUsuario(String nick);
	public DtEdicion seleccionarEdicion(String nombre);
	public DtProgFormacionExp seleccionarPrograma(String programa);
	public String obtenerDatosUsuario (DtUsuario usuario);
	public String obtenerDatosEdicion(DtEdicion edicion);
	public String obtenerDatosPrograma(DtProgFormacionExp programa);
	public String [] getEdiciones(DtUsuario usuario);
	public String [] getEdicionesNueva(String usuario);
	public String [] getEdicionesInscRechazadas(DtUsuario usuario);
	public String [] getEdicionesInscRechazadasNueva(String estudiante);
	public String[] getProgramas(DtUsuario usuario);
	public String [] getProgramasNueva(String estudiante);
	public String tipoUsuarioSeleccionado(String nick);
	public String getEstudiantesAceptadosAEdicion(String edicion);
}
