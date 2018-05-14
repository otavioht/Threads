package Exercicio4;


import java.util.Iterator;
import java.util.List;

public class Barbeiro extends Thread {{

   private final List Fila;

    public Barbeiro(List Fila){
        this.Fila = Fila;
    }

    @Override
    public synchronized void run(){
        try {
            Iterator<Cliente> espera = Fila.iterator();
            while (espera.hasNext()) {
                Cliente Cadeira = espera.next();
                System.out.println("Proximo Cliente da Fila" + Cadeira);
                Cadeira.ChamadoPraCadeira();
            }

        } catch (InterruptedException e) {
            System.out.println("Barbeiro terminou de atender");
        }
    }
}

    //public Barbeiro(List<Cliente> fila) {
    //this.fila=fila;
    //}

}
