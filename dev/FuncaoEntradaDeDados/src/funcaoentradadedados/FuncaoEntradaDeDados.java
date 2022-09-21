/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package funcaoentradadedados;

import java.util.Scanner;

/**
 *
 * @author Luciano Pelissoli
 */
public class FuncaoEntradaDeDados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final int alunos = 2;
        String nome[] = new String[alunos];
        double notas[][] = new double[alunos][4];
        iniciaNomes(nome);
        iniciaNotas(notas);
        
        for (int aluno = 0; aluno < alunos ; aluno ++ ){
            nome[aluno] = entradaTexto("Digite um nome\n");
            for (int C = 0; C < 3; C++){
              notas[aluno][C] = entradaDouble("Qual nota "+( C+1) + " do aluno?\n");
              // notas[aluno][3] += notas[aluno][C];
              notas[aluno][3] += (notas[aluno][C]/3);
            }
            // notas[aluno][3] /= 3;
        }
        String resultado = "O aluno %s, com notas %f, "
                             + "%f, %f e média %f\n";
        for (int aluno = 0 ; aluno < alunos; aluno++){
            
            System.out.printf(resultado,nome[aluno],notas[aluno][0],
                    notas[aluno][1],notas[aluno][2],notas[aluno][3]);
        }
        
        
        /*System.out.println("Você informou " + nome);
        * int idade = entradaInteiro("Digite sua idade\n");
        * double peso = entradaDouble("Qual o seu peso?\n");
        * char sexo = entradaChar("Qual o seu sexo?\n");
        */
    }
    
    static String entradaTexto(String mensagem){
        Scanner teclado = new Scanner(System.in);
        System.out.print(mensagem);
        return teclado.nextLine();
    }
    
    static int entradaInteiro(String mensagem){
        boolean erro = false;
        int num = 0;
        do {
           String aux = entradaTexto(mensagem);
           try{
                num = Integer.parseInt(aux);
                erro = false;
           }
           catch(Exception e){
               erro = true;
           }
        } while (erro);
        return num;
    }
    
    static double entradaDouble(String mensagem){
        boolean erro = false;
        double num = 0;
        do {
           String aux = entradaTexto(mensagem);
           try{
                num = Double.parseDouble(aux);
                erro = false;
           }
           catch(Exception e){
               erro = true;
           }
        } while (erro);
        return num;
    }

    private static char entradaChar(String mensagem) {
        boolean erro = false;
        char caracter = '\0';
        do{
            String aux = entradaTexto(mensagem);
            if (aux.length() != 1){
                erro = true;
            }
            else{
                caracter = aux.charAt(0);
                erro=false;
            }
        }
        while (erro);
        return caracter;
    }

    private static void iniciaNotas(double[][] notas) {
        for (int L = 0; L < notas.length; L++){
            for (int C = 0; C <notas[L].length;C++){
                notas[L][C] = 0;
            }
        }
    }

    private static void iniciaNomes(String[] nome) {
        for (int L = 0; L < nome.length; L++){
            nome[L] = "";
        }
    }
    
}
