package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatype.DtProgFormacion;
import excepciones.ProgramaRepetidoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaProgFormacion;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorAltaProgFormacionPublish {

	private Fabrica fabrica;
	private IControladorAltaProgFormacion icon;
	private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;

	public ControladorAltaProgFormacionPublish() {
		fabrica = Fabrica.getInstancia();
		icon = fabrica.getIControladorAltaProgFormacion();
		try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}
	}

	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAltaProgFormacion", this);
		System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAltaProgFormacion");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
        return endpoint;
	}
	
	@WebMethod
	public void ingresarProgFormacion(DtProgFormacion programa) throws ProgramaRepetidoException{
		icon.ingresarProgFormacion(programa);
	}
	
	@WebMethod
	public void confirmarAltaPrograma(){
		icon.confirmarAltaPrograma();
	}
	
	@WebMethod
	public void cancelarAltaPrograma(){
		icon.cancelarAltaPrograma();
		
	}

	
	
}
