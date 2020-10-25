package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

import datatype.DtUsuario;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Usuario {
	@Id
	private String nick; 
	private String nombre; 
	private String apellido; 
	@Column(unique = true)
	private String correo; 
	private Date fechaNac; 
	private String password;
	
	@ManyToMany
	private List<Usuario> usuariosSeguidos = new ArrayList<Usuario>();
	
	//public abstract DtUsuario obtenerDtUsuario();
	public boolean existeUsuario(DtUsuario usuario) {
		return false;}
	public void compararDatos(DtUsuario datos) {}
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nick, String nombre, String apellido, String correo, Date fechaNac, String password) {
		super();
		this.nick = nick;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.fechaNac = fechaNac;
		this.password = password;
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
	
	public Date getFechaNac() {
		return fechaNac;
	}
	
	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public List<Usuario> getUsuariosSeguidos() {
		return usuariosSeguidos;
	}
	public void setUsuariosSeguidos(List<Usuario> usuariosSeguidos) {
		this.usuariosSeguidos = usuariosSeguidos;
	}
	
	
	
	
}
