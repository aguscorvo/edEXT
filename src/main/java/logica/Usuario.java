package logica;

import datatype.DtFecha;
import datatype.DtUsuario;

public abstract class Usuario {
	private String nick; 
	private String nombre; 
	private String apellido; 
	private String correo; 
	private DtFecha fechaNac; 


	//public abstract DtUsuario obtenerDtUsuario();
	public boolean existeUsuario(DtUsuario usuario) {
		return false;}
	public void compararDatos(DtUsuario datos) {}
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(String nick, String nombre, String apellido, String correo, DtFecha fechaNac) {
		super();
		this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNac = fechaNac;
	}
	
	public String getNick() {
		return nick;
	}
	
	public void setNick(String nick) {
		this.nick = nick;
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
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public DtFecha getFechaNac() {
		return fechaNac;
	}
	
	public void setFechaNac(DtFecha fechaNac) {
		this.fechaNac = fechaNac;
	}
	
	
	
	
}
