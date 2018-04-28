<%-- 
    Document   : novoEstrangeiro
    Created on : 27/04/2018, 21:58:20
    Author     : rodri
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="../jspf/cabecalho.jspf" %>
<div>
<h2>Novo Estrangeiro</h2>
    <form method="post">
        <label>Nome:<input type="text" name = "nome" value = ""/></label><br>
        <label>Disponivel de:<input type="date" name = "disponivel" value = ""/></label>
        <label>Até:<input type="date" name = "ate" value = ""/></label><br>
        <label>email:<input type="text" name = "email" value = ""/></label><br>
        <label>telefone:<input type="text" name = "telefone" value = ""/></label><br>
        <label>Idioma 1: 
            <select name ="i1" >
                
                <c:forEach var="lin" items="${lingua}">                
                    <option value="${lin.getId()}">${lin}</option> 
                </c:forEach>
            </select>
        </label>
        <label>Idioma 2: 
            <select name ="i2" >
                
                <c:forEach var="lin" items="${lingua}">                
                    <option value="${lin.getId()}">${lin}</option> 
                </c:forEach>
            </select>
        </label>
        <input type="submit" value="Inserir Estrangeiro"/>
    </form>

<%@include file="../jspf/footer.jspf" %>
</div>