/**
 * DtDocente.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class DtDocente  extends publicadores.DtUsuario  implements java.io.Serializable {
    private java.lang.String instituto;

    public DtDocente() {
    }

    public DtDocente(
           java.lang.String apellido,
           java.lang.String correo,
           java.util.Date fechaNac,
           java.lang.String nick,
           java.lang.String nombre,
           java.lang.String password,
           java.lang.String instituto) {
        super(
            apellido,
            correo,
            fechaNac,
            nick,
            nombre,
            password);
        this.instituto = instituto;
    }


    /**
     * Gets the instituto value for this DtDocente.
     * 
     * @return instituto
     */
    public java.lang.String getInstituto() {
        return instituto;
    }


    /**
     * Sets the instituto value for this DtDocente.
     * 
     * @param instituto
     */
    public void setInstituto(java.lang.String instituto) {
        this.instituto = instituto;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtDocente)) return false;
        DtDocente other = (DtDocente) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.instituto==null && other.getInstituto()==null) || 
             (this.instituto!=null &&
              this.instituto.equals(other.getInstituto())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = super.hashCode();
        if (getInstituto() != null) {
            _hashCode += getInstituto().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DtDocente.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtDocente"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("instituto");
        elemField.setXmlName(new javax.xml.namespace.QName("", "instituto"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
