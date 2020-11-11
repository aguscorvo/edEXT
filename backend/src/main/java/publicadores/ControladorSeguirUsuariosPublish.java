package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import interfaces.Fabrica;
import interfaces.IControladorSeguirUsuarios;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorSeguirUsuariosPublish {
	
	private Fabrica fabrica;
	private IControladorSeguirUsuarios icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorSeguirUsuariosPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIcontroladorSeguirUsuarios();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorSeguirUsuarios", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorSeguirUsuarios");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	

	@WebMethod
	public String [] getUsuariosNoSeguidos (String usuario) {
		return icon.getUsuariosNoSeguidos(usuario);
	}
	
	@WebMethod
	public String [] getUsuariosSeguidos (String usuario) {
		return icon.getUsuariosSeguidos(usuario);
	}
	
	@WebMethod
	public String getCadenaUsuariosSeguidos (String usuario) {
		return icon.getCadenaUsuariosSeguidos(usuario);
	}
	
	@WebMethod
	public String getCadenaUsuariosSeguidores (String usuario) {
		return icon.getCadenaUsuariosSeguidores(usuario);
	}
	
	@WebMethod
	public void seguirUsuario (String usuario, String usuarioASeguir) {
		icon.seguirUsuario(usuario, usuarioASeguir);
	}
	
	@WebMethod
	public void noSeguirUsuario (String usuario, String usuarioNoSeguir) {
		icon.noSeguirUsuario(usuario, usuarioNoSeguir);
	}
	

}
