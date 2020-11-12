package publicadores;

public class ControladorModificarDatosUsuarioPublishProxy implements publicadores.ControladorModificarDatosUsuarioPublish {
  private String _endpoint = null;
  private publicadores.ControladorModificarDatosUsuarioPublish controladorModificarDatosUsuarioPublish = null;
  
  public ControladorModificarDatosUsuarioPublishProxy() {
    _initControladorModificarDatosUsuarioPublishProxy();
  }
  
  public ControladorModificarDatosUsuarioPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorModificarDatosUsuarioPublishProxy();
  }
  
  private void _initControladorModificarDatosUsuarioPublishProxy() {
    try {
      controladorModificarDatosUsuarioPublish = (new publicadores.ControladorModificarDatosUsuarioPublishServiceLocator()).getControladorModificarDatosUsuarioPublishPort();
      if (controladorModificarDatosUsuarioPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorModificarDatosUsuarioPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorModificarDatosUsuarioPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorModificarDatosUsuarioPublish != null)
      ((javax.xml.rpc.Stub)controladorModificarDatosUsuarioPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorModificarDatosUsuarioPublish getControladorModificarDatosUsuarioPublish() {
    if (controladorModificarDatosUsuarioPublish == null)
      _initControladorModificarDatosUsuarioPublishProxy();
    return controladorModificarDatosUsuarioPublish;
  }
  
  public void modificarDatosUsuario(publicadores.DtUsuario arg0) throws java.rmi.RemoteException{
    if (controladorModificarDatosUsuarioPublish == null)
      _initControladorModificarDatosUsuarioPublishProxy();
    controladorModificarDatosUsuarioPublish.modificarDatosUsuario(arg0);
  }
  
  public publicadores.DtUsuario seleccionarUsuario(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorModificarDatosUsuarioPublish == null)
      _initControladorModificarDatosUsuarioPublishProxy();
    return controladorModificarDatosUsuarioPublish.seleccionarUsuario(arg0);
  }
  
  public java.lang.String[] getUsuarios() throws java.rmi.RemoteException{
    if (controladorModificarDatosUsuarioPublish == null)
      _initControladorModificarDatosUsuarioPublishProxy();
    return controladorModificarDatosUsuarioPublish.getUsuarios();
  }
  
  
}