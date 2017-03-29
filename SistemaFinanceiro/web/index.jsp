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
        <link rel="stylesheet" href="style.css" />

        <title>Sistema Financeiro</title>        
    </head>
    <body>
        <div class="container">
            <header>
                <h1>Asha Bank</h1>
            </header>
            <div class="body">
                <form action="OpPicker">
                    <div class="operations">
                        <input name="operation" type="radio" value="create-account"> Create Account</input></br>
                        <input name="operation" type="radio" value="balance"> Balance</input></br>
                        <input name="operation" type="radio" value="deposit"> Deposit</input></br>
                        <input name="operation" type="radio" value="transfer"> Transfer</input></br>
                        <input name="operation" type="radio" value="balance"> Balance</input>
                    </div>
                    </br>
                    </br>
                    <input type="submit" value="Confirm"></input>
                </form>
            </div>
        </div>
    </body>
</html>
