package modelo;

import java.util.Objects;

public class Conquista {
    private String nome;
    private String id;

    public Conquista(String nome, String id) {
        this.nome = nome;
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conquista conquista = (Conquista) o;
        return Objects.equals(id, conquista.id); // Compara pelo ID
    }

    @Override
    public int hashCode() {
        return Objects.hash(id); // Gera o hash a partir do ID
    }
}
