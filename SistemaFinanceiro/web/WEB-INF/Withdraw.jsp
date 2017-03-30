<%-- 
    Document   : Withdraw
    Created on : 29/03/2017, 10:22:52
    Author     : tiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Financeiro - Saque</title>
        <link rel="stylesheet" href="bootstrap.min.css" />
        <link rel="stylesheet" href="uikit.min.css" />
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <div class="container">
            <header>
                <h1 class="text-center">Saque</h1>
            </header>
            <div class="col-md-6 col-md-offset-3">
                <form method="POST" action="Withdraw">
                    <p>Insira o número da conta a qual o valor será retirado:</p>
                    <p><input class="uk-input" type="text" name="numero"/>
                    <p>Qual o valor que deseja retirar?</p>
                    <p><input class="uk-input" type="text" name="saldo"/>
                    <p><input type="submit"  class="uk-button uk-button-default uk-button-primary" value="RETIRAR"></input></p>
                </form>               
            </div>
        </div>
    </body>
</html>
