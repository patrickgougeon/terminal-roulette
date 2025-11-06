package modelo;

public class Algema extends Item{
    public Algema(String nome, String desc, int constDePoder, Player player) {
        super(nome, desc, constDePoder, player);
    }

    public void poder(Player player) {
        player.deixarInativo();
    }

    public void usar(Player player) {
        this.poder(player);

        this.player.removerItem(this);
    }
}
