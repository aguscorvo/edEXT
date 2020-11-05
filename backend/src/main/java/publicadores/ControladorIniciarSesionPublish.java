package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatype.DtUsuarioLogueado;
import excepciones.ContraseniaIncorrectaException;
import excepciones.NoExisteUsuarioException;
import interfaces.Fabrica;
import interfaces.IControladorIniciarSesion;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorIniciarSesionPublish {
	
	private Fabrica fabrica;
	private IControladorIniciarSesion icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorIniciarSesionPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorIniciarSesion();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorIniciarSesion", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorIniciarSesion");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	

	@WebMethod
	public DtUsuarioLogueado iniciarSesion(String nickOEmail, String contraseña) throws NoExisteUsuarioException, ContraseniaIncorrectaException{
		return icon.iniciarSesion(nickOEmail, contraseña);
		
	}
	
	
	

}
