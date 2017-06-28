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
        <script src="js/jquery.min.js"></script>
        <script src="js/run_prettify.js"></script>
        <link rel="stylesheet" href="css/prettify.css">
        <script src="js/site.js"></script>
        <title></title>
    </head>
    <body>
        <jsp:useBean id="usuarioConectado" class="entity.Usuario" scope="page"/>
        <jsp:useBean id="objMenuPadre" class="entity.Menu" scope="page"/>
        <jsp:useBean id="objMenuHijo" class="entity.Menu" scope="page"/>
        <div class="container">
            <div class="navbar-spacer"></div>
            <nav class="navbar">
                <div class="container">
                    <ul class="navbar-list">
                        <c:set var="var" value="1" scope="page"/>
                        <c:forEach items="${listadoMenu}" var="objMenuPadre">
                            <c:if test="${objMenuPadre.padreMenu==null}">
                                <li class="navbar-item">
                                    <a class="navbar-link" href="#" data-popover="#codeNavPopover${var}"><c:out value="${objMenuPadre.nombreMenu.toString()}"></c:out></a>
                                    <div id="codeNavPopover${var}" class="popover">
                                        <ul class="popover-list">
                                            <c:forEach items="${listadoMenu}" var="objMenuHijo"> 
                                                <c:if test="${objMenuHijo.idMenu.intValue() !=0 && objMenuPadre.idMenu.intValue() ==objMenuHijo.padreMenu.intValue()}">                                                             
                                                    <li class="popover-item">
                                                        <a class="popover-link" href="<c:out value="${objMenuHijo.destinoMenu.toString()}"/>"><c:out value="${objMenuHijo.nombreMenu.toString()}"></c:out></a>
                                                        </li>                       
                                                </c:if>
                                            </c:forEach>
                                        </ul>
                                        <c:set var="var" value="${var + 1}" scope="page" />
                                    </div>
                                </li>
                            </c:if>
                        </c:forEach>
                        <li class="navbar-item">
                            <a class="navbar-link" href="#">Salir</a>
                        </li>
                    </ul>
                </div>
            </nav>
        </nav>
    </div>
</body>
</html>
