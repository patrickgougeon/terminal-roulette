package modelo;

import java.util.HashMap;
import java.util.Map;

public enum GerenciadorConquistas {
    // 1. A única instância do Singleton
    INSTANCIA;

    // 2. Onde "criamos" e "guardamos" as definições das conquistas
    private final Map<String, Conquista> registroDeConquistas;

    /**
     * O construtor de um enum é chamado automaticamente (e apenas uma vez).
     * Usamos ele para "criar" nossas conquistas concretas.
     */
    GerenciadorConquistas() {
        this.registroDeConquistas = new HashMap<>();

        // --- AQUI CRIAMOS AS CONQUISTAS ---
        adicionarAoRegistro(new Conquista(
                "Me da um cigarro", "01"
        ));
        adicionarAoRegistro(new Conquista(
                "Dano máximo", "02"
        ));
    }

    // Helper para facilitar o registro
    private void adicionarAoRegistro(Conquista c) {
        this.registroDeConquistas.put(c.getId(), c);
    }

    public void checarUsoItem(Player player, Item item) {
        String tipoItem = item.getTipo();

        if (tipoItem.equals("Cigarro")) {
            player.desbloquearConquista(registroDeConquistas.get("01"));
        } else if (tipoItem.equals("Serra")) {
            player.desbloquearConquista(registroDeConquistas.get("02"));
        }
    }
}
