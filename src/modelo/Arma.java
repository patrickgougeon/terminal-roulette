package modelo;

import java.util.ArrayList;

public class Arma extends UI implements Esvaziavel {
    private ArrayList<Boolean> ammo; // lista de shells da escopeta
    private int dano;    // dano aplicado ao alvo
    private boolean estaSerrada; // se serrada dano 2x;
    private Player dono;

    // ##### CONSTRUCTOR ##### \\
    public Arma() {
        this.ammo = new ArrayList<>(9);
        this.dano = 1;
        this.estaSerrada = false;
    }

    // ##### FUNÇÕES ##### \\
    public void seEsvaziar() {
        this.ammo.clear();
    }

    public boolean possuiBala() {
        return this.ammo.getFirst();
    }

    public boolean taVazia() { // keep track da munição
        return this.ammo.isEmpty();
    }

    public void defDono(Player novoDono) {this.dono = novoDono;}

    public void adicionarBala(Boolean bala) {
        this.ammo.add(bala);
    }

    public boolean serSerrada() {
        if (estaSerrada) {
            System.out.println("Esta arma ja esta serrada!");
            return false;
        }

        this.estaSerrada = true;
        System.out.println("Você serrou a arma, agora ela da o DOBRO do dano!");
        return true;
    }

    public void darDano(Player alvo) {
        if (estaSerrada) {
            alvo.levarDano(this.dano*2);
            return;
        }

        alvo.levarDano(this.dano);
    }

    public boolean atirar(Player alvo) throws InterruptedException { // keep track da bala + aplique do dano
        if (taVazia()) { // se arma estiver vazia
            msg_reload();
            return false; // não houve dano
        }

        // armazena o tipo da bala engatilhada
        boolean balaAtual = this.ammo.getFirst();

        if (balaAtual) { // bala real
            msg_tiroReal();
            this.darDano(alvo);
        } else {
            msg_tiroFake();
        }

        this.ammo.removeFirst(); // remova a bala
        this.estaSerrada = false;

        return balaAtual; // retorna a bala
    }
}
