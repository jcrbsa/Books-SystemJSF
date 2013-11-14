<%-- 
    Document   : login
    Created on : 26/10/2013, 15:47:53
    Author     : jcrbsa
--%>

<%@page contentType="text/html" pageEncoding="UTf-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html>
<html >
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTf-8"/>
        <title>JSP Page</title>
         <link rel="stylesheet" type="text/css" href="css/login.css" />
    </head>
    <body style="background-color: #f0f0f0">
        

        <br /><br /><br /><br /> 
    <center>
        <f:view>
            <h:graphicImage value="images/logo_ifpe.gif" />     
            <h:form styleClass="loginform"  title="loginform" id="formulario">
            <h:panelGrid  cellpadding="6"  cellspacing="0" width="250" border="0" columns="2" styleClass="std" >
                 <f:facet name="header">
                        <h:outputText value="Login"/>
                    </f:facet>
                <h:outputLabel value="email" for="login" id="label_login"/>
                <h:inputText id="login" value="#{loginView.login}"  size="20" styleClass="text" title="email" required="true" />
                <h:outputLabel title="#{msg.senha}" value="#{msg.senha}" for="senha" id="label_senha"/>
            <h:inputSecret  id="senha" maxlength="8" size="20" styleClass="text" value="#{loginView.password}" title="senha"  required="true"/>
             <h:commandButton  title="login" value="Login" action="#{loginView.checkLogin}" styleClass="button"/>
             <h:commandButton id="cadastrar" title="#{msg.cadastrar}" action="#{loginView.checkCadastro()}" value="#{msg.cadastrar}"  styleClass="button"/>
            </h:panelGrid>
        </h:form>
            <h:messages style="color: red" /> 
             </f:view>
                 </center>
   


    
    <center><span style="font-size:7pt">Version 1.0.0</span></center>
    </body>
</html>
