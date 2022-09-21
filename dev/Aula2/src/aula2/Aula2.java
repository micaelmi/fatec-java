/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aula2;

import java.util.Scanner;

public class Aula2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int program = 0;
        System.out.println("Olá, qual programa você deseja executar?");
        System.out.println("1 - Entradas de dados");
        System.out.println("2 - Vetores");
        program = sc.nextInt();
        sc.nextLine();
        if(program == 1) {
            entradas();
        }
        if(program == 2) {
            vetores();
        }
        
    }
    
    public static void entradas() {
        Scanner sc = new Scanner(System.in);  
        String name;
        int age;
        double wage;
        System.out.println("Ola, qual e o seu nome?");
        name = sc.nextLine();
        System.out.println("Qual e a sua idade?");
        age = sc.nextInt();
        System.out.println("Qual e o valor do seu salario mensal?");
        wage = sc.nextDouble();
        sc.nextLine();
        System.out.printf("Bom dia %s, sua idade é %d e voce ganha %.2f reais. \n", name, age, wage);
        System.out.println("Seu salario anual e de: " + wage*12 + " reais");
    }
    
    public static void vetores() {
        String[] semana = {"Dom","Seg", "Ter", "Qua", "Qui", "Sex"};
        int[] numeros = {1,4,7,6,2,9,8,8,0};
        double[] outrosNumeros = {1.8, -44.6, 345.78};
        
        System.out.println(semana[3]);
        
        System.out.println(outrosNumeros.length);
        
        for(int i=0; i < numeros.length; i++) {
            System.out.println(numeros[i]);
        }
        
        //For-each --> para cada. Um "for" igual ao de cima, mas automático.
        for(int i: numeros) { 
            System.out.println(i);
        }
    }    
}
