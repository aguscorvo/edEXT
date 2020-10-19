package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatype.DtEdicion;
import datatype.EstadoInscripcion;
import excepciones.NoEsProfesorDeEdicionVigenteException;
import excepciones.NoExisteEdicionVigenteException;

public class ControladorSeleccionarEstudiantes {
	
	private String edicion;
	
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


	public String[] ingresarInstituto(String instituto){
	
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

	public String ingresarCurso(String curso, String docente) throws NoExisteEdicionVigenteException, NoEsProfesorDeEdicionVigenteException{
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		Curso auxCurso = mc.getCurso(curso);
		Date fechaActual = new Date();
		String vacio = null;
		List<Edicion> edicionesCurso = auxCurso.getEdiciones();
		
		if(edicionesCurso.isEmpty()) {
			throw new NoExisteEdicionVigenteException("El curso '" + curso + "' no tiene una edición vigente.");
		}else {
			
			for(Edicion e: edicionesCurso) {
				
				if(((fechaActual.compareTo(e.getFechaI()) <0 )) & (fechaActual.compareTo(e.getFechaF()) >= 0))
					throw new NoExisteEdicionVigenteException("El curso '" + curso + "' no tiene una edición vigente.");	
				
				else {
					if (!e.getNombreEd().equals(docente))
						throw new NoEsProfesorDeEdicionVigenteException("No participas de la edición vigente del curso seleccionado.");
					else {
						this.edicion = e.getNombreEd();
						return e.getNombreEd();
					}
					
				} 				
				
			}
		}
		
		return vacio;
					
	}

	public DtEdicion obtenerDatosBasicosEd() {
		
		ManejadorEdicion me = ManejadorEdicion.getInstancia();
		Edicion auxEdicion = me.getEdicion(this.edicion);
		DtEdicion auxDT = new DtEdicion(auxEdicion.getNombreEd(), auxEdicion.getFechaI(), auxEdicion.getFechaF(), auxEdicion.getCupo(), auxEdicion.getFechaPub());
		
		return auxDT;
		
	}

	public String [] getEstudiantes() {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		List <Usuario> usuarios = mu.getUsuarios();
		List<InscripcionEd> inscripcionesEd;
		List<String> estudiantes = new ArrayList <String>();

		Edicion auxEdicion;
		for (Usuario e: usuarios) {
			if(e instanceof Estudiante) {
				inscripcionesEd=((Estudiante) e).getInscripcionesEd();
				if (!inscripcionesEd.isEmpty()) {  			//el estudiante está inscripto a alguna edición
					
					for(InscripcionEd ie: inscripcionesEd) {
						auxEdicion=ie.getEdicion();
						if (auxEdicion.getNombreEd().equals(this.edicion)) //si está inscripto a la edición
							estudiantes.add(e.getNick());
					}
					

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
	
	public void ordenarEstPorPrioridad (String[] estudiantes) {
		
		 ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		 String aux_elem;
		 Usuario u;
		 float prioridad1 = 0;
		 float prioridad2 = 0;

		 for (int i = 0; i < estudiantes.length - 1; i++)
		 {
		     for (int j = 1; j < estudiantes.length; j++){
		    	 
		    	 u = mu.getUsuario(estudiantes[j]);
		    	 if (u instanceof Estudiante) {
		    		 prioridad1 = (float) (((Estudiante) u).getInscEd(this.edicion).getIPR() * 0.5);
		    	 }
		    	 
		    	 u = mu.getUsuario(estudiantes[j-1]);
			   	 if (u instanceof Estudiante) {
			   		 prioridad2 = (float) (((Estudiante) u).getInscEd(this.edicion).getIPR() * 0.5);	 
		    		 
		    	 }
		         
			   	 if (prioridad2 > prioridad1){
		            // si el elemento anterior es mayor, hacemos el cambio
		             aux_elem = estudiantes[j];
		             estudiantes[j] = estudiantes[j-1];
		             estudiantes[j-1] = aux_elem;
		         }
		     }
		 }
	}
	

	public void ordenarEstPorFechaInsc (String[] estudiantes) {
		
		 ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		 String aux_elem;
		 Usuario u;
		 Date fecha1 = new Date();
		 Date fecha2 = new Date();

		 for (int i = 0; i < estudiantes.length - 1; i++)
		 {
		     for (int j = 1; j < estudiantes.length; j++){
		    	 
		    	 u = mu.getUsuario(estudiantes[j]);
		    	 if (u instanceof Estudiante) {
		    		 fecha1 = ((Estudiante) u).getInscEd(this.edicion).getFecha();
		    	 }
		    	 
		    	 u = mu.getUsuario(estudiantes[j-1]);
			   	 if (u instanceof Estudiante) {
			   		fecha2 = ((Estudiante) u).getInscEd(this.edicion).getFecha();
		    		 
		    	 }
		         
			   	 if (fecha2.compareTo(fecha1) > 0){
		            // si el elemento anterior es mayor, hacemos el cambio
		             aux_elem = estudiantes[j];
		             estudiantes[j] = estudiantes[j-1];
		             estudiantes[j-1] = aux_elem;
		         }
		     }
		 }
	}
	
	public EstadoInscripcion [] getEstadosSegunEstudiantes (String [] estudiantes) {
		
		Usuario u;
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		
		if (estudiantes.length == 0)
			return null;
		else {
			EstadoInscripcion [] estados = new EstadoInscripcion [estudiantes.length];
		
			for(int i=0; i<estudiantes.length; i++) {
				u = mu.getUsuario(estudiantes[i]);
				if (u instanceof Estudiante) {
					estados[i] = ((Estudiante) u).getInscEd(this.edicion).getEstado();
				}
				i++;
			}
			return estados;	
		}
	
	}

	public void confirmarSeleccionarEstudiantes (String [] estudiantes, String [] estados) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario u;
		int ipr;
		EstadoInscripcion e = null;
		
		
		for (int i = 0; i < estudiantes.length; i++) {
			u = mu.getUsuario(estudiantes[i]);
			if (u instanceof Estudiante) {
				InscripcionEd ie = ((Estudiante) u).getInscEd(this.edicion);
				if (estados[i].equals("INSCRIPTO")){
					e = EstadoInscripcion.INSCRIPTO;
				}
				else if (estados[i].equals("RECHAZADO")){
					e = EstadoInscripcion.RECHAZADO;
					ipr = ie.getIPR() + 1;
					ie.setIPR(ipr);
				}
				else if (estados[i].equals("ACEPTADO")){
					e = EstadoInscripcion.ACEPTADO;
				}
				
				ie.setEstado(e);
				
			}
		}
	}
	
}	 	
