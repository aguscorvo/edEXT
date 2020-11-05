<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorAgregarCursoAPFPublishProxyid" scope="session" class="publicadores.ControladorAgregarCursoAPFPublishProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorAgregarCursoAPFPublishProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorAgregarCursoAPFPublishProxyid.getEndpoint();
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
        sampleControladorAgregarCursoAPFPublishProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorAgregarCursoAPFPublish getControladorAgregarCursoAPFPublish10mtemp = sampleControladorAgregarCursoAPFPublishProxyid.getControladorAgregarCursoAPFPublish();
if(getControladorAgregarCursoAPFPublish10mtemp == null){
%>
<%=getControladorAgregarCursoAPFPublish10mtemp %>
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
        java.lang.String[] getCursos17mtemp = sampleControladorAgregarCursoAPFPublishProxyid.getCursos();
if(getCursos17mtemp == null){
%>
<%=getCursos17mtemp %>
<%
}else{
        String tempreturnp18 = null;
        if(getCursos17mtemp != null){
        java.util.List listreturnp18= java.util.Arrays.asList(getCursos17mtemp);
        tempreturnp18 = listreturnp18.toString();
        }
        %>
        <%=tempreturnp18%>
        <%
}
break;
case 20:
        gotMethod = true;
        java.lang.String[] getProgramas20mtemp = sampleControladorAgregarCursoAPFPublishProxyid.getProgramas();
if(getProgramas20mtemp == null){
%>
<%=getProgramas20mtemp %>
<%
}else{
        String tempreturnp21 = null;
        if(getProgramas20mtemp != null){
        java.util.List listreturnp21= java.util.Arrays.asList(getProgramas20mtemp);
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
        sampleControladorAgregarCursoAPFPublishProxyid.seleccionarPrograma(arg0_1idTemp);
break;
case 28:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg031");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        sampleControladorAgregarCursoAPFPublishProxyid.seleccionarCurso(arg0_2idTemp);
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