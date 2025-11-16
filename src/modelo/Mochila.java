package modelo;

import java.util.ArrayList;

public class Mochila {
    private final int capacidade = 4;
    private ArrayList<Item> itens;

    public Mochila() {
        this.itens = new ArrayList<>(this.capacidade);
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void removerItem(Item item) {
        itens.remove(item);
    }

    public void seEsvaziar() {
        itens.clear();
    }

    public Item pegarItem(int index) {
        return itens.get(index);
    }

    public boolean mostrarItems() {
        if (itens.isEmpty()) {
            System.out.println("Esta mochila está vazia.");
            return false;
        }

        for (int i=0; i < itens.size(); i++) {
            Item itemAtual = pegarItem(i);
            System.out.printf("[ %d ] %s", i, itemAtual.getTipo());
        }

        return true;
    }

    // ##### GET & SET ##### \\
}
