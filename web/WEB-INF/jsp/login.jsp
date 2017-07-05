
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/skeleton.css">
        <link rel="stylesheet" href="css/m.css">
        <script src="js/jquery.min.js"></script>
        <script src="js/run_prettify.js"></script>
        <link rel="stylesheet" href="css/prettify.css">
        <script src="js/site.js"></script>
        <title></title>
    </head>
    <body>
        <div class="container">
            <div class="docs-section" id="forms">
                <h1>Login</h1>
            </div>
            <div class="docs-example">
                <form:form method="POST" modelAttribute="usuario">
                    <div class="row">
                        <div class="six columns">
                            <form:label for="usu" path="nombreUsuario">Login</form:label>
                            <form:input cssClass="u-full-width" path="nombreUsuario"/>
                        </div>
                        <div class="six columns">
                            <form:label for="pass" path="password">Password</form:label>
                            <form:password cssClass="u-full-width" path="password"/>
                        </div>
                    </div>
                    <form:button>Ingresar</form:button>
                </form:form>
                <c:url var="addUsuario" value="/addUsuario.htm">
                </c:url>
                    <td><button type="button" class="button-primary" onclick="window.location.href = '${addUsuario}'">Registrar</button></td>
                <c:if test="${error!=null}">
                    <div class="alert">
                        <strong><c:out value="${error}"/></strong>
                        <c:remove var="error"/>
                    </div>
                </c:if> 
            </div>
        </div>
    </body>
</html>
