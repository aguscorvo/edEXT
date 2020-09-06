package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Edicion {
	@Id
	private String nombre;
	private Date fechaI;
	private Date fechaF;
	private int cupo;
	private Date fechaPub;
	
	@OneToMany(cascade=CascadeType.ALL)
	private List<InscripcionEd> inscripcionesEd = new ArrayList<InscripcionEd>();
	
	//public DtEdicion obtenerDatos() {};
	//public boolean existeEdicion(DtEdicionExp edicion) {};
	//public boolean esEdicion(String nombre) {};
	//public boolean esEdicionVigente() {};
	
	public Edicion() {
		super();
	}
	
	public Edicion(String nombre, Date fechaI, Date fechaF, int cupo, Date fechaPub) {
		super();
		this.nombre = nombre;
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.cupo = cupo;
		this.fechaPub = fechaPub;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	
	public int getCupo() {
		return cupo;
	}
	
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	
	public Date getFechaPub() {
		return fechaPub;
	}
	
	public void setFechaPub(Date fechaPub) {
		this.fechaPub = fechaPub;
	}
	
	
	
}
