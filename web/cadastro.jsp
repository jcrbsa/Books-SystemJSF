<%-- 
    Document   : cadastro
    Created on : 26/10/2013, 18:34:07
    Author     : jcrbsa
--%>

<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro</title>
         <link rel="stylesheet" type="text/css" href="css/login.css" />
    </head>
    <body style="background-color: #f0f0f0">
        

        <br /><br /><br /><br /> 
    <center>
        <f:view>
            
        <h:form styleClass="loginform"  title="loginform">
            <h:panelGrid  cellpadding="6"  cellspacing="0" width="250" border="0" columns="2" styleClass="std" >
                 <f:facet name="header">
                        <h:outputText value="Cadastro"/>
                    </f:facet>
            <em>Email:</em>
                <h:inputText maxlength="30" size="20" styleClass="text" title="email"/>
             <em>Senha:</em>
                <h:inputSecret  size="20" styleClass="text" title="senha"  />
              <h:commandButton value="Cadastrar" action="null" styleClass="button"/>
            </h:panelGrid>
                       <h:commandLink action="login" value="Retornar login"/>
        </h:form>

             </f:view>
                 </center>

    
    <center><span style="font-size:7pt">Version 1.0.0</span><center>
    </body>
</html>
