
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"   %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">
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
                <h1 class="docs-header">Login</h1>
            </div>
            <div class="docs-example">
                <form:form method="POST" modelAttribute="usuario">
                    <div class="row">
                        <div class="twelve column">
                            <form:label for="usu" path="nombreUsuario">Login</form:label>
                            <form:input cssClass="u-full-width" path="nombreUsuario"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="twelve column">
                            <form:label for="pass" path="password">Password</form:label>
                            <form:input cssClass="u-full-width" path="password"/>
                        </div>
                    </div>
                    <form:button>Ingresar</form:button>
                </form:form>
                <c:url var="agregarUsu" value="/agregarUsu">
                </c:url>
                <td><button type="button"  onclick="window.location.href = '${agregarUsu}'">Registrar</button></td>
            </div>
        </div>
    </body>
</html>
