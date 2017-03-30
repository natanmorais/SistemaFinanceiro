package sf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            p = connection.prepareStatement("INSERT INTO cliente VALUES(?,?,?)");
            p.setInt(1, numero);
            p.setString(2, nome);
            p.setDouble(3, saldo);
            p.executeUpdate();
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
}
