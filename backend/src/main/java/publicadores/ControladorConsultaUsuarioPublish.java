package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatype.DtEdicion;
import datatype.DtProgFormacionExp;
import datatype.DtUsuario;
import interfaces.Fabrica;
import interfaces.IControladorConsultaUsuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorConsultaUsuarioPublish {
	private Fabrica fabrica;
	private IControladorConsultaUsuario icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorConsultaUsuarioPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorConsultaUsuario();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaUsuario", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorConsultaUsuario");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public String[] getUsuarios() {
		return icon.getUsuarios();
	}
	
	@WebMethod
	public DtUsuario seleccionarUsuario(String nick) {
		return icon.seleccionarUsuario(nick);
	}
	
	@WebMethod
	public DtEdicion seleccionarEdicion(String nombre) {
		return icon.seleccionarEdicion(nombre);
	}
	
	@WebMethod
	public DtProgFormacionExp seleccionarPrograma(String programa) {
		return icon.seleccionarPrograma(programa);
	}
	
	@WebMethod
	public String obtenerDatosUsuario (DtUsuario usuario) {
		return icon.obtenerDatosUsuario(usuario);
	}
	
	@WebMethod
	public String obtenerDatosEdicion(DtEdicion edicion){
		return icon.obtenerDatosEdicion(edicion);
	}
	
	@WebMethod
	public String obtenerDatosPrograma(DtProgFormacionExp programa){
		return icon.obtenerDatosPrograma(programa);
	}
	
	@WebMethod
	public String [] getEdiciones(DtUsuario usuario){
		return icon.getEdiciones(usuario);
	}
	
	@WebMethod
	public String [] getEdicionesInscRechazadas(DtUsuario usuario){
		return icon.getEdicionesInscRechazadas(usuario);
	}
	
	@WebMethod
	public String[] getProgramas(DtUsuario usuario){
		return icon.getProgramas(usuario);
	}
	
	@WebMethod
	public String tipoUsuarioSeleccionado(String nick){
		return icon.tipoUsuarioSeleccionado(nick);
	}
	
	@WebMethod
	public String getEstudiantesAceptadosAEdicion(String edicion){
		return icon.getEstudiantesAceptadosAEdicion(edicion);
	}
	
}