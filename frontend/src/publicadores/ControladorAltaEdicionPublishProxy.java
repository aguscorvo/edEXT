package publicadores;

public class ControladorAltaEdicionPublishProxy implements publicadores.ControladorAltaEdicionPublish {
  private String _endpoint = null;
  private publicadores.ControladorAltaEdicionPublish controladorAltaEdicionPublish = null;
  
  public ControladorAltaEdicionPublishProxy() {
    _initControladorAltaEdicionPublishProxy();
  }
  
  public ControladorAltaEdicionPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorAltaEdicionPublishProxy();
  }
  
  private void _initControladorAltaEdicionPublishProxy() {
    try {
      controladorAltaEdicionPublish = (new publicadores.ControladorAltaEdicionPublishServiceLocator()).getControladorAltaEdicionPublishPort();
      if (controladorAltaEdicionPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorAltaEdicionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorAltaEdicionPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorAltaEdicionPublish != null)
      ((javax.xml.rpc.Stub)controladorAltaEdicionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorAltaEdicionPublish getControladorAltaEdicionPublish() {
    if (controladorAltaEdicionPublish == null)
      _initControladorAltaEdicionPublishProxy();
    return controladorAltaEdicionPublish;
  }
  
  public java.lang.String[] getCursosNueva(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorAltaEdicionPublish == null)
      _initControladorAltaEdicionPublishProxy();
    return controladorAltaEdicionPublish.getCursosNueva(arg0);
  }
  
  public java.lang.String[] getCursos(publicadores.Instituto arg0) throws java.rmi.RemoteException{
    if (controladorAltaEdicionPublish == null)
      _initControladorAltaEdicionPublishProxy();
    return controladorAltaEdicionPublish.getCursos(arg0);
  }
  
  public java.lang.String[] ingresarInstituto(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.NoExisteInstitutoException{
    if (controladorAltaEdicionPublish == null)
      _initControladorAltaEdicionPublishProxy();
    return controladorAltaEdicionPublish.ingresarInstituto(arg0);
  }
  
  public java.lang.String[] getInstitutos() throws java.rmi.RemoteException{
    if (controladorAltaEdicionPublish == null)
      _initControladorAltaEdicionPublishProxy();
    return controladorAltaEdicionPublish.getInstitutos();
  }
  
  public void seleccionarCurso(java.lang.String arg0) throws java.rmi.RemoteException, publicadores.NoExisteCursoException{
    if (controladorAltaEdicionPublish == null)
      _initControladorAltaEdicionPublishProxy();
    controladorAltaEdicionPublish.seleccionarCurso(arg0);
  }
  
  public void ingresarDtEdicion(publicadores.DtEdicionExp arg0) throws java.rmi.RemoteException, publicadores.EdicionRepetidaException{
    if (controladorAltaEdicionPublish == null)
      _initControladorAltaEdicionPublishProxy();
    controladorAltaEdicionPublish.ingresarDtEdicion(arg0);
  }
  
  public void confirmarAltaEdicion() throws java.rmi.RemoteException{
    if (controladorAltaEdicionPublish == null)
      _initControladorAltaEdicionPublishProxy();
    controladorAltaEdicionPublish.confirmarAltaEdicion();
  }
  
  public void cancelarAltaEdicion() throws java.rmi.RemoteException{
    if (controladorAltaEdicionPublish == null)
      _initControladorAltaEdicionPublishProxy();
    controladorAltaEdicionPublish.cancelarAltaEdicion();
  }
  
  public boolean existeInstituto(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorAltaEdicionPublish == null)
      _initControladorAltaEdicionPublishProxy();
    return controladorAltaEdicionPublish.existeInstituto(arg0);
  }
  
  public publicadores.Instituto getInstituto(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorAltaEdicionPublish == null)
      _initControladorAltaEdicionPublishProxy();
    return controladorAltaEdicionPublish.getInstituto(arg0);
  }
  
  public java.lang.String[] getDocentes() throws java.rmi.RemoteException{
    if (controladorAltaEdicionPublish == null)
      _initControladorAltaEdicionPublishProxy();
    return controladorAltaEdicionPublish.getDocentes();
  }
  
  
}