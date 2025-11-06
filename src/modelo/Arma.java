package modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Arma {
    private String tipo;
    private int capacidade;
    private int municao;
    private ArrayList<Boolean> tambor;
    private int posicaoAtualTambor;
    private int dano;

    public Arma(String tipo, int capacidade, ArrayList<Boolean> tambor) {
        this.tipo = tipo;
        this.capacidade = capacidade;
        this.municao = 0;
        this.tambor = new ArrayList<>(this.capacidade);
        this.posicaoAtualTambor = 0;
        this.dano = 1;
    }

    public void definirMunicao() {
        int min = 2;
        int max = this.capacidade;

        this.municao = (int) (Math.random() * (max - min + 1) + min);
    }

    public void definirTambor() {
        ArrayList<Integer> indices = new ArrayList<>(capacidade);

        for (int i = 0; i < capacidade; i++) {
            indices.add(i, i);
        }

        Collections.shuffle(indices);

        for (int i = 0; i < this.municao; i++) {
            int indiceRandom = indices.get(i);
            this.tambor.set(indiceRandom, true);
        }
    }

    public void recarregar() {
        this.definirMunicao();
        this.definirTambor();
    }

    public void atirar(Player player) {
        if (this.tambor.get(this.posicaoAtualTambor)) {
            player.levarDano(this.dano);
        }

        this.dano = 1;
        this.posicaoAtualTambor++;

        if (posicaoAtualTambor >= capacidade) {
            this.recarregar();
        }
    }
}
