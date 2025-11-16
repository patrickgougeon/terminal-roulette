package modelo;

public class Player{
    private int vida;   // decrementa com o zerar da saúde | 0 = perdeu
    private int saude;  // decrementa a partir dos tiros   | 0 = vida - 1

    private Mochila mochila; // armazena seus itens

    private Arma gun; // arma em posse do player

    // ##### CONSTRUCTOR ##### \\
    public Player() {
        this.vida = 2;
        this.saude = 3;
        this.mochila = new Mochila();
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

    public boolean saudeCheia() {
        if (this.saude == 3) {
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
