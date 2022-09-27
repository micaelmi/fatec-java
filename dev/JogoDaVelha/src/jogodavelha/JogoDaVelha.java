package jogodavelha;

import static jogodavelha.Entradas.*;

public class JogoDaVelha {
    
    public static String[][] boardSquares = new String[3][3];
    public static boolean end = false;
    public static boolean xTurn = true;
    public static String player = " ";
    public static String column = " ";
    public static int row = 0;
    
    public static int c, r;
    public static boolean error = false;
    
    public static int moves = 0;

        
    public static void main(String[] args) {        
        
        initializeBoard(); // Coloca um valor " " para todos os campos da matriz
        showBoard(); // mostra o tabuleiro vazio
        printPlayerTurn(); // escreve de quem é a vez de jogar
        
        do {
            playerInput(); // Entrada de valores para escolher a casa que quer jogar
            fillBoard(); // preenche o tabuleiro com a casa escolhida
        }while(end == false); // repete enquanto não acabar o jogo
        
        
    }
    
    public static void initializeBoard() {
        // Coloca um valor " " em todas as casas
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardSquares[i][j] = " ";
            }
            
        }
    }
    
    public static void showBoard() {
        // Printa o tabuleiro
        System.out.println("       JOGO DA VELHA");
        String horizontal ="    +-----+-----+-----+";
        System.out.println("       A     B     C");
        System.out.println(horizontal);
        System.out.println("1   |  "+boardSquares[0][0]+"  |  "+boardSquares[0][1]+"  |  "+boardSquares[0][2]+"  |");
        System.out.println(horizontal);
        System.out.println("2   |  "+boardSquares[1][0]+"  |  "+boardSquares[1][1]+"  |  "+boardSquares[1][2]+"  |");
        System.out.println(horizontal);
        System.out.println("3   |  "+boardSquares[2][0]+"  |  "+boardSquares[2][1]+"  |  "+boardSquares[2][2]+"  |");
        System.out.println(horizontal);
        System.out.println(" ");    
        // Define se o jogador é X ou O
        if(xTurn) player = "X";
             else player = "O";
    }
    
    public static void printPlayerTurn() {
        if(end != true) { // caso o jogo não tenha acabado
            // escreve de que é a vez
            System.out.println("Vez do " + player);
        }
    }
    
    public static void playerInput() {
        // zera as variáveis
        row = 0;
        column = "";
        do { // entra no laço de repetição
            do { // verifica as entradas de linha
                try { // verifica se é um número inteiro
                    row = entradaInteiro("Escolha uma linha. (1, 2 ou 3)\n");
                    error = false;
                } catch(Exception e) { // se não for, manda repetir
                    System.out.println(e.getMessage());
                    error = true;
                }
                // valida se o número é permitido
                inputValidation("R");
            } while(error);

            do { // verifica as entradas de coluna
                column = entradaTexto("Escolha uma coluna. (A, B ou C)\n");
                // valida se a entrada é um valor permitido (a, b ou c)
                inputValidation("C");
            }while(error);
            
            if(!" ".equals(boardSquares[(row-1)][c])) { // verifica se a casa não está vazia
                // se não estiver, manda escolher outra
                System.out.println("Casa ja preenchida, escolha outra");
                error = true;
            } else {
                error = false;
            }
        }while(error); // fim das repetições
    }
    
    public static void inputValidation(String type) {
        
        if(type.equals("C")) { // verifica se o tipo de entrada é coluna "C"
            // transforma as letras em números para poder usar no vetor
            if(column.equals("A") || column.equals("a")) {
                c = 0;
                error = false;
            } else if(column.equals("B") || column.equals("b")) {
                c = 1;
                error = false;
            } else if(column.equals("C") || column.equals("c")) {
                c = 2;
                error = false;
            } else { // se não for nenhuma das letras acima, avisa que é um valor inválido
                System.out.println("Coluna invalida");
                error = true;
            }
            
        } else if(type.equals("R")) { // verifica se o tipo da entrada é linha "R" (R de ROW)
            if(row < 1 || row > 3) { // verifica se o valor está fora dos limites ( < 1 e > 3)
                error = true;
                System.out.println("Linha invalida");
            } else {
                error = false;
            }
        } else { // se ao chamar a função, não passar nem "C" nem "R", avisa que não é um tipo válido
            System.out.println("Tipo invalido");
        }
    }
    
    public static void fillBoard() {
            if(error == false) { // verifica se não há erros pela última vez
                r = row - 1; // diminui 1 no valor digitado, pois o vetor começa em zero, e não em um
                if(xTurn) { // verifica de quem é a vez para saber se vai preencher com X ou O
                    boardSquares[r][c] = "X"; // preenche com X
                } else {
                    boardSquares[r][c] = "O"; // preenche com O
                }
                
            moves++; // soma um movimento na contagem, para depois verificar se houve empate
            
            xTurn = !xTurn; // troca a vez do jogador
            showBoard(); // mostra o tabuleiro
            winCondition(); // verifica se alguém ganhou
            tiedTheGame(); // verifica se empatou
            printPlayerTurn(); // mostra de quem é a vez
            
        }
    }
    
    public static void winCondition() {
        // verifica todas as possibilidades para o X vencer (horizontal, vertical, diagonal)
        if( "X".equals(boardSquares[0][0]) && "X".equals(boardSquares[0][1]) && "X".equals(boardSquares[0][2]) ||
            "X".equals(boardSquares[1][0]) && "X".equals(boardSquares[1][1]) && "X".equals(boardSquares[1][2]) ||
            "X".equals(boardSquares[2][0]) && "X".equals(boardSquares[2][1]) && "X".equals(boardSquares[2][2]) ||
            "X".equals(boardSquares[0][0]) && "X".equals(boardSquares[1][0]) && "X".equals(boardSquares[2][0]) ||
            "X".equals(boardSquares[0][1]) && "X".equals(boardSquares[1][1]) && "X".equals(boardSquares[2][1]) ||
            "X".equals(boardSquares[0][2]) && "X".equals(boardSquares[1][2]) && "X".equals(boardSquares[2][2]) ||
            "X".equals(boardSquares[0][0]) && "X".equals(boardSquares[1][1]) && "X".equals(boardSquares[2][2]) ||
            "X".equals(boardSquares[0][2]) && "X".equals(boardSquares[1][1]) && "X".equals(boardSquares[2][0])
          ) { // se alguma for verdadeira, acaba o jogo
            System.out.println("X venceu!!");
            end = true;
            System.exit(0); // termina a execução
        }
        // verifica todas as possibilidades para o X vencer (horizontal, vertical, diagonal)
        if( "O".equals(boardSquares[0][0]) && "O".equals(boardSquares[0][1]) && "O".equals(boardSquares[0][2]) ||
            "O".equals(boardSquares[1][0]) && "O".equals(boardSquares[1][1]) && "O".equals(boardSquares[1][2]) ||
            "O".equals(boardSquares[2][0]) && "O".equals(boardSquares[2][1]) && "O".equals(boardSquares[2][2]) ||
            "O".equals(boardSquares[0][0]) && "O".equals(boardSquares[1][0]) && "O".equals(boardSquares[2][0]) ||
            "O".equals(boardSquares[0][1]) && "O".equals(boardSquares[1][1]) && "O".equals(boardSquares[2][1]) ||
            "O".equals(boardSquares[0][2]) && "O".equals(boardSquares[1][2]) && "O".equals(boardSquares[2][2]) ||
            "O".equals(boardSquares[0][0]) && "O".equals(boardSquares[1][1]) && "O".equals(boardSquares[2][2]) ||
            "O".equals(boardSquares[0][2]) && "O".equals(boardSquares[1][1]) && "O".equals(boardSquares[2][0])
          ) {// se alguma for verdadeira, acaba o jogo
            System.out.println("O venceu!!");
            end = true;
            System.exit(0); // termina a execução
        }
    }
    
    public static void tiedTheGame() { // essa função só vai ser chamada depois da de vitória
            if(moves > 8) { // se a quantidade de movimentos for maior que 8,
                // o tabuleiro vai estar cheio e vai ter empatado
                System.out.println("Deu velha!!");
                end = true;
                System.exit(0); // finaliza a execução
            }
    }
    
}