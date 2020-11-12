package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatype.DtUsuario;
import interfaces.Fabrica;
import interfaces.IControladorModificarDatosUsuario;


@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorModificarDatosUsuarioPublish {
	
	private Fabrica fabrica;
	private IControladorModificarDatosUsuario icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorModificarDatosUsuarioPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorModificarDatosUsuario();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorModificarDatosUsuario", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorModificarDatosUsuario");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	

	@WebMethod
	public String [] getUsuarios() {
		return icon.getUsuarios();
	}
	
	@WebMethod
	public DtUsuario seleccionarUsuario(String nick) {
		return icon.seleccionarUsuario(nick);
	}
	
	@WebMethod
	public void modificarDatosUsuario(DtUsuario datos) {
		icon.modificarDatosUsuario(datos);
	}
	
}
