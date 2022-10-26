package jogodaforca;

import java.util.Scanner;
import java.util.Random;

public class JogoDaForca {

    public static char[][] gallow = {
            { '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ' },
            { '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ' },
            { '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' },
            { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ' },
            { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#' },
    };

    public static String theme = "Animal";
    public static char attempt = ' ';
    public static String[] listOfAttempts = {
            " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ",
            " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " " };

    public static String[] wordsList = {
            "BABUINO", "GNU", "VEADO", "PINGUIM", "HIPOPOTAMO",
            "LEAO", "ELEFANTE", "GIRAFA", "ZEBRA", "HIENA"
    };

    public static String wordDrawn;
    public static String wordSplited[], hiddenWord[];

    public static int chances = 7;
    public static int guessingCounter = 0;

    public static boolean gameIsEnded = false;

    public static void main(String[] args) {
        drawnWord();
        do {
            System.out.println("\n\n\n\n\n\n\n");
            showGame();
            tryLetter();
        } while (gameIsEnded == false);
    }

    public static void drawnWord() {
        Random random = new Random();
        int index = random.nextInt(wordsList.length);
        wordDrawn = wordsList[index];

        wordSplited = wordDrawn.split("");
        hiddenWord = new String[wordSplited.length];

        for (int i = 0; i < wordSplited.length; i++) {
            hiddenWord[i] = "_ ";
        }
    }

    public static void showGame() {
        System.out.println("============== Jogo da Forca ============= \n");
        System.out.println("Tema: " + theme);
        System.out.println("Chances: " + chances);
        System.out.print("Tentativas: ");
        for (int i = 0; i < listOfAttempts.length; i++) {
            System.out.print(listOfAttempts[i] + " ");
        }
        System.out.println("");
        // Forca ----------
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 15; j++) {
                System.out.print(gallow[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
        System.out.print("Palavra: ");
        for (int i = 0; i < hiddenWord.length; i++) {
            System.out.print(hiddenWord[i]);
        }
        System.out.println("");
    }

    public static void tryLetter() {
        boolean error = false;
        do {
            try {
                attempt = entradaChar("Seu palpite: ");
                error = false;
            } catch (Exception e) {
                error = true;
                System.out.println(e.getMessage());
            }

            String validateAttempt = String.valueOf(attempt);
            for (int i = 0; i < listOfAttempts.length; i++) {
                if (validateAttempt.equals(listOfAttempts[i])) {
                    error = true;
                    System.out.println("Você já tentou essa letra");
                }
            }

        } while (error);

        String letterAttempted = String.valueOf(attempt);

        boolean guessedLetter = false;
        boolean guessedWord = true;
        for (int i = 0; i < wordSplited.length; i++) {

            if (letterAttempted.equals(wordSplited[i])) { // Acertou a letra OK
                hiddenWord[i] = letterAttempted;
                guessedLetter = true;
                guessingCounter++;
            }
        }

        // Lista as letras já usadas OK
        for (int j = 0; j < listOfAttempts.length; j++) {
            if (listOfAttempts[j] == " ") {
                listOfAttempts[j] = letterAttempted;
                j = listOfAttempts.length;
            }
        }
        // Se errou a letra
        if (guessedLetter == false || guessingCounter == 0) {
            System.out.println("Errou o palpite!");
            chances--;
            // Adicionar parte do boneco
            addBodyPart();
        }
        // Se acabaram as chances
        if (chances == 0) {
            endGame("lost");
        }

        // Verifica se ganhou
        if (guessingCounter == hiddenWord.length) {
            guessedWord = true;
        } else {
            guessedWord = false;
        }

        if (guessedWord) {
            endGame("won");
        }
    }

    public static void addBodyPart() {
        if (chances == 6) {
            gallow[2][6] = '(';
            gallow[2][7] = '°';
            gallow[2][8] = '¬';
            gallow[2][9] = '°';
            gallow[2][10] = ')';
        }
        if (chances == 5) {
            gallow[3][7] = '[';
            gallow[3][9] = ']';
        }
        if (chances == 4) {
            gallow[4][6] = '/';
            gallow[5][5] = '/';
        }
        if (chances == 3) {
            gallow[4][8] = '|';
            gallow[5][8] = '|';
        }
        if (chances == 2) {
            gallow[4][10] = '\\';
            gallow[5][11] = '\\';
        }
        if (chances == 1) {
            gallow[6][7] = '/';
            gallow[7][6] = '/';
        }
        if (chances == 0) {
            gallow[6][9] = '\\';
            gallow[7][10] = '\\';
        }
    }

    public static void endGame(String status) {
        if (status == "lost") {
            // Game Over
            showGame();
            System.out.println("Fim de Jogo! Você perdeu!");
            System.out.println("A palavra era: " + wordDrawn);
            gameIsEnded = true;
        } else if (status == "won") {
            // Vitória
            showGame();
            System.out.println("Parabéns! Você Venceu!");
            gameIsEnded = true;
        } else {
            // Status Inválido
            System.out.println("Erro de Execução!");
        }
    }

    public static String entradaTexto(String mensagem) {
        Scanner teclado = new Scanner(System.in);
        System.out.print(mensagem);
        return teclado.nextLine();
    }

    public static char entradaChar(String mensagem) throws Exception {
        char caracter = '\0';
        String aux = entradaTexto(mensagem);
        if (aux.length() != 1) {
            throw new Exception("Nao recebeu apenas um caractere");
        } else {
            aux = aux.toUpperCase();
            caracter = aux.charAt(0);
        }
        return caracter;
    }

}

/*
 * 
 * ============== Jogo da Forca =============
 * 
 * Tema: Animal
 * Tentativas: A G H J K P O
 * 
 * #########
 * ## |
 * ## (°¬°)
 * ## [ ]
 * ## / | \
 * ## / | \
 * ## / \
 * ## / \
 * ##
 * #############
 * ###############
 * 
 * Palavra: P A _ _ A _ O
 * 
 * Palpite: S
 * 
 * 
 * 
 * { '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ', ' ', ' ', ' ', ' ' 0
 * },
 * { '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', ' ', ' ', ' ' 1
 * },
 * { '#', '#', ' ', ' ', ' ', ' ', '(', 'x', '¬', 'x', ')', ' ', ' ', ' ', ' ' 2
 * },
 * { '#', '#', ' ', ' ', ' ', ' ', ' ', '[', ' ', ']', ' ', ' ', ' ', ' ', ' ' 3
 * },
 * { '#', '#', ' ', ' ', ' ', ' ', '/', ' ', '|', ' ', '\\', ' ', ' ', ' ', ' '
 * 4
 * },
 * { '#', '#', ' ', ' ', ' ', '/', ' ', ' ', '|', ' ', ' ', '\\', ' ', ' ', ' '
 * 5
 * },
 * { '#', '#', ' ', ' ', ' ', ' ', ' ', '/', ' ', '\\', ' ', ' ', ' ', ' ', ' '
 * 6
 * },
 * { '#', '#', ' ', ' ', ' ', ' ', '/', ' ', ' ', ' ', '\\', ' ', ' ', ' ', ' '
 * 7
 * },
 * { '#', '#', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ' 8
 * },
 * { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', ' ', ' ' 9
 * },
 * { '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'
 * },
 */