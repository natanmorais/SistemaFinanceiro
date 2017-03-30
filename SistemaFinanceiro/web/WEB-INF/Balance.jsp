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
        <title>Sistema Financeiro - Consultar Saldo</title>
    </head>
    <body>
        <div class="container">
            <header>
                <h1>Criar Conta</h1>
            </header>
            <div>
                <form method="POST" action="Balance">
                    <p>Insira o número da conta:</p>
                    <p><input type="text" name="numero"/>
                    <p><input type="submit" value="CONSULTAR"></input></p>
                </form>               
            </div>
            
        </div>
    </body>
</html>
