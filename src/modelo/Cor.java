package modelo;

public enum Cor {
    BASE("\u001B[0m", "\u001B[0m"), // cor BASE (geralmente cinza)
    PRET("\u001B[30m", "\u001B[90m"), // PRETO
    VERM("\u001B[31m", "\u001B[91m"), // VERMELHO
    VERD("\u001B[32m", "\u001B[92m"), // VERDE
    AMRL("\u001B[33m", "\u001B[93m"), // AMARELO
    AZUL("\u001B[34m", "\u001B[94m"), // AZUL
    ROXO("\u001B[35m", "\u001B[95m"), // ROXO
    CIAN("\u001B[36m", "\u001B[96m"), // CIANO
    BRNC("\u001B[37m", "\u001B[97m"); // BRANCO

    private final String tipoNormal;
    private final String tipoBrilho; // cor mais destacada

    Cor(String normal, String brilho) {
        this.tipoNormal = normal;
        this.tipoBrilho = brilho;
    }

    public String pin(String texto, boolean isBrilhante) {
        if (this == BASE) {
            return texto;
        }

        String codigo = isBrilhante ? this.tipoBrilho : this.tipoNormal;

        return codigo + texto + BASE.tipoNormal;
    }

    public String pin(String texto) {
        return pin(texto, false);
    }

    @Override
    public String toString() {
        return this.tipoNormal;
    }
}
