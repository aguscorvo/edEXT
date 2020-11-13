/**
 * ControladorConsultaUsuarioPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorConsultaUsuarioPublish extends java.rmi.Remote {
    public java.lang.String[] getEdicionesInscRechazadas(publicadores.DtUsuario arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getEdicionesInscRechazadasNueva(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getProgramasNueva(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String tipoUsuarioSeleccionado(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String getEstudiantesAceptadosAEdicion(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtEdicion seleccionarEdicion(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String obtenerDatosPrograma(publicadores.DtProgFormacionExp arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getEdiciones(publicadores.DtUsuario arg0) throws java.rmi.RemoteException;
    public publicadores.DtUsuario seleccionarUsuario(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getUsuarios() throws java.rmi.RemoteException;
    public java.lang.String obtenerDatosUsuario(publicadores.DtUsuario arg0) throws java.rmi.RemoteException;
    public publicadores.DtProgFormacionExp seleccionarPrograma(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getProgramas(publicadores.DtUsuario arg0) throws java.rmi.RemoteException;
    public java.lang.String obtenerDatosEdicion(publicadores.DtEdicion arg0) throws java.rmi.RemoteException;
}
