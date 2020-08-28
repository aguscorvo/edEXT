package logica;

import datatype.DtFecha;
import datatype.DtProgFormacionExp;
import datatype.DtProgFormacionMin;

public class ProgFormacion {
	private String nombre;
	private String desc;
	private DtFecha fechaI;
	private DtFecha fechaF;
	private DtFecha fechaAlta;
	public DtProgFormacionExp obtenerDatos() {};
	public boolean esProgFormacion(String progFormacion) {};
	public DtProgFormacionMin obtenerDtPM() {};
	
	public ProgFormacion() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ProgFormacion(String nombre, String desc, DtFecha fechaI, DtFecha fechaF, DtFecha fechaAlta) {
		super();
		this.nombre = nombre;
		this.desc = desc;
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
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
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
	
	public DtFecha getFechaAlta() {
		return fechaAlta;
	}
	
	public void setFechaAlta(DtFecha fechaAlta) {
		this.fechaAlta = fechaAlta;
	}
	
	
}
