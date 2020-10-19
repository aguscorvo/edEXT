package logica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import datatype.EstadoInscripcion;
import persistencia.InscripcionIdEd;

@Entity
@IdClass(InscripcionIdEd.class)
public class InscripcionEd {
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Enumerated(EnumType.STRING)
	private EstadoInscripcion estado;
	
	int IPR;
	
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
	}

	public InscripcionEd(Date fecha, EstadoInscripcion estado, int IPR, Edicion edicion) {
		super();
		this.fecha = fecha;
		this.estado = estado;
		this.IPR = IPR;
		this.edicion = edicion;
	}

	public EstadoInscripcion getEstado() {
		return estado;
	}

	public void setEstado(EstadoInscripcion estado) {
		this.estado = estado;
	}

	public int getIPR() {
		return IPR;
	}

	public void setIPR(int iPR) {
		IPR = iPR;
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
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	};
	
	
	
}
