package test;

import com.google.gson.Gson;

import modelo.Cliente;
import modelo.Domicilio;

public class TestJson {

    public static void main(String[] args) {
        // TODO Auto-generated method stub



        Cliente cliente= new Cliente("Sanches","jorge",11111,33333,new Domicilio("Boedo",235,"buenos aires","cap.Fed"));
        Gson gson=new Gson();
        String json=gson.toJson(cliente);


        System.out.println(json);
        String json1= "{'apellido':'Sanches','nombre':'jorge','dni':11111,'numeroAfiliado':33333,'domicilio':{'calle':'Boedo','numero':235,'localidad':'buenos aires','provincia':'cap.Fed'}}";
        Gson gson1=new Gson();
        Cliente cliente1=gson1.fromJson(json1, Cliente.class);
        System.out.println(cliente1);



    }

}