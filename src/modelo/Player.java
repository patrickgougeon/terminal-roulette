package modelo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Player{
    private static final int SAUDE_MAXIMA = 3;
    private static final int VIDA_MAXIMA = 2;

    private int vida;   // decrementa com o zerar da saúde | 0 = perdeu
    private int saude;  // decrementa a partir dos tiros   | 0 = vida - 1

    private Mochila mochila; // armazena seus itens
    private Set<Conquista> conquistas;

    private Arma gun; // arma em posse do player

    // ##### CONSTRUCTOR ##### \\
    public Player() {
        this.vida = VIDA_MAXIMA;
        this.saude = SAUDE_MAXIMA;
        this.mochila = new Mochila();
        this.conquistas = new HashSet<>();
        this.gun = null; // começa sem arma
    }

    // ##### FUNÇÕES EFEITOS ##### \\
    /* ações ativas referente ao player
        - levar dano
        - usar item
        - etc

        * funções de item faltando
     */


    public boolean usarItemDaMochila(int index) {
        Item item = mochila.pegarItem(index);

        if (item.ativar(this)) {
            mochila.removerItem(item);

            GerenciadorConquistas.INSTANCIA.checarUsoItem(this, item);

            return true;
        }

        return false;
    }

    public void levarDano(int dano) { // saude - dano da arma
        this.saude -= dano;
    }

    public void regenerarSaude(int saude) {
        this.saude += saude;
    }

    // Sobrecarga!!!
    public void regenerarSaude() {
        this.saude = SAUDE_MAXIMA;
    }

    public boolean saudeCheia() {
        if (this.saude == SAUDE_MAXIMA) {
            return true;
        }
        return false;
    }

    // ##### FUNÇÕES ARMA ##### \\
    /* ações referentes a arma */

    public void receberArma(Arma a) { // player armazena arma
        this.gun = a;
    }

    public void soltarArma() { // arma do player vira null
        this.gun = null;
    }

    public boolean mirar(Player alvo) { // chama função atirar da arma
        return this.gun.atirar(alvo);
    }

    // ##### FUNÇÕES CONQUISTAS ##### \\

    public void desbloquearConquista(Conquista conquista) {
        // O método .add() do Set retorna 'true' apenas se o item
        // não estava presente e foi adicionado com sucesso.
        if (this.conquistas.add(conquista)) {
            System.out.println("\n--- CONQUISTA DESBLOQUEADA ---");
            System.out.println("   " + conquista.getNome());
            System.out.println("--------------------------------\n");
        }
    }

    // ##### GET & SET ##### \\
    /* getters e setters (muitas vezes temporarios)*/

    public int getSaude() { // retorna saúde
        return saude;
    }

    public Mochila getMochila() {
        return mochila;
    }

    public Arma getGun() {
        return gun;
    }
}
