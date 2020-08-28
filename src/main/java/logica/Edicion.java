package logica;

import datatype.*;


public class Edicion {
	private String nombre;
	private DtFecha fechaI;
	private DtFecha fechaF;
	private int cupo;
	private DtFecha fechaPub;
	//public DtEdicion obtenerDatos() {};
	//public boolean existeEdicion(DtEdicionExp edicion) {};
	//public boolean esEdicion(String nombre) {};
	//public boolean esEdicionVigente() {};
	
	public Edicion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Edicion(String nombre, DtFecha fechaI, DtFecha fechaF, int cupo, DtFecha fechaPub) {
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
	
	public DtFecha getFechaI() {
		return fechaI;
	}
	
	public void setFechaI(DtFecha fechaI) {
		this.fechaI = fechaI;
	}
	
	public DtFecha getFechaF() {
		return fechaF;
	}
	
	public void setFechaF(DtFecha fechaF) {
		this.fechaF = fechaF;
	}
	
	public int getCupo() {
		return cupo;
	}
	
	public void setCupo(int cupo) {
		this.cupo = cupo;
	}
	
	public DtFecha getFechaPub() {
		return fechaPub;
	}
	
	public void setFechaPub(DtFecha fechaPub) {
		this.fechaPub = fechaPub;
	}
	
	
	
}
