package com.example.models;
import com.example.models.Cliente;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccionesCliente {
    //Insertar un nuevo cliente en la BBDD
    public static int registrarCliente(Cliente c) {
        int estado = 0;
    
        try {
            //Conexion a la BBDD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bbdd_negocio", "root","");
            //Insertar un registro
            String query = "INSERT INTO clientes values (?,?,?,?)";

            int idC = c.getId();
            String nombre = c.getNombre();
            String apellido = c.getApellido();
            String contacto = c.getContacto();

            PreparedStatement pst = conexion.prepareStatement(query);
            pst.setInt(1, idC);
            pst.setString(2, nombre);
            pst.setString(3, apellido);
            pst.setString(4, contacto);

            estado = pst.executeUpdate();

            conexion.close(); //método (close) cierra la BBDD.

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR, algo salió mal!");
        }
        return estado;    
    }
    //Actualizar un cliente en la BBDD
    public static int actualizarCliente(Cliente c) {
        int estado = 0;

        try {
            //Conexion a la BBDD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bbdd_negocio", "root","");
            //Insertar un registro
            String query = "UPDATE INTO clientes SET nombreCliente=?,apellidoCliente=?, contactoCliente=? WHERE idCliente=?";

            int idCliente = c.getId();
            String nombreCliente = c.getNombre();
            String apellidoCliente = c.getApellido();
            String contactoCliente = c.getContacto();

            PreparedStatement pst = conexion.prepareStatement(query);
            pst.setInt(1, idCliente);
            pst.setString(2, nombreCliente);
            pst.setString(3, apellidoCliente);
            pst.setString(4, contactoCliente);

            estado = pst.executeUpdate();

            conexion.close(); //método (close) cierra la BBDD.

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR, algo salió mal!");
        }
        return estado;   
    }
    //consultar registro por id
    public static Cliente verCliente(int idAConsultar){
        Cliente clienteADevolver = new Cliente();

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd_negocio","root","");
            String query = "SELECT * FROM clientes WHERE idCliente=?";

            PreparedStatement pst = conexion.prepareStatement(query);
            
            pst.setInt(1, idAConsultar);

            ResultSet consultaCliente = pst.executeQuery();

            if (consultaCliente.next()){
                clienteADevolver.setId( consultaCliente.getInt(1));
                clienteADevolver.setNombre( consultaCliente.getString(2));
                clienteADevolver.setApellido( consultaCliente.getString(3));
                clienteADevolver.setContacto( consultaCliente.getString(4));
                conexion.close();
            }
        } catch (Exception e){
            System.out.println(e);
            System.out.println("uppsss algo salio mal");
        }

        return clienteADevolver;
    }    
    //consultar todos los registros de una tabla
    public static List<Cliente> verTodosClientes(){
        List<Cliente> listaClientesADevolver = new ArrayList<Cliente>();
        

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/bbdd_negocio","root","");
            String query = "SELECT * FROM clientes";

            PreparedStatement pst = conexion.prepareStatement(query);

            ResultSet consultaCliente = pst.executeQuery();

            while (consultaCliente.next()){
                Cliente clienteADevolver = new Cliente();
                clienteADevolver.setId( consultaCliente.getInt(1));
                clienteADevolver.setNombre( consultaCliente.getString(2));
                clienteADevolver.setApellido( consultaCliente.getString(3));
                clienteADevolver.setContacto( consultaCliente.getString(4));
                listaClientesADevolver.add(clienteADevolver);
            }
            conexion.close();
        } catch (Exception e){
            System.out.println(e);
            System.out.println("uppsss algo salio mal");
        }

        return listaClientesADevolver;
    }
    //Borrar un cliente de la BBDD
    public static int borrarCliente(Cliente c) {
        int estado = 0;

        try {
            //Conexion a la BBDD
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/bbdd_negocio", "root","");
            //Insertar un registro
            String query = "DELETE FROM clientes WHERE idCliente=?";

            int idCliente = c.getId();
            String nombreCliente = c.getNombre();
            String apellidoCliente = c.getApellido();
            String contactoCliente = c.getContacto();

            PreparedStatement pst = conexion.prepareStatement(query);
            pst.setInt(1, idCliente);
            pst.setString(2, nombreCliente);
            pst.setString(3, apellidoCliente);
            pst.setString(4, contactoCliente);

            estado = pst.executeUpdate();

            conexion.close(); //método (close) cierra la BBDD.

        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("ERROR, algo salió mal!");
        }
        return estado;
    }
}
