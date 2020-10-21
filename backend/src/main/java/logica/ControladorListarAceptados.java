package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatype.EstadoInscripcion;
import excepciones.NoEsProfesorDeEdicionVigenteException;
import excepciones.NoExisteEdicionVigenteException;
import interfaces.IControladorListarAceptados;

public class ControladorListarAceptados implements IControladorListarAceptados{

	private String edicion;
	
	public String[] getInstitutos() {
		
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


	public String[] ingresarInstituto(String instituto) {
		
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
	
	
	public String getEstudiantesAceptados() {
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		List <Usuario> usuarios = mu.getUsuarios();
		List<InscripcionEd> inscripcionesEd;
		List<String> estudiantesNombre = new ArrayList <String>();
		List<String> estudiantesApellido = new ArrayList <String>();
		
		Edicion auxEdicion;
		for (Usuario e: usuarios) {
			if(e instanceof Estudiante) {
				inscripcionesEd=((Estudiante) e).getInscripcionesEd();
				if (!inscripcionesEd.isEmpty()) {  			//el estudiante está inscripto a alguna edición
					
					for(InscripcionEd ie: inscripcionesEd) {
						auxEdicion=ie.getEdicion();
						if (auxEdicion.getNombreEd().equals(this.edicion)) //si está inscripto a la edición
							if (ie.getEstado() == EstadoInscripcion.ACEPTADO) {
								estudiantesNombre.add(e.getNombre());
								estudiantesApellido.add(e.getApellido());
					
							}
					}

				}
				
			}
		}
		
		int cantElem = estudiantesNombre.size();
		int cont = 0;
		String cadenaEst = "";
		while (!estudiantesNombre.isEmpty() && !estudiantesApellido.isEmpty() && cont<cantElem) {
			cadenaEst = cadenaEst + estudiantesNombre.get(cont) + " " + estudiantesApellido.get(cont) + "<br>";
			cont++;
		}
		
		return cadenaEst;
	}


}
