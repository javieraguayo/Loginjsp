<%-- 
    Document   : index
    Created on : 21-08-2016, 22:48:31
    Author     : Javier
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Iniciar Sesión</title>
    </head>
    <body>
        <h1>Iniciar Sesión</h1>
        <form action="Iniciar" method="post">
            <label>Usuario</label>         
            <input type="text" name="usuario"/><br>
            <label>Contraseña</label>
            <input type="password" name="pass"/><br>
            <input type="submit" value="Iniciar Sesión"/> 
        </form>
        <br>
        <label>¿No tienes una cuenta ?</label><a href="registro.jsp">Registrarme</a>
    </body>
</html>
