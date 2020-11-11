/**
 * ControladorAltaProgFormacionPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorAltaProgFormacionPublish extends java.rmi.Remote {
    public void ingresarProgFormacion(publicadores.DtProgFormacion arg0) throws java.rmi.RemoteException, publicadores.ProgramaRepetidoException;
    public void confirmarAltaPrograma() throws java.rmi.RemoteException;
    public void cancelarAltaPrograma() throws java.rmi.RemoteException;
}
