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
        <div class="container">
            <section class="header">
                <jsp:useBean id="usuarioConectado" class="entity.Usuario" scope="page"/>
                <jsp:useBean id="sorteo" class="entity.Sorteo" scope="page"/>
                <jsp:useBean id="HG" class="entity.HistorialGanadores" scope="page"/>
                <h1 class="title">Bienvenido</h1>
            </section>
            <jsp:include page="./menu.jsp" flush="true"/>
            <div class="docs-section" id="meme">
                <h4>Sorteos</h4>
                <table class="u-full-width">
                    <thead>
                        <tr>
                            <td>Combinacion</td>
                            <td>Fecha Sorteo</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaSorteo}" var="sorteo">
                            <tr>
                                <td><c:out value="${sorteo.combinacion}"/></td>
                                <td><c:out value="${sorteo.fechaSorteo}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="docs-section" id="meme">
                <h4>Historial</h4>
                <table class="u-full-width">
                    <thead>
                        <tr>
                            <td>Nombre Usuario</td>
                            <td>Fecha juego</td>
                            <td>Cantidad de aciertos ganados</td>
                            <td>Combinacion</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaHG}" var="HG">
                            <tr>
                                <td><c:out value="${HG.usuarioJuego.usuario.nombreUsuario}"/></td>
                                <td><c:out value="${HG.usuarioJuego.fechaJuego}"/></td>
                                <td><c:out value="${HG.usuarioJuego.juego.ganadorAciertos}"/></td>
                                <td><c:out value="${HG.usuarioJuego.juego.combinacion}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
