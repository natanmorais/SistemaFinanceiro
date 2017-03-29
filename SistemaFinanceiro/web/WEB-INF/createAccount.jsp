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
        <title>Sistema Financeiro - Criar Conta</title>
    </head>
    <body>
        <div class="container">
            <header>
                <h1>Criar Conta</h1>
            </header>
            <div>
                <form method="POST" action="CreateAccount">
                    <p>Insira seu nome completo:</p>
                    <p><input type="text" name="nome"/>
                    <p>Qual o valor que deseja depositar?</p>
                    <p><input type="text" name="saldo"/>
                    <p><input type="submit" value="CADASTRAR"></input></p>
                </form>               
            </div>
            
        </div>
    </body>
</html>
