/**
 * ControladorConsultaProgFormacionPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorConsultaProgFormacionPublish extends java.rmi.Remote {
    public java.lang.String[] getCursos(publicadores.DtProgFormacionExp arg0) throws java.rmi.RemoteException;
    public java.lang.String obtenerDatosCurso(publicadores.DtCursoExp arg0) throws java.rmi.RemoteException;
    public java.lang.String obtenerDatosPrograma(publicadores.DtProgFormacionExp arg0) throws java.rmi.RemoteException;
    public publicadores.DtProgFormacionExp seleccionarPrograma(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getProgramasDeFormacion() throws java.rmi.RemoteException;
    public java.lang.String[] getCategoriasPrograma(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtCursoExp seleccionarCurso(java.lang.String arg0) throws java.rmi.RemoteException;
}
