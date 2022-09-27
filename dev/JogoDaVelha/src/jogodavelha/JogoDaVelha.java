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
        
        initializeBoard();
        showBoard();
        printPlayerTurn();
        
        do {
            playerInput();
            fillBoard();
        }while(end == false);
        
        
    }
    
    public static void fillBoard() {
            if(error == false) {
                r = row - 1;
                if(xTurn) { 
                    boardSquares[r][c] = "X";
                } else {
                    boardSquares[r][c] = "O";
                }
            moves++;
            
            xTurn = !xTurn;
            showBoard();
            tiedTheGame();            
            winCondition();
            printPlayerTurn();
            
        }
    }
    
    public static void winCondition() {
        if( "X".equals(boardSquares[0][0]) && "X".equals(boardSquares[0][1]) && "X".equals(boardSquares[0][2]) ||
            "X".equals(boardSquares[1][0]) && "X".equals(boardSquares[1][1]) && "X".equals(boardSquares[1][2]) ||
            "X".equals(boardSquares[2][0]) && "X".equals(boardSquares[2][1]) && "X".equals(boardSquares[2][2]) ||
            "X".equals(boardSquares[0][0]) && "X".equals(boardSquares[1][0]) && "X".equals(boardSquares[2][0]) ||
            "X".equals(boardSquares[0][1]) && "X".equals(boardSquares[1][1]) && "X".equals(boardSquares[2][1]) ||
            "X".equals(boardSquares[0][2]) && "X".equals(boardSquares[1][2]) && "X".equals(boardSquares[2][2]) ||
            "X".equals(boardSquares[0][0]) && "X".equals(boardSquares[1][1]) && "X".equals(boardSquares[2][2]) ||
            "X".equals(boardSquares[0][2]) && "X".equals(boardSquares[1][1]) && "X".equals(boardSquares[2][0])
          ) {
            System.out.println("X venceu!!");
            end = true;
        }
        
        if( "O".equals(boardSquares[0][0]) && "O".equals(boardSquares[0][1]) && "O".equals(boardSquares[0][2]) ||
            "O".equals(boardSquares[1][0]) && "O".equals(boardSquares[1][1]) && "O".equals(boardSquares[1][2]) ||
            "O".equals(boardSquares[2][0]) && "O".equals(boardSquares[2][1]) && "O".equals(boardSquares[2][2]) ||
            "O".equals(boardSquares[0][0]) && "O".equals(boardSquares[1][0]) && "O".equals(boardSquares[2][0]) ||
            "O".equals(boardSquares[0][1]) && "O".equals(boardSquares[1][1]) && "O".equals(boardSquares[2][1]) ||
            "O".equals(boardSquares[0][2]) && "O".equals(boardSquares[1][2]) && "O".equals(boardSquares[2][2]) ||
            "O".equals(boardSquares[0][0]) && "O".equals(boardSquares[1][1]) && "O".equals(boardSquares[2][2]) ||
            "O".equals(boardSquares[0][2]) && "O".equals(boardSquares[1][1]) && "O".equals(boardSquares[2][0])
          ) {
            System.out.println("O venceu!!");
            end = true;
        }
    }
    
    public static void playerInput() {
        row = 0;
        column = "";
        do {
            do {
                try {
                    row = entradaInteiro("Escolha uma linha. (1, 2 ou 3)\n");
                    error = false;
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                    error = true;
                }
                inputValidation("R");
            } while(error);

            do {
                column = entradaTexto("Escolha uma coluna. (A, B ou C)\n");
                inputValidation("C");
            }while(error);
            
            if(!" ".equals(boardSquares[(row-1)][c])) {
                System.out.println("Casa ja preenchida, escolha outra");
                error = true;
            } else {
                error = false;
            }
        }while(error);
    }
    
    public static void inputValidation(String type) {
        // VERIFICA O VALOR DA COLUNA, E SE FOR VÁLIDO,
        // ATRIBUI UM NÚMERO 
        if(type.equals("C")) {
            if(column.equals("A") || column.equals("a")) {
                c = 0;
                error = false;
            } else if(column.equals("B") || column.equals("b")) {
                c = 1;
                error = false;
            } else if(column.equals("C") || column.equals("c")) {
                c = 2;
                error = false;
            } else {
                System.out.println("Coluna invalida");
                error = true;
            }
        //
        } else if(type.equals("R")) {
            if(row < 1 || row > 3) {
                error = true;
                System.out.println("Linha invalida");
            } else {
                error = false;
            }
        } else {
            System.out.println("Tipo invalido");
        }
    }
    
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardSquares[i][j] = " ";
            }
            
        }
    }
    
    public static void showBoard() {
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
        
        if(xTurn) player = "X";
             else player = "O";
    }
    
    public static void printPlayerTurn() {
        if(end != true) {
            System.out.println("Vez do " + player);
        }
    }
    
    public static void tiedTheGame() {
            if(moves >= 8) {
                System.out.println("Deu velha!!");
                end = true;
                System.exit(0);
            }
    }
    
}

/*
        JOGO DA VELHA
       A     B     C
    +-----+-----+-----+
1   |     |     |     |
    +-----+-----+-----+
2   |     |     |     |
    +-----+-----+-----+
3   |     |     |     |
    +-----+-----+-----+
*/
