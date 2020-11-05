<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorAltaUsuarioPublishProxyid" scope="session" class="publicadores.ControladorAltaUsuarioPublishProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorAltaUsuarioPublishProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorAltaUsuarioPublishProxyid.getEndpoint();
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
        sampleControladorAltaUsuarioPublishProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorAltaUsuarioPublish getControladorAltaUsuarioPublish10mtemp = sampleControladorAltaUsuarioPublishProxyid.getControladorAltaUsuarioPublish();
if(getControladorAltaUsuarioPublish10mtemp == null){
%>
<%=getControladorAltaUsuarioPublish10mtemp %>
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
case 15:
        gotMethod = true;
        String nick_2id=  request.getParameter("nick20");
            java.lang.String nick_2idTemp = null;
        if(!nick_2id.equals("")){
         nick_2idTemp  = nick_2id;
        }
        String fechaNac_3id=  request.getParameter("fechaNac22");
            java.util.Calendar fechaNac_3idTemp = null;
        if(!fechaNac_3id.equals("")){
        java.text.DateFormat dateFormatfechaNac22 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfechaNac22  = dateFormatfechaNac22.parse(fechaNac_3id);
         fechaNac_3idTemp = new java.util.GregorianCalendar();
        fechaNac_3idTemp.setTime(dateTempfechaNac22);
        }
        String password_4id=  request.getParameter("password24");
            java.lang.String password_4idTemp = null;
        if(!password_4id.equals("")){
         password_4idTemp  = password_4id;
        }
        String correo_5id=  request.getParameter("correo26");
            java.lang.String correo_5idTemp = null;
        if(!correo_5id.equals("")){
         correo_5idTemp  = correo_5id;
        }
        String apellido_6id=  request.getParameter("apellido28");
            java.lang.String apellido_6idTemp = null;
        if(!apellido_6id.equals("")){
         apellido_6idTemp  = apellido_6id;
        }
        String nombre_7id=  request.getParameter("nombre30");
            java.lang.String nombre_7idTemp = null;
        if(!nombre_7id.equals("")){
         nombre_7idTemp  = nombre_7id;
        }
        %>
        <jsp:useBean id="publicadores1DtUsuario_1id" scope="session" class="publicadores.DtUsuario" />
        <%
        publicadores1DtUsuario_1id.setNick(nick_2idTemp);
        publicadores1DtUsuario_1id.setFechaNac(fechaNac_3idTemp);
        publicadores1DtUsuario_1id.setPassword(password_4idTemp);
        publicadores1DtUsuario_1id.setCorreo(correo_5idTemp);
        publicadores1DtUsuario_1id.setApellido(apellido_6idTemp);
        publicadores1DtUsuario_1id.setNombre(nombre_7idTemp);
        sampleControladorAltaUsuarioPublishProxyid.ingresarDtUsuarioFrontEnd(publicadores1DtUsuario_1id);
break;
case 32:
        gotMethod = true;
        sampleControladorAltaUsuarioPublishProxyid.cancelarAltaUsuario();
break;
case 35:
        gotMethod = true;
        String nick_9id=  request.getParameter("nick40");
            java.lang.String nick_9idTemp = null;
        if(!nick_9id.equals("")){
         nick_9idTemp  = nick_9id;
        }
        String fechaNac_10id=  request.getParameter("fechaNac42");
            java.util.Calendar fechaNac_10idTemp = null;
        if(!fechaNac_10id.equals("")){
        java.text.DateFormat dateFormatfechaNac42 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfechaNac42  = dateFormatfechaNac42.parse(fechaNac_10id);
         fechaNac_10idTemp = new java.util.GregorianCalendar();
        fechaNac_10idTemp.setTime(dateTempfechaNac42);
        }
        String password_11id=  request.getParameter("password44");
            java.lang.String password_11idTemp = null;
        if(!password_11id.equals("")){
         password_11idTemp  = password_11id;
        }
        String correo_12id=  request.getParameter("correo46");
            java.lang.String correo_12idTemp = null;
        if(!correo_12id.equals("")){
         correo_12idTemp  = correo_12id;
        }
        String apellido_13id=  request.getParameter("apellido48");
            java.lang.String apellido_13idTemp = null;
        if(!apellido_13id.equals("")){
         apellido_13idTemp  = apellido_13id;
        }
        String nombre_14id=  request.getParameter("nombre50");
            java.lang.String nombre_14idTemp = null;
        if(!nombre_14id.equals("")){
         nombre_14idTemp  = nombre_14id;
        }
        %>
        <jsp:useBean id="publicadores1DtUsuario_8id" scope="session" class="publicadores.DtUsuario" />
        <%
        publicadores1DtUsuario_8id.setNick(nick_9idTemp);
        publicadores1DtUsuario_8id.setFechaNac(fechaNac_10idTemp);
        publicadores1DtUsuario_8id.setPassword(password_11idTemp);
        publicadores1DtUsuario_8id.setCorreo(correo_12idTemp);
        publicadores1DtUsuario_8id.setApellido(apellido_13idTemp);
        publicadores1DtUsuario_8id.setNombre(nombre_14idTemp);
        sampleControladorAltaUsuarioPublishProxyid.ingresarDtUsuario(publicadores1DtUsuario_8id);
break;
case 52:
        gotMethod = true;
        sampleControladorAltaUsuarioPublishProxyid.confirmarAltaUsuario();
break;
case 55:
        gotMethod = true;
        java.lang.String[] getInstitutos55mtemp = sampleControladorAltaUsuarioPublishProxyid.getInstitutos();
if(getInstitutos55mtemp == null){
%>
<%=getInstitutos55mtemp %>
<%
}else{
        String tempreturnp56 = null;
        if(getInstitutos55mtemp != null){
        java.util.List listreturnp56= java.util.Arrays.asList(getInstitutos55mtemp);
        tempreturnp56 = listreturnp56.toString();
        }
        %>
        <%=tempreturnp56%>
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