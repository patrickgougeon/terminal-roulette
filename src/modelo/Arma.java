package modelo;

import java.util.ArrayList;
import java.util.Random;

public class Arma {
    private ArrayList<Boolean> ammo; // lista de shells da escopeta
    private int dano;    // dano aplicado ao alvo
    private int serrada; // se serrada dano 2x

    private int nReal;
    private int nFake;

    // ##### CONSTRUCTOR ##### \\
    public Arma() {
        this.ammo = new ArrayList<>(9);
        this.dano = 1;
        this.serrada = 0;

        this.nReal = 0;
        this.nFake = 0;
    }

    // ##### FUNÇÕES ##### \\

    public boolean taVazia() { // keep track da munição
        return this.ammo.isEmpty();
    }

    public void carregar() { // adiciona a munição na arma
        Random rdm = new Random(); // import random (local, só usa aqui)


        // loop, adiciona 3 a 9 balas, aleatória entre cheias e vazias (true e false)
        // DISCLAIMER: implementar impedir todas cheias ou vazias

        while (this.nReal == 0 || this.nFake == 0) {
            this.nReal = 0;
            this.nFake = 0;
            this.ammo.clear(); // limpa as balas antigas (se tiver)

            for (int i = 0; i <= rdm.nextInt(2, 9); i++) {
                this.ammo.add(rdm.nextBoolean());

                if (this.ammo.get(i)) {
                    this.nReal += 1;
                } else {
                    this.nFake += 1;
                }
            }
        }
    }

    public boolean atirar(Player alvo) { // keep track da bala + aplique do dano
        if (taVazia()) { // se arma estiver vazia
            System.out.println("CLICK... Arma vazia");
            return false; // não houve dano
        }

        // armazena o tipo da bala engatilhada
        boolean balaAtual = this.ammo.getFirst();

        if (balaAtual) { // bala real
            alvo.levarDano(this.dano + this.serrada);
            System.out.println("BAAAANG");
        } else { // bala falsa
            System.out.println("capsula VAZIA!");
        }

        this.ammo.removeFirst(); // remova a bala

        return balaAtual; // retorna a bala
    }
}
