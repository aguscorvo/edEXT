package logica;

import java.util.Date;


public class InscripcionPF {
	
	private Date fecha;
	
	private ProgFormacion progFormacion;
	
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
