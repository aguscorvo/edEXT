package datatype;

public class DtProgFormacion extends DtProgFormacionMin {
	private DtFecha fechaI;
	private DtFecha fechaF;
	private DtFecha fechaAlta;
	
	public DtProgFormacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DtProgFormacion(String nombre, String desc, DtFecha fechaI, DtFecha fechaF, DtFecha fechaAlta) {
		super(nombre, desc);
		this.fechaI = fechaI;
		this.fechaF = fechaF;
		this.fechaAlta = fechaAlta;
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
