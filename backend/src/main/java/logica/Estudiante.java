package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;



@Entity
public class Estudiante extends Usuario {
	
	@OneToMany(mappedBy="estudiante",cascade=CascadeType.ALL)
	private List<InscripcionEd> inscripcionesEd = new ArrayList<InscripcionEd>();
	@OneToMany(mappedBy="estudiante",cascade=CascadeType.ALL)
	private List<InscripcionPF> inscripcionesPF = new ArrayList<InscripcionPF>();
	
	//@Override
	//public DtEstudiante obtenerDtUsuario() {}
	
	//public boolean existeInscEdicion(String edicion) {}
	
	public void agregarInscripcion(InscripcionEd ie) {}

	public Estudiante() {
		super();
	}

	public Estudiante(String nick, String nombre, String apellido, String correo, Date fechaNac, String password,
			List<InscripcionEd> inscripcionesEd, List<InscripcionPF> inscripcionesPF) {
		super(nick, nombre, apellido, correo, fechaNac, password);
		this.inscripcionesEd = inscripcionesEd;
		this.inscripcionesPF = inscripcionesPF;
	}

	public List<InscripcionEd> getInscripcionesEd() {
		return inscripcionesEd;
	}

	public void setInscripcionesEd(List<InscripcionEd> inscripcionesEd) {
		this.inscripcionesEd = inscripcionesEd;
		for(InscripcionEd ie :this.inscripcionesEd) {
			ie.setEstudiante(this);
		}
	}

	public List<InscripcionPF> getInscripcionesPF() {
		return inscripcionesPF;
	
	}

	public void setInscripcionesPF(List<InscripcionPF> inscripcionesPF) {
		this.inscripcionesPF = inscripcionesPF;
		for(InscripcionPF ipf :this.inscripcionesPF) {
			ipf.setEstudiante(this);
		}
	}
	
	//Devuelve el pelotito inscripcionEd que se corresponde a la edición pasada como parámetro
	//Prec: Existe la asociación
	public InscripcionEd getInscEd (String edicion) {
		List<InscripcionEd> auxInsc = this.getInscripcionesEd();
		
		for (InscripcionEd i: auxInsc) {
			if (i.getEdicion().getNombreEd().equals(edicion)) {
				return i;
			}
		}
		return null;
		
	}
	
	public InscripcionPF getInscPF (String programa) {
		List<InscripcionPF> auxInsc = this.getInscripcionesPF();
		
		for (InscripcionPF i: auxInsc) {
			if (i.getProgFormacion().getNombre().equals(programa)) {
				return i;
			}
		}
		return null;
		
	}
	
	
	
}
