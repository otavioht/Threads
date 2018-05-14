package Exercicio2;

import java.util.Collection;

    public class CalculaPrimos extends Thread {

        private final int valorInicial;
        private final int valorFinal;
        private final Collection<Integer> primos;

        //Construtor da Classe
        public CalculaPrimos(int valorInicial, int valorFinal, Collection<Integer> primos) {
            this.valorInicial = valorInicial;
            this.valorFinal = valorFinal;
            this.primos = primos;
        }

        //Procura numeros primos no intervalo recebido
        @Override
        public void run() {
            for (int ate = valorInicial; ate <= valorFinal; ate++) {
                int primo = 0;
                for (int i = 2; i < ate; i++) {
                    if ((ate % i) == 0) {
                        primo++;
                        break;
                    }
                }
                if (primo == 0) {
                    synchronized (primos) {
                        primos.add(ate);
                    }
                }
            }
            //Ao final do trabalho printa o nome de quem terminou
            System.out.println(this.getName() + " terminou!");
        }
    }

