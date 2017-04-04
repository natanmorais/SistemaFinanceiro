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

    public String getCliente1() {
        return cliente1;
    }

    public void setCliente1(String cliente1) {
        this.cliente1 = cliente1;
    }

    public String getCliente2() {
        return cliente2;
    }

    public void setCliente2(String cliente2) {
        this.cliente2 = cliente2;
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
    private String cliente1;
    private String cliente2;
    private double valor;
    private long data;
    
    public Extrato() {
        
    }

    public Extrato(int tipo, String cliente1, String cliente2, double valor, long data) {
        this.tipo = tipo;
        this.cliente1 = cliente1;
        this.cliente2 = cliente2;
        this.valor = valor;
        this.data = data;
    }
}
