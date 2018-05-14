package Exercicio1;

import java.util.ArrayList;
import java.util.Collection;

public class Main1 {
    public static void main(String[] args) {
        //Armazena o tempo inicial
        long ti = System.currentTimeMillis();
        //armazena a quantidade de nucleos de processamento disponiveis
        int numThreads = 4;

        int vTamanho = 8000;
        boolean achei=false;
        int pos=0;
        int nvalor=3000;

        //Lista para armazenar os numeros primos encontrados
        ArrayList<Integer> nVetor = new ArrayList<>();

        for (int i = 0; i < vTamanho; i++){
            nVetor.add(i);
        }
            //Lista para as threads
        Collection<ProcuraNumero> threads = new ArrayList<>();

        for (int i = 1; i <= numThreads; i++) {
            //npthread é a quantidade de valores que cada thread irá calcular
            int npthread = Math.round(vTamanho / numThreads);
            //Calcula o valor inicial e final de cada thread
            int fim = npthread * i;
            int ini = (fim - npthread) + 1;

            ProcuraNumero thread = new ProcuraNumero(ini, fim, nVetor, achei, pos, nvalor);
            thread.setName("Busca " + i);
            threads.add(thread);
        }

        //Inicia as Threads
        for (ProcuraNumero cp : threads) {
            cp.start();
        }

        //Aguarda todas as threads finalizarem o processamento
        for (ProcuraNumero cp : threads) {
            try {
                cp.join();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }


        //Tempo total gasto
        System.out.println("tempo: " + (System.currentTimeMillis() - ti));
    }
}


