/**
 * ControladorConsultaCursoPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorConsultaCursoPublish extends java.rmi.Remote {
    public java.lang.String[] getCategoriasGlobal() throws java.rmi.RemoteException;
    public java.lang.String[] getCursosPorCategoria(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getCategorias(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] ingresarInstituto(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtCursoExp seleccionarCurso(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String obtenerDatosCurso(publicadores.DtCursoExp arg0) throws java.rmi.RemoteException;
    public publicadores.DtEdicion seleccionarEdicion(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtProgFormacionExp seleccionarProgFormacion(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String obtenerDatosPrograma(publicadores.DtProgFormacionExp arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getPrevias(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getPFs(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String obtenerDatosEdicion(publicadores.DtEdicion arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getInstitutos() throws java.rmi.RemoteException;
    public java.lang.String[] getEdiciones(java.lang.String arg0) throws java.rmi.RemoteException;
}
