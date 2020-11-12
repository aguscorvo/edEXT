package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import interfaces.Fabrica;
import interfaces.IControladorListarResultadosInscripciones;



@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorListarResultadosInscripcionesPublish {
	
	private Fabrica fabrica;
	private IControladorListarResultadosInscripciones icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorListarResultadosInscripcionesPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorListarResultadosInscripciones();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorListarResultadosInscripciones", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorListarResultadosInscripciones");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	
	@WebMethod
	public String inscripcionesPendientes (String estudiante) {
		return icon.inscripcionesPendientes(estudiante);
	}
	
	@WebMethod
	public String inscripcionesRechazadas (String estudiante) {
		return icon.inscripcionesRechazadas(estudiante);
		
	}
	
	@WebMethod
	public String inscripcionesAceptadas (String estudiante) {
		return icon.inscripcionesAceptadas(estudiante);
	}
	
}
