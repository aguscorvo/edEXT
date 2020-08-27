package logica;

import java.util.ArrayList;
import java.util.List;
import datatype.DtEstudiante;
import datatype.DtFecha;

public class Estudiante extends Usuario {
	
	private List<InscripcionEd> inscripcionesEd = new ArrayList<InscripcionEd>();
	private List<InscripcionPF> inscripcionesPF = new ArrayList<InscripcionPF>();
	
	@Override
	public DtEstudiante obtenerDtUsuario() {}
	
	public boolean existeInscEdicion(String edicion) {}
	
	public void agregarInscripcion(InscripcionEd ie) {}

	public Estudiante() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estudiante(String nick, String nombre, String apellido, String correo, DtFecha fechaNac,
			List<InscripcionEd> inscripcionesEd, List<InscripcionPF> inscripcionesPF) {
		super(nick, nombre, apellido, correo, fechaNac);
		this.inscripcionesEd = inscripcionesEd;
		this.inscripcionesPF = inscripcionesPF;
	}

	public List<InscripcionEd> getInscripcionesEd() {
		return inscripcionesEd;
	}

	public void setInscripcionesEd(List<InscripcionEd> inscripcionesEd) {
		this.inscripcionesEd = inscripcionesEd;
	}

	public List<InscripcionPF> getInscripcionesPF() {
		return inscripcionesPF;
	}

	public void setInscripcionesPF(List<InscripcionPF> inscripcionesPF) {
		this.inscripcionesPF = inscripcionesPF;
	}
	
	
	
	
}