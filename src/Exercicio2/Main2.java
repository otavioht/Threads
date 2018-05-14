package Exercicio2;

import java.util.ArrayList;
import java.util.Collection;


public class Main2 {
        public static void main(String[] args) {
            //Armazena o tempo inicial
            long ti = System.currentTimeMillis();
            //armazena a quantidade de nucleos de processamento disponiveis
            int numThreads = 4;
            int valorInicial = 1;
            int valorFinal = 9999;

            //Lista para armazenar os numeros primos encontrados
            Collection<Integer> primos = new ArrayList<>();

            //Lista para as threads
            Collection<CalculaPrimos> threads = new ArrayList<>();

            int numporthread = valorFinal / valorInicial;

            for (int i = 1; i <= numThreads; i++) {
                //npthread é a quantidade de valores que cada thread irá calcular
                int npthread = Math.round(numporthread / numThreads);
                //Calcula o valor inicial e final de cada thread
                int fim = npthread * i;
                int ini = (fim - npthread) + 1;

                CalculaPrimos thread = new CalculaPrimos(ini, fim, primos);
                thread.setName("Calculadora "+i);
                threads.add(thread);
            }

            //Inicia as Threads
            for (CalculaPrimos cp : threads) {
                cp.start();
            }

            //Aguarda todas as threads finalizarem o processamento
            for (CalculaPrimos cp : threads) {
                try {
                    cp.join();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            //Mostra os numeros primos encontrados no intervalo
            for (Integer primo : primos) {
                System.out.println(primo);
            }

            //Tempo total gasto
            System.out.println("tempo: " + (System.currentTimeMillis() - ti));
        }
    }

