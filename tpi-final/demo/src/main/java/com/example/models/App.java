/* PRUEBA I
package com.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args )
    {
        try{
            //JDBC para conectarnos a una BBDD:
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("el POM está OK :)");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
            System.out.println("revisa el POM :(");
        }

        try {
            //Conexion a la BBDD:
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bbdd_negocio", "root","");
            System.out.println("la Conexión está OK :)");
            //Insertar un registro:
            String sqlquery = "INSERT INTO clientes values (?,?,?,?)";
            //Registro BBDD:
            int idCliente = 1;
            String nombreCliente = "juan";
            String apellidoCliente = "perez";
            String contactoCliente = "jp@aol.com";

            PreparedStatement pst = conexion.prepareStatement(sqlquery);
            pst.setInt(1, idCliente);
            pst.setString(2, nombreCliente);
            pst.setString(3, apellidoCliente);
            pst.setString(4, contactoCliente);

            pst.executeUpdate();

            conexion.close();

        } catch (SQLException a) {
            System.out.println(a.getMessage());
            System.out.println("No me pude conectar a la BBDD");
        }
    }
}
*/
/* PRUEBA II
package com.example;
import com.example.AccionesCliente;
import com.example.models.*;

public class App 
{
    public static void main( String[] args )
    {
        Cliente nuevoCliente = new Cliente(2,"pilar","alcorta","pili@yahoo.com");

        int estadoInsercion = AccionesCliente.registrarCliente(nuevoCliente);

        if (estadoInsercion == 1){
            System.out.println("Se insertó el nuevo cliente correctamente");
        } else {
            System.out.println("ERROR, No se pudo insertasr el nuevo cliente");
        }
    }
}
*/