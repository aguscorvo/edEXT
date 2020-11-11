package publicadores;

public class ControladorSeguirUsuariosPublishProxy implements publicadores.ControladorSeguirUsuariosPublish {
  private String _endpoint = null;
  private publicadores.ControladorSeguirUsuariosPublish controladorSeguirUsuariosPublish = null;
  
  public ControladorSeguirUsuariosPublishProxy() {
    _initControladorSeguirUsuariosPublishProxy();
  }
  
  public ControladorSeguirUsuariosPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorSeguirUsuariosPublishProxy();
  }
  
  private void _initControladorSeguirUsuariosPublishProxy() {
    try {
      controladorSeguirUsuariosPublish = (new publicadores.ControladorSeguirUsuariosPublishServiceLocator()).getControladorSeguirUsuariosPublishPort();
      if (controladorSeguirUsuariosPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorSeguirUsuariosPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorSeguirUsuariosPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorSeguirUsuariosPublish != null)
      ((javax.xml.rpc.Stub)controladorSeguirUsuariosPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorSeguirUsuariosPublish getControladorSeguirUsuariosPublish() {
    if (controladorSeguirUsuariosPublish == null)
      _initControladorSeguirUsuariosPublishProxy();
    return controladorSeguirUsuariosPublish;
  }
  
  public void seguirUsuario(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorSeguirUsuariosPublish == null)
      _initControladorSeguirUsuariosPublishProxy();
    controladorSeguirUsuariosPublish.seguirUsuario(arg0, arg1);
  }
  
  public java.lang.String[] getUsuariosNoSeguidos(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorSeguirUsuariosPublish == null)
      _initControladorSeguirUsuariosPublishProxy();
    return controladorSeguirUsuariosPublish.getUsuariosNoSeguidos(arg0);
  }
  
  public java.lang.String[] getUsuariosSeguidos(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorSeguirUsuariosPublish == null)
      _initControladorSeguirUsuariosPublishProxy();
    return controladorSeguirUsuariosPublish.getUsuariosSeguidos(arg0);
  }
  
  public java.lang.String getCadenaUsuariosSeguidos(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorSeguirUsuariosPublish == null)
      _initControladorSeguirUsuariosPublishProxy();
    return controladorSeguirUsuariosPublish.getCadenaUsuariosSeguidos(arg0);
  }
  
  public java.lang.String getCadenaUsuariosSeguidores(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorSeguirUsuariosPublish == null)
      _initControladorSeguirUsuariosPublishProxy();
    return controladorSeguirUsuariosPublish.getCadenaUsuariosSeguidores(arg0);
  }
  
  public void noSeguirUsuario(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorSeguirUsuariosPublish == null)
      _initControladorSeguirUsuariosPublishProxy();
    controladorSeguirUsuariosPublish.noSeguirUsuario(arg0, arg1);
  }
  
  
}