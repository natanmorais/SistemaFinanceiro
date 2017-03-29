
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
}
