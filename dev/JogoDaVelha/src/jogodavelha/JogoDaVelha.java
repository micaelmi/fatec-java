package jogodavelha;

import java.util.Scanner;
import static jogodavelha.Entradas.*;

public class JogoDaVelha {
    
    public static String[][] boardSquares = new String[3][3];
    public static boolean xTurn = true;
    public static String player = " ";
    public static String column = " ";
    public static int row = 0;
    
    public static int c;
    public static boolean error = false;

        
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if(xTurn) player = "X";
             else player = "O";
        
        System.out.println("        JOGO DA VELHA");
        initializeBoard();
        board();
        
        System.out.println("Vez do " + player);
        column = entradaTexto("Escolha uma casa para jogar. (Coluna ENTER Linha) Ex: A 1\n");
        row = sc.nextInt();
        //System.out.println("Coluna "+ column + " Linha" + row);
        do {
            fillBoard();
            if(error) 
                System.out.println("Dado inválido");
        } while(error);
        
    }
    
    public static void fillBoard() {
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
            error = true;
        }
        
        if(row < 1 && row > 3) {
            error = true;
        } else {
            error = false;
        }
        
    }
    
    public static void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardSquares[i][j] = " ";
            }
            
        }
    }
    
    public static void board() {
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
