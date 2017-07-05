
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
            <section class="header">
                <h1 class="title">Bienvenido ${usuario.nombreUsuario}.</h1>
            </section>
            <jsp:include page="./menu.jsp" flush="true"/>
            <div class="docs-section" id="meme">
                <form:form method="POST" commandName="usuario">
                    <div class="row">
                        <div class="six columns">
                            <form:label for="fon" path="fondo">Agregar fondo</form:label>
                            <form:input path="fondo"/>
                        </div>
                    </div>
                    <form:button>Agregar dinero</form:button>
                </form:form>
            </div>
        </div>
    </body>
</html>
