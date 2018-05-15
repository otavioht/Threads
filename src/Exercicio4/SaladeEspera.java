package Exercicio4;


import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;

public class SaladeEspera {


        private final ArrayBlockingQueue<Cliente> clientesEsperando;

        public SaladeEspera(int capacity) {
            clientesEsperando = new ArrayBlockingQueue<>(capacity);
        }

        public void sentaAe(Cliente cliente) throws InterruptedException {
            clientesEsperando.put(cliente);
        }

        public Cliente proximoCliente() throws InterruptedException {
            return clientesEsperando.take();
        }
}
