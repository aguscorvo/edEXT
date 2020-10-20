package datatype;

import java.util.Date;

public class DtUsuarioLogueado {
	private String nick;
	private String tipo;
	private String nombre;
	private String apellido;
	private Date fechaNac;
	private String password;
	
	
	public DtUsuarioLogueado() {
		super();
	}


	public DtUsuarioLogueado(String nick, String tipo, String nombre, String apellido, Date fechaNac, String password) {
		super();
		this.nick = nick;
		this.tipo = tipo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.fechaNac= fechaNac;
		this.password = password;
	}


	public Date getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}


	public String getNick() {
		return nick;
	}


	public void setNick(String nick) {
		this.nick = nick;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
}
