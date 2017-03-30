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
    </head>
    <body>
        <div class="container">
            <header>
                <h1>Depósito</h1>
            </header>
            <div>
                <form method="POST" action="Deposit">
                    <p>Insira o número da conta recebedora:</p>
                    <p><input type="text" name="numero"/>
                    <p>Qual o valor que deseja depositar?</p>
                    <p><input type="text" name="saldo"/>
                    <p><input type="submit" value="DEPOSITAR"></input></p>
                </form>               
            </div>
        </div>
    </body>
</html>