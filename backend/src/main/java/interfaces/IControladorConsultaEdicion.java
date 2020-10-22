package interfaces;
import java.util.List;

import datatype.DtEdicion;

public interface IControladorConsultaEdicion {
	public List<String> ingresarInstituto(String instituto);
	public List<String> ingresarCurso(String curso);
	public DtEdicion ingresarEdicion(String edicion);
	public String[] getInstitutos();
	public String[] getCategoriasGlobal();
	public String[] getCursos(String instituto);
	public String[] getCursosPorCategoria(String categoria);
	public String[] getEdiciones(String curso);
	public String getDocentesAsignados(String edicion);
	public String obtenerDatosBasicosEd(String edicion);
	public String obtenerDatosEdicion(DtEdicion edicion);
	public DtEdicion getDatosEdicion();
	public void setDatosEdicion(DtEdicion datosEdicion);
	

}
