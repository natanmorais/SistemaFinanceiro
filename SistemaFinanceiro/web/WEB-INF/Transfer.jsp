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
    </head>
    <body>
        <div class="container">
            <header>
                <h1>Transferência</h1>
            </header>
            <div>
                <form method="POST" action="Transfer">
                    <p>Insira o número da conta a ser retirado o dinheiro:</p>
                    <p><input type="text" name="numero1"/>
                    <p>Insira o número da conta para ser depositado o dinheiro:</p>
                    <p><input type="text" name="numero2"/>
                    <p>Qual o valor que deseja transferir?</p>
                    <p><input type="text" name="saldo"/>
                    <p><input type="submit" value="TRANSFERIR"></input></p>
                </form>               
            </div>
        </div>
    </body>
</html>
