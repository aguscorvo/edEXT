package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Docente extends Usuario {
	@ManyToOne
	private Instituto instituto;
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Edicion> ediciones = new ArrayList<Edicion>();

	//@Override
	//public DtDocente obtenerDtUsuario() {}
	
	//public boolean estaAsociado(String nombre) {}

	public Docente(String nick, String nombre, String apellido, String correo, Date fechaNac, String password, Instituto instituto, List<Edicion> ediciones) {
		super(nick, nombre, apellido, correo, fechaNac, password);
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


