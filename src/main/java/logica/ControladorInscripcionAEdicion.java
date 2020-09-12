package logica;

import java.util.ArrayList;
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
		String vacio = null;
		List<Edicion> edicionesCurso = auxCurso.getEdiciones();
		
		if(edicionesCurso.isEmpty()) {
			throw new NoExisteEdicionVigenteException("El curso '" + curso + "' no tiene una edición vigente.");
		}else {
			
			for(Edicion e: edicionesCurso) {
				
				if(((fechaActual.compareTo(e.getFechaI()) <0 ) /*|| fechaActual.compareTo(e.getFechaI()) == 0)*/) & (fechaActual.compareTo(e.getFechaF()) >= 0))
					throw new NoExisteEdicionVigenteException("El curso '" + curso + "' no tiene una edición vigente.");	
				
				else {
					this.edicion = e.getNombre();
					return e.getNombre();
				} 				
				
			}
		}
		
		return vacio;
					
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
	
	public String[] getInstitutos(){
		ManejadorInstituto mi = ManejadorInstituto.getInstancia();		
		List<Instituto> institutos = mi.getInstitutos();
		String [] arrInstitutos = new String [institutos.size()];
		
		int i=0;		
		for(Instituto ins: institutos) {
			arrInstitutos[i] = ins.getNombre();
			i++;
		}
		return arrInstitutos;	
		
	}
	
	public String[] getCursos(String instituto){		

		ManejadorInstituto mi = ManejadorInstituto.getInstancia();
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
	
	public String [] getEstudiantes(String edicion) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		List <Usuario> usuarios = mu.getUsuarios();
		List<InscripcionEd> inscripcionesEd;
		List<String> estudiantes = new ArrayList <String>();
		boolean tieneEdicionAsociada =false;

		Edicion auxEdicion;
		for (Usuario e: usuarios) {
			if(e instanceof Estudiante) {
				inscripcionesEd=((Estudiante) e).getInscripcionesEd();
				if (inscripcionesEd.isEmpty())  			//el estudiante no está inscripto a ninguna edición
					estudiantes.add(e.getNick());
				
				else {
					for(InscripcionEd ie: inscripcionesEd) {
						auxEdicion=ie.getEdicion();
						if (auxEdicion.getNombre().equals(edicion)) 
							tieneEdicionAsociada=true;	
					}
					if (!tieneEdicionAsociada) 				//el estudiante no está inscripto en la edición que pasamos como parámetro (se puede inscribir)
						estudiantes.add(e.getNick());
				}
				
			}
		}
		String [] arrEstudiantes = new String[estudiantes.size()];
		int i =0;
		for (String e: estudiantes) {
			arrEstudiantes[i]=e;
			i++;
		}
		return arrEstudiantes;
	}
}
