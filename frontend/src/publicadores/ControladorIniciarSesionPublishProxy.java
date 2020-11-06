package publicadores;

public class ControladorIniciarSesionPublishProxy implements publicadores.ControladorIniciarSesionPublish {
  private String _endpoint = null;
  private publicadores.ControladorIniciarSesionPublish controladorIniciarSesionPublish = null;
  
  public ControladorIniciarSesionPublishProxy() {
    _initControladorIniciarSesionPublishProxy();
  }
  
  public ControladorIniciarSesionPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorIniciarSesionPublishProxy();
  }
  
  private void _initControladorIniciarSesionPublishProxy() {
    try {
      controladorIniciarSesionPublish = (new publicadores.ControladorIniciarSesionPublishServiceLocator()).getControladorIniciarSesionPublishPort();
      if (controladorIniciarSesionPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorIniciarSesionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorIniciarSesionPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorIniciarSesionPublish != null)
      ((javax.xml.rpc.Stub)controladorIniciarSesionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorIniciarSesionPublish getControladorIniciarSesionPublish() {
    if (controladorIniciarSesionPublish == null)
      _initControladorIniciarSesionPublishProxy();
    return controladorIniciarSesionPublish;
  }
  
  public publicadores.DtUsuarioLogueado iniciarSesion(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, publicadores.NoExisteUsuarioException, publicadores.ContraseniaIncorrectaException{
    if (controladorIniciarSesionPublish == null)
      _initControladorIniciarSesionPublishProxy();
    return controladorIniciarSesionPublish.iniciarSesion(arg0, arg1);
  }
  
  
}