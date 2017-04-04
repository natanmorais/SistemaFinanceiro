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
        <div class="parte-esquerda">

        </div>
        <div class="parte-direita fundo-colorido">
            <h1>Saque</h1>
        </div>
        <div class="parte-central">
            <form method="POST" action="Withdraw">
                <div class="opcoes">
                    <span>
                        <p>Insira o número da conta a qual o valor será retirado:</p>
                    </span>
                    <span class="opcao">
                        <input class="uk-input" type="text" name="numero"/>
                    </span>
                    <span>
                        <p>Qual o valor que deseja retirar?</p>
                    </span>
                    <span class="opcao">
                        <input class="uk-input" type="text" name="saldo"/>
                    </span>
                </div>
                <input type="submit"  class="uk-button uk-button-default uk-button-primary" value="RETIRAR"></input>
            </form>  
        </div>      
    </body>
</html>
