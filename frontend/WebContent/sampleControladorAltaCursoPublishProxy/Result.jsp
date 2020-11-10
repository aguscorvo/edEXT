<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorAltaCursoPublishProxyid" scope="session" class="publicadores.ControladorAltaCursoPublishProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorAltaCursoPublishProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorAltaCursoPublishProxyid.getEndpoint();
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
        sampleControladorAltaCursoPublishProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorAltaCursoPublish getControladorAltaCursoPublish10mtemp = sampleControladorAltaCursoPublishProxyid.getControladorAltaCursoPublish();
if(getControladorAltaCursoPublish10mtemp == null){
%>
<%=getControladorAltaCursoPublish10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 19:
        gotMethod = true;
        java.lang.String[] getCursos19mtemp = sampleControladorAltaCursoPublishProxyid.getCursos();
if(getCursos19mtemp == null){
%>
<%=getCursos19mtemp %>
<%
}else{
        String tempreturnp20 = null;
        if(getCursos19mtemp != null){
        java.util.List listreturnp20= java.util.Arrays.asList(getCursos19mtemp);
        tempreturnp20 = listreturnp20.toString();
        }
        %>
        <%=tempreturnp20%>
        <%
}
break;
case 22:
        gotMethod = true;
        java.lang.String[] getCategorias22mtemp = sampleControladorAltaCursoPublishProxyid.getCategorias();
if(getCategorias22mtemp == null){
%>
<%=getCategorias22mtemp %>
<%
}else{
        String tempreturnp23 = null;
        if(getCategorias22mtemp != null){
        java.util.List listreturnp23= java.util.Arrays.asList(getCategorias22mtemp);
        tempreturnp23 = listreturnp23.toString();
        }
        %>
        <%=tempreturnp23%>
        <%
}
break;
case 25:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg028");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        String url_3id=  request.getParameter("url32");
            java.lang.String url_3idTemp = null;
        if(!url_3id.equals("")){
         url_3idTemp  = url_3id;
        }
        String creditos_4id=  request.getParameter("creditos34");
        int creditos_4idTemp  = Integer.parseInt(creditos_4id);
        String cantHoras_5id=  request.getParameter("cantHoras36");
        int cantHoras_5idTemp  = Integer.parseInt(cantHoras_5id);
        String desc_6id=  request.getParameter("desc38");
            java.lang.String desc_6idTemp = null;
        if(!desc_6id.equals("")){
         desc_6idTemp  = desc_6id;
        }
        String duracion_7id=  request.getParameter("duracion40");
        int duracion_7idTemp  = Integer.parseInt(duracion_7id);
        String nombre_8id=  request.getParameter("nombre42");
            java.lang.String nombre_8idTemp = null;
        if(!nombre_8id.equals("")){
         nombre_8idTemp  = nombre_8id;
        }
        String fechaR_9id=  request.getParameter("fechaR44");
            java.util.Calendar fechaR_9idTemp = null;
        if(!fechaR_9id.equals("")){
        java.text.DateFormat dateFormatfechaR44 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfechaR44  = dateFormatfechaR44.parse(fechaR_9id);
         fechaR_9idTemp = new java.util.GregorianCalendar();
        fechaR_9idTemp.setTime(dateTempfechaR44);
        }
        %>
        <jsp:useBean id="publicadores1DtCurso_2id" scope="session" class="publicadores.DtCurso" />
        <%
        publicadores1DtCurso_2id.setUrl(url_3idTemp);
        publicadores1DtCurso_2id.setCreditos(creditos_4idTemp);
        publicadores1DtCurso_2id.setCantHoras(cantHoras_5idTemp);
        publicadores1DtCurso_2id.setDesc(desc_6idTemp);
        publicadores1DtCurso_2id.setDuracion(duracion_7idTemp);
        publicadores1DtCurso_2id.setNombre(nombre_8idTemp);
        publicadores1DtCurso_2id.setFechaR(fechaR_9idTemp);
        sampleControladorAltaCursoPublishProxyid.ingresarCurso(arg0_1idTemp,publicadores1DtCurso_2id);
break;
case 46:
        gotMethod = true;
        sampleControladorAltaCursoPublishProxyid.confirmarAltaCurso();
break;
case 49:
        gotMethod = true;
        sampleControladorAltaCursoPublishProxyid.cancelarAltaCurso();
break;
case 52:
        gotMethod = true;
        java.lang.String[] getInstitutos52mtemp = sampleControladorAltaCursoPublishProxyid.getInstitutos();
if(getInstitutos52mtemp == null){
%>
<%=getInstitutos52mtemp %>
<%
}else{
        String tempreturnp53 = null;
        if(getInstitutos52mtemp != null){
        java.util.List listreturnp53= java.util.Arrays.asList(getInstitutos52mtemp);
        tempreturnp53 = listreturnp53.toString();
        }
        %>
        <%=tempreturnp53%>
        <%
}
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