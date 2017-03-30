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
    </head>
    <body>
        <div class="container">
            <header>
                <h1>Saque</h1>
            </header>
            <div>
                <form method="POST" action="Withdraw">
                    <p>Insira o número da conta a qual o valor será retirado:</p>
                    <p><input type="text" name="numero"/>
                    <p>Qual o valor que deseja retirar?</p>
                    <p><input type="text" name="saldo"/>
                    <p><input type="submit" value="RETIRAR"></input></p>
                </form>               
            </div>
        </div>
    </body>
</html>
