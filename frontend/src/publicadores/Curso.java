/**
 * Curso.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public class Curso  implements java.io.Serializable {
    private int cantHoras;

    private publicadores.Categoria[] categorias;

    private int creditos;

    private java.lang.String descripcion;

    private int duracion;

    private publicadores.Edicion[] ediciones;

    private java.util.Calendar fechaR;

    private publicadores.Curso[] misPrevias;

    private java.lang.String nombre;

    private publicadores.ProgFormacion[] programas;

    private java.lang.String url;

    public Curso() {
    }

    public Curso(
           int cantHoras,
           publicadores.Categoria[] categorias,
           int creditos,
           java.lang.String descripcion,
           int duracion,
           publicadores.Edicion[] ediciones,
           java.util.Calendar fechaR,
           publicadores.Curso[] misPrevias,
           java.lang.String nombre,
           publicadores.ProgFormacion[] programas,
           java.lang.String url) {
           this.cantHoras = cantHoras;
           this.categorias = categorias;
           this.creditos = creditos;
           this.descripcion = descripcion;
           this.duracion = duracion;
           this.ediciones = ediciones;
           this.fechaR = fechaR;
           this.misPrevias = misPrevias;
           this.nombre = nombre;
           this.programas = programas;
           this.url = url;
    }


    /**
     * Gets the cantHoras value for this Curso.
     * 
     * @return cantHoras
     */
    public int getCantHoras() {
        return cantHoras;
    }


    /**
     * Sets the cantHoras value for this Curso.
     * 
     * @param cantHoras
     */
    public void setCantHoras(int cantHoras) {
        this.cantHoras = cantHoras;
    }


    /**
     * Gets the categorias value for this Curso.
     * 
     * @return categorias
     */
    public publicadores.Categoria[] getCategorias() {
        return categorias;
    }


    /**
     * Sets the categorias value for this Curso.
     * 
     * @param categorias
     */
    public void setCategorias(publicadores.Categoria[] categorias) {
        this.categorias = categorias;
    }

    public publicadores.Categoria getCategorias(int i) {
        return this.categorias[i];
    }

    public void setCategorias(int i, publicadores.Categoria _value) {
        this.categorias[i] = _value;
    }


    /**
     * Gets the creditos value for this Curso.
     * 
     * @return creditos
     */
    public int getCreditos() {
        return creditos;
    }


    /**
     * Sets the creditos value for this Curso.
     * 
     * @param creditos
     */
    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }


    /**
     * Gets the descripcion value for this Curso.
     * 
     * @return descripcion
     */
    public java.lang.String getDescripcion() {
        return descripcion;
    }


    /**
     * Sets the descripcion value for this Curso.
     * 
     * @param descripcion
     */
    public void setDescripcion(java.lang.String descripcion) {
        this.descripcion = descripcion;
    }


    /**
     * Gets the duracion value for this Curso.
     * 
     * @return duracion
     */
    public int getDuracion() {
        return duracion;
    }


    /**
     * Sets the duracion value for this Curso.
     * 
     * @param duracion
     */
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }


    /**
     * Gets the ediciones value for this Curso.
     * 
     * @return ediciones
     */
    public publicadores.Edicion[] getEdiciones() {
        return ediciones;
    }


    /**
     * Sets the ediciones value for this Curso.
     * 
     * @param ediciones
     */
    public void setEdiciones(publicadores.Edicion[] ediciones) {
        this.ediciones = ediciones;
    }

    public publicadores.Edicion getEdiciones(int i) {
        return this.ediciones[i];
    }

    public void setEdiciones(int i, publicadores.Edicion _value) {
        this.ediciones[i] = _value;
    }


    /**
     * Gets the fechaR value for this Curso.
     * 
     * @return fechaR
     */
    public java.util.Calendar getFechaR() {
        return fechaR;
    }


    /**
     * Sets the fechaR value for this Curso.
     * 
     * @param fechaR
     */
    public void setFechaR(java.util.Calendar fechaR) {
        this.fechaR = fechaR;
    }


    /**
     * Gets the misPrevias value for this Curso.
     * 
     * @return misPrevias
     */
    public publicadores.Curso[] getMisPrevias() {
        return misPrevias;
    }


    /**
     * Sets the misPrevias value for this Curso.
     * 
     * @param misPrevias
     */
    public void setMisPrevias(publicadores.Curso[] misPrevias) {
        this.misPrevias = misPrevias;
    }

    public publicadores.Curso getMisPrevias(int i) {
        return this.misPrevias[i];
    }

    public void setMisPrevias(int i, publicadores.Curso _value) {
        this.misPrevias[i] = _value;
    }


    /**
     * Gets the nombre value for this Curso.
     * 
     * @return nombre
     */
    public java.lang.String getNombre() {
        return nombre;
    }


    /**
     * Sets the nombre value for this Curso.
     * 
     * @param nombre
     */
    public void setNombre(java.lang.String nombre) {
        this.nombre = nombre;
    }


    /**
     * Gets the programas value for this Curso.
     * 
     * @return programas
     */
    public publicadores.ProgFormacion[] getProgramas() {
        return programas;
    }


    /**
     * Sets the programas value for this Curso.
     * 
     * @param programas
     */
    public void setProgramas(publicadores.ProgFormacion[] programas) {
        this.programas = programas;
    }

    public publicadores.ProgFormacion getProgramas(int i) {
        return this.programas[i];
    }

    public void setProgramas(int i, publicadores.ProgFormacion _value) {
        this.programas[i] = _value;
    }


    /**
     * Gets the url value for this Curso.
     * 
     * @return url
     */
    public java.lang.String getUrl() {
        return url;
    }


    /**
     * Sets the url value for this Curso.
     * 
     * @param url
     */
    public void setUrl(java.lang.String url) {
        this.url = url;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Curso)) return false;
        Curso other = (Curso) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.cantHoras == other.getCantHoras() &&
            ((this.categorias==null && other.getCategorias()==null) || 
             (this.categorias!=null &&
              java.util.Arrays.equals(this.categorias, other.getCategorias()))) &&
            this.creditos == other.getCreditos() &&
            ((this.descripcion==null && other.getDescripcion()==null) || 
             (this.descripcion!=null &&
              this.descripcion.equals(other.getDescripcion()))) &&
            this.duracion == other.getDuracion() &&
            ((this.ediciones==null && other.getEdiciones()==null) || 
             (this.ediciones!=null &&
              java.util.Arrays.equals(this.ediciones, other.getEdiciones()))) &&
            ((this.fechaR==null && other.getFechaR()==null) || 
             (this.fechaR!=null &&
              this.fechaR.equals(other.getFechaR()))) &&
            ((this.misPrevias==null && other.getMisPrevias()==null) || 
             (this.misPrevias!=null &&
              java.util.Arrays.equals(this.misPrevias, other.getMisPrevias()))) &&
            ((this.nombre==null && other.getNombre()==null) || 
             (this.nombre!=null &&
              this.nombre.equals(other.getNombre()))) &&
            ((this.programas==null && other.getProgramas()==null) || 
             (this.programas!=null &&
              java.util.Arrays.equals(this.programas, other.getProgramas()))) &&
            ((this.url==null && other.getUrl()==null) || 
             (this.url!=null &&
              this.url.equals(other.getUrl())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getCantHoras();
        if (getCategorias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCategorias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCategorias(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        _hashCode += getCreditos();
        if (getDescripcion() != null) {
            _hashCode += getDescripcion().hashCode();
        }
        _hashCode += getDuracion();
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
        if (getFechaR() != null) {
            _hashCode += getFechaR().hashCode();
        }
        if (getMisPrevias() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMisPrevias());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMisPrevias(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getNombre() != null) {
            _hashCode += getNombre().hashCode();
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
        if (getUrl() != null) {
            _hashCode += getUrl().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Curso.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "curso"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cantHoras");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cantHoras"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categorias");
        elemField.setXmlName(new javax.xml.namespace.QName("", "categorias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "categoria"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("creditos");
        elemField.setXmlName(new javax.xml.namespace.QName("", "creditos"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("descripcion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "descripcion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("duracion");
        elemField.setXmlName(new javax.xml.namespace.QName("", "duracion"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ediciones");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ediciones"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "edicion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fechaR");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fechaR"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "dateTime"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("misPrevias");
        elemField.setXmlName(new javax.xml.namespace.QName("", "misPrevias"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "curso"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("nombre");
        elemField.setXmlName(new javax.xml.namespace.QName("", "nombre"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("programas");
        elemField.setXmlName(new javax.xml.namespace.QName("", "programas"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://publicadores/", "progFormacion"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("url");
        elemField.setXmlName(new javax.xml.namespace.QName("", "url"));
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
