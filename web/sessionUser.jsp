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
            <ul>
                <li ><h:outputLink styleClass="link" value="Home">
                    <h:outputText value="Home" />
                </h:outputLink>
                </li>
                <li ><h:outputLink styleClass="link" value="Editar Perfil">
                        <h:outputText value="Editar Perfil" />
                    </h:outputLink>
                </li>
                <li ><h:outputLink styleClass="link"  >

                        <h:outputText value="Historico" />
                    </h:outputLink></li>
                <li ><h:outputLink styleClass="link" >

                        <h:outputText value="Sobre" />
                    </h:outputLink></li>
            </ul>
                </fieldset>  
            
            
            
            <h:form>
      <h:inputText id="inputName" value="#{userData.name}"></h:inputText>
       <h:commandButton value="Show Message">
         <f:ajax execute="inputName" render="outputMessage" />
      </h:commandButton>
      <h2><h:outputText id="outputMessage"
         value="#{userData.welcomeMessage != null ?
            userData.welcomeMessage : ''}"
         /></h2>
      </h:form>
        </f:view>
    
    </body>
</html>
