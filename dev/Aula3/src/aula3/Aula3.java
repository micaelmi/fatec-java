package aula3;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class Aula3 {
    public static void main(String[] args) {
        Aprovacao();
    } 
    
   public static void Aprovacao() {
       String name = "", aproved = "";
       float grade1 = 0.0f, grade2 = 0.0f, average = 0.0f;
       Scanner read = new Scanner(System.in);
       
       //byte i = 0;
       //while (i < 3) {
       //i++;
       for (byte i = 0; i < 2; i++) {
            System.out.println("Qual é o nome do aluno");
            name = read.nextLine();
            System.out.println("Qual é a primeira nota?");
            grade1 = read.nextFloat();
            System.out.println("Qual é a segunda nota?"); 
            grade2 = read.nextFloat();
            read.nextLine();
            average = (grade1 + grade2) / 2;
            System.out.println("A média do(a)" + name + " é: " + average);
            if(average >= 6) {
                aproved = "aprovado(a)";
            } else {
                aproved = "reprovado(a)";
            }
            System.out.print(name + " está " + aproved);
       }
       read.close();
       JOptionPane.showMessageDialog(null, "Programa Terminado.");
   }
}
