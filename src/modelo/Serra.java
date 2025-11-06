package modelo;

// A serra talvez seja o item mais poderoso do jogo, portanto, ela vale mais moedas
public class Serra extends Item implements SuperItem{
    public Serra(String nome, String desc, int constDePoder, Player player) {
        super(nome, desc, constDePoder, player);
    }

    public void efeitoColateral() {
        player.levarDano(constDePoder);
    }

    public void poder(Player player) {
        player.esvaziarMochila();
    }

    public void usar(Player player) {
        this.poder(player);
        efeitoColateral();

        this.player.removerItem(this);
    }

    // Sobrescrita!!
    public int calcularValorMoedas() {
        return this.constDePoder * 15;
    }
}
