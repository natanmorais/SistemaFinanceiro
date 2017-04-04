<%-- 
    Document   : Transfer
    Created on : 29/03/2017, 10:23:26
    Author     : tiago
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema Financeiro - Transferência Bancária</title>
        <link rel="stylesheet" href="bootstrap.min.css" />
        <link rel="stylesheet" href="uikit.min.css" />
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <div class="parte-esquerda fundo-colorido">
            <h1>Transferência</h1>
        </div>
        <div class="parte-direita">
        </div>
        <div class="parte-central">
            <form method="POST" action="Transfer">
                <div class="opcoes">
                    <span>
                        <p>Insira o número da conta a ser retirado o dinheiro:</p>
                    </span>
                    <span class="opcao">
                        <input class="uk-input" type="text" name="numero1"/>
                    </span>
                    <span>
                        <p>Insira o número da conta para ser depositado o dinheiro:</p>
                    </span>
                    <span class="opcao">
                        <input class="uk-input" type="text" name="numero2"/>
                    </span>
                    <span>
                        <p>Qual o valor que deseja transferir?</p>
                    </span>
                    <span class="opcao">
                        <input class="uk-input" type="text" name="saldo"/>
                    </span>
                </div>
                <input type="submit"  class="uk-button uk-button-default uk-button-primary" value="TRANSFERIR"></input>
            </form> 
        </div>        
    </body>
</html>
