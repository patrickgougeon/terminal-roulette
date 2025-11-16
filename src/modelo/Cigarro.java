package modelo;

public class Cigarro extends Item {

    public Cigarro() {
        this.tipo = "Cigarro";
    }

    public boolean ativar(Player player) {
        if (!player.saudeCheia()) {
            player.regenerarSaude(1);
            System.out.println("Você acende o cigarro. Você recupera 1 de saúde!");
            return true;
        }

        System.out.println("Você não pode usar o cigarro com a saúde cheia...");
        return false;
    }
}
