<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorBuscarCursoOProgramaPublishProxyid" scope="session" class="publicadores.ControladorBuscarCursoOProgramaPublishProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorBuscarCursoOProgramaPublishProxyid.setEndpoint(request.getParameter("endpoint"));
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
        java.lang.String getEndpoint2mtemp = sampleControladorBuscarCursoOProgramaPublishProxyid.getEndpoint();
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
        sampleControladorBuscarCursoOProgramaPublishProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorBuscarCursoOProgramaPublish getControladorBuscarCursoOProgramaPublish10mtemp = sampleControladorBuscarCursoOProgramaPublishProxyid.getControladorBuscarCursoOProgramaPublish();
if(getControladorBuscarCursoOProgramaPublish10mtemp == null){
%>
<%=getControladorBuscarCursoOProgramaPublish10mtemp %>
<%
}else{
        if(getControladorBuscarCursoOProgramaPublish10mtemp!= null){
        String tempreturnp11 = getControladorBuscarCursoOProgramaPublish10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg016");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        publicadores.DtCurso[] buscarCursos13mtemp = sampleControladorBuscarCursoOProgramaPublishProxyid.buscarCursos(arg0_1idTemp);
if(buscarCursos13mtemp == null){
%>
<%=buscarCursos13mtemp %>
<%
}else{
        String tempreturnp14 = null;
        if(buscarCursos13mtemp != null){
        java.util.List listreturnp14= java.util.Arrays.asList(buscarCursos13mtemp);
        tempreturnp14 = listreturnp14.toString();
        }
        %>
        <%=tempreturnp14%>
        <%
}
break;
case 18:
        gotMethod = true;
        String arg0_2id=  request.getParameter("arg021");
            java.lang.String arg0_2idTemp = null;
        if(!arg0_2id.equals("")){
         arg0_2idTemp  = arg0_2id;
        }
        publicadores.DtProgFormacion[] buscarProgramas18mtemp = sampleControladorBuscarCursoOProgramaPublishProxyid.buscarProgramas(arg0_2idTemp);
if(buscarProgramas18mtemp == null){
%>
<%=buscarProgramas18mtemp %>
<%
}else{
        String tempreturnp19 = null;
        if(buscarProgramas18mtemp != null){
        java.util.List listreturnp19= java.util.Arrays.asList(buscarProgramas18mtemp);
        tempreturnp19 = listreturnp19.toString();
        }
        %>
        <%=tempreturnp19%>
        <%
}
break;
case 23:
        gotMethod = true;
        %>
        <jsp:useBean id="publicadores1ArrayList_3id" scope="session" class="publicadores.ArrayList" />
        <%
        publicadores.DtCurso[] ordenarCursosAlfabeticamente23mtemp = sampleControladorBuscarCursoOProgramaPublishProxyid.ordenarCursosAlfabeticamente(publicadores1ArrayList_3id);
if(ordenarCursosAlfabeticamente23mtemp == null){
%>
<%=ordenarCursosAlfabeticamente23mtemp %>
<%
}else{
        String tempreturnp24 = null;
        if(ordenarCursosAlfabeticamente23mtemp != null){
        java.util.List listreturnp24= java.util.Arrays.asList(ordenarCursosAlfabeticamente23mtemp);
        tempreturnp24 = listreturnp24.toString();
        }
        %>
        <%=tempreturnp24%>
        <%
}
break;
case 28:
        gotMethod = true;
        %>
        <jsp:useBean id="publicadores1ArrayList_4id" scope="session" class="publicadores.ArrayList" />
        <%
        publicadores.DtCurso[] ordenarCursosPorFecha28mtemp = sampleControladorBuscarCursoOProgramaPublishProxyid.ordenarCursosPorFecha(publicadores1ArrayList_4id);
if(ordenarCursosPorFecha28mtemp == null){
%>
<%=ordenarCursosPorFecha28mtemp %>
<%
}else{
        String tempreturnp29 = null;
        if(ordenarCursosPorFecha28mtemp != null){
        java.util.List listreturnp29= java.util.Arrays.asList(ordenarCursosPorFecha28mtemp);
        tempreturnp29 = listreturnp29.toString();
        }
        %>
        <%=tempreturnp29%>
        <%
}
break;
case 33:
        gotMethod = true;
        %>
        <jsp:useBean id="publicadores1ArrayList_5id" scope="session" class="publicadores.ArrayList" />
        <%
        publicadores.DtProgFormacion[] ordenarProgramasAlfabeticamente33mtemp = sampleControladorBuscarCursoOProgramaPublishProxyid.ordenarProgramasAlfabeticamente(publicadores1ArrayList_5id);
if(ordenarProgramasAlfabeticamente33mtemp == null){
%>
<%=ordenarProgramasAlfabeticamente33mtemp %>
<%
}else{
        String tempreturnp34 = null;
        if(ordenarProgramasAlfabeticamente33mtemp != null){
        java.util.List listreturnp34= java.util.Arrays.asList(ordenarProgramasAlfabeticamente33mtemp);
        tempreturnp34 = listreturnp34.toString();
        }
        %>
        <%=tempreturnp34%>
        <%
}
break;
case 38:
        gotMethod = true;
        %>
        <jsp:useBean id="publicadores1ArrayList_6id" scope="session" class="publicadores.ArrayList" />
        <%
        publicadores.DtProgFormacion[] ordenarProgramasPorFecha38mtemp = sampleControladorBuscarCursoOProgramaPublishProxyid.ordenarProgramasPorFecha(publicadores1ArrayList_6id);
if(ordenarProgramasPorFecha38mtemp == null){
%>
<%=ordenarProgramasPorFecha38mtemp %>
<%
}else{
        String tempreturnp39 = null;
        if(ordenarProgramasPorFecha38mtemp != null){
        java.util.List listreturnp39= java.util.Arrays.asList(ordenarProgramasPorFecha38mtemp);
        tempreturnp39 = listreturnp39.toString();
        }
        %>
        <%=tempreturnp39%>
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