package modelo;

public abstract class Item {
    protected String tipo;

    public abstract boolean ativar(Player player);

    // ### GETs && SETs ###
    public String getTipo() {
        return tipo;
    }
}
