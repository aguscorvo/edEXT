package datatype;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DtCurso {
	private String nombre;
	private String desc;
	private String duracion;
	private DtTime cantHoras;
	private int creditos;
	private Date fechaR;
	private String url;	
	private List<String> previas = new ArrayList<String>(); // ver distintos contenedores
	
	public DtCurso() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DtCurso(String nombre, String desc, String duracion, DtTime cantHoras, int creditos, Date fechaR,
			String url, List<String> previas) {
		super();
		this.nombre = nombre;
		this.desc = desc;
		this.duracion = duracion;
		this.cantHoras = cantHoras;
		this.creditos = creditos;
		this.fechaR = fechaR;
		this.url = url;
		this.previas = previas;
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

	public List<String> getPrevias() {
		return previas;
	}

	public void setPrevias(List<String> previas) {
		this.previas = previas;
	}
	
	
	
}
