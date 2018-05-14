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
    public static List<Cliente> Fila = Collections.synchronizedList(new ArrayList<Cliente>(15));

    public static void main(String[] args) throws InterruptedException {

        Barbeiro onlyone = new Barbeiro(Fila);

        List<Cliente> clientes = Stream.generate(() -> new Cliente(Fila))
                .limit(100)
                .collect(toList());

        while (!clientes.stream().allMatch(Cliente::foiAtendido)) {
            TimeUnit.SECONDS.sleep(1);
        }

        System.out.println("Todos os Clientes");
    }
}
