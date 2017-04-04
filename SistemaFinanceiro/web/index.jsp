<%-- 
    Document   : index
    Created on : 29/03/2017, 10:21:19
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

        <title>Sistema Financeiro</title>        
    </head>
    <body style="width: 100%; height: 100%">
        <div class="parte-superior fundo-colorido">
            <h1>ashaBank</h1>
        </div>
        <div class="parte-inferior">

        </div>
        <div class="parte-central">
            <form action="OpPicker">
                <div class="opcoes">
                    <span class="opcao">
                        <input name="operation" class="uk-radio" type="radio" value="create-account">Criar Conta</input>
                    </span>
                    <span class="opcao">
                        <input name="operation" class="uk-radio" type="radio" value="balance">Saldo</input>
                    </span>
                    <span class="opcao">
                        <input name="operation" class="uk-radio" type="radio" value="deposit">Depósito</input>
                    </span>
                    <span class="opcao">
                        <input name="operation" class="uk-radio" type="radio" value="transfer">Transferência</input>
                    </span>
                    <span class="opcao">
                        <input name="operation" class="uk-radio" type="radio" value="withdraw">Saque</input>
                    </span>
                    <span class="opcao">
                        <input name="operation" class="uk-radio" type="radio" value="extrato">Extrato</input>
                    </span>
                </div>
                <input type="submit" value="Proceder" class="uk-button uk-button-default uk-button-primary"></input>
            </form>
        </div>        
    </body>
</html>
