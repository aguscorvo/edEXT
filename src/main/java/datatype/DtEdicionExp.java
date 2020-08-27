package datatype;

import java.util.ArrayList;
import java.util.List;

public class DtEdicionExp extends DtEdicion{
	private List<String> docentes = new ArrayList<String>();

	public DtEdicionExp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DtEdicionExp(String nombre, DtFecha fechaI, DtFecha fechaF, int cupo, DtFecha fechaPub,
			List<String> docentes) {
		super(nombre, fechaI, fechaF, cupo, fechaPub);
		this.docentes = docentes;
	}

	public List<String> getDocentes() {
		return docentes;
	}

	public void setDocentes(List<String> docentes) {
		this.docentes = docentes;
	}
	
	
	
}
