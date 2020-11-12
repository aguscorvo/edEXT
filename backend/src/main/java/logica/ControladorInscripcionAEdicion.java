package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;

import datatype.EstadoInscripcion;
import excepciones.NoExisteEdicionVigenteException;
import interfaces.IControladorInscripcionAEdicion;
import persistencia.Conexion;

public class ControladorInscripcionAEdicion implements IControladorInscripcionAEdicion {
	private String edicion;
	private String nick;
	private Date fecha;
	
	public String [] ingresarInstituto(String instituto){
		
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
	
	public String[] getCategoriasGlobal() {
		
		List<Categoria> categorias;
		ManejadorCategoria mc = ManejadorCategoria.getInstancia();
		categorias = mc.getCategorias();
		String[] cat_ret = new String [categorias.size()];
		int i=0;
		for (Categoria c: categorias) {
			cat_ret[i]= c.getNombreCategoria();
			i++;
		}
		return cat_ret;

		
	}
	
	public String[] getCursosPorCategoria(String categoria) {
		String [] arrVacio = {""};
		ManejadorCategoria mca = ManejadorCategoria.getInstancia();
		ManejadorCurso mcu = ManejadorCurso.getInstancia();
		Categoria cat = mca.getCategoria(categoria);
		List<Curso> cursosAux = mcu.getCursos();
		List<Curso> cursos = new ArrayList<Curso>();
		
		if (!cursosAux.isEmpty()) {
			for (Curso c: cursosAux) {
				List <Categoria> cats = c.getCategorias();
				if (cats.contains(cat)) {
					cursos.add(c);
				}
			}
			if (!cursos.isEmpty()) {
				String[] losCur = new String [cursos.size()];
				int i = 0;
				for(Curso c: cursos) {
					losCur[i]=c.getNombre();
					i++;
				}
				return losCur;
			}
			else return arrVacio;
		}
		else return arrVacio;
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
				
				if(((fechaActual.compareTo(e.getFechaI()) <0 )) & (fechaActual.compareTo(e.getFechaF()) >= 0))
					throw new NoExisteEdicionVigenteException("El curso '" + curso + "' no tiene una edición vigente.");	
				
				else {
					this.edicion = e.getNombreEd();
					return e.getNombreEd();
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
		
		
	public void ingresarEstudiante(String nick, Date fecha) {
		this.nick = nick;
		this.fecha = fecha;
		
		
	}
	
	public boolean tieneInscripcion () {
		boolean tiene = false;
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario auxUsuario = mu.getUsuario(nick);
		if (auxUsuario instanceof Estudiante) {
			Estudiante auxEstudiante = ((Estudiante) auxUsuario);
			ManejadorEdicion me = ManejadorEdicion.getInstancia();
			InscripcionEd inscripcion = auxEstudiante.getInscEd(edicion);
			if (inscripcion != null){
				tiene = true;
			}
		}
		return tiene;
	}
	
	public EstadoInscripcion chequearEstudianteEdicion() {
		
		EstadoInscripcion e = null;
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario auxUsuario = mu.getUsuario(nick);
		if (auxUsuario instanceof Estudiante) {
			Estudiante auxEstudiante = ((Estudiante) auxUsuario);
			ManejadorEdicion me = ManejadorEdicion.getInstancia();
			InscripcionEd inscripcion = auxEstudiante.getInscEd(edicion);
			if (inscripcion != null){
				e = inscripcion.getEstado();
			}
		}
		return e;
	}
	
	public void confirmarInscripcionAEdicion() {
		
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario auxUsuario = mu.getUsuario(nick);
		if (auxUsuario instanceof Estudiante) {
			Estudiante auxEstudiante = ((Estudiante) auxUsuario);
			ManejadorEdicion me = ManejadorEdicion.getInstancia();
			Edicion auxEdicion = me.getEdicion(edicion);
			InscripcionEd inscripcion = auxEstudiante.getInscEd(edicion);
			if (inscripcion == null){
				inscripcion = new InscripcionEd(this.fecha, EstadoInscripcion.INSCRIPTO, 0, auxEdicion);
				
				List<InscripcionEd> auxInscripciones = auxEstudiante.getInscripcionesEd();
				auxInscripciones.add(inscripcion);
				auxEstudiante.setInscripcionesEd(auxInscripciones);
				
				Conexion conexion = Conexion.getInstancia();
				EntityManager em = conexion.getEntityManager();
				em.getTransaction().begin();
				em.persist(inscripcion);
				em.getTransaction().commit();
			}
			else {
				inscripcion.setEstado(EstadoInscripcion.INSCRIPTO);
				Conexion conexion = Conexion.getInstancia();
				EntityManager em = conexion.getEntityManager();
				em.getTransaction().begin();
				em.merge(inscripcion);
				em.getTransaction().commit();	
			}
		}
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
						if (auxEdicion.getNombreEd().equals(edicion)) { 
							tieneEdicionAsociada=true;	
							if (ie.getEstado() == EstadoInscripcion.RECHAZADO)
								estudiantes.add(e.getNick());
								
						}
					}	
					if (!tieneEdicionAsociada) 				//el estudiante no está inscripto en la edición que pasamos como parámetro (se puede inscribir)
						estudiantes.add(e.getNick());
					tieneEdicionAsociada=false;

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
