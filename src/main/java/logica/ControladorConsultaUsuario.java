package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatype.DtDocente;
import datatype.DtDocenteExp;
import datatype.DtEdicion;
import datatype.DtEstudiante;
import datatype.DtEstudianteExp;
import datatype.DtProgFormacionExp;
import datatype.DtUsuario;
import interfaces.IControladorConsultaUsuario;

public class ControladorConsultaUsuario implements IControladorConsultaUsuario{
	
	public String [] getUsuarios() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List <Usuario> usuarios = mU.getUsuarios();
		String [] arrVacio = {""};
		
		if (!usuarios.isEmpty()) {
			String [] arrUsuarios = new String [usuarios.size()];
			int i=0;
			for (Usuario u: usuarios) {
				arrUsuarios[i]=u.getNick();
				i++;
			}
			return arrUsuarios;
		}
		return arrVacio;
	}
	
	public DtUsuario seleccionarUsuario(String nick) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario auxUsuario = mU.getUsuario(nick);
		DtUsuario dt = new DtUsuario();
		if (auxUsuario instanceof Estudiante) {

			List<InscripcionEd> auxInscripcionesEd = (((Estudiante)auxUsuario).getInscripcionesEd());
			List<String> nombreEdiciones = new ArrayList<String>();
			String nombreEd;
			for (InscripcionEd ie: auxInscripcionesEd) {
				nombreEd=ie.getEdicion().getNombreEd();
				nombreEdiciones.add(nombreEd);
			}
			
			List<InscripcionPF> auxInscripcionesPF = new ArrayList<InscripcionPF>(((Estudiante)auxUsuario).getInscripcionesPF()); 
			List<String> nombreProgramas = new ArrayList<String>();
			String nombrePF;
			for (InscripcionPF ipf: auxInscripcionesPF) {
				nombrePF=ipf.getProgFormacion().getNombre();
				nombreEdiciones.add(nombrePF);
			}
			
			dt = new DtEstudianteExp (auxUsuario.getNick(), auxUsuario.getNombre(), auxUsuario.getApellido(), auxUsuario.getCorreo(), 
					auxUsuario.getFechaNac(), nombreEdiciones, nombreProgramas);
						
		}else if(auxUsuario instanceof Docente) {
			List<Edicion> auxEdiciones = (((Docente)auxUsuario).getEdiciones());
			List<String> nombreEdiciones = new ArrayList<String>();
			for (Edicion e: auxEdiciones)
				nombreEdiciones.add(e.getNombreEd());
			
			dt = new DtDocenteExp (auxUsuario.getNick(), auxUsuario.getNombre(), auxUsuario.getApellido(), auxUsuario.getCorreo(), 
					auxUsuario.getFechaNac(), ((Docente)auxUsuario).getInstituto().getNombre(), nombreEdiciones);
			
		}
		return dt;
	}
	
	//public DtCursoExp seleccionarCurso(String nombre) {}
	
	public DtEdicion seleccionarEdicion(String nombre) {
		ManejadorEdicion me = ManejadorEdicion.getInstancia();
		Edicion auxEdicion = me.getEdicion(nombre);
		DtEdicion auxDT = new DtEdicion(auxEdicion.getNombreEd(), auxEdicion.getFechaI(), auxEdicion.getFechaF(), auxEdicion.getCupo(), auxEdicion.getFechaPub());
		
		return auxDT;
	}
	
	public DtProgFormacionExp seleccionarPrograma(String programa) {
		ManejadorProgFormacion mpf = ManejadorProgFormacion.getInstancia();
		ProgFormacion auxPF = mpf.getProgFormacion(programa);
		String nombre = auxPF.getNombre();
		String desc = auxPF.getDescPF();
		Date fechaI = auxPF.getFechaI();
		Date fechaF = auxPF.getFechaF();
		Date fechaAlta = auxPF.getFechaAlta();
		
		
		ManejadorCurso mc = ManejadorCurso.getInstancia();
		List<Curso> cursos = mc.getCursos();
		List<String> nomCursos = new ArrayList<String>();
		List<ProgFormacion> cursosPFs = new ArrayList<ProgFormacion>();
		
		for(Curso c: cursos) {
			cursosPFs = c.getProgramas();
			for(ProgFormacion pf: cursosPFs) {
				if(pf.getNombre().equals(programa)) {
					nomCursos.add(c.getNombre());
					break;
				}
			}
		}
		
		DtProgFormacionExp auxDT = new DtProgFormacionExp(nombre, desc, fechaI, fechaF, fechaAlta, nomCursos);  
																												
		return auxDT;
	}
	
	public String obtenerDatosEdicion(DtEdicion edicion) {
		String fechaI = funcionesAux.convertirAString(edicion.getFechaI());
		String fechaF = funcionesAux.convertirAString(edicion.getFechaF());
		String fechaP = funcionesAux.convertirAString(edicion.getFechaPub());
		String cupo = String.valueOf(edicion.getCupo());
		
		String auxDatos = "Nombre: " + edicion.getNombre() + "\n\nFecha inicio: " + fechaI + "\n\nFecha fin: " + fechaF + "\n\nCupo: " + cupo + "\n\nFecha de publicación: " + fechaP;
		return auxDatos;
		
	}
	
	public String obtenerDatosPrograma(DtProgFormacionExp programa) {
		String nombre = programa.getNombre();
		String desc = programa.getDesc();
		Date auxFechaI = programa.getFechaI();
		Date auxFechaF = programa.getFechaF();
		Date auxFechaAlta = programa.getFechaAlta();
		String fechaI = funcionesAux.convertirAString(auxFechaI);
		String fechaF = funcionesAux.convertirAString(auxFechaF);
		String fechaAlta = funcionesAux.convertirAString(auxFechaAlta);
		String aRetornar = "Nombre: " + nombre + "\n\nDescripción: " + desc + "\n\nFecha de inicio: " + fechaI + "\n\nFecha de finalización: " + fechaF + "\n\n"
				+ "Fecha de alta: " + fechaAlta;
		
		return aRetornar;
		
	}
	
	public String obtenerDatosUsuario (DtUsuario usuario) {
		String fechaNac = funcionesAux.convertirAString(usuario.getFechaNac());
		String aRetornar = "Nick: " + usuario.getNick() + "\n\nNombre: " + usuario.getNombre() + "\n\nApellido: "  + usuario.getApellido() + "\n\nCorreo:" +
				usuario.getCorreo() + "\n\nFecha de nacimiento: " + fechaNac;
		return aRetornar;
		
	}
	
	public String [] getEdiciones(DtUsuario usuario) {
		List <String> auxEdiciones = new ArrayList<String>();
		String[] arrVacio= {""};
		
		if (usuario instanceof DtDocente) {
			auxEdiciones=((DtDocenteExp)usuario).getEdiciones();
		}else if(usuario instanceof DtEstudiante) {
			auxEdiciones=((DtEstudianteExp)usuario).getEdiciones();
		}
		if(!auxEdiciones.isEmpty()) {
			String [] ediciones = new String [auxEdiciones.size()];
			int i = 0;
			for(String e: auxEdiciones) {
				ediciones[i]=e;
				i++;
			}
			return ediciones;			
		}
		return arrVacio;
		
			
	}
	
	public String[] getProgramas(DtUsuario usuario) {
		List <String> auxProgramas = new ArrayList<String>();
		String [] arrVacio = {""};
		
		if(usuario instanceof DtEstudiante)
			auxProgramas = ((DtEstudianteExp)usuario).getProgramas();
		
		if(!auxProgramas.isEmpty()) {
			String [] programas = new String[auxProgramas.size()];
			int i = 0;
			for(String e: auxProgramas) {
				programas[i]=e;
				i++;
			}
			return programas;			
		}
		return arrVacio;
	}
	
	
			
		
}
	


