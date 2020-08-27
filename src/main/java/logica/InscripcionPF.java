package logica;

import datatype.DtFecha; 
import datatype.DtProgFormacionMin;

public class InscripcionPF {
	
	private DtFecha fecha;
	
	private ProgFormacion progFormacion;
	
	public DtProgFormacionMin obtenerDtProgFormacionMin() {}

	public InscripcionPF() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InscripcionPF(DtFecha fecha, ProgFormacion progFormacion) {
		super();
		this.fecha = fecha;
		this.progFormacion = progFormacion;
	}

	public DtFecha getFecha() {
		return fecha;
	}

	public void setFecha(DtFecha fecha) {
		this.fecha = fecha;
	}

	public ProgFormacion getProgFormacion() {
		return progFormacion;
	}

	public void setProgFormacion(ProgFormacion progFormacion) {
		this.progFormacion = progFormacion;
	};
	
	
}
