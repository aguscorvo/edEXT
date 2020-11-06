/**
 * ControladorIniciarSesionPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorIniciarSesionPublish extends java.rmi.Remote {
    public publicadores.DtUsuarioLogueado iniciarSesion(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException, publicadores.NoExisteUsuarioException, publicadores.ContraseniaIncorrectaException;
}
