/**
 * ControladorAltaUsuarioPublishServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ControladorAltaUsuarioPublishServiceLocator extends org.apache.axis.client.Service implements publicadores.ControladorAltaUsuarioPublishService {

    public ControladorAltaUsuarioPublishServiceLocator() {
    }


    public ControladorAltaUsuarioPublishServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorAltaUsuarioPublishServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorAltaUsuarioPublishPort
    private java.lang.String ControladorAltaUsuarioPublishPort_address = "http://127.0.0.1:1942/controladorAltaUsuario";

    public java.lang.String getControladorAltaUsuarioPublishPortAddress() {
        return ControladorAltaUsuarioPublishPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorAltaUsuarioPublishPortWSDDServiceName = "ControladorAltaUsuarioPublishPort";

    public java.lang.String getControladorAltaUsuarioPublishPortWSDDServiceName() {
        return ControladorAltaUsuarioPublishPortWSDDServiceName;
    }

    public void setControladorAltaUsuarioPublishPortWSDDServiceName(java.lang.String name) {
        ControladorAltaUsuarioPublishPortWSDDServiceName = name;
    }

    public publicadores.ControladorAltaUsuarioPublish getControladorAltaUsuarioPublishPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorAltaUsuarioPublishPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorAltaUsuarioPublishPort(endpoint);
    }

    public publicadores.ControladorAltaUsuarioPublish getControladorAltaUsuarioPublishPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            publicadores.ControladorAltaUsuarioPublishPortBindingStub _stub = new publicadores.ControladorAltaUsuarioPublishPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorAltaUsuarioPublishPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorAltaUsuarioPublishPortEndpointAddress(java.lang.String address) {
        ControladorAltaUsuarioPublishPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (publicadores.ControladorAltaUsuarioPublish.class.isAssignableFrom(serviceEndpointInterface)) {
                publicadores.ControladorAltaUsuarioPublishPortBindingStub _stub = new publicadores.ControladorAltaUsuarioPublishPortBindingStub(new java.net.URL(ControladorAltaUsuarioPublishPort_address), this);
                _stub.setPortName(getControladorAltaUsuarioPublishPortWSDDServiceName());
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
        if ("ControladorAltaUsuarioPublishPort".equals(inputPortName)) {
            return getControladorAltaUsuarioPublishPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publicadores/", "ControladorAltaUsuarioPublishService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publicadores/", "ControladorAltaUsuarioPublishPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorAltaUsuarioPublishPort".equals(portName)) {
            setControladorAltaUsuarioPublishPortEndpointAddress(address);
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
