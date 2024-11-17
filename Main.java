import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

    public static void main (String[] args) {

        try (Connection connection = DriverManager.getConnection(
            "jdbc:postgresql://localhost:5432/banco", 
            "postgres", 
            "Danny1053814829"
        )) {
            System.out.println("Conexion Exitosa"); 

            //crea una decladarcion
            Statement statement = connection.createStatement();

            //boolean result = statement.execute("INSERT INTO Cuentas (numero_cuenta, tipo_cuenta, saldo_cuenta) VALUES ('123434-9,', 'Ahorros', 1000) RETURNING id_cuenta");
            //se genera la consulta

            Cuenta cuenta = new Cuenta("1234877-sd", "Ahorros", 20000);
            boolean result = cuenta.inrestarCuenta(statement);
            if (result){
                System.out.println("Cuenta insertada correctamente");
            }else {
                System.out.println("No se pudo insertar la cuenta");
            }
            
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Cuentas");

            while (resultSet.next()) {
                int idCuenta = resultSet.getInt("id_cuenta");
                String numeroCuenta = resultSet.getString("numero_cuenta");
                String tipoCuenta = resultSet.getString("tipo_cuenta");
                double saldo = resultSet.getDouble("saldo_cuenta");
                
                System.out.println("ID: " + idCuenta + " Numero: " + numeroCuenta + " Tipo: " + tipoCuenta + " Saldo: "+ saldo);
            }

        }catch (SQLException e){
            System.out.println("Error de coneccion: " + e.getMessage());
        }
    }
}