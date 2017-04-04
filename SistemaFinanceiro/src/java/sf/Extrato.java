/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sf;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Extrato {

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getConta() {
        return conta;
    }

    public void setConta(String conta) {
        this.conta = conta;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public long getData() {
        return data;
    }
    
    public String getDataFormatada() {
        return new SimpleDateFormat("dd/MM/yyyy HH:mm").format(new Date(getData()));
    }
    
    private int tipo;
    private String conta;
    private double valor;
    private long data;
    
    public Extrato() {
        
    }

    public Extrato(int tipo, String conta, double valor, long data) {
        this.tipo = tipo;
        this.conta = conta;
        this.valor = valor;
        this.data = data;
    }
}
