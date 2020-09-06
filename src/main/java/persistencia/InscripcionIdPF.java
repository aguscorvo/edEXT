package persistencia;

import java.io.Serializable;

public class InscripcionIdPF implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String estudiante;
	private String progFormacion;
	
	public InscripcionIdPF() {
		super();
	}

	public String getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(String estudiante) {
		this.estudiante = estudiante;
	}

	public String getProgFormacion() {
		return progFormacion;
	}

	public void setProgFormacion(String progFormacion) {
		this.progFormacion = progFormacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estudiante == null) ? 0 : estudiante.hashCode());
		result = prime * result + ((progFormacion == null) ? 0 : progFormacion.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InscripcionIdPF other = (InscripcionIdPF) obj;
		if (estudiante == null) {
			if (other.estudiante != null)
				return false;
		} else if (!estudiante.equals(other.estudiante))
			return false;
		if (progFormacion == null) {
			if (other.progFormacion != null)
				return false;
		} else if (!progFormacion.equals(other.progFormacion))
			return false;
		return true;
	}
	
	
	
	

}
