<%-- 
    Document   : index
    Created on : 27/04/2018, 21:31:30
    Author     : rodri
--%>


<%@page import="Classes.Anfitriao"%>
<%@page import="Classes.Estrangeiro"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="../jspf/cabecalho.jspf" %>
<h2>Pedidos </h2>
<div>
    <table>
        <thead>
        <th>Anfitrião</th>
        <th>Estrangeiro</th>
        </thead>
        <tbody><tr><td>
    <table>
        <thead> 
            <th>Nome</th>
            <th>Endereco</th>
            <th>Disponibilidade</th>
            <th>email</th>
            <th>telefone</th>
            <th>linguas</th>
        </thead> 
        <tbody>
            <%
                int i = 0;
                for (Anfitriao a: (List<Anfitriao>) request.getAttribute("anfitrioes")) {
            %>
            <tr>
                <td><%=a.getNome()%></td>
                <td><%=a.getEndereco()%></td>
                <td><%=a.getDisponibilidade()%></td>
                <td><%=a.getEmail()%></td>
                <td><%=a.getTelefone()%></td>
                <%for(int j = 0; j < a.getLinguagens().size();j++){%>
                    <td><%=a.getLinguagens().get(j)%></td>
                    <%}%>
                
            </tr>
            <%
                i++;
                }
            %>   
        </tbody>
    </table>
        </td>
        <td><table>
        <thead> 
            <th>Nome</th>
            <th>Disponibilidade</th>
            <th>email</th>
            <th>telefone</th>
            <th>linguas</th>
        </thead> 
        <tbody>
            <%
                int k = 0;
                for (Estrangeiro a: (List<Estrangeiro>) request.getAttribute("estrangeiros")) {
            %>
            <tr>
                <td><%=a.getNome()%></td>
                <td><%=a.getDisponibilidade()%></td>
                <td><%=a.getEmail()%></td>
                <td><%=a.getTelefone()%></td>
                <%for(int j = 0; j < a.getLinguagens().size();j++){%>
                    <td><%=a.getLinguagens().get(j)%></td>
                    <%}%>
                
            </tr>
            <%
                k++;
                }
            %>   
        </tbody>
    </table>
        </td>
        </tr>
        </tbody>
    </table>        
            
</div>
<%@include file="../jspf/footer.jspf" %>
