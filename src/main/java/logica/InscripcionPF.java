package logica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import datatype.DtProgFormacionMin;
import persistencia.InscripcionIdPF;

@Entity
@IdClass(InscripcionIdPF.class)
public class InscripcionPF {
	
	@Temporal(TemporalType.DATE)
	private Date fecha;
	
	@Id 
	@ManyToOne
	private ProgFormacion progFormacion;
	
	@Id 
	@ManyToOne
	private Estudiante estudiante;
	
	//public DtProgFormacionMin obtenerDtProgFormacionMin() {}

	public InscripcionPF() {
		super();
	}

	public InscripcionPF(Date fecha, ProgFormacion progFormacion) {
		super();
		this.fecha = fecha;
		this.progFormacion = progFormacion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public ProgFormacion getProgFormacion() {
		return progFormacion;
	}

	public void setProgFormacion(ProgFormacion progFormacion) {
		this.progFormacion = progFormacion;
	};
	
	
}
