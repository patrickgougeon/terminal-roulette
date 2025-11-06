package modelo;

import java.util.ArrayList;

public class Player {
    private String nickname;

    private int capacidade;
    private int qtdItens;
    private int moedas;
    private int saude;
    private int vida;

    private final int saudeMaxima = 3;
    private final int vidaMaxima = 2;

    private ArrayList<Item> itens;
    private Arma arma;

    private String status;

    public Player(String nickname, Arma arma) {
        this.nickname = nickname;
        this.saude = this.saudeMaxima;
        this.status = "ativo";
        this.vida = this.vidaMaxima;
        this.arma = arma;
    }

    public void deixarInativo() {
        this.status = "inativo";
    }

    public void apertarGatilho(Player player) {
        if (this.status == "ativo") {
            this.arma.atirar(player);
            this.adicionarMoedas(5);
        }
    }

    public void levarDano(int dano) {
        this.saude -= dano;
        this.status = "ativo";

        if (this.saude <= 0) {
            if (this.vida == 0) {
                this.status = "morto";
                return;
            }
            this.vida--;
            this.saude = this.saudeMaxima;
        }
    }

    public void levarCura(int cura) {
        this.saude = Math.min(this.saude + cura, this.saudeMaxima);
    }

    // --- Mochila ---

    public boolean adicionarItem(Item item) {
        if (qtdItens < capacidade) {
            this.itens.add(item);
            return true;
        }
        return false;
    }

    public boolean removerItem(Item item) {
        return this.itens.remove(item);
    }

    public void adicionarMoedas(int moedas) {
        this.moedas += moedas;
    }

    public void removerMoedas(int moedas) {
        this.moedas = Math.max(this.moedas - moedas, 0);
    }

    public boolean utilizarMoedas(int moedas) {
        if (moedas <= this.moedas) {
            return true;
        }
        return false;
    }

    public boolean venderItem(Item item) {
        if (removerItem(item)) {
            adicionarMoedas(item.calcularValorMoedas());
            return true;
        }
        return false;
    }

    public void esvaziarMochila() {
        itens.clear();
    }

    // --- GETs e SETs ---

    public String getNickname() {
        return nickname;
    }

    public int getSaude() {
        return saude;
    }

    public int getVida() {
        return vida;
    }
}
