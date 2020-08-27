package datatype;

public class DtDocente extends DtUsuario{
	private String instituto;
	
	public DtDocente() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public DtDocente(String nick, String nombre, String apellido, String correo, DtFecha fechaNac, String instituto) {
		super(nick, nombre, apellido, correo, fechaNac);
		this.instituto = instituto;
	}	

	public String getInstituto() {
		return instituto;
	}

	public void setInstituto(String instituto) {
		this.instituto = instituto;
	}

	
	
	
	
}
