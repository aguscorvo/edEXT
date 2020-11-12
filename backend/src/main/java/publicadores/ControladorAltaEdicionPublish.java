package publicadores;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatype.DtEdicionExp;
import excepciones.EdicionRepetidaException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaEdicion;
import logica.Instituto;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorAltaEdicionPublish {

	private Fabrica fabrica;
	private IControladorAltaEdicion icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorAltaEdicionPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaEdicion();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAltaEdicion", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAltaEdicion");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public String[] ingresarInstituto(String instituto) throws NoExisteInstitutoException{
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
	public void seleccionarCurso(String curso) throws NoExisteCursoException{
		icon.seleccionarCurso(curso);
	}
	
	@WebMethod
	public void ingresarDtEdicion(DtEdicionExp edicion) throws EdicionRepetidaException{
		icon.ingresarDtEdicion(edicion);
	}	
	
	@WebMethod
	public void confirmarAltaEdicion(){
		icon.confirmarAltaEdicion();
	}	
	
	@WebMethod
	public void cancelarAltaEdicion(){
		icon.cancelarAltaEdicion();
	}	
	
	@WebMethod
	public Instituto getInstituto(String nombre) {
		return icon.getInstituto(nombre);
	}
	
	@WebMethod
	public String[] getInstitutos() {
		return icon.getInstitutos();
	}
	
	@WebMethod
	public String[] getCursos(Instituto nombre) {
		return icon.getCursos(nombre);
		
	}
	
	@WebMethod
	public boolean existeInstituto(String nombre) {
		return icon.existeInstituto(nombre);
	}	
	
	@WebMethod
	public String [] getDocentes() {
		return icon.getDocentes();
		
	}
	
	@WebMethod
	public String [] getCursosNueva(String instituto) {//agregada por ultimo
		return icon.getCursosNueva(instituto);
	}

}