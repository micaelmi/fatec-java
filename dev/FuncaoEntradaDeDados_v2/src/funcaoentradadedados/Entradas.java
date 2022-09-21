package funcaoentradadedados;

import java.util.Scanner;

public class Entradas {
    public static String entradaTexto(String mensagem){
        Scanner teclado = new Scanner(System.in);
        System.out.print(mensagem);
        return teclado.nextLine();
    }
    
    public static int entradaInteiro(String mensagem) throws Exception{
        //boolean erro = false;
        int num = 0;
        //do {
           String aux = entradaTexto(mensagem);
           try{
                num = Integer.parseInt(aux);
                //erro = false;
           }
           catch(Exception e){
               //erro = true;
               throw new Exception("Nao recebeu um numero inteiro");
           }
        //} while (erro);
        return num;
    }
    
    public static double entradaDouble(String mensagem) throws Exception{
        //boolean erro = false;
        double num = 0;
        //do {
           String aux = entradaTexto(mensagem);
           try{
                num = Double.parseDouble(aux);
                //erro = false;
           }
           catch(Exception e){
               //erro = true;
               throw new Exception("Nao recebeu um numero válido");
           }
        //} while (erro);
        return num;
    }

    public static char entradaChar(String mensagem) throws Exception {
        //boolean erro = false;
        char caracter = '\0';
        //do{
            String aux = entradaTexto(mensagem);
            if (aux.length() != 1){
                //erro = true;
                throw new Exception("Nao recebeu apenas um caractere");
            }
            else{
                caracter = aux.charAt(0);
                //erro=false;
            }
        //} while (erro);
        return caracter;
    }
}
