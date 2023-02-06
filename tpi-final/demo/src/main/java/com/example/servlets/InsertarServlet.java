package com.mycompany.web.servlets;

import com.mycompany.web.models.Cliente;

import java.io.IOException;

import com.mycompany.web.models.AccionesCliente ;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/nuevocliente")
public class InsertarServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String n , a, c;

        n = req.getParameter("nombre");

        a = req.getParameter("apellido");

        c = req.getParameter("contacto");

        Cliente nuevoCliente = new Cliente();

        nuevoCliente.setNombre(n);
        nuevoCliente.setApellido(a);
        nuevoCliente.setContacto(c);

        int estado = AccionesCliente.registrarCliente(nuevoCliente);

        if (estado == 1){
            resp.sendRedirect("exito.jsp");
            System.out.println("todo ok");
        } else {
            System.out.println("Error");
            resp.sendRedirect("error.jsp");
        }



    }
}
