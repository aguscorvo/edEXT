/**
 * DtCursoExp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class DtCursoExp  extends publicadores.DtCurso  implements java.io.Serializable {
    private java.lang.String[] ediciones;

    private java.lang.String[] programas;

    public DtCursoExp() {
    }

    public DtCursoExp(
           int cantHoras,
           java.lang.String[] categorias,
           int creditos,
           java.lang.String desc,
           int duracion,
           java.util.Date fechaR,
           java.lang.String nombre,
           java.lang.String[] previas,
           java.lang.String url,
           java.lang.String[] ediciones,
           java.lang.String[] programas) {
        super(
            cantHoras,
            categorias,
            creditos,
            desc,
            duracion,
            fechaR,
            nombre,
            previas,
            url);
        this.ediciones = ediciones;
        this.programas = programas;
    }


    /**
     * Gets the ediciones value for this DtCursoExp.
     * 
     * @return ediciones
     */
    public java.lang.String[] getEdiciones() {
        return ediciones;
    }


    /**
     * Sets the ediciones value for this DtCursoExp.
     * 
     * @param ediciones
     */
    public void setEdiciones(java.lang.String[] ediciones) {
        this.ediciones = ediciones;
    }

    public java.lang.String getEdiciones(int i) {
        return this.ediciones[i];
    }

    public void setEdiciones(int i, java.lang.String _value) {
        this.ediciones[i] = _value;
    }


    /**
     * Gets the programas value for this DtCursoExp.
     * 
     * @return programas
     */
    public java.lang.String[] getProgramas() {
        return programas;
    }


    /**
     * Sets the programas value for this DtCursoExp.
     * 
     * @param programas
     */
    public void setProgramas(java.lang.String[] programas) {
        this.programas = programas;
    }

    public java.lang.String getProgramas(int i) {
        return this.programas[i];
    }

    public void setProgramas(int i, java.lang.String _value) {
        this.programas[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof DtCursoExp)) return false;
        DtCursoExp other = (DtCursoExp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = super.equals(obj) && 
            ((this.ediciones==null && other.getEdiciones()==null) || 
             (this.ediciones!=null &&
              java.util.Arrays.equals(this.ediciones, other.getEdiciones()))) &&
            ((this.programas==null && other.getProgramas()==null) || 
             (this.programas!=null &&
              java.util.Arrays.equals(this.programas, other.getProgramas())));
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
        if (getEdiciones() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getEdiciones());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getEdiciones(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getProgramas() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getProgramas());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getProgramas(), i);
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
        new org.apache.axis.description.TypeDesc(DtCursoExp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "dtCursoExp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ediciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ediciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("programas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "programas"));
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
