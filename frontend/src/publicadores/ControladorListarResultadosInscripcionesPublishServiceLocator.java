/**
 * ControladorListarResultadosInscripcionesPublishServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ControladorListarResultadosInscripcionesPublishServiceLocator extends org.apache.axis.client.Service implements publicadores.ControladorListarResultadosInscripcionesPublishService {

    public ControladorListarResultadosInscripcionesPublishServiceLocator() {
    }


    public ControladorListarResultadosInscripcionesPublishServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorListarResultadosInscripcionesPublishServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorListarResultadosInscripcionesPublishPort
    private java.lang.String ControladorListarResultadosInscripcionesPublishPort_address = "http://127.0.0.1:1942/controladorListarResultadosInscripciones";

    public java.lang.String getControladorListarResultadosInscripcionesPublishPortAddress() {
        return ControladorListarResultadosInscripcionesPublishPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorListarResultadosInscripcionesPublishPortWSDDServiceName = "ControladorListarResultadosInscripcionesPublishPort";

    public java.lang.String getControladorListarResultadosInscripcionesPublishPortWSDDServiceName() {
        return ControladorListarResultadosInscripcionesPublishPortWSDDServiceName;
    }

    public void setControladorListarResultadosInscripcionesPublishPortWSDDServiceName(java.lang.String name) {
        ControladorListarResultadosInscripcionesPublishPortWSDDServiceName = name;
    }

    public publicadores.ControladorListarResultadosInscripcionesPublish getControladorListarResultadosInscripcionesPublishPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorListarResultadosInscripcionesPublishPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorListarResultadosInscripcionesPublishPort(endpoint);
    }

    public publicadores.ControladorListarResultadosInscripcionesPublish getControladorListarResultadosInscripcionesPublishPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            publicadores.ControladorListarResultadosInscripcionesPublishPortBindingStub _stub = new publicadores.ControladorListarResultadosInscripcionesPublishPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorListarResultadosInscripcionesPublishPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorListarResultadosInscripcionesPublishPortEndpointAddress(java.lang.String address) {
        ControladorListarResultadosInscripcionesPublishPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (publicadores.ControladorListarResultadosInscripcionesPublish.class.isAssignableFrom(serviceEndpointInterface)) {
                publicadores.ControladorListarResultadosInscripcionesPublishPortBindingStub _stub = new publicadores.ControladorListarResultadosInscripcionesPublishPortBindingStub(new java.net.URL(ControladorListarResultadosInscripcionesPublishPort_address), this);
                _stub.setPortName(getControladorListarResultadosInscripcionesPublishPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("ControladorListarResultadosInscripcionesPublishPort".equals(inputPortName)) {
            return getControladorListarResultadosInscripcionesPublishPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publicadores/", "ControladorListarResultadosInscripcionesPublishService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publicadores/", "ControladorListarResultadosInscripcionesPublishPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorListarResultadosInscripcionesPublishPort".equals(portName)) {
            setControladorListarResultadosInscripcionesPublishPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
