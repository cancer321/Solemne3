<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link href="//fonts.googleapis.com/css?family=Raleway:400,300,600" rel="stylesheet" type="text/css">
        <link rel="stylesheet" href="css/normalize.css">
        <link rel="stylesheet" href="css/skeleton.css">
        <link rel="stylesheet" href="css/m.css">
        <link rel="icon" type="image/png" href="images/favicon.png">
        <title></title>
    </head>
    <body>
        <c:choose>
            <c:when test="${usuario!=null}">
                <div class="container">
                    <section class="header">
                        <h1 class="title">Bienvenido ${usuario.nombreUsuario}.</h1>
                    </section>
                    <jsp:include page="./menu.jsp" flush="true"/>
                    <div class="docs-section" id="meme">
                        <h2>mimo</h2>
                    </div>
                    <div class="docs-section" id="mimo">
                        <h6>@Todos los derechos reservados mimo de mim 6969 - 1234</h6>
                    </div>
                </div>
            </c:when>
            <c:otherwise>
                <c:redirect url="login.jsp"/>
            </c:otherwise>
        </c:choose>
    </body>
</html>
