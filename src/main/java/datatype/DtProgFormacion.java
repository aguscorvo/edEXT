package datatype;

import java.util.Date;

public class DtProgFormacion extends DtProgFormacionMin {
	private Date fechaI;
	private Date fechaF;
	private Date fechaAlta;
	
	public DtProgFormacion() {
		super();
	}

	public DtProgFormacion(String nombre, String desc, Date fechaI, Date fechaF, Date fechaAlta) {
		super(nombre, desc);
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.fechaAlta = fechaAlta;
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
	

	
}
