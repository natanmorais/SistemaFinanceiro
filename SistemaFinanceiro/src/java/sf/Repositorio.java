package sf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transaction;

public class Repositorio {

    private static Connection connection;

    public static void init(String user, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/banco", user, password);
            System.out.println("OK");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Cliente getCliente(int numero) {
        try {
            PreparedStatement p = connection.prepareStatement("SELECT * FROM cliente WHERE numero = ?");
            p.setInt(1, numero);
            ResultSet rs = p.executeQuery();
            if (rs != null && rs.next()) {
                return new Cliente(rs.getInt(1), rs.getString(2), rs.getDouble(3));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Cliente[] transferMoney(int envia, int recebe, double valor) {
        try {
            Cliente[] c = new Cliente[2];
            //Transaction
            connection.setAutoCommit(false);
            PreparedStatement p = connection.prepareStatement("UPDATE cliente SET saldo = saldo - ? WHERE numero = ?");
            p.setDouble(1, valor);
            p.setInt(2, envia);
            p.executeUpdate();
            p.close();
            p = connection.prepareStatement("UPDATE cliente SET saldo = saldo + ? WHERE numero = ?");
            p.setDouble(1, valor);
            p.setInt(2, recebe);
            p.executeUpdate();
            p.close();
            connection.commit();
            //Obter os dois clientes.
            p = connection.prepareStatement("SELECT * FROM cliente WHERE numero = ?");
            p.setInt(1, envia);
            ResultSet rs = p.executeQuery();
            if (rs != null && rs.next()) {
                c[0] = new Cliente(rs.getInt(1), rs.getString(2), rs.getDouble(3));
            }
            p.close();
            p = connection.prepareStatement("SELECT * FROM cliente WHERE numero = ?");
            p.setInt(1, recebe);
            rs = p.executeQuery();
            if (rs != null && rs.next()) {
                c[1] = new Cliente(rs.getInt(1), rs.getString(2), rs.getDouble(3));
            }
            p.close();
            connection.setAutoCommit(false);
            criarEntradaNoExtrato(TRANSFER_TYPE, envia, -valor);
            criarEntradaNoExtrato(TRANSFER_TYPE, recebe, valor);
            connection.commit();
            return c;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static Cliente withdrawMoney(int numero, double value) {
        try {
            PreparedStatement p = connection.prepareStatement("SELECT * FROM cliente WHERE numero = ?");
            p.setInt(1, numero);
            ResultSet rs = p.executeQuery();
            if (rs != null && rs.next()) {
                double novoSaldo;
                Cliente c = new Cliente(rs.getInt(1), rs.getString(2), rs.getDouble(3));
                novoSaldo = c.getSaldo();
                novoSaldo -= value;
                p.close();
                p = connection.prepareStatement("UPDATE cliente SET saldo = ? WHERE numero = ?");
                p.setDouble(1, novoSaldo);
                p.setInt(2, numero);
                p.executeUpdate();
                criarEntradaNoExtrato(WITHDRAW_TYPE, numero, -value);
                return c;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Cliente depositMoney(int numero, double value) {
        try {
            PreparedStatement p = connection.prepareStatement("SELECT * FROM cliente WHERE numero = ?");
            p.setInt(1, numero);
            ResultSet rs = p.executeQuery();
            if (rs != null && rs.next()) {
                double novoSaldo = value;
                Cliente c = new Cliente(rs.getInt(1), rs.getString(2), rs.getDouble(3));
                novoSaldo += c.getSaldo();
                p.close();
                p = connection.prepareStatement("UPDATE cliente SET saldo = ? WHERE numero = ?");
                p.setDouble(1, novoSaldo);
                p.setInt(2, numero);
                p.executeUpdate();
                criarEntradaNoExtrato(DEPOSIT_TYPE, numero, value);
                return c;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static Cliente criarConta(String nome, double saldo) {
        int numero = -1;
        System.out.println("Na função!");
        try {
            System.out.println("Entrou try");
            PreparedStatement p = connection.prepareStatement("SELECT max(numero) FROM cliente");
            ResultSet rs = p.executeQuery();
            System.out.println("passou execute");
            if (rs.next()) {
                numero = rs.getInt(1) + 1;
            } else {
                numero = 1000;
            }
            System.out.println("passou if else");
            Cliente c = new Cliente(numero, nome, saldo);
            p.close();
            System.out.println("Codigo: " + numero);
            connection.setAutoCommit(false);
            p = connection.prepareStatement("INSERT INTO cliente VALUES(?,?,?)");
            p.setInt(1, numero);
            p.setString(2, nome);
            p.setDouble(3, saldo);
            p.executeUpdate();
            p.close();
            p = connection.prepareStatement("INSERT INTO transacao VALUES(?,?,?");
            connection.commit();
            //if (p.executeUpdate()) {
            System.out.println("Entrou!");
            return c;
            //}
        } catch (Exception e) {
            System.out.println("Entrou catch " + e.getMessage());
        }
        System.out.println("Saindo com null");
        return null;
    }

    //create table extrato (id serial, tipo int, c1 int, valor float);
    public static final int BALANCE_TYPE = 3;
    public static final int DEPOSIT_TYPE = 2;
    public static final int TRANSFER_TYPE = 1;
    public static final int WITHDRAW_TYPE = 4;

    public static List<Extrato> verExtrato(int numero) {
        List<Extrato> extratos = new ArrayList<>();
        try {
            PreparedStatement p = connection.prepareStatement("select * from extrato e where e.conta = ?");
            p.setInt(1, numero);
            ResultSet rs = p.executeQuery();
            if (rs != null && rs.next()) {
                do {
                    int tipo = rs.getInt(2);
                    String c1 = null, c2 = null;
                    c1 = getCliente(rs.getInt(3)).getNome();
                    double valor = rs.getDouble(4);
                    long data = rs.getLong(5);
                    extratos.add(new Extrato(tipo, c1, valor, data));
                } while (rs.next());
            }
            return extratos;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static void criarEntradaNoExtrato(int tipo, int cliente, double valor) {
        System.out.println("Entrou no extrato!");
        try {
            PreparedStatement p = connection.prepareStatement("INSERT INTO extrato (tipo, conta, valor, data) VALUES(?, ?, ?, ?)");
            p.setInt(1, tipo);
            p.setInt(2, cliente);
            p.setDouble(3, valor);
            p.setLong(4, System.currentTimeMillis());
            p.executeUpdate();
            System.out.println("Executou extrato!");
            p.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
