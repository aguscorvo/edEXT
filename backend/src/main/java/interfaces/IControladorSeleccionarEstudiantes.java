package interfaces;

import datatype.DtEdicion;
import datatype.EstadoInscripcion;
import excepciones.NoEsProfesorDeEdicionVigenteException;
import excepciones.NoExisteEdicionVigenteException;

public interface IControladorSeleccionarEstudiantes {

	public String[] getInstitutos();

    public String[] ingresarInstituto(String instituto);
		
	public String ingresarCurso(String curso, String docente) throws NoExisteEdicionVigenteException, NoEsProfesorDeEdicionVigenteException;
		
	public String obtenerDatosBasicosEd();
		
	public String [] getEstudiantes();
	
	public boolean esDocenteEdicion (String docente, String edicion);
	
	//public void ordenarEstPorPrioridad (String[] estudiantes);
	
    //public void ordenarEstPorFechaInsc (String[] estudiantes);
	
	public EstadoInscripcion [] getEstadosSegunEstudiantes (String [] estudiantes);

	public void confirmarSeleccionarEstudiantes (String [] estudiantes, EstadoInscripcion ei, String edi);

}
