package publicadores;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

import configuraciones.WebServiceConfiguracion;
import datatype.DtCurso;
import excepciones.CursoRepetidoException;
import excepciones.NoExisteCursoException;
import excepciones.NoExisteInstitutoException;
import interfaces.Fabrica;
import interfaces.IControladorAltaCurso;
import interfaces.IControladorAltaUsuario;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle= ParameterStyle.WRAPPED)
public class ControladorAltaCursoPublish {
					
			private Fabrica fabrica;
			private IControladorAltaCurso icon;
			private WebServiceConfiguracion configuracion;
			private Endpoint endpoint;

			public ControladorAltaCursoPublish() {
				fabrica = Fabrica.getInstancia();
				icon = fabrica.getIControladorAltaCurso();
				try {
					configuracion = new WebServiceConfiguracion();
				} catch (Exception ex) {
					
				}
			}

			@WebMethod(exclude = true)
			public void publicar() {
				endpoint = Endpoint.publish("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAltaCurso", this);
				System.out.println("http://" + configuracion.getConfigOf("#WS_IP") + ":" + configuracion.getConfigOf("#WS_PORT") + "/controladorAltaCurso");
			}
			
			@WebMethod(exclude = true)
			public Endpoint getEndpoint() {
		        return endpoint;
			}
			
			@WebMethod
			public void ingresarCurso(String instituto, DtCurso curso) throws NoExisteInstitutoException, CursoRepetidoException, NoExisteCursoException {
				icon.ingresarCurso(instituto, curso);
			}
			
			@WebMethod
			public void confirmarAltaCurso() {
				icon.confirmarAltaCurso();
			}
			
			@WebMethod
			public void cancelarAltaCurso() {
				icon.cancelarAltaCurso();
			}
			
			@WebMethod
			public String[] getInstitutos() {
				return icon.getInstitutos();
			}
			
			@WebMethod
			public String [] getCursos() {
				return icon.getCursos();
			}
			
			@WebMethod
			public String [] getCategorias() {
				return icon.getCategorias();
			}
}
