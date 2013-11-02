<%-- 
    Document   : sessionAdmin
    Created on : 28/10/2013, 18:14:49
    Author     : jcrbsa
--%>

<%@page contentType="text/html" pageEncoding="UTf-8"%>
<%@taglib uri="http://java.sun.com/jsf/core" prefix="f"%>
<%@taglib uri="http://java.sun.com/jsf/html" prefix="h"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin</title>
                <link rel="stylesheet" type="text/css" href="css/menuBar.css" />
    </head>
    <body>
   <f:view>
 
        <fieldset>
                        <legend>Opções</legend>
                        <h:form>
        <ul>
            <li ><h:outputLink styleClass="link" value="Home">
                    <h:outputText value="Home" />
                </h:outputLink>
            </li>
            <li ><h:outputLink styleClass="link" value="Editar Perfil">
                    <h:outputText value="Editar Perfil" />
                </h:outputLink>
            </li>
            <li ><h:commandLink action="crudLivros" styleClass="link" >
                    <h:outputText value="Livros"  />
              </h:commandLink></li>
            <li ><h:commandLink action="crudUsuarios" styleClass="link" >
                    <h:outputText value="Usuarios"  />
              </h:commandLink></li>
            <li ><h:outputLink styleClass="link" >
                    <h:outputText value="Historico" />
                </h:outputLink></li>
            <li ><h:outputLink styleClass="link" >
                    <h:outputText value="Gráficos" />
                </h:outputLink></li>
            <li ><h:outputLink styleClass="link" >
                    <h:outputText value="Sobre" />
                </h:outputLink></li>
        </ul>
        
        </h:form>

            </fieldset>
                </f:view>
</body>
</html>
