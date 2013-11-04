<%-- 
    Document   : session
    Created on : 27/10/2013, 01:13:28
    Author     : jcrbsa
--%>

<%@page contentType="text/html" pageEncoding="UTf-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Página Usuário</title>
    <link rel="stylesheet" type="text/css" href="css/menuBar.css" />

    </head>
    <body>

        <f:view>           
            <fieldset id='fieldset'>
                <legend>Opções</legend>
                <h:form>
                <h:panelGrid cellpadding="0.01px" columns="1">
              <h:outputLink styleClass="link" value="Home">
                    <h:outputText value="Home" />
                </h:outputLink>
                
                <h:outputLink styleClass="link" value="Editar Perfil">
                        <h:outputText value="Editar Perfil" />
                    </h:outputLink>
                
                <h:outputLink styleClass="link"  >

                        <h:outputText value="Historico" />
                    </h:outputLink>
         <h:outputLink styleClass="link" >

                        <h:outputText value="Sobre" />
                    </h:outputLink>
            <h:commandLink styleClass="link" action="login.jsp" >
                    <h:outputText value="Sair" />
                </h:commandLink>
                </fieldset>  
            </h:panelGrid >
            </h:form>
            
            <h2>Test booleancheckBox</h2>
            <h:form>
            <h:selectBooleanCheckbox />
            <h:commandButton value="testCheckBox"/>
            </h:form>
            
            <h:outputText value="#{livrosView.checkBox}" />
            
      
        </f:view>
    
    </body>
</html>
