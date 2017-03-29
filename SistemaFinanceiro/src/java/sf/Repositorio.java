package sf;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Repositorio {

    private static Connection connection;

    public static void init(String user, String password) {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/cliente", user, password);
            System.out.println("OK");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public static Cliente getCliente(int numero) {
        try {
            PreparedStatement p = connection.prepareStatement("SELECT * FROM cliente WHERE nro = ?");
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

    public static Cliente criarConta(String nome, double saldo) {
        int numero = -1;
        try {
            PreparedStatement p = connection.prepareStatement("SELECT max(numero) FROM cliente");
            ResultSet rs = p.executeQuery();
            rs.next();
            numero = rs.getInt(1) + 1;
            Cliente c = new Cliente(numero, nome, saldo);
            p.close();
            p = connection.prepareStatement("INSERT INTO cliente VALUES(?,?,?)");
            p.setInt(1, numero);
            p.setString(2, nome);
            p.setDouble(3, saldo);
            if (p.execute()) {
                return c;
            }
        } catch (Exception e) {
        }
        return null;
    }
}