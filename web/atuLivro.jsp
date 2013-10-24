<%-- 
    Document   : atuLivro
    Created on : 18/10/2013, 16:59:40
    Author     : richardsonandrade
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1" language="java"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Atualizar Livros</title>
    </head>
    <body>
        <f:view>
            <h:form id="cadastro">
                <h:panelGrid columns="2">
                    <f:facet name="header">
                        <h:outputText value="Atualizar Livros"/>
                    </f:facet>
                    <h:outputText value="ISBN:" />
                    <h:inputText size="15" id="isbn" value="#{livrosView.livro.isbn}" readonly="true"/>
                    <h:outputText value="Título:"/>
                    <h:inputText size="30" id="titulo" value="#{livrosView.livro.titulo}" />
                    <h:outputText value="Edição:"/>
                    <h:inputText size="10" id="edicao" value="#{livrosView.livro.edicao}" />
                    <h:outputText value="Publicação:"/>
                    <h:inputText size="10" id="publicacao" value="#{livrosView.livro.publicacao}" converter="converteAnoMySQL"/>
                    <h:outputText value="Descrição:"/>
                    <h:inputTextarea cols="20" id="descricao" rows="5" value="#{livrosView.livro.descricao}" />
                </h:panelGrid>
                <h:commandButton value="Atualizar" action="#{livrosView.update}" />
                <h:commandButton value="Redefinir" type="reset" />
                <h:commandButton value="Cancelar" action="mostrar" />
            </h:form>
        </f:view>
    </body>
</html>
