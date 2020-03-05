<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.scss" media="screen" />
     <title>Loja de Games</title>
  </head>
  <header>
  </header>
  <body>
      <div class="page-title" style="background-color: green; padding: 9px; margin-top: 0px;">
          <h1><i class="fas fa-gamepad-alt"></i>Loja de Games</h1>
      </div>
      <br>
      <div style="text-align: center;">
        <h2>Projeto Integrador IIII - TADS - 4º Semestre</h2>
        <p>Este trabalho foi desenvolvido para a disciplina de projeto integrador IIII, do Centro Universitário Senac</p>
     
        <td><a data-method="get" href="${pageContext.request.contextPath}/login" class="btn btn-lg btn-primary mb-1" >Ir para o Login</a></td>
      </div>
  </body>
  <script src="https://kit.fontawesome.com/1803175e4f.js" crossorigin="anonymous"></script>
</html>
