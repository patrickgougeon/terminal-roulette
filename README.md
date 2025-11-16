# Terminal Roulette

Bem-vindo ao Terminal Roulette, uma adaptação estratégica 1v1 do jogo de suspense Buckshot Roulette, reimaginada como um duelo tático baseado em texto para ser jogado diretamente no seu console.

Neste jogo, dois jogadores se enfrentam em um teste de probabilidade, gerenciamento de risco e manipulação psicológica. O objetivo é eliminar seu oponente. Para fazer isso, você deve esgotar os Pontos de Saúde dele e, em seguida, suas Cargas de Vida, antes que ele faça o mesmo com você.

---

## Como Jogar: As Regras

### 1. O Sistema de Saúde e Cargas (A Regra Principal)

Nesta versão, os jogadores têm dois tipos de vitalidade:
* **Pontos de Saúde (Saúde):** Cada jogador começa com 3 Pontos de Saúde. Esta é sua "barra de energia" imediata.
* **Cargas de Vida (Vidas):** Cada jogador começa a partida com 2 Cargas de Vida. Estas são a quantidade de vezes que você pode ser reanimado.

**Como funciona o dano:**
* Ser atingido por um cartucho real (dano padrão) faz o jogador perder 1 Ponto de Saúde.
* Se os Pontos de Saúde de um jogador chegam a 0 (zero), ele não é eliminado imediatamente.
* Em vez disso, ele gasta 1 Carga de Vida e seus Pontos de Saúde são imediatamente restaurados para 3.

**Condição de Vitória:** Um jogador perde a partida se ele sofrer dano (que zeraria seus Pontos de Saúde) mas ele não tiver mais Cargas de Vida (0 Cargas) para gastar.

### 2. A Estrutura do Jogo: Rodadas Contínuas

Diferente de outras versões, aqui o jogo não tem fases de dificuldade.

**Mudança de Rodada:** O jogo é dividido em "rodadas" que são definidas pelo uso das Cargas de Vida.
* A rodada termina IMEDIATAMENTE no momento em que um jogador é forçado a gastar uma Carga de Vida.
* Quando isso acontece, a arma é esvaziada (independentemente de quantos cartuchos ainda restavam), e uma nova rodada começa com um novo carregamento de cartuchos e distribuição de itens.
* A dificuldade não aumenta; o número de itens distribuídos e o sistema de saúde (3 Saúde / 2 Vidas) permanecem os mesmos do início ao fim.

### 3. O Turno Básico

No início de uma rodada, a espingarda é carregada com uma mistura aleatória de cartuchos reais e falsos. A contagem total é anunciada a ambos os jogadores (ex: "3 reais, 2 falsos").

Um jogador começa. No seu turno, você pode usar itens (veja abaixo) e então deve fazer uma escolha:

* **Atirar no Oponente:**
    * **Real:** O oponente perde 1 Ponto de Saúde. O turno passa para ele.
    * **Falso:** Nada acontece. O turno passa para ele.
* **Atirar em Si Mesmo:**
    * **Real:** Você perde 1 Ponto de Saúde. O turno passa para o oponente.
    * **Falso:** Você não se fere E ganha um turno extra (você joga novamente).

### 4. Os Itens Estratégicos (Versão Limitada)

Itens são distribuídos no início de cada rodada (ou seja, no início do jogo e sempre que alguém gasta uma Carga de Vida).

* **Lupa:** Permite que você espie o cartucho que está na câmara, descobrindo se é real ou de festim.
* **Serra:** Dobra o dano do próximo disparo. Se o cartucho for real, ele remove 2 Pontos de Saúde do alvo em vez de 1. O efeito é usado (e descartado) mesmo se o cartucho for de festim.
* **Cigarro:** Permite que você recupere 1 Ponto de Saúde. Você não pode usar isso se já estiver com seus 3 Pontos de Saúde completos. (Este item NÃO recupera Cargas de Vida).

---

## Pré-requisitos

* Java Development Kit (JDK) instalado (versão 8 ou superior).
* Um terminal (prompt de comando) para compilação e execução.

---

## Como Executar o Jogo

O projeto é executado através da classe `Main`, que apresenta um menu para que você escolha qual versão do aplicativo rodar.

1.  **Abra seu terminal** ou prompt de comando.

2.  **Navegue até a pasta** `src` dentro de `terminal-roulette`, onde estão localizados (a pasta que contém `Main.java` e a pasta `modelo`).

3.  **Compile todos os arquivos Java:**
    * Execute este comando:

    ```bash
    javac Main.java modelo/*.java
    ```

4.  **Execute a classe principal** para iniciar o menu:

    ```bash
    java Main
    ```

5.  **Escolha o modo no menu:**
    * Assim que o programa iniciar, você verá este menu:

    ```text
    Escolha o modo de jogo:
    [ 1 ] App interativo (Jogo normal)
    [ 2 ] App roteiro (Modo de teste/demo)
    Opção:
    ```

---

### App Interativo (Opção 1)

* **O que é:** Esta é a versão principal e jogável do projeto.
* **Como usar:** Digite `1` e pressione Enter.
* **O que esperar:** O jogo iniciará e você poderá jogar ativamente, tomando decisões, escolhendo itens e respondendo aos prompts no console. Os comandos do jogo são simples e auto-explicativos.

### App Roteiro (Opção 2)

* **O que é:** Esta é uma versão de demonstração ou teste.
* **Como usar:** Digite `2` e pressione Enter.
* **O que esperar:** O jogo rodará "sozinho", seguindo um roteiro pré-definido. Ele não deve esperar por nenhuma entrada do usuário e apenas exibirá o fluxo do jogo automaticamente. É ideal para testar a lógica do jogo ou fazer uma demonstração rápida.
