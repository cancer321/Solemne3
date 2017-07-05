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
                <h1 class="title">Bienvenido ${usuario.nombreUsuario}.</h1>
            </section>
            <jsp:include page="./menu.jsp" flush="true"/>
            <jsp:useBean id="usuario" class="entity.Usuario" scope="page"/>
            <div class="docs-section" id="meme">
                <table class="u-full-width">
                    <thead>
                        <tr>
                            <td>Username</td>
                            <td>Nombre</td>
                            <td>Apellido</td>
                            <td>Fondo</td>
                            <td>Estado</td>
                            <td>Perfil</td>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaUsu}" var="usu">
                            <tr>
                                <td><c:out value="${usu.nombreUsuario}"/></td>
                                <td><c:out value="${usu.nombre}"/></td>
                                <td><c:out value="${usu.apellido}"/></td>
                                <td><c:out value="${usu.fondo}"/></td>
                                <td><c:out value="${usu.estado}"/></td>
                                <td><c:out value="${usu.perfil.nombrePerfil}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
