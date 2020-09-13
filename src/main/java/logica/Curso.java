package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class Curso {
	@Id
	private String nombre;
	private String descripcion;
	private int duracion;
	private int cantHoras;
	private int creditos;
	private Date fechaR;
	private String url;
	
	
	@ManyToMany
	private List<Curso> misPrevias = new ArrayList<Curso>();
	

	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Edicion> ediciones = new ArrayList<Edicion>();
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<ProgFormacion> programas = new ArrayList<ProgFormacion>();
	
	/*public boolean existeCurso(String curso) {};
	public DtCursoExp obtenerDatos() {};
	public boolean tieneProgFormacion(String progFormacion) {};
	public List<String> obtenerEdiciones(){};
	public boolean existeCursoAsociado(String edicion) {};
	public void agregarAPF(ProgFormacion pf) {};
	public boolean estaAsociado(String nombre) {};
	public boolean tieneLink(String programa) {};
	public String obtenerNombreEdicionVigente() {};*/
	
	public Curso() {
		super();
	}
	
	public Curso(String nombre, String desc, int duracion, int cantHoras, int creditos, Date fechaR,
			String url, List<Curso> previas, List<Edicion> ediciones, List<ProgFormacion> programas) {
		super();
		this.nombre = nombre;
		this.descripcion = desc;
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		this.url = url;
		this.misPrevias = previas;
		this.ediciones = ediciones;
		this.programas = programas;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String desc) {
		this.descripcion = desc;
	}
	
	public int getDuracion() {
		return duracion;
	}
	
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
	public int getCantHoras() {
		return cantHoras;
	}
	
	public void setCantHoras(int cantHoras) {
		this.cantHoras = cantHoras;
	}
	
	public int getCreditos() {
		return creditos;
	}
	
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	public Date getFechaR() {
		return fechaR;
	}
	
	public void setFechaR(Date fechaR) {
		this.fechaR = fechaR;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public List<Curso> getMisPrevias() {
		return misPrevias;
	}
	
	public void setMisPrevias(List<Curso> cursos) {
		this.misPrevias = cursos;
	}
	
	public List<Edicion> getEdiciones() {
		return ediciones;
	}
	
	public void setEdiciones(List<Edicion> ediciones) {
		this.ediciones = ediciones;
	}
	
	public void agregarEdicion(Edicion aux) {
		this.ediciones.add(aux);
	}
	
	
	public List<ProgFormacion> getProgramas() {
		return programas;
	}
	
	public void setProgramas(List<ProgFormacion> programas) {
		this.programas = programas;
	}

	/*public List<Curso> getSoyPreviaDe() {
		return soyPreviaDe;
	}

	public void setSoyPreviaDe(List<Curso> soyPreviaDe) {
		this.soyPreviaDe = soyPreviaDe;
	};*/
	
	
	
	
	

}
