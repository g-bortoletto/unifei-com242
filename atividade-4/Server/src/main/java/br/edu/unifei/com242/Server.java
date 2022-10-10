package br.edu.unifei.com242;

import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Server extends Atividade4 {

    public static final String IP_ADDRESS = "localhost";
    public static final int PORT = 8090;

    public Server() {
    }

    public static void main(String[] args) {
        try {
            System.setProperty("java.rmi.server.hostname", IP_ADDRESS);

            Atividade4 obj = new Atividade4();

            IAtividade4 atividade4 = (IAtividade4) UnicastRemoteObject.exportObject(obj, 0);

            Registry registry = LocateRegistry.createRegistry(PORT);
            registry.bind("IAtividade4", atividade4);

            System.err.println("Servidor Pronto!");
        } catch (Exception e) {
            System.out.println("ERRO no Servidor (Exception): " + e);
            e.printStackTrace();
        }
    }

}

