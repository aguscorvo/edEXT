package logica;

import java.util.Date;
import java.util.List;

import excepciones.NoExisteEdicionVigenteException;
import interfaces.IControladorInscripcionAEdicion;

public class ControladorInscripcionAEdicion implements IControladorInscripcionAEdicion {
	private String instituto;
	private String edicion;
	private String nick;
	private Date fecha;
	
	public String [] ingresarInstituto(String instituto){
		
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
		this.instituto = instituto;
		String [] arrCursosVacio = {""};
		if(mi.existeInstituto(instituto)) {
			Instituto auxInst = mi.getInstituto(instituto);
			List<String> auxCursos = auxInst.getCursosString();
			String [] arrCursos = new String [auxCursos.size()];
			
			int i=0;
			
			for(String c: auxCursos) {
				
				arrCursos[i] = c;
				i++;
			}
			
			return arrCursos;
		}
		
		return arrCursosVacio;
		
	}
	
	public String ingresarCurso(String curso) throws NoExisteEdicionVigenteException{
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		Curso auxCurso = mc.getCurso(curso);
		Date fechaActual = new Date();
		List<Edicion> edicionesCurso = auxCurso.getEdiciones();
		
		for(Edicion e: edicionesCurso) {
			
			if((fechaActual.compareTo(e.getFechaI()) > 0 || fechaActual.compareTo(e.getFechaI()) == 0)){
				if((fechaActual.compareTo(e.getFechaF()) < 0)) {
					this.edicion = e.getNombre();
					return e.getNombre();
					
				}
				
			}
		}	
			
		throw new NoExisteEdicionVigenteException("El curso '" + curso + "' no tiene una edición vigente.");
			
	}
		
		
		
		
	public void ingresarEstudiante(String nick, Date fecha) {
		this.nick = nick;
		this.fecha = fecha;
		
		
	}
	
	
	public void confirmarInscripcionAEdicion() {
		
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Estudiante auxEstudiante = (Estudiante) mu.getUsuario(nick);
		ManejadorEdicion me = ManejadorEdicion.getInstancia();
		Edicion auxEdicion = me.getEdicion(edicion);
		
		InscripcionEd nuevaInscripcion = new InscripcionEd(this.fecha, auxEdicion);
		
		List<InscripcionEd> auxInscripciones = auxEstudiante.getInscripcionesEd();
		auxInscripciones.add(nuevaInscripcion);
		auxEstudiante.setInscripcionesEd(auxInscripciones);
		
	}
	
	
	
	public void cancelarInscripcionAEdicion() {}
}
