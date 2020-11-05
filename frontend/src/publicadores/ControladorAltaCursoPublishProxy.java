package publicadores;

public class ControladorAltaCursoPublishProxy implements publicadores.ControladorAltaCursoPublish {
  private String _endpoint = null;
  private publicadores.ControladorAltaCursoPublish controladorAltaCursoPublish = null;
  
  public ControladorAltaCursoPublishProxy() {
    _initControladorAltaCursoPublishProxy();
  }
  
  public ControladorAltaCursoPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorAltaCursoPublishProxy();
  }
  
  private void _initControladorAltaCursoPublishProxy() {
    try {
      controladorAltaCursoPublish = (new publicadores.ControladorAltaCursoPublishServiceLocator()).getControladorAltaCursoPublishPort();
      if (controladorAltaCursoPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorAltaCursoPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorAltaCursoPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorAltaCursoPublish != null)
      ((javax.xml.rpc.Stub)controladorAltaCursoPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorAltaCursoPublish getControladorAltaCursoPublish() {
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    return controladorAltaCursoPublish;
  }
  
  public java.lang.String[] getCursos() throws java.rmi.RemoteException{
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    return controladorAltaCursoPublish.getCursos();
  }
  
  public java.lang.String[] getCategorias() throws java.rmi.RemoteException{
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    return controladorAltaCursoPublish.getCategorias();
  }
  
  public void ingresarCurso(java.lang.String arg0, publicadores.DtCurso arg1) throws java.rmi.RemoteException, publicadores.NoExisteInstitutoException, publicadores.NoExisteCursoException, publicadores.CursoRepetidoException{
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    controladorAltaCursoPublish.ingresarCurso(arg0, arg1);
  }
  
  public void confirmarAltaCurso() throws java.rmi.RemoteException{
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    controladorAltaCursoPublish.confirmarAltaCurso();
  }
  
  public void cancelarAltaCurso() throws java.rmi.RemoteException{
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    controladorAltaCursoPublish.cancelarAltaCurso();
  }
  
  public java.lang.String[] getInstitutos() throws java.rmi.RemoteException{
    if (controladorAltaCursoPublish == null)
      _initControladorAltaCursoPublishProxy();
    return controladorAltaCursoPublish.getInstitutos();
  }
  
  
}