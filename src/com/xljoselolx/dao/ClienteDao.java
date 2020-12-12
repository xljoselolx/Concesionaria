package com.xljoselolx.dao;

import com.xljoselolx.model.Cliente;
import com.xljoselolx.util.ConectorBD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDao {
    private Connection connection;
    public ClienteDao(){
        connection = ConectorBD.getConnection();
    }

    public void addCliente(Cliente cliente){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO cliente (nif, nombre, ciudad,telefono)VALUES(?,?,?,?,?)"
            );
            preparedStatement.setString(1, cliente.getNif());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getCiudad());
            preparedStatement.setString(4, cliente.getDireccion());
            preparedStatement.setInt(5, cliente.getTelefono());
            preparedStatement.executeUpdate();

            System.out.println(cliente+"creado");
        }catch (SQLException e){
            System.out.println("error al crear el cliente" + e.getMessage());
        }
    }

    public void updateCliente(Cliente cliente){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE cliente SET nif=?,nombre=?, ciudad=?, direccion=?,telefono=? WHERE nif=?"
            );
            preparedStatement.setString(1, cliente.getNif());
            preparedStatement.setString(2, cliente.getNombre());
            preparedStatement.setString(3, cliente.getCiudad());
            preparedStatement.setString(4, cliente.getDireccion());
            preparedStatement.setInt(5, cliente.getTelefono());


            preparedStatement.setString(6, cliente.getNif());
            preparedStatement.executeUpdate();

            System.out.println(cliente+"editado");
        }catch (SQLException e){
            System.out.println("error al editar el cliente" + e.getMessage());
        }

    }


    public void deleteCliente(String nif){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM clientes WHERE nif=?"
            );
            preparedStatement.setString(1,nif);
            preparedStatement.executeUpdate();

            System.out.println(nif+"eliminado");
        }catch (SQLException e){
            System.out.println("error al editar el cliente" + e.getMessage());
        }

    }

    public List <Cliente> getALLClientes()
    {

        List<Cliente> clientes = new ArrayList<>();
        try
        {
            Statement statement= connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM clientes");

            while (resultSet.next()){
                Cliente cliente=new Cliente();
                cliente.setNif(resultSet.getString("nif"));
                cliente.setNombre(resultSet.getString("nomber"));
                cliente.setCiudad(resultSet.getString("ciudad"));
                cliente.setDireccion(resultSet.getString("direccion"));
                cliente.setTelefono(resultSet.getInt("telefono"));

                clientes.add(cliente);
            }

        }catch (SQLException e)
        {
            System.out.println("error al listar los clientes" + e.getMessage());
        }
        return clientes;
    }
}
