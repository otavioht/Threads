package Exercicio4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

import static java.util.concurrent.TimeUnit.MINUTES;
import static java.util.stream.Collectors.toList;


public class Main4 {
    //public static List<Cliente> Fila = Collections.synchronizedList(new ArrayList<Cliente>(15));

    public static void main(String[] args) throws InterruptedException {
        SaladeEspera esperadoido = new SaladeEspera(15);

        ExecutorService executorService = Executors.newFixedThreadPool(4);
        executorService.submit(new Barbeiro(esperadoido));

        List<Cliente> clientes = Stream.generate(() -> new Cliente(esperadoido))
                .limit(100)
                .peek(executorService::submit)
                .collect(toList());
        //TioChico.run();
       /*List<Cliente> clientes = new ArrayList<Cliente>(100);

        for(int i =0 ; i < 100; i++) {
            clientes.add(new Cliente(esperadoido));
        }
*/

        while(!clientes.stream().allMatch(Cliente::foiAtendido)){
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("Todos os Clientes foram atendidos");
    }
}

