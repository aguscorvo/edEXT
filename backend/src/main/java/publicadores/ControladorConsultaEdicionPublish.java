package publicadores;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatype.DtEdicion;
import interfaces.Fabrica;
import interfaces.IControladorConsultaEdicion;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorConsultaEdicionPublish {

	private Fabrica fabrica;
	private IControladorConsultaEdicion icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorConsultaEdicionPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorConsultaEdicion();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaEdicion", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaEdicion");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public String[] ingresarInstituto(String instituto){
		List<String> auxLista = icon.ingresarInstituto(instituto);
		String[] auxArreglo = new String[auxLista.size()];
		int i = 0;
		for(String c: auxLista) {
			auxArreglo[i] = c;
			i++;
		}
		return auxArreglo;
	}
	
	@WebMethod
	public String[] ingresarCurso(String curso) {
		List<String> auxLista = icon.ingresarCurso(curso);
		String[] auxArreglo = new String[auxLista.size()];
		int i = 0;
		for(String s: auxLista) {
			auxArreglo[i] = s;
			i++;
		}
		return auxArreglo;
	}
	
	@WebMethod
	public DtEdicion ingresarEdicion(String edicion) {
		return icon.ingresarEdicion(edicion);
	}
	
	@WebMethod
	public String[] getInstitutos() {
		return icon.getInstitutos();
	}
	
	@WebMethod
	public String[] getCategoriasGlobal() {
		return icon.getCategoriasGlobal();
	}
	
	@WebMethod
	public String[] getCursos(String instituto) {
		return icon.getCursos(instituto);
	}
	
	@WebMethod
	public String[] getCursosPorCategoria(String categoria) {
		return icon.getCursosPorCategoria(categoria);
	}
	
	@WebMethod
	public String[] getEdiciones(String curso) {
		return icon.getEdiciones(curso);
	}
	
	@WebMethod
	public String getDocentesAsignados(String edicion) {
		return icon.getDocentesAsignados(edicion);
	}
	
	@WebMethod
	public String obtenerDatosBasicosEd(String edicion) {
		return icon.obtenerDatosBasicosEd(edicion);
	}
	
	@WebMethod
	public String obtenerDatosEdicion(DtEdicion edicion) {
		return icon.obtenerDatosEdicion(edicion);
	}
	
	@WebMethod
	public DtEdicion getDatosEdicion() {
		return icon.getDatosEdicion();
	}
	
	@WebMethod
	public void setDatosEdicion(DtEdicion datosEdicion) {
		icon.setDatosEdicion(datosEdicion);
	}

	
	
}
