package com.xljoselolx;

import com.xljoselolx.dao.ClienteDao;
import com.xljoselolx.model.Cliente;
import com.xljoselolx.util.ConectorBD;

import java.sql.Connection;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Connection connection=ConectorBD.getConnection();
        //Cliente cliente=new Cliente("1450","carlos perez","cochabamba", "Av, Ayacucho s/n",78451263);
       // Cliente laura=new Cliente("1451","carlos perez","cochabamba", "Av, Ayacucho s/n",78451263);
        //Cliente roberto=new Cliente("2250","roberto lopez","cochabamba", "Av, la paz s/n",77837873);
        //Cliente felipe=new Cliente("1440","felipe estrada","cochabamba", "Av, oruro s/n",75896321);
        //Cliente oscar=new Cliente("1465","oscar garcia","cochabamba", "Av, potosi s/n",78451255);
        //Cliente miguel=new Cliente("1451","miguel zurita","cochabamba", "Av, luis calvo s/n",78451263);
        //Cliente edwin=new Cliente("1454","edwin delgadillo","cochabamba", "Av, linde s/n",78455263);
        //Cliente erika=new Cliente("1455","erika rivera","cochabamba", "Av, heroinas s/n",78451963);

        //crud TABLA CLIENTES
        ClienteDao clienteDao=new ClienteDao();

        //CREATED
        //clienteDao.addCliente(laura);
        //clienteDao.addCliente(roberto);
        //clienteDao.addCliente(felipe);
        //clienteDao.addCliente(oscar);
        //clienteDao.addCliente(miguel);
        //clienteDao.addCliente(edwin);
        //clienteDao.addCliente(erika);

        //READ
        /*List<Cliente>clientes= clienteDao.getALLClientes();
        for (int i = 0; i <clientes.size(); i++) {
            Cliente cliente= clientes.get(i);

            System.out.println(cliente);

        }*/
        //UPDATE
        //Cliente cliente=new Cliente("1450","fernando lopez","cochabamba", "Av,litoral s/n",78454598);
        //clienteDao.updateCliente(cliente);

        //DELETE
        clienteDao.deleteCliente("1450");
        clienteDao.deleteCliente("1440");

    }
}
