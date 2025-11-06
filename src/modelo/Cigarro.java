package modelo;

import java.util.Random;

public class Cigarro extends Item implements SuperItem {
    public Cigarro(String nome, String desc, int constDePoder, Player player) {
        super(nome, desc, constDePoder, player);
    }

    public void efeitoColateral() {
        this.player.deixarInativo();
    }

    public void poder(Player player) {
        this.player.levarCura(constDePoder);
    }

    public void usar(Player player) {
        this.poder(player);
        efeitoColateral();

        this.player.removerItem(this);
    }

    // Voce pode utilizar moedas para ter uma chance de escapar do efeito colateral! (Sobrecarga)
    public boolean usar(Player player, int moedas) {
        if (player.utilizarMoedas(moedas)) {

            Random random = new Random();
            int numeroRandom = random.nextInt(30);

            if (numeroRandom > moedas) {
                efeitoColateral();
            }

            this.poder(player);
            this.player.removerItem(this);
            return true;
        }
        return false;
    }

}
