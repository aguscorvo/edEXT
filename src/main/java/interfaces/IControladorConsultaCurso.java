package interfaces;
import datatype.*;


public interface IControladorConsultaCurso {
	public String [] ingresarInstituto(String instituto);
	public DtCursoExp seleccionarCurso(String curso);
	public DtEdicion seleccionarEdicion(String edicion);
	public DtProgFormacionExp seleccionarProgFormacion(String progFormacion);	
	public String[] getInstitutos();
	public String [] getPrevias (String curso);
	public String[] getEdiciones (String curso);
	public String[] getPFs (String curso);
	public String obtenerDatosCurso(DtCursoExp curso);
	public String obtenerDatosEdicion(DtEdicion edicion);
	public String obtenerDatosPrograma(DtProgFormacionExp programa);




	
}
