/**
 * ControladorConsultaEdicionPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorConsultaEdicionPublish extends java.rmi.Remote {
    public java.lang.String obtenerDatosBasicosEd(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtEdicion getDatosEdicion() throws java.rmi.RemoteException;
    public java.lang.String[] getCategoriasGlobal() throws java.rmi.RemoteException;
    public java.lang.String[] getCursosPorCategoria(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String getDocentesAsignados(java.lang.String arg0) throws java.rmi.RemoteException;
    public void setDatosEdicion(publicadores.DtEdicion arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getCursos(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] ingresarCurso(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] ingresarInstituto(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtEdicion ingresarEdicion(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String obtenerDatosEdicion(publicadores.DtEdicion arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getInstitutos() throws java.rmi.RemoteException;
    public java.lang.String[] getEdiciones(java.lang.String arg0) throws java.rmi.RemoteException;
}
