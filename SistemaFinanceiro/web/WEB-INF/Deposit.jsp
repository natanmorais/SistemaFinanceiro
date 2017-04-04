<%-- 
    Document   : Deposit
    Created on : 29/03/2017, 10:23:05
    Author     : tiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Financeiro - Depósito Monetário</title>
        <link rel="stylesheet" href="bootstrap.min.css" />
        <link rel="stylesheet" href="uikit.min.css" />
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <div class="parte-esquerda">

        </div>
        <div class="parte-direita fundo-colorido">
            <h1 class="text-center">Depósito</h1>
        </div>
        <div class="parte-central">
            <form method="POST" action="Deposit">
                <div class="opcoes">
                    <span>
                        <p>Insira o número da conta recebedora:</p>
                    </span>
                    <span class="opcao">
                        <input class="uk-input" type="text" name="numero"/>
                    </span>
                    <span>
                        <p>Qual o valor que deseja depositar?</p>
                    </span>
                    <span class="opcao">
                        <p><input class="uk-input" type="text" name="saldo"/>
                    </span>
                </div>
                <input type="submit" class="uk-button uk-button-default uk-button-primary" value="DEPOSITAR"></input>
            </form> 
        </div>       
    </body>
</html>