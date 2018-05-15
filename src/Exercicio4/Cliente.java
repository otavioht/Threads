package Exercicio4;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Cliente  implements Runnable {

    private static final AtomicInteger idGenerator = new AtomicInteger();

    private final int id;

    private final SaladeEspera Fila;;

    private final SynchronousQueue<Boolean> synchronousQueue;

    private volatile boolean atendido;

    public Cliente(SaladeEspera Fila) {
        this.id = idGenerator.incrementAndGet();
        this.Fila = Fila;
        this.synchronousQueue = new SynchronousQueue<>();
    }


    public void run() {
        try {
            Fila.sentaAe(this);
            System.out.println("Cliente " + this + " esperando ser chamado");
            esperaPraSerAtendido();

            atendido= true;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void ChamadoPraCadeira() throws InterruptedException {
        synchronousQueue.put(true);
    }

    public void esperaPraSerAtendido() throws InterruptedException {
        synchronousQueue.take();
    }

    public boolean foiAtendido() {
        return atendido;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
