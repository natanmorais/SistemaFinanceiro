<%-- 
    Document   : createAccount
    Created on : 29/03/2017, 10:22:16
    Author     : tiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="bootstrap.min.css" />
        <link rel="stylesheet" href="uikit.min.css" />
        <link rel="stylesheet" href="style.css" />
        <title>Sistema Financeiro - Criar Conta</title>
    </head>
    <body>
        <div class="container">
            <header>
                <h1 class="text-center">Criar Conta</h1>
            </header>
            <div class="col-md-6 col-md-offset-3">
                <form method="POST" action="CreateAccount">
                    <p>Insira seu nome completo:</p>
                    <p><input class="uk-input" type="text" name="nome"/>
                    <p>Qual o valor que deseja depositar?</p>
                    <p><input class="uk-input" type="text" name="saldo"/>
                    <p><input  class="uk-button uk-button-default uk-button-primary" type="submit" value="CADASTRAR"></input></p>
                </form>               
            </div>
            
        </div>
    </body>
</html>
