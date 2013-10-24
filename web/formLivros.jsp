<%-- 
    Document   : formLivros
    Created on : 18/10/2013, 16:47:30
    Author     : richardsonandrade
--%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1" language="java"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro de Livros</title>
    </head>
        <f:view>
            <h:messages />
            <h:form id="cadastro">
                <h:panelGrid columns="2">
                    <f:facet name="header">
                        <h:outputText value="Cadastro de Livros"/>
                    </f:facet>
                    <h:outputText value="ISBN:"/>
                    <h:inputText id="isbn" value="#{livrosView.livro.isbn}" required="true">
                    <f:validateLength minimum="13" maximum="13"  />
                    </h:inputText>
                    <h:outputText value="Título:"/>
                    <h:inputText size="30" id="titulo" value="#{livrosView.livro.titulo}" />
                    <h:outputText value="Edição:"/>
                    <h:inputText size="10" id="edicao" value="#{livrosView.livro.edicao}" />
                    <h:outputText value="Publicação:"/>
                    <h:inputText size="10" id="publicacao" value="#{livrosView.livro.publicacao}" />
                    <h:outputText value="Descrição:"/>
                    <h:inputTextarea cols="20" id="descricao"  value="#{livrosView.livro.descricao}" />            
                </h:panelGrid>  
                <h:commandButton value="Cadastrar" action="#{livrosView.create}" />
                <h:commandButton value="Limpar" type="reset" />
                <h:commandButton value="Cancelar" action="mostrar" />                   
            </h:form>
        </f:view>
    </body>
</html>