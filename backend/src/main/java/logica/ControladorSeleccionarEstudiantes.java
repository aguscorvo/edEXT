package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import datatype.EstadoInscripcion;
import excepciones.NoExisteEdicionVigenteException;
import interfaces.IControladorSeleccionarEstudiantes;
import persistencia.Conexion;

public class ControladorSeleccionarEstudiantes implements IControladorSeleccionarEstudiantes {
	
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

	public String ingresarCurso(String curso, String docente) throws NoExisteEdicionVigenteException/*, NoEsProfesorDeEdicionVigenteException*/{
		
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
					/*if (!e.getNombreEd().equals(docente))
						throw new NoEsProfesorDeEdicionVigenteException("No participas de la edición vigente del curso seleccionado.");
					else {
						this.edicion = e.getNombreEd();
						return e.getNombreEd();
					}*/
					this.edicion = e.getNombreEd();
					return e.getNombreEd();//cambiar por lo de arriba
					
				} 				
				
			}
		}
		
		return vacio;
					
	}

	public String obtenerDatosBasicosEd() {
		
			ManejadorEdicion me = ManejadorEdicion.getInstancia();
			Edicion e = me.getEdicion(this.edicion);
		
			String fechaI = funcionesAux.convertirAString(e.getFechaI());
			String fechaF = funcionesAux.convertirAString(e.getFechaF());
			String fechaP = funcionesAux.convertirAString(e.getFechaPub());
			String cupo = String.valueOf(e.getCupo());
			
			String auxDatos = "Nombre: " + e.getNombreEd() + "<br><br>Fecha inicio:" + fechaI + "<br>Fecha fin: " + fechaF + "<br><br>Cupo: " + cupo + "<br><br>Fecha de publicación: <br>" + fechaP;
			return auxDatos;
			
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
							if (ie.getEstado() == EstadoInscripcion.INSCRIPTO)
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
	
	/*public void ordenarEstPorPrioridad (String[] estudiantes) {
		
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
	}*/
	

	/*public void ordenarEstPorFechaInsc (String[] estudiantes) {
		
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
	}*/
	
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

	public void confirmarSeleccionarEstudiantes (String [] estudiantes, EstadoInscripcion ei, String edi) {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario u;
		Estudiante e;
		int ipr =0;
		
		for (int i = 0; i < estudiantes.length; i++) {
			
			u = mu.getUsuario(estudiantes[i]);
			if (u instanceof Estudiante) {
				e = (Estudiante) u;
				InscripcionEd ie = e.getInscEd(edi);
				System.out.println("ipr");
				if (ei == EstadoInscripcion.RECHAZADO){
					
					ipr = ie.getIPR() + 1;
					ie.setIPR(ipr);
				}
				
				ie.setEstado(ei);
				Conexion conexion = Conexion.getInstancia();
				EntityManager em = conexion.getEntityManager();
				em.getTransaction().begin();
				em.merge(ie);
				em.getTransaction().commit();	
				
			}
		}
	}


	
	public boolean esDocenteEdicion(String docente, String edicion) {
		
		boolean esDocente = false;
		
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario u = mu.getUsuario(docente);
		if (u instanceof Docente) {
			List<Edicion> ediciones = ((Docente) u).getEdiciones();
			for (Edicion aux: ediciones) {
				if(aux.getNombreEd().equals(edicion)) {
					esDocente = true;
				}
			}
		}
		return esDocente;
			
	}
	
}	 	
