package publicadores;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatype.DtCurso;
import datatype.DtProgFormacion;
import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;
import interfaces.IControladorBuscarCursoOPrograma;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorBuscarCursoOProgramaPublish {

	private Fabrica fabrica;
	private IControladorBuscarCursoOPrograma icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorBuscarCursoOProgramaPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorBuscarCursoOPrograma();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorBuscarCursoOPrograma", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorBuscarCursoOPrograma");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public DtCurso[] buscarCursos(String nombre){
		ArrayList<DtCurso> auxArrList = icon.buscarCursos(nombre);
		DtCurso[] auxArreglo = new DtCurso[auxArrList.size()];
		int i = 0;
		for(DtCurso c: auxArrList) {
			auxArreglo[i] = c;
			i++;
		}
		
		return auxArreglo;
		
	}	
	
	@WebMethod
	public DtProgFormacion[] buscarProgramas(String nombre){
		ArrayList<DtProgFormacion> auxArrList = icon.buscarProgramas(nombre);
		DtProgFormacion[] auxArreglo = new DtProgFormacion[auxArrList.size()];
		int i = 0;
		for(DtProgFormacion pf: auxArrList) {
			auxArreglo[i] = pf;
			i++;
		}
		
		return auxArreglo;
		
	}		
	
	@WebMethod
	public DtCurso[] ordenarCursosAlfabeticamente(ArrayList<DtCurso> cursos){
		
		ArrayList<DtCurso> auxArrList = icon.ordenarCursosAlfabeticamente(cursos);
		DtCurso[] auxArreglo = new DtCurso[auxArrList.size()];
		int i = 0;
		for(DtCurso c: auxArrList) {
			auxArreglo[i] = c;
			i++;
		}
		
		return auxArreglo;
		
	}
	
	@WebMethod
	public DtCurso[] ordenarCursosPorFecha(ArrayList<DtCurso> cursos){
		
		ArrayList<DtCurso> auxArrList = icon.ordenarCursosPorFecha(cursos);
		DtCurso[] auxArreglo = new DtCurso[auxArrList.size()];
		int i = 0;
		for(DtCurso c: auxArrList) {
			auxArreglo[i] = c;
			i++;
		}
		
		return auxArreglo;
		
		
	}
	
	@WebMethod
	public DtProgFormacion[] ordenarProgramasAlfabeticamente(ArrayList<DtProgFormacion> programas){
		ArrayList<DtProgFormacion> auxArrList = icon.ordenarProgramasAlfabeticamente(programas);
		DtProgFormacion[] auxArreglo = new DtProgFormacion[auxArrList.size()];
		int i = 0;
		for(DtProgFormacion pf: auxArrList) {
			auxArreglo[i] = pf;
			i++;
		}
		
		return auxArreglo;
		
	}
	
	@WebMethod
	public DtProgFormacion[] ordenarProgramasPorFecha(ArrayList<DtProgFormacion> programas){
		
		ArrayList<DtProgFormacion> auxArrList = icon.ordenarProgramasPorFecha(programas);
		DtProgFormacion[] auxArreglo = new DtProgFormacion[auxArrList.size()];
		int i = 0;
		for(DtProgFormacion pf: auxArrList) {
			auxArreglo[i] = pf;
			i++;
		}
		
		return auxArreglo;
	}

}
