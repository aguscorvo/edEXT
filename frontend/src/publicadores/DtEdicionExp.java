/**
 * DtEdicionExp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class DtEdicionExp  extends publicadores.DtEdicion  implements java.io.Serializable {
    private java.lang.String[] docentes;

    public DtEdicionExp() {
    }

    public DtEdicionExp(
           int cupo,
           java.util.Date fechaF,
           java.util.Date fechaI,
           java.util.Date fechaPub,
           java.lang.String nombre,
           java.lang.String[] docentes) {
        super(
            cupo,
            fechaF,
            fechaI,
            fechaPub,
            nombre);
        this.docentes = docentes;
    }


    /**
     * Gets the docentes value for this DtEdicionExp.
     * 
     * @return docentes
     */
    public java.lang.String[] getDocentes() {
        return docentes;
    }


    /**
     * Sets the docentes value for this DtEdicionExp.
     * 
     * @param docentes
     */
    public void setDocentes(java.lang.String[] docentes) {
        this.docentes = docentes;
    }

    public java.lang.String getDocentes(int i) {
        return this.docentes[i];
    }

    public void setDocentes(int i, java.lang.String _value) {
        this.docentes[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtEdicionExp)) return false;
        DtEdicionExp other = (DtEdicionExp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.docentes==null && other.getDocentes()==null) || 
             (this.docentes!=null &&
              java.util.Arrays.equals(this.docentes, other.getDocentes())));
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
        if (getDocentes() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDocentes());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDocentes(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DtEdicionExp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtEdicionExp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("docentes");
        elemField.setXmlName(new javax.xml.namespace.QName("", "docentes"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
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
