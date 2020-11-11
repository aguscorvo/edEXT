package publicadores;

public class ControladorConsultaCursoPublishProxy implements publicadores.ControladorConsultaCursoPublish {
  private String _endpoint = null;
  private publicadores.ControladorConsultaCursoPublish controladorConsultaCursoPublish = null;
  
  public ControladorConsultaCursoPublishProxy() {
    _initControladorConsultaCursoPublishProxy();
  }
  
  public ControladorConsultaCursoPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorConsultaCursoPublishProxy();
  }
  
  private void _initControladorConsultaCursoPublishProxy() {
    try {
      controladorConsultaCursoPublish = (new publicadores.ControladorConsultaCursoPublishServiceLocator()).getControladorConsultaCursoPublishPort();
      if (controladorConsultaCursoPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorConsultaCursoPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorConsultaCursoPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorConsultaCursoPublish != null)
      ((javax.xml.rpc.Stub)controladorConsultaCursoPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorConsultaCursoPublish getControladorConsultaCursoPublish() {
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish;
  }
  
  public java.lang.String[] getCategoriasGlobal() throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.getCategoriasGlobal();
  }
  
  public java.lang.String[] getCursosPorCategoria(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.getCursosPorCategoria(arg0);
  }
  
  public java.lang.String[] getCategorias(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.getCategorias(arg0);
  }
  
  public java.lang.String[] ingresarInstituto(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.ingresarInstituto(arg0);
  }
  
  public publicadores.DtCursoExp seleccionarCurso(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.seleccionarCurso(arg0);
  }
  
  public java.lang.String obtenerDatosCurso(publicadores.DtCursoExp arg0) throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.obtenerDatosCurso(arg0);
  }
  
  public publicadores.DtEdicion seleccionarEdicion(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.seleccionarEdicion(arg0);
  }
  
  public publicadores.DtProgFormacionExp seleccionarProgFormacion(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.seleccionarProgFormacion(arg0);
  }
  
  public java.lang.String obtenerDatosPrograma(publicadores.DtProgFormacionExp arg0) throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.obtenerDatosPrograma(arg0);
  }
  
  public java.lang.String[] getPrevias(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.getPrevias(arg0);
  }
  
  public java.lang.String[] getPFs(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.getPFs(arg0);
  }
  
  public java.lang.String obtenerDatosEdicion(publicadores.DtEdicion arg0) throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.obtenerDatosEdicion(arg0);
  }
  
  public java.lang.String[] getInstitutos() throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.getInstitutos();
  }
  
  public java.lang.String[] getEdiciones(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaCursoPublish == null)
      _initControladorConsultaCursoPublishProxy();
    return controladorConsultaCursoPublish.getEdiciones(arg0);
  }
  
  
}