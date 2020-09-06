package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Docente")

public class Docente extends Usuario {
	private Instituto instituto;
	
	private List<Edicion> ediciones = new ArrayList<Edicion>();

	//@Override
	//public DtDocente obtenerDtUsuario() {}
	
	//public boolean estaAsociado(String nombre) {}

	public Docente(String nick, String nombre, String apellido, String correo, Date fechaNac, Instituto instituto, List<Edicion> ediciones) {
		super(nick, nombre, apellido, correo, fechaNac);
		this.instituto = instituto;
		this.ediciones = ediciones;
	}

	public Docente() {
		super();
	}

	public Instituto getInstituto() {
		return instituto;
	}

	public void setInstituto(Instituto instituto) {
		this.instituto = instituto;
	}

	public List<Edicion> getEdiciones() {
		return ediciones;
	}

	public void setEdiciones(List<Edicion> ediciones) {
		this.ediciones = ediciones;
	}
	
	

}


