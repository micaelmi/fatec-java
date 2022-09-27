package jogodavelha;

import java.util.Scanner;

public class Entradas {
    
    // realiza entradas tipo String
    public static String entradaTexto(String mensagem){
        Scanner sc = new Scanner(System.in);
        System.out.print(mensagem);
        return sc.nextLine();
    }
    
    // realiza entradas tipo Inteiro e faz uma validação, podendo lançar um erro caso não seja inteiro
    public static int entradaInteiro(String mensagem) throws Exception{
        int num = 0;
           String aux = entradaTexto(mensagem);
           try{
                num = Integer.parseInt(aux);
           }
           catch(NumberFormatException e){
               throw new Exception("Nao recebeu um numero inteiro");
           }
        return num;
    }
}
