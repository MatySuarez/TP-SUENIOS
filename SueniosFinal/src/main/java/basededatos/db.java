package basededatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class db {
    private final List<dbPersona> listaPersonas = new ArrayList<>();

    public List<dbPersona> getListaPersonas() {
        return listaPersonas;
    }

    public void leerPersona() {

        String nombre;
        String apellido;
        int edad;
        String suenio;
        String salida = "Si";
        while (salida.equalsIgnoreCase("Si")){
            Scanner lectura0 = new Scanner (System.in);
            Scanner lectura1 = new Scanner (System.in);
            Scanner lectura2 = new Scanner (System.in);
            Scanner lectura3 = new Scanner (System.in);
            Scanner lectura4 = new Scanner (System.in);
            System.out.println("Ingrese su nombre:");
            nombre = lectura0.nextLine();
            System.out.println("Ingrese su apellido:");
            apellido = lectura1.nextLine();
            System.out.println("Ingrese su edad:");
            edad = lectura2.nextInt();
            System.out.println("Ingrese su suenio:");
            suenio = lectura3.nextLine();
            dbPersona p = new dbPersona(nombre, apellido, edad, suenio);
            listaPersonas.add(p);
            System.out.println("Desea agregar una nueva persona? Ingrese SI o presione cualquier tecla para salir.");
            salida = lectura4.nextLine();

        }

    }
}
