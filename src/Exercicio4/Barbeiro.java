package Exercicio4;


import java.util.Iterator;
import java.util.List;

public class Barbeiro implements Runnable {

   private final SaladeEspera Fila;

    public Barbeiro(SaladeEspera fila){
        this.Fila = fila;
    }
    public void start() {
        this.start();
    }

    @Override
    public void run(){
        try {
            while (true) {
                Cliente Cadeira = Fila.proximoCliente();
                System.out.println("Proximo Cliente da Fila -- " +"Cliente de ID: " +Cadeira);
                Cadeira.ChamadoPraCadeira();
            }

        } catch (InterruptedException e) {
            System.out.println("Barbeiro terminou de atender");
        }
    }
}
