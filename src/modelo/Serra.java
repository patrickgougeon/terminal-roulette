package modelo;

public class Serra extends Item{

    public Serra() {
        this.tipo = "Serra";
    }

    public boolean ativar(Player player) {
        Arma arma = player.getGun();

        return arma.serSerrada();
    }
}
