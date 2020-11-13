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
import datatype.EstadoInscripcion;
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
			List<String> nombreEdiciones = new ArrayList<String>(); // nombres de ediciones con inscripcion Inscripto o Aceptado
			List<String> nombreEdicionesInscRechazadas = new ArrayList<String>(); // nombres de ediciones con inscripción Rechazado
			
			String nombreEd;
			for (InscripcionEd ie: auxInscripcionesEd) { 
				nombreEd=ie.getEdicion().getNombreEd();
				if (ie.getEstado()==EstadoInscripcion.ACEPTADO || ie.getEstado()==EstadoInscripcion.INSCRIPTO)
					nombreEdiciones.add(nombreEd);					
				else if (ie.getEstado()==EstadoInscripcion.RECHAZADO)
					nombreEdicionesInscRechazadas.add(nombreEd);
			}			
			
			
			List<InscripcionPF> auxInscripcionesPF = new ArrayList<InscripcionPF>(((Estudiante)auxUsuario).getInscripcionesPF()); 
			List<String> nombreProgramas = new ArrayList<String>();
			String nombrePF;
			for (InscripcionPF ipf: auxInscripcionesPF) {
				nombrePF=ipf.getProgFormacion().getNombre();
				nombreProgramas.add(nombrePF);
			}
			
			dt = new DtEstudianteExp (auxUsuario.getNick(), auxUsuario.getNombre(), auxUsuario.getApellido(), auxUsuario.getCorreo(), 
					auxUsuario.getFechaNac(), "", nombreEdiciones, nombreEdicionesInscRechazadas, nombreProgramas);
						
		}else if(auxUsuario instanceof Docente) {
			List<Edicion> auxEdiciones = (((Docente)auxUsuario).getEdiciones());
			List<String> nombreEdiciones = new ArrayList<String>();
			for (Edicion e: auxEdiciones)
				nombreEdiciones.add(e.getNombreEd());
			
			dt = new DtDocenteExp (auxUsuario.getNick(), auxUsuario.getNombre(), auxUsuario.getApellido(), auxUsuario.getCorreo(), 
					auxUsuario.getFechaNac(), "", ((Docente)auxUsuario).getInstituto().getNombre(), nombreEdiciones);
			
		}
		return dt;
	}
	
	
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
		
		String auxDatos = "Nombre: " + edicion.getNombre() + "<br><br>Fecha inicio: " + fechaI + "<br>Fecha fin: " + fechaF + "<br><br>nCupo: " + cupo + "<br><br>Fecha de publicación: " + fechaP;
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
		String aRetornar = "Nombre: " + nombre + "<br>Descripción: " + desc + "<br><br>Fecha de inicio: " + fechaI + "<br>Fecha de finalización: " + fechaF + "<br>"
				+ "Fecha de alta: " + fechaAlta;
		
		return aRetornar;
		
	}
	
	public String obtenerDatosUsuario (DtUsuario usuario) {
		String fechaNac = funcionesAux.convertirAString(usuario.getFechaNac());
		String aRetornar = "Nick: " + usuario.getNick() + "<br><br>Nombre: " + usuario.getNombre() + "<br>Apellido: "  + usuario.getApellido() + "<br>Correo:" +
				usuario.getCorreo() + "<br>Fecha de nacimiento: " + fechaNac;
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
	
	public String [] getEdicionesInscRechazadas(DtUsuario usuario) {
		List <String> auxEdiciones = new ArrayList<String>();
		String[] arrVacio= {""};
		
		if (usuario instanceof DtEstudiante) {
			auxEdiciones=((DtEstudianteExp)usuario).getEdicionesRechazadas();
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
	
	public String tipoUsuarioSeleccionado(String nick) {
		String tipo="";
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario auxUsuario = mu.getUsuario(nick);
		if (auxUsuario instanceof Estudiante)
			tipo="estudiante";
		else if (auxUsuario instanceof Docente)
			tipo="docente";
		return tipo;
	}
	
	public String getEstudiantesAceptadosAEdicion(String edicion) {
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
							if (auxEdicion.getNombreEd().equals(edicion)) //si está inscripto a la edición
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

	
	public String[] getProgramasNueva(String estudiante) {
		
		String [] arrVacio = {""};
	
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario u = mu.getUsuario(estudiante);
		if (u instanceof Estudiante) {
			List<InscripcionPF> ipfs = ((Estudiante) u).getInscripcionesPF();
			if(!ipfs.isEmpty()) {
				String [] programas = new String[ipfs.size()];
				int i = 0;
				for(InscripcionPF ipf: ipfs) {
					programas[i]= ipf.getProgFormacion().getNombre();
					i++;
				}
				return programas;			
			}
			
		}
		return arrVacio;
	}

	public String[] getEdicionesInscRechazadasNueva(String estudiante) {
		String [] arrVacio = {""};
		
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario u = mu.getUsuario(estudiante);
		if (u instanceof Estudiante) {
			List<InscripcionEd> ies = ((Estudiante) u).getInscripcionesEd();
			if(!ies.isEmpty()) {
		
				List<String> edStr = new ArrayList<String>();
				for(InscripcionEd ie: ies) {
					if(ie.getEstado() == EstadoInscripcion.RECHAZADO)
						edStr.add(ie.getEdicion().getNombreEd());
				}
				if(!edStr.isEmpty()) {
					String [] edicionesRech = new String[edStr.size()];
					int i = 0;
					for(String s: edStr) {
						edicionesRech[i] = s;
						i++;
					}
					return edicionesRech;
				}
			
			}
		}
		return arrVacio;
	}

	@Override
	public String[] getEdicionesNueva(String usuario) {
		
		List<String> ediciones = new ArrayList<String>();
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		Usuario u = mu.getUsuario(usuario);
		
		if(u instanceof Docente) {
			for(Edicion e: ((Docente) u).getEdiciones()) {
				ediciones.add(e.getNombreEd());
			}
		}
		if(u instanceof Estudiante) {
			for(InscripcionEd ie: ((Estudiante) u).getInscripcionesEd()) {
				ediciones.add(ie.getEdicion().getNombreEd());
			}
		}
		String [] arrVacio = {""};
		if(!ediciones.isEmpty()) {
			String [] edis = new String[ediciones.size()];
			int i = 0;
			for (String s: ediciones) {
				edis[i] = s;
				i++;
			}
			return edis;
		}
		else
			return arrVacio;
			
	}
	
}