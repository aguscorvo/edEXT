/**
 * ControladorSeguirUsuariosPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorSeguirUsuariosPublish extends java.rmi.Remote {
    public void seguirUsuario(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String[] getUsuariosNoSeguidos(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] getUsuariosSeguidos(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String getCadenaUsuariosSeguidos(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String getCadenaUsuariosSeguidores(java.lang.String arg0) throws java.rmi.RemoteException;
    public void noSeguirUsuario(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
}
