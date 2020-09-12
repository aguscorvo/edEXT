package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class ProgFormacion {
	@Id
	private String nombre;
	private String descPF;
	private Date fechaI;
	private Date fechaF;
	private Date fechaAlta;
	
	@OneToMany(mappedBy = "progFormacion", cascade=CascadeType.ALL)
	private List <InscripcionPF> inscripcionesPF = new ArrayList<InscripcionPF>();
	
	//public DtProgFormacionExp obtenerDatos() {};
	//public boolean esProgFormacion(String progFormacion) {};
	//public DtProgFormacionMin obtenerDtPM() {};
	
	public ProgFormacion() {
		super();
	}
	
	public ProgFormacion(String nombre, String desc, Date fechaI, Date fechaF, Date fechaAlta) {
		super();
		this.nombre = nombre;
		this.descPF = desc;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.fechaAlta = fechaAlta;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescPF() {
		return descPF;
	}
	
	public void setDescPF(String desc) {
		this.descPF = desc;
	}
	public Date getFechaI() {
		return fechaI;
	}
	
	public void setFechaI(Date fechaI) {
		this.fechaI = fechaI;
	}
	
	public Date getFechaF() {
		return fechaF;
	}
	
	public void setFechaF(Date fechaF) {
		this.fechaF = fechaF;
	}
	
	public Date getFechaAlta() {
		return fechaAlta;
	}
	
	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public List<InscripcionPF> getInscripcionesPF() {
		return inscripcionesPF;
	}

	public void setInscripcionesPF(List<InscripcionPF> inscripcionesPF) {
		this.inscripcionesPF = inscripcionesPF;
		for (InscripcionPF ipf: this.inscripcionesPF) {
			ipf.setProgFormacion(this);
		}
	}
	
	
	
}
