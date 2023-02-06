package com.example.models;

public class Cliente {
    int idCliente;
    String nombreCliente, apellidoCliente, contactoCliente;
    //defino 2 constructores:
    public Cliente(int idCliente, String nombreCliente, String apellidoCliente, String contactoCliente){
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.contactoCliente = contactoCliente;
    }
    public Cliente() {

    }

    //BBDD idCliente
    public int getId(){
        return idCliente;
    }
    public void setId(int nuevoId){
        this.idCliente = nuevoId;
    }
    //BBDD nombreCliente
    public String getNombre(){
        return nombreCliente;
    }
    public void setNombre(String nuevoNombre){
        this.nombreCliente = nuevoNombre;
    }
    //BBDD apellidoCliente
    public String getApellido(){
        return apellidoCliente;
    }
    public void setApellido(String nuevoApellido){
        this.apellidoCliente = nuevoApellido;
    }
    //BBDD contactoCliente
    public String getContacto(){
        return contactoCliente;
    }
    public void setContacto(String nuevoContacto){
        this.contactoCliente = nuevoContacto;
    }

}
