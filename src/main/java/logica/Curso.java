package logica;

import datatype.*;
import java.util.ArrayList;
import java.util.List;

public class Curso {
	private String nombre;
	private String desc;
	private String duracion;
	private DtTime cantHoras;
	private int creditos;
	private DtFecha fechaR;
	private String url;
	
	private List<Curso> cursos = new ArrayList<Curso>();
	private List<Edicion> ediciones = new ArrayList<Edicion>();
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
		// TODO Auto-generated constructor stub
	}
	
	public Curso(String nombre, String desc, String duracion, DtTime cantHoras, int creditos, DtFecha fechaR,
			String url, List<Curso> cursos, List<Edicion> ediciones, List<ProgFormacion> programas) {
		super();
		this.nombre = nombre;
		this.desc = desc;
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		this.url = url;
		this.cursos = cursos;
		this.ediciones = ediciones;
		this.programas = programas;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDesc() {
		return desc;
	}
	
	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	public String getDuracion() {
		return duracion;
	}
	
	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}
	
	public DtTime getCantHoras() {
		return cantHoras;
	}
	
	public void setCantHoras(DtTime cantHoras) {
		this.cantHoras = cantHoras;
	}
	
	public int getCreditos() {
		return creditos;
	}
	
	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}
	
	public DtFecha getFechaR() {
		return fechaR;
	}
	
	public void setFechaR(DtFecha fechaR) {
		this.fechaR = fechaR;
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public List<Curso> getCursos() {
		return cursos;
	}
	
	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}
	
	public List<Edicion> getEdiciones() {
		return ediciones;
	}
	
	public void setEdiciones(List<Edicion> ediciones) {
		this.ediciones = ediciones;
	}
	
	public List<ProgFormacion> getProgramas() {
		return programas;
	}
	
	public void setProgramas(List<ProgFormacion> programas) {
		this.programas = programas;
	};
	
	
	
	

}
