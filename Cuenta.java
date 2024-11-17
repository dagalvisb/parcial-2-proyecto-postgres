import java.sql.SQLException;
import java.sql.Statement;

public class Cuenta {
    
    String numero;
    String tipo;
    double saldo;
    
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    
    public Cuenta (String numero, String tipo, double saldo){
        
        this.numero = numero;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public Cuenta (String numero, String tipo){
        this(numero, tipo, 0);
    }

    public boolean retirarSaldo(double cantidadARetirar){
        if (cantidadARetirar <= this.saldo){
            this.saldo -= cantidadARetirar;
            return true;
        }else{
            return false;
        }
    }

    public void consignarSaldo(double cantidadAConsignar){
        this.saldo += cantidadAConsignar;
    }

    public double consultarSaldo(){
        return this.saldo;
    }

    boolean inrestarCuenta(Statement statement){
        try {
            statement.execute("INSERT INTO Cuentas (numero_cuenta, tipo_cuenta, saldo_cuenta) VALUES ('" + this.numero + "', '" + this.tipo + "', " + this.saldo + ") RETURNING id_cuenta");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
