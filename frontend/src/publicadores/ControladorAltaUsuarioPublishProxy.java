package publicadores;

public class ControladorAltaUsuarioPublishProxy implements publicadores.ControladorAltaUsuarioPublish {
  private String _endpoint = null;
  private publicadores.ControladorAltaUsuarioPublish controladorAltaUsuarioPublish = null;
  
  public ControladorAltaUsuarioPublishProxy() {
    _initControladorAltaUsuarioPublishProxy();
  }
  
  public ControladorAltaUsuarioPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorAltaUsuarioPublishProxy();
  }
  
  private void _initControladorAltaUsuarioPublishProxy() {
    try {
      controladorAltaUsuarioPublish = (new publicadores.ControladorAltaUsuarioPublishServiceLocator()).getControladorAltaUsuarioPublishPort();
      if (controladorAltaUsuarioPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorAltaUsuarioPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorAltaUsuarioPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorAltaUsuarioPublish != null)
      ((javax.xml.rpc.Stub)controladorAltaUsuarioPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorAltaUsuarioPublish getControladorAltaUsuarioPublish() {
    if (controladorAltaUsuarioPublish == null)
      _initControladorAltaUsuarioPublishProxy();
    return controladorAltaUsuarioPublish;
  }
  
  public void ingresarDtUsuarioFrontEnd(publicadores.DtUsuario arg0) throws java.rmi.RemoteException, publicadores.UsuarioRepetidoExceptionNick, publicadores.UsuarioRepetidoExceptionMail{
    if (controladorAltaUsuarioPublish == null)
      _initControladorAltaUsuarioPublishProxy();
    controladorAltaUsuarioPublish.ingresarDtUsuarioFrontEnd(arg0);
  }
  
  public void ingresarDtEstudianteFrontEnd(publicadores.DtEstudiante arg0) throws java.rmi.RemoteException, publicadores.UsuarioRepetidoExceptionNick, publicadores.UsuarioRepetidoExceptionMail{
    if (controladorAltaUsuarioPublish == null)
      _initControladorAltaUsuarioPublishProxy();
    controladorAltaUsuarioPublish.ingresarDtEstudianteFrontEnd(arg0);
  }
  
  public void ingresarDtDocenteFrontEnd(publicadores.DtDocente arg0) throws java.rmi.RemoteException, publicadores.UsuarioRepetidoExceptionNick, publicadores.UsuarioRepetidoExceptionMail{
    if (controladorAltaUsuarioPublish == null)
      _initControladorAltaUsuarioPublishProxy();
    controladorAltaUsuarioPublish.ingresarDtDocenteFrontEnd(arg0);
  }
  
  public void cancelarAltaUsuario() throws java.rmi.RemoteException{
    if (controladorAltaUsuarioPublish == null)
      _initControladorAltaUsuarioPublishProxy();
    controladorAltaUsuarioPublish.cancelarAltaUsuario();
  }
  
  public java.lang.String[] getInstitutos() throws java.rmi.RemoteException{
    if (controladorAltaUsuarioPublish == null)
      _initControladorAltaUsuarioPublishProxy();
    return controladorAltaUsuarioPublish.getInstitutos();
  }
  
  public void ingresarDtUsuario(publicadores.DtUsuario arg0) throws java.rmi.RemoteException, publicadores.UsuarioRepetidoException{
    if (controladorAltaUsuarioPublish == null)
      _initControladorAltaUsuarioPublishProxy();
    controladorAltaUsuarioPublish.ingresarDtUsuario(arg0);
  }
  
  public void confirmarAltaUsuario() throws java.rmi.RemoteException, publicadores.NoExisteInstitutoException{
    if (controladorAltaUsuarioPublish == null)
      _initControladorAltaUsuarioPublishProxy();
    controladorAltaUsuarioPublish.confirmarAltaUsuario();
  }
  
  
}