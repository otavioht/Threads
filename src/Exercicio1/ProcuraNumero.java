package Exercicio1;

import java.util.Collection;
import java.util.ArrayList;

public class ProcuraNumero extends Thread {
    private final int valorInicial;
    private final int valorFinal;
    private final ArrayList<Integer> nVetor;
    private boolean achei;
    private int pos;
    private final int nvalor;
    int contador;

    //Construtor da Classe
    public ProcuraNumero(int valorInicial, int valorFinal, ArrayList<Integer> nVetor, boolean achei, int pos, int nvalor) {
        this.valorInicial = valorInicial;
        this.valorFinal = valorFinal;
        this.achei = achei;
        this.nVetor = nVetor;
        this.pos = pos;
        this.nvalor = nvalor;
    }

    //Busca pelo valor no vetor compartilhado entre as threads
    @Override
    public synchronized void run() {
        for (int ate = valorInicial - 1; ate <= valorFinal - 1; ate++) {
            if (achei) {
                break;
            }
            if (nVetor.get(ate) == nvalor) {
                System.out.println(this.getName() + " - Achei!! Posição :" + ate);
                achei = true;
                break;
            }
        }
    }

}

