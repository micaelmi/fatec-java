package funcaoentradadedados;

import static funcaoentradadedados.Entradas.*;

public class FuncaoEntradaDeDados {

    public static void main(String[] args) {
        final int alunos = 2;
        String nome[] = new String[alunos];
        double notas[][] = new double[alunos][4];
        String aprovacao[] = new String[alunos];
        iniciaNomes(nome);
        iniciaNotas(notas);
        iniciaAprovacao(aprovacao);
        
        for (int aluno = 0; aluno < alunos ; aluno ++ ){
            nome[aluno] = entradaTexto("Digite o nome do(a) aluno(a)\n");
            for (int C = 0; C < 3; C++){
              boolean erro = false;
              do {
                  try {
                    notas[aluno][C] = entradaDouble("Qual "+( C+1) + "a nota?\n");
                    erro = false;
                  } catch(Exception e) {
                    erro = true;
                    System.out.println(e.getMessage());
                  }
              } while(erro);
              // notas[aluno][3] += notas[aluno][C];
              notas[aluno][3] += (notas[aluno][C]/3); // media
              
              if(notas[aluno][3] >= 6.0) {
                  aprovacao[aluno] = "Aprovado(a)";
                } else {
                  aprovacao[aluno] = "Reprovado(a)";
                }
            }
            // notas[aluno][3] /= 3;
        }
        String resultado = "O aluno %s, com notas %.2f, %.2f, %.2f e media %.2f esta %s\n";
        for (int aluno = 0 ; aluno < alunos; aluno++){
            
            System.out.printf(resultado,nome[aluno],notas[aluno][0],
                    notas[aluno][1],notas[aluno][2],notas[aluno][3], aprovacao[aluno]);
        }
        
        
        int idade;
        double peso;
        char sexo;
        try {
        System.out.println("Você informou " + nome);
        idade = entradaInteiro("Digite sua idade\n");
        peso = entradaDouble("Qual o seu peso?\n");
        sexo = entradaChar("Qual o seu sexo?\n");
        } catch(Exception e) {
            idade = 0;
            peso = 0.0;
            sexo = ' ';
        }
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
    
    private static void iniciaAprovacao(String[] aprovado) {
        for (int L = 0; L < aprovado.length; L++){
            aprovado[L] = "Aprovado(a)";
        }
    }
    
}
