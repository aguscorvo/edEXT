package datatype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DtProgFormacionExp extends DtProgFormacion{
	
	private List<String> cursos = new ArrayList<String>();

	public DtProgFormacionExp() {
		super();
	}

	public DtProgFormacionExp(String nombre, String desc, Date fechaI, Date fechaF, Date fechaAlta,
			List<String> cursos) {
		super(nombre, desc, fechaI, fechaF, fechaAlta);
		this.cursos = cursos;
	}

	public List<String> getCursos() {
		return cursos;
	}

	public void setCursos(List<String> cursos) {
		this.cursos = cursos;
	}
	
	
	

}
