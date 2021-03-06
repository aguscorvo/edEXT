package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatype.DtDocente;
import datatype.DtEstudiante;
import datatype.DtUsuario;
import excepciones.NoExisteInstitutoException;
import excepciones.UsuarioRepetidoException;
import excepciones.UsuarioRepetidoExceptionMail;
import excepciones.UsuarioRepetidoExceptionNick;
import interfaces.Fabrica;
import interfaces.IControladorAltaUsuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorAltaUsuarioPublish {
			
		private Fabrica fabrica;
		private IControladorAltaUsuario icon;
		private WebServiceConfiguracion configuracion;
		private Endpoint endpoint;

		public ControladorAltaUsuarioPublish() {
			fabrica = Fabrica.getInstancia();
			icon = fabrica.getIControladorAltaUsuario();
			try {
				configuracion = new WebServiceConfiguracion();
			} catch (Exception ex) {
				
			}
		}

		@WebMethod(exclude = true)
		public void publicar() {
			endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAltaUsuario", this);
			System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAltaUsuario");
		}
		
		@WebMethod(exclude = true)
		public Endpoint getEndpoint() {
	        return endpoint;
		}
		
		@WebMethod
		public void ingresarDtUsuario(DtUsuario usuario) throws UsuarioRepetidoException{
			icon.ingresarDtUsuario(usuario);
		}
		
		@WebMethod
		public void ingresarDtUsuarioFrontEnd(DtUsuario usuario) throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
			icon.ingresarDtUsuarioFrontEnd(usuario);
		}
		
		@WebMethod
		public void ingresarDtEstudianteFrontEnd(DtEstudiante estudiante) throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
			icon.ingresarDtEstudianteFrontEnd(estudiante);
		}
		
		@WebMethod
		public void ingresarDtDocenteFrontEnd(DtDocente docente) throws UsuarioRepetidoExceptionNick, UsuarioRepetidoExceptionMail{
			icon.ingresarDtDocenteFrontEnd(docente);
		}
		
		@WebMethod
		public void confirmarAltaUsuario() throws NoExisteInstitutoException{
			icon.confirmarAltaUsuario();
		}
		
		@WebMethod
		public void cancelarAltaUsuario() {
			icon.cancelarAltaUsuario();
		}
		
		@WebMethod
		public String[] getInstitutos() {
			return icon.getInstitutos();
		}
		
		@WebMethod
		public boolean existeUsuarioNick(String nick) {
			return icon.existeUsuarioNick(nick);
		}
		
		@WebMethod
		public boolean existeUsuarioCorreo(String correo) {
			return icon.existeUsuarioCorreo(correo);
		}

}
