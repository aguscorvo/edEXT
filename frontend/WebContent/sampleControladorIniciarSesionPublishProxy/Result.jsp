<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorIniciarSesionPublishProxyid" scope="session" class="publicadores.ControladorIniciarSesionPublishProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorIniciarSesionPublishProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorIniciarSesionPublishProxyid.getEndpoint();
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
        sampleControladorIniciarSesionPublishProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorIniciarSesionPublish getControladorIniciarSesionPublish10mtemp = sampleControladorIniciarSesionPublishProxyid.getControladorIniciarSesionPublish();
if(getControladorIniciarSesionPublish10mtemp == null){
%>
<%=getControladorIniciarSesionPublish10mtemp %>
<%
}else{
        if(getControladorIniciarSesionPublish10mtemp!= null){
        String tempreturnp11 = getControladorIniciarSesionPublish10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg028");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        String arg1_2id=  request.getParameter("arg130");
            java.lang.String arg1_2idTemp = null;
        if(!arg1_2id.equals("")){
         arg1_2idTemp  = arg1_2id;
        }
        publicadores.DtUsuarioLogueado iniciarSesion13mtemp = sampleControladorIniciarSesionPublishProxyid.iniciarSesion(arg0_1idTemp,arg1_2idTemp);
if(iniciarSesion13mtemp == null){
%>
<%=iniciarSesion13mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nick:</TD>
<TD>
<%
if(iniciarSesion13mtemp != null){
java.lang.String typenick16 = iniciarSesion13mtemp.getNick();
        String tempResultnick16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenick16));
        %>
        <%= tempResultnick16 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaNac:</TD>
<TD>
<%
if(iniciarSesion13mtemp != null){
java.util.Calendar typefechaNac18 = iniciarSesion13mtemp.getFechaNac();
        java.text.DateFormat dateFormatfechaNac18 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaNac18 = typefechaNac18.getTime();
        String tempResultfechaNac18 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaNac18.format(datefechaNac18));
        %>
        <%= tempResultfechaNac18 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">password:</TD>
<TD>
<%
if(iniciarSesion13mtemp != null){
java.lang.String typepassword20 = iniciarSesion13mtemp.getPassword();
        String tempResultpassword20 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typepassword20));
        %>
        <%= tempResultpassword20 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">tipo:</TD>
<TD>
<%
if(iniciarSesion13mtemp != null){
java.lang.String typetipo22 = iniciarSesion13mtemp.getTipo();
        String tempResulttipo22 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typetipo22));
        %>
        <%= tempResulttipo22 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(iniciarSesion13mtemp != null){
java.lang.String typeapellido24 = iniciarSesion13mtemp.getApellido();
        String tempResultapellido24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido24));
        %>
        <%= tempResultapellido24 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(iniciarSesion13mtemp != null){
java.lang.String typenombre26 = iniciarSesion13mtemp.getNombre();
        String tempResultnombre26 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre26));
        %>
        <%= tempResultnombre26 %>
        <%
}%>
</TD>
</TABLE>
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