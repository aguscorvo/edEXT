<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorAltaProgFormacionPublishProxyid" scope="session" class="publicadores.ControladorAltaProgFormacionPublishProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorAltaProgFormacionPublishProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = sampleControladorAltaProgFormacionPublishProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleControladorAltaProgFormacionPublishProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorAltaProgFormacionPublish getControladorAltaProgFormacionPublish10mtemp = sampleControladorAltaProgFormacionPublishProxyid.getControladorAltaProgFormacionPublish();
if(getControladorAltaProgFormacionPublish10mtemp == null){
%>
<%=getControladorAltaProgFormacionPublish10mtemp %>
<%
}else{
        if(getControladorAltaProgFormacionPublish10mtemp!= null){
        String tempreturnp11 = getControladorAltaProgFormacionPublish10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String fechaI_2id=  request.getParameter("fechaI18");
            java.util.Calendar fechaI_2idTemp = null;
        if(!fechaI_2id.equals("")){
        java.text.DateFormat dateFormatfechaI18 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfechaI18  = dateFormatfechaI18.parse(fechaI_2id);
         fechaI_2idTemp = new java.util.GregorianCalendar();
        fechaI_2idTemp.setTime(dateTempfechaI18);
        }
        String fechaF_3id=  request.getParameter("fechaF20");
            java.util.Calendar fechaF_3idTemp = null;
        if(!fechaF_3id.equals("")){
        java.text.DateFormat dateFormatfechaF20 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfechaF20  = dateFormatfechaF20.parse(fechaF_3id);
         fechaF_3idTemp = new java.util.GregorianCalendar();
        fechaF_3idTemp.setTime(dateTempfechaF20);
        }
        String fechaAlta_4id=  request.getParameter("fechaAlta22");
            java.util.Calendar fechaAlta_4idTemp = null;
        if(!fechaAlta_4id.equals("")){
        java.text.DateFormat dateFormatfechaAlta22 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfechaAlta22  = dateFormatfechaAlta22.parse(fechaAlta_4id);
         fechaAlta_4idTemp = new java.util.GregorianCalendar();
        fechaAlta_4idTemp.setTime(dateTempfechaAlta22);
        }
        %>
        <jsp:useBean id="publicadores1DtProgFormacion_1id" scope="session" class="publicadores.DtProgFormacion" />
        <%
        publicadores1DtProgFormacion_1id.setFechaI(fechaI_2idTemp);
        publicadores1DtProgFormacion_1id.setFechaF(fechaF_3idTemp);
        publicadores1DtProgFormacion_1id.setFechaAlta(fechaAlta_4idTemp);
        sampleControladorAltaProgFormacionPublishProxyid.ingresarProgFormacion(publicadores1DtProgFormacion_1id);
break;
case 24:
        gotMethod = true;
        sampleControladorAltaProgFormacionPublishProxyid.confirmarAltaPrograma();
break;
case 27:
        gotMethod = true;
        sampleControladorAltaProgFormacionPublishProxyid.cancelarAltaPrograma();
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>