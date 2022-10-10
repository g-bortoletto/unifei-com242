package br.edu.unifei.com242;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAtividade4 extends Remote {

    double DistanciaEuclidiana(double ax, double ay, double bx, double by) throws RemoteException;

} 