<%-- 
    Document   : pedirEstrangeiro
    Created on : 27/04/2018, 22:39:16
    Author     : rodri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>

        <label>Estrangeiro: 
            <select name ="estrangeiro" >
                <%int i = 0;%>
                <c:forEach var="est" items="${estrangeiros}">                
                    <option value="${est.getId()}">${est}</option> <%i++;%> 
                </c:forEach>
            </select>
        </label>
                <a href="intercambio.html?id=<%=i%>">Enviar</a>
  
<%@include file="../jspf/footer.jspf" %>