package modelo;

public abstract class Item {
    protected String nome;
    protected String desc;
    protected int constDePoder;
    protected Player player;

    public Item(String nome, String desc, int constDePoder, Player player) {
        this.nome = nome;
        this.desc = desc;
        this.constDePoder = constDePoder;
        this.player = player;
    }

    public abstract void poder(Player player);

    public abstract void usar(Player player);

    public int calcularValorMoedas() {
        return this.constDePoder * 10;
    }
}
