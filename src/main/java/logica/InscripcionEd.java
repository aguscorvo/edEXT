package logica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import persistencia.InscripcionIdEd;

@Entity
@IdClass(InscripcionIdEd.class)
public class InscripcionEd {
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Id 
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Edicion edicion;
	
	@Id 
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Estudiante estudiante;
	
	
	//public String obtenerEdicion() {}

	public InscripcionEd() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InscripcionEd(Date fecha, Edicion edicion) {
		super();
		this.fecha = fecha;
		this.edicion = edicion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Edicion getEdicion() {
		return edicion;
	}

	public void setEdicion(Edicion edicion) {
		this.edicion = edicion;
	};
	
	
}
