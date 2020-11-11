/**
 * DtProgFormacionExp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class DtProgFormacionExp  extends publicadores.DtProgFormacion  implements java.io.Serializable {
    private java.lang.String[] cursos;

    public DtProgFormacionExp() {
    }

    public DtProgFormacionExp(
           java.lang.String nombre,
           java.lang.String desc,
           java.util.Date fechaAlta,
           java.util.Date fechaF,
           java.util.Date fechaI,
           java.lang.String[] cursos) {
        super(
            nombre,
            desc,
            fechaAlta,
            fechaF,
            fechaI);
        this.cursos = cursos;
    }


    /**
     * Gets the cursos value for this DtProgFormacionExp.
     * 
     * @return cursos
     */
    public java.lang.String[] getCursos() {
        return cursos;
    }


    /**
     * Sets the cursos value for this DtProgFormacionExp.
     * 
     * @param cursos
     */
    public void setCursos(java.lang.String[] cursos) {
        this.cursos = cursos;
    }

    public java.lang.String getCursos(int i) {
        return this.cursos[i];
    }

    public void setCursos(int i, java.lang.String _value) {
        this.cursos[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtProgFormacionExp)) return false;
        DtProgFormacionExp other = (DtProgFormacionExp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.cursos==null && other.getCursos()==null) || 
             (this.cursos!=null &&
              java.util.Arrays.equals(this.cursos, other.getCursos())));
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
        if (getCursos() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCursos());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCursos(), i);
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
        new org.apache.axis.description.TypeDesc(DtProgFormacionExp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtProgFormacionExp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cursos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cursos"));
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
