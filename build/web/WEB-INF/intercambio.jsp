<%-- 
    Document   : intercambio
    Created on : 27/04/2018, 22:54:22
    Author     : rodri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<h2>Criando Intercambio</h2>    
<form method="post">
        <label>Anfitrião: 
            <select name ="anfitriao" >
                <c:forEach var="anf" items="${anfitrioes}">                
                    <option value="${anf.getId()}">${anf}</option>  
                </c:forEach>
            </select>
        </label>
        <input type="submit" value="Inserir">
    </form>
<%@include file="../jspf/footer.jspf" %>
