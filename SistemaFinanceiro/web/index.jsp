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
    <body>
        <div class="container">
            <header>
                <h1 class="text-center">ashaBank</h1>
            </header>
            <div class="col-md-6 col-md-offset-3">
                <form action="OpPicker">
                    <div class="operations uk-card">
                        <input name="operation" class="uk-radio" type="radio" value="create-account"> Create Account</input></br>
                        <input name="operation" class="uk-radio" type="radio" value="balance"> Balance</input></br>
                        <input name="operation" class="uk-radio" type="radio" value="deposit"> Deposit</input></br>
                        <input name="operation" class="uk-radio" type="radio" value="transfer"> Transfer</input></br>
                        <input name="operation" class="uk-radio" type="radio" value="withdraw"> Withdraw</input>
                    </div>
                    </br>
                    </br>
                    <input type="submit" value="Confirm" class="uk-button uk-button-default uk-button-primary"></input>
                </form>
            </div>
        </div>
    </body>
</html>
