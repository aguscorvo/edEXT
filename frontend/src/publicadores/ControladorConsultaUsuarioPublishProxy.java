package publicadores;

public class ControladorConsultaUsuarioPublishProxy implements publicadores.ControladorConsultaUsuarioPublish {
  private String _endpoint = null;
  private publicadores.ControladorConsultaUsuarioPublish controladorConsultaUsuarioPublish = null;
  
  public ControladorConsultaUsuarioPublishProxy() {
    _initControladorConsultaUsuarioPublishProxy();
  }
  
  public ControladorConsultaUsuarioPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorConsultaUsuarioPublishProxy();
  }
  
  private void _initControladorConsultaUsuarioPublishProxy() {
    try {
      controladorConsultaUsuarioPublish = (new publicadores.ControladorConsultaUsuarioPublishServiceLocator()).getControladorConsultaUsuarioPublishPort();
      if (controladorConsultaUsuarioPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorConsultaUsuarioPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorConsultaUsuarioPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorConsultaUsuarioPublish != null)
      ((javax.xml.rpc.Stub)controladorConsultaUsuarioPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorConsultaUsuarioPublish getControladorConsultaUsuarioPublish() {
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish;
  }
  
  public java.lang.String[] getEdicionesInscRechazadas(publicadores.DtUsuario arg0) throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.getEdicionesInscRechazadas(arg0);
  }
  
  public java.lang.String[] getProgramasNueva(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.getProgramasNueva(arg0);
  }
  
  public java.lang.String tipoUsuarioSeleccionado(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.tipoUsuarioSeleccionado(arg0);
  }
  
  public java.lang.String getEstudiantesAceptadosAEdicion(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.getEstudiantesAceptadosAEdicion(arg0);
  }
  
  public publicadores.DtEdicion seleccionarEdicion(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.seleccionarEdicion(arg0);
  }
  
  public java.lang.String obtenerDatosPrograma(publicadores.DtProgFormacionExp arg0) throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.obtenerDatosPrograma(arg0);
  }
  
  public java.lang.String[] getEdiciones(publicadores.DtUsuario arg0) throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.getEdiciones(arg0);
  }
  
  public publicadores.DtUsuario seleccionarUsuario(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.seleccionarUsuario(arg0);
  }
  
  public java.lang.String[] getUsuarios() throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.getUsuarios();
  }
  
  public java.lang.String obtenerDatosUsuario(publicadores.DtUsuario arg0) throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.obtenerDatosUsuario(arg0);
  }
  
  public publicadores.DtProgFormacionExp seleccionarPrograma(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.seleccionarPrograma(arg0);
  }
  
  public java.lang.String[] getProgramas(publicadores.DtUsuario arg0) throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.getProgramas(arg0);
  }
  
  public java.lang.String obtenerDatosEdicion(publicadores.DtEdicion arg0) throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.obtenerDatosEdicion(arg0);
  }
  
  public java.lang.String[] getEdicionesInscRechazadasNueva(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaUsuarioPublish == null)
      _initControladorConsultaUsuarioPublishProxy();
    return controladorConsultaUsuarioPublish.getEdicionesInscRechazadasNueva(arg0);
  }
  
  
}