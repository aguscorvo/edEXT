/**
 * ControladorListarAceptadosPublishServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ControladorListarAceptadosPublishServiceLocator extends org.apache.axis.client.Service implements publicadores.ControladorListarAceptadosPublishService {

    public ControladorListarAceptadosPublishServiceLocator() {
    }


    public ControladorListarAceptadosPublishServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorListarAceptadosPublishServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorListarAceptadosPublishPort
    private java.lang.String ControladorListarAceptadosPublishPort_address = "http://127.0.0.1:1942/controladorListarAceptados";

    public java.lang.String getControladorListarAceptadosPublishPortAddress() {
        return ControladorListarAceptadosPublishPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorListarAceptadosPublishPortWSDDServiceName = "ControladorListarAceptadosPublishPort";

    public java.lang.String getControladorListarAceptadosPublishPortWSDDServiceName() {
        return ControladorListarAceptadosPublishPortWSDDServiceName;
    }

    public void setControladorListarAceptadosPublishPortWSDDServiceName(java.lang.String name) {
        ControladorListarAceptadosPublishPortWSDDServiceName = name;
    }

    public publicadores.ControladorListarAceptadosPublish getControladorListarAceptadosPublishPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorListarAceptadosPublishPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorListarAceptadosPublishPort(endpoint);
    }

    public publicadores.ControladorListarAceptadosPublish getControladorListarAceptadosPublishPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            publicadores.ControladorListarAceptadosPublishPortBindingStub _stub = new publicadores.ControladorListarAceptadosPublishPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorListarAceptadosPublishPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorListarAceptadosPublishPortEndpointAddress(java.lang.String address) {
        ControladorListarAceptadosPublishPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (publicadores.ControladorListarAceptadosPublish.class.isAssignableFrom(serviceEndpointInterface)) {
                publicadores.ControladorListarAceptadosPublishPortBindingStub _stub = new publicadores.ControladorListarAceptadosPublishPortBindingStub(new java.net.URL(ControladorListarAceptadosPublishPort_address), this);
                _stub.setPortName(getControladorListarAceptadosPublishPortWSDDServiceName());
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
        if ("ControladorListarAceptadosPublishPort".equals(inputPortName)) {
            return getControladorListarAceptadosPublishPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publicadores/", "ControladorListarAceptadosPublishService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publicadores/", "ControladorListarAceptadosPublishPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorListarAceptadosPublishPort".equals(portName)) {
            setControladorListarAceptadosPublishPortEndpointAddress(address);
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
