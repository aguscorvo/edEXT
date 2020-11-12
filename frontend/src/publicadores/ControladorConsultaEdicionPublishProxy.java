package publicadores;

public class ControladorConsultaEdicionPublishProxy implements publicadores.ControladorConsultaEdicionPublish {
  private String _endpoint = null;
  private publicadores.ControladorConsultaEdicionPublish controladorConsultaEdicionPublish = null;
  
  public ControladorConsultaEdicionPublishProxy() {
    _initControladorConsultaEdicionPublishProxy();
  }
  
  public ControladorConsultaEdicionPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorConsultaEdicionPublishProxy();
  }
  
  private void _initControladorConsultaEdicionPublishProxy() {
    try {
      controladorConsultaEdicionPublish = (new publicadores.ControladorConsultaEdicionPublishServiceLocator()).getControladorConsultaEdicionPublishPort();
      if (controladorConsultaEdicionPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorConsultaEdicionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorConsultaEdicionPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorConsultaEdicionPublish != null)
      ((javax.xml.rpc.Stub)controladorConsultaEdicionPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorConsultaEdicionPublish getControladorConsultaEdicionPublish() {
    if (controladorConsultaEdicionPublish == null)
      _initControladorConsultaEdicionPublishProxy();
    return controladorConsultaEdicionPublish;
  }
  
  public java.lang.String obtenerDatosBasicosEd(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaEdicionPublish == null)
      _initControladorConsultaEdicionPublishProxy();
    return controladorConsultaEdicionPublish.obtenerDatosBasicosEd(arg0);
  }
  
  public publicadores.DtEdicion getDatosEdicion() throws java.rmi.RemoteException{
    if (controladorConsultaEdicionPublish == null)
      _initControladorConsultaEdicionPublishProxy();
    return controladorConsultaEdicionPublish.getDatosEdicion();
  }
  
  public java.lang.String[] getCategoriasGlobal() throws java.rmi.RemoteException{
    if (controladorConsultaEdicionPublish == null)
      _initControladorConsultaEdicionPublishProxy();
    return controladorConsultaEdicionPublish.getCategoriasGlobal();
  }
  
  public java.lang.String[] getCursosPorCategoria(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaEdicionPublish == null)
      _initControladorConsultaEdicionPublishProxy();
    return controladorConsultaEdicionPublish.getCursosPorCategoria(arg0);
  }
  
  public java.lang.String getDocentesAsignados(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaEdicionPublish == null)
      _initControladorConsultaEdicionPublishProxy();
    return controladorConsultaEdicionPublish.getDocentesAsignados(arg0);
  }
  
  public void setDatosEdicion(publicadores.DtEdicion arg0) throws java.rmi.RemoteException{
    if (controladorConsultaEdicionPublish == null)
      _initControladorConsultaEdicionPublishProxy();
    controladorConsultaEdicionPublish.setDatosEdicion(arg0);
  }
  
  public java.lang.String[] getCursos(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaEdicionPublish == null)
      _initControladorConsultaEdicionPublishProxy();
    return controladorConsultaEdicionPublish.getCursos(arg0);
  }
  
  public java.lang.String[] ingresarCurso(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaEdicionPublish == null)
      _initControladorConsultaEdicionPublishProxy();
    return controladorConsultaEdicionPublish.ingresarCurso(arg0);
  }
  
  public java.lang.String[] ingresarInstituto(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaEdicionPublish == null)
      _initControladorConsultaEdicionPublishProxy();
    return controladorConsultaEdicionPublish.ingresarInstituto(arg0);
  }
  
  public publicadores.DtEdicion ingresarEdicion(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaEdicionPublish == null)
      _initControladorConsultaEdicionPublishProxy();
    return controladorConsultaEdicionPublish.ingresarEdicion(arg0);
  }
  
  public java.lang.String obtenerDatosEdicion(publicadores.DtEdicion arg0) throws java.rmi.RemoteException{
    if (controladorConsultaEdicionPublish == null)
      _initControladorConsultaEdicionPublishProxy();
    return controladorConsultaEdicionPublish.obtenerDatosEdicion(arg0);
  }
  
  public java.lang.String[] getInstitutos() throws java.rmi.RemoteException{
    if (controladorConsultaEdicionPublish == null)
      _initControladorConsultaEdicionPublishProxy();
    return controladorConsultaEdicionPublish.getInstitutos();
  }
  
  public java.lang.String[] getEdiciones(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorConsultaEdicionPublish == null)
      _initControladorConsultaEdicionPublishProxy();
    return controladorConsultaEdicionPublish.getEdiciones(arg0);
  }
  
  
}