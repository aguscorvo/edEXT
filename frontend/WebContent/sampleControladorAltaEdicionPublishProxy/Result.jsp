<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorAltaEdicionPublishProxyid" scope="session" class="publicadores.ControladorAltaEdicionPublishProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorAltaEdicionPublishProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorAltaEdicionPublishProxyid.getEndpoint();
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
        sampleControladorAltaEdicionPublishProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorAltaEdicionPublish getControladorAltaEdicionPublish10mtemp = sampleControladorAltaEdicionPublishProxyid.getControladorAltaEdicionPublish();
if(getControladorAltaEdicionPublish10mtemp == null){
%>
<%=getControladorAltaEdicionPublish10mtemp %>
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
        String arg0_1id=  request.getParameter("arg020");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        java.lang.String[] ingresarInstituto17mtemp = sampleControladorAltaEdicionPublishProxyid.ingresarInstituto(arg0_1idTemp);
if(ingresarInstituto17mtemp == null){
%>
<%=ingresarInstituto17mtemp %>
<%
}else{
        String tempreturnp18 = null;
        if(ingresarInstituto17mtemp != null){
        java.util.List listreturnp18= java.util.Arrays.asList(ingresarInstituto17mtemp);
        tempreturnp18 = listreturnp18.toString();
        }
        %>
        <%=tempreturnp18%>
        <%
}
break;
case 22:
        gotMethod = true;
        String nombre_3id=  request.getParameter("nombre27");
            java.lang.String nombre_3idTemp = null;
        if(!nombre_3id.equals("")){
         nombre_3idTemp  = nombre_3id;
        }
        %>
        <jsp:useBean id="publicadores1Instituto_2id" scope="session" class="publicadores.Instituto" />
        <%
        publicadores1Instituto_2id.setNombre(nombre_3idTemp);
        java.lang.String[] getCursos22mtemp = sampleControladorAltaEdicionPublishProxyid.getCursos(publicadores1Instituto_2id);
if(getCursos22mtemp == null){
%>
<%=getCursos22mtemp %>
<%
}else{
        String tempreturnp23 = null;
        if(getCursos22mtemp != null){
        java.util.List listreturnp23= java.util.Arrays.asList(getCursos22mtemp);
        tempreturnp23 = listreturnp23.toString();
        }
        %>
        <%=tempreturnp23%>
        <%
}
break;
case 29:
        gotMethod = true;
        java.lang.String[] getInstitutos29mtemp = sampleControladorAltaEdicionPublishProxyid.getInstitutos();
if(getInstitutos29mtemp == null){
%>
<%=getInstitutos29mtemp %>
<%
}else{
        String tempreturnp30 = null;
        if(getInstitutos29mtemp != null){
        java.util.List listreturnp30= java.util.Arrays.asList(getInstitutos29mtemp);
        tempreturnp30 = listreturnp30.toString();
        }
        %>
        <%=tempreturnp30%>
        <%
}
break;
case 32:
        gotMethod = true;
        sampleControladorAltaEdicionPublishProxyid.cancelarAltaEdicion();
break;
case 35:
        gotMethod = true;
        String arg0_4id=  request.getParameter("arg038");
            java.lang.String arg0_4idTemp = null;
        if(!arg0_4id.equals("")){
         arg0_4idTemp  = arg0_4id;
        }
        boolean existeInstituto35mtemp = sampleControladorAltaEdicionPublishProxyid.existeInstituto(arg0_4idTemp);
        String tempResultreturnp36 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(existeInstituto35mtemp));
        %>
        <%= tempResultreturnp36 %>
        <%
break;
case 40:
        gotMethod = true;
        String arg0_5id=  request.getParameter("arg045");
            java.lang.String arg0_5idTemp = null;
        if(!arg0_5id.equals("")){
         arg0_5idTemp  = arg0_5id;
        }
        publicadores.Instituto getInstituto40mtemp = sampleControladorAltaEdicionPublishProxyid.getInstituto(arg0_5idTemp);
if(getInstituto40mtemp == null){
%>
<%=getInstituto40mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getInstituto40mtemp != null){
java.lang.String typenombre43 = getInstituto40mtemp.getNombre();
        String tempResultnombre43 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre43));
        %>
        <%= tempResultnombre43 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 47:
        gotMethod = true;
        java.lang.String[] getDocentes47mtemp = sampleControladorAltaEdicionPublishProxyid.getDocentes();
if(getDocentes47mtemp == null){
%>
<%=getDocentes47mtemp %>
<%
}else{
        String tempreturnp48 = null;
        if(getDocentes47mtemp != null){
        java.util.List listreturnp48= java.util.Arrays.asList(getDocentes47mtemp);
        tempreturnp48 = listreturnp48.toString();
        }
        %>
        <%=tempreturnp48%>
        <%
}
break;
case 50:
        gotMethod = true;
        String arg0_6id=  request.getParameter("arg053");
            java.lang.String arg0_6idTemp = null;
        if(!arg0_6id.equals("")){
         arg0_6idTemp  = arg0_6id;
        }
        sampleControladorAltaEdicionPublishProxyid.seleccionarCurso(arg0_6idTemp);
break;
case 55:
        gotMethod = true;
        %>
        <jsp:useBean id="publicadores1DtEdicionExp_7id" scope="session" class="publicadores.DtEdicionExp" />
        <%
        sampleControladorAltaEdicionPublishProxyid.ingresarDtEdicion(publicadores1DtEdicionExp_7id);
break;
case 60:
        gotMethod = true;
        sampleControladorAltaEdicionPublishProxyid.confirmarAltaEdicion();
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