package modelo;

public class Lupa extends Item{

    public Lupa() {
        this.tipo = "Lupa";
    }

    public boolean ativar(Player player) {
        Arma arma = player.getGun();

        if (arma.possuiBala()) {
            System.out.println("Câmara carregada.");
        } else {
            System.out.println("Câmara vazia.");
        }

        return true;
    }
}
