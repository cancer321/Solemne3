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
                <jsp:useBean id="usu" class="entity.Usuario" scope="page"/>
                <h1 class="title">Bienvenido ${usuario.nombreUsuario}.</h1>
            </section>
            <jsp:include page="./menu.jsp" flush="true"/>
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
                                <c:if test="${usu.estado==0}">
                                    <td>Deshabilitado</td>
                                </c:if>
                                <c:if test="${usu.estado==1}">
                                    <td>Habilitado</td>
                                </c:if>
                                <td><c:out value="${usu.perfil.nombrePerfil}"/></td>
                                <c:url var="editar" value="/editUsuario.htm">
                                    <c:param name="id_usuario" value="${usu.idUsuario}"/>
                                </c:url>
                                <td><button type="button" class="btn btn-xs btn-warning" onclick="window.location.href = '${editar}'">Editar</button></td>                                            
                                <c:if test="${usu.estado==0}">
                                    <c:url var="eliminar" value="/deleteUsuario.htm">
                                        <c:param name="id_usuario" value="${usu.idUsuario}"/>
                                    </c:url>
                                    <td><button type="button" onclick="window.location.href = '${eliminar}'">Habilitar</button></td>
                                </c:if>
                                <c:if test="${usu.estado==1}">
                                    <c:url var="eliminar" value="/deleteUsuario.htm">
                                        <c:param name="id_usuario" value="${usu.idUsuario}"/>
                                    </c:url>
                                    <td><button type="button" onclick="window.location.href = '${eliminar}'">Deshabilitar</button></td>
                                </c:if>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
