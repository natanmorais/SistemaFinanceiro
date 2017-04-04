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
        <div class="parte-esquerda fundo-colorido">
            <h1>Criar Conta</h1>                
        </div>
        <div class="parte-direita">

        </div>
        <div class="parte-central">
            <form method="POST" action="CreateAccount">
                <div class="opcoes">
                    <p>
                        Insira seu nome completo:
                    </p>
                    <span class="opcao">
                        <input class="uk-input" type="text" name="nome"/>
                    </span>
                    <p>
                        Qual o valor que deseja depositar?
                    </p>
                    <span class="opcao">
                        <input class="uk-input" type="text" name="saldo"/>
                    </span>
                </div>
                <input  class="uk-button uk-button-default uk-button-primary" type="submit" value="CADASTRAR"></input>
            </form> 
        </div>        
    </body>
</html>
