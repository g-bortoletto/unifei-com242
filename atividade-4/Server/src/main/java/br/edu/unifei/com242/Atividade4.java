package br.edu.unifei.com242;

import java.rmi.RemoteException;

public class Atividade4 implements IAtividade4 {

    public double DistanciaEuclidiana(double ax, double ay, double bx, double by) throws RemoteException {
        double yDifference = by - ay;
        double xDifference = bx - ax;
        return Math.sqrt(xDifference * xDifference + yDifference * yDifference);
    }

}

