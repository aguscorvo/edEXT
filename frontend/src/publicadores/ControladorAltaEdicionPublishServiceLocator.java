/**
 * ControladorAltaEdicionPublishServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class ControladorAltaEdicionPublishServiceLocator extends org.apache.axis.client.Service implements publicadores.ControladorAltaEdicionPublishService {

    public ControladorAltaEdicionPublishServiceLocator() {
    }


    public ControladorAltaEdicionPublishServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ControladorAltaEdicionPublishServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ControladorAltaEdicionPublishPort
    private java.lang.String ControladorAltaEdicionPublishPort_address = "http://127.0.0.1:1942/controladorAltaEdicion";

    public java.lang.String getControladorAltaEdicionPublishPortAddress() {
        return ControladorAltaEdicionPublishPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ControladorAltaEdicionPublishPortWSDDServiceName = "ControladorAltaEdicionPublishPort";

    public java.lang.String getControladorAltaEdicionPublishPortWSDDServiceName() {
        return ControladorAltaEdicionPublishPortWSDDServiceName;
    }

    public void setControladorAltaEdicionPublishPortWSDDServiceName(java.lang.String name) {
        ControladorAltaEdicionPublishPortWSDDServiceName = name;
    }

    public publicadores.ControladorAltaEdicionPublish getControladorAltaEdicionPublishPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ControladorAltaEdicionPublishPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getControladorAltaEdicionPublishPort(endpoint);
    }

    public publicadores.ControladorAltaEdicionPublish getControladorAltaEdicionPublishPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            publicadores.ControladorAltaEdicionPublishPortBindingStub _stub = new publicadores.ControladorAltaEdicionPublishPortBindingStub(portAddress, this);
            _stub.setPortName(getControladorAltaEdicionPublishPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setControladorAltaEdicionPublishPortEndpointAddress(java.lang.String address) {
        ControladorAltaEdicionPublishPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (publicadores.ControladorAltaEdicionPublish.class.isAssignableFrom(serviceEndpointInterface)) {
                publicadores.ControladorAltaEdicionPublishPortBindingStub _stub = new publicadores.ControladorAltaEdicionPublishPortBindingStub(new java.net.URL(ControladorAltaEdicionPublishPort_address), this);
                _stub.setPortName(getControladorAltaEdicionPublishPortWSDDServiceName());
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
        if ("ControladorAltaEdicionPublishPort".equals(inputPortName)) {
            return getControladorAltaEdicionPublishPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://publicadores/", "ControladorAltaEdicionPublishService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://publicadores/", "ControladorAltaEdicionPublishPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ControladorAltaEdicionPublishPort".equals(portName)) {
            setControladorAltaEdicionPublishPortEndpointAddress(address);
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
