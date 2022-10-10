package br.edu.unifei.com242;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.*;
import java.util.Scanner;

public class Client {

    public static final String IP_ADDRESS = "localhost";
    public static final int PORT = 8090;

    private Client() { }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Entre com valores x e y do primeiro ponto separados por espaço:");
        double ax = keyboard.nextDouble();
        double ay = keyboard.nextDouble();
        System.out.println("");

        System.out.println("Entre com valores x e y do segundo ponto separados por espaço:");
        double bx = keyboard.nextDouble();
        double by = keyboard.nextDouble();
        System.out.println("");

        try {
            Registry registry = LocateRegistry.getRegistry(IP_ADDRESS, PORT);

            IAtividade4 stub = (IAtividade4) Naming.lookup("rmi://" + IP_ADDRESS + ":" + PORT + "/IAtividade4");

            System.out.println("Invocando Métodos Remotos...");
            System.out.println("");

            System.out.println("Distância: A(" + ax + ", " + ay + ") B(" + bx + ", " + by + ") = " +
                    stub.DistanciaEuclidiana(ax, ay, bx, by));

        } catch (Exception e) {
            System.err.println("ERRO no Cliente (Exception): " + e.toString());
            e.printStackTrace();
        }
    }
}

