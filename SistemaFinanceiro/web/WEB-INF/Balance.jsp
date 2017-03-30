<%-- 
    Document   : Balance
    Created on : 29/03/2017, 10:23:41
    Author     : tiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Financeiro - Consultar Saldo</title>
        <link rel="stylesheet" href="bootstrap.min.css" />
        <link rel="stylesheet" href="uikit.min.css" />
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <div class="container">
            <header>
                <h1 class="text-center">Saldo</h1>
            </header>
            <div class="col-md-6 col-md-offset-3">
                <form method="POST" action="Balance">
                    <p>Insira o número da conta:</p>
                    <p><input class="uk-input"type="text" name="numero"/>
                    <p><input class="uk-button uk-button-default uk-button-primary" type="submit" value="CONSULTAR"></input></p>
                </form>               
            </div>

        </div>
    </body>
</html>
