<%-- 
    Document   : menu
    Created on : 18/10/2013, 16:16:13
    Author     : richardsonandrade
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1" language="java"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>JavaServerFaces e DAO</title>
    </head>
    <body>
    <center>
        <h1>Menu</h1>
        <f:view>
            <h:form>
                <h:commandLink action="#{livrosView.novoLivro}" value="Cadastro de Livros" />
                <br />
                <h:commandLink action="mostrar" value="Mostrar Livros Cadastrados" /><br />
                <h:commandLink action="crudLivros" value="Mostrar Livros Cadastrados" /><br />

            </h:form>
        </f:view>
                
                </center>
    </body>
</html>
