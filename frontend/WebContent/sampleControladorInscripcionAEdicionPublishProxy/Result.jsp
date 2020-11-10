<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorInscripcionAEdicionPublishProxyid" scope="session" class="publicadores.ControladorInscripcionAEdicionPublishProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorInscripcionAEdicionPublishProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorInscripcionAEdicionPublishProxyid.getEndpoint();
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
        sampleControladorInscripcionAEdicionPublishProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorInscripcionAEdicionPublish getControladorInscripcionAEdicionPublish10mtemp = sampleControladorInscripcionAEdicionPublishProxyid.getControladorInscripcionAEdicionPublish();
if(getControladorInscripcionAEdicionPublish10mtemp == null){
%>
<%=getControladorInscripcionAEdicionPublish10mtemp %>
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
case 17:
        gotMethod = true;
        java.lang.String obtenerDatosBasicosEd17mtemp = sampleControladorInscripcionAEdicionPublishProxyid.obtenerDatosBasicosEd();
if(obtenerDatosBasicosEd17mtemp == null){
%>
<%=obtenerDatosBasicosEd17mtemp %>
<%
}else{
        String tempResultreturnp18 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(obtenerDatosBasicosEd17mtemp));
        %>
        <%= tempResultreturnp18 %>
        <%
}
break;
case 20:
        gotMethod = true;
        java.lang.String[] getCategoriasGlobal20mtemp = sampleControladorInscripcionAEdicionPublishProxyid.getCategoriasGlobal();
if(getCategoriasGlobal20mtemp == null){
%>
<%=getCategoriasGlobal20mtemp %>
<%
}else{
        String tempreturnp21 = null;
        if(getCategoriasGlobal20mtemp != null){
        java.util.List listreturnp21= java.util.Arrays.asList(getCategoriasGlobal20mtemp);
        tempreturnp21 = listreturnp21.toString();
        }
        %>
        <%=tempreturnp21%>
        <%
}
break;
case 23:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg026");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        java.lang.String[] getCursosPorCategoria23mtemp = sampleControladorInscripcionAEdicionPublishProxyid.getCursosPorCategoria(arg0_1idTemp);
if(getCursosPorCategoria23mtemp == null){
%>
<%=getCursosPorCategoria23mtemp %>
<%
}else{
        String tempreturnp24 = null;
        if(getCursosPorCategoria23mtemp != null){
        java.util.List listreturnp24= java.util.Arrays.asList(getCursosPorCategoria23mtemp);
        tempreturnp24 = listreturnp24.toString();
        }
        %>
        <%=tempreturnp24%>
        <%
}
break;
case 28:
        gotMethod = true;
        publicadores.EstadoInscripcion chequearEstudianteEdicion28mtemp = sampleControladorInscripcionAEdicionPublishProxyid.chequearEstudianteEdicion();
if(chequearEstudianteEdicion28mtemp == null){
%>
<%=chequearEstudianteEdicion28mtemp %>
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
case 33:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg036");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        java.lang.String[] ingresarInstituto33mtemp = sampleControladorInscripcionAEdicionPublishProxyid.ingresarInstituto(arg0_2idTemp);
if(ingresarInstituto33mtemp == null){
%>
<%=ingresarInstituto33mtemp %>
<%
}else{
        String tempreturnp34 = null;
        if(ingresarInstituto33mtemp != null){
        java.util.List listreturnp34= java.util.Arrays.asList(ingresarInstituto33mtemp);
        tempreturnp34 = listreturnp34.toString();
        }
        %>
        <%=tempreturnp34%>
        <%
}
break;
case 38:
        gotMethod = true;
        java.lang.String[] getInstitutos38mtemp = sampleControladorInscripcionAEdicionPublishProxyid.getInstitutos();
if(getInstitutos38mtemp == null){
%>
<%=getInstitutos38mtemp %>
<%
}else{
        String tempreturnp39 = null;
        if(getInstitutos38mtemp != null){
        java.util.List listreturnp39= java.util.Arrays.asList(getInstitutos38mtemp);
        tempreturnp39 = listreturnp39.toString();
        }
        %>
        <%=tempreturnp39%>
        <%
}
break;
case 41:
        gotMethod = true;
        sampleControladorInscripcionAEdicionPublishProxyid.cancelarInscripcionAEdicion();
break;
case 44:
        gotMethod = true;
        String arg0_3id=  request.getParameter("arg047");
            java.lang.String arg0_3idTemp = null;
        if(!arg0_3id.equals("")){
         arg0_3idTemp  = arg0_3id;
        }
        String arg1_4id=  request.getParameter("arg149");
            java.util.Calendar arg1_4idTemp = null;
        if(!arg1_4id.equals("")){
        java.text.DateFormat dateFormatarg149 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg149  = dateFormatarg149.parse(arg1_4id);
         arg1_4idTemp = new java.util.GregorianCalendar();
        arg1_4idTemp.setTime(dateTemparg149);
        }
        sampleControladorInscripcionAEdicionPublishProxyid.ingresarEstudiante(arg0_3idTemp,arg1_4idTemp);
break;
case 51:
        gotMethod = true;
        sampleControladorInscripcionAEdicionPublishProxyid.confirmarInscripcionAEdicion();
break;
case 54:
        gotMethod = true;
        String arg0_5id=  request.getParameter("arg057");
            java.lang.String arg0_5idTemp = null;
        if(!arg0_5id.equals("")){
         arg0_5idTemp  = arg0_5id;
        }
        java.lang.String[] getEstudiantes54mtemp = sampleControladorInscripcionAEdicionPublishProxyid.getEstudiantes(arg0_5idTemp);
if(getEstudiantes54mtemp == null){
%>
<%=getEstudiantes54mtemp %>
<%
}else{
        String tempreturnp55 = null;
        if(getEstudiantes54mtemp != null){
        java.util.List listreturnp55= java.util.Arrays.asList(getEstudiantes54mtemp);
        tempreturnp55 = listreturnp55.toString();
        }
        %>
        <%=tempreturnp55%>
        <%
}
break;
case 59:
        gotMethod = true;
        String arg0_6id=  request.getParameter("arg062");
            java.lang.String arg0_6idTemp = null;
        if(!arg0_6id.equals("")){
         arg0_6idTemp  = arg0_6id;
        }
        java.lang.String[] getCursos59mtemp = sampleControladorInscripcionAEdicionPublishProxyid.getCursos(arg0_6idTemp);
if(getCursos59mtemp == null){
%>
<%=getCursos59mtemp %>
<%
}else{
        String tempreturnp60 = null;
        if(getCursos59mtemp != null){
        java.util.List listreturnp60= java.util.Arrays.asList(getCursos59mtemp);
        tempreturnp60 = listreturnp60.toString();
        }
        %>
        <%=tempreturnp60%>
        <%
}
break;
case 64:
        gotMethod = true;
        String arg0_7id=  request.getParameter("arg067");
            java.lang.String arg0_7idTemp = null;
        if(!arg0_7id.equals("")){
         arg0_7idTemp  = arg0_7id;
        }
        java.lang.String ingresarCurso64mtemp = sampleControladorInscripcionAEdicionPublishProxyid.ingresarCurso(arg0_7idTemp);
if(ingresarCurso64mtemp == null){
%>
<%=ingresarCurso64mtemp %>
<%
}else{
        String tempResultreturnp65 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(ingresarCurso64mtemp));
        %>
        <%= tempResultreturnp65 %>
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