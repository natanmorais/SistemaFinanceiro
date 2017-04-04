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
        <title>Sistema Financeiro - Extrato</title>
        <link rel="stylesheet" href="bootstrap.min.css" />
        <link rel="stylesheet" href="uikit.min.css" />
        <link rel="stylesheet" href="style.css" />
    </head>
    <body>
        <div class="parte-esquerda">

        </div>
        <div class="parte-direita fundo-colorido">
            <h1>Extrato</h1>
        </div>
        <div class="parte-central">
            <form method="POST" action="VerExtrato">
                <div class="opcoes">
                    <span>
                        <p>Insira o número da conta:</p>
                    </span>
                    <span class="opcao">
                        <input id="numero" class="uk-input"type="text" name="numero"/>
                    </span>
                </div>
                <input class="uk-button uk-button-default uk-button-primary" type="submit" value="CONSULTAR"></input>
            </form>
        </div>    
    </body>
</html>
