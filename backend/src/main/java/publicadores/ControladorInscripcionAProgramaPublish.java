package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import interfaces.Fabrica;
import interfaces.IControladorInscripcionAPrograma;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorInscripcionAProgramaPublish {
	
	private Fabrica fabrica;
	private IControladorInscripcionAPrograma icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorInscripcionAProgramaPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorInscripcionAPrograma();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorInscripcionAPrograma", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorInscripcionAPrograma");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public String[] getProgramas() {
		return icon.getProgramas();
	}
	
	@WebMethod
	public boolean confirmarInscripcion (String nick, String programa) {
		return icon.confirmarInscripcion(nick, programa);
	}

}
