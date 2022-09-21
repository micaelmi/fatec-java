package aula4;

//import java.text.DecimalFormat;
import java.util.Scanner;

public class Aula4 {
    public static void main(String[] args) {
        // VETORES
        //String name[] = new String[5];
        byte size = 5; // variável que vai definir o tamanho de todos os vetores
        String[] nome = new String[size]; // valor inicial = null
        float[] n1 = new float[size];     // valor inicial = 0.0
        float[] n2 = new float[size];
        float[] n3 = new float[size];
        float[] media = new float[size];
        String[] status = new String[size];
        String auxString = "";
        float auxFloat = 0;
        Scanner sc = new Scanner(System.in);
        //DecimalFormat df = new DecimalFormat("#.00"); // arredonda números
        
        // "FOR" QUE CONFIGURA VALOR INICIAL PARA OS VETORES
        for (byte i = 0; i < size; i++) { // size ou name.length
            nome[i] = "";
            status[i] = "Aprovado(a)";
            n1[i] = 0;
            n2[i] = 0;
            n3[i] = 0;
            media[i] = 0;
            
            //System.out.println("Aluno: " + name[i] + n1[i] + n2[i] + n3[i]);
        }
        // PREENCHIMENTO DOS VETORES PELO USUÁRIO
        for (byte i = 0; i < size; i++) {
            System.out.println("Digite o nome do(a) aluno(a) "+(i+1));
            nome[i] = sc.nextLine();
            System.out.println("Digite a nota 1");
            n1[i] = sc.nextFloat();
            System.out.println("Digite a nota 2");
            n2[i] = sc.nextFloat();
            System.out.println("Digite a nota 3");
            n3[i] = sc.nextFloat();
            sc.nextLine();
            // CÁLCULO DE MÉDIA E STATUS
            media[i] = (n1[i]+n2[i]+n3[i])/3;
            if(media[i] < 6) status[i] = "Reprovado(a)"; 
        }
        //Ordenação
            for (int j = 0; j < size-1; j++) {
                for (int k = (j+1); k < size; k++) {
                    if(media[j] < media[k]){
                        
                        auxString = nome[j];
                        nome[j] = nome[k];
                        nome[k] = auxString;
                        
                        auxFloat = n1[j];
                        n1[j] = n1[k];
                        n1[k] = auxFloat;
                        
                        auxFloat = n2[j];
                        n2[j] = n2[k];
                        n2[k] = auxFloat;
                        
                        auxFloat = n3[j];
                        n3[j] = n3[k];
                        n3[k] = auxFloat;
                        
                        auxFloat = media[j];
                        media[j] = media[k];
                        media[k] = auxFloat;
                        
                        auxString = status[j];
                        status[j] = status[k];
                        status[k] = auxString;
                    }
                }
            }
            // Saída de dados
            String saida = "O aluno %s com nota 1 = %.2f; nota 2 = %.2f e nota 3 = %.2f; tem uma média de %.2f, portanto está %s";
            for (int i = 0; i < size; i++) {
                System.out.println(" ");
                System.out.printf(saida, nome[i], n1[i], n2[i], n3[i], media[i], status[i]); 
                System.out.println(" ");
            }
        
        /* OUTRO MODO DE FAZER A SAÍDA DE DADOS
            System.out.println("Aluno(a) " + name[i]);
            System.out.println("Notas: " + n1[i]+ " | " + n2[i] + " | " + n3[i]);
            float media = (n1[i]+n2[i]+n3[i])/3;
            System.out.println("Média: " + df.format(media));
            String status = "Aprovado(a)";
            if(media < 6) status = "Reprovado(a)";
            System.out.println("Status: " + status); 
        */
    }   
}
