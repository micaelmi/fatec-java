package aula1;

import java.util.Scanner;

public class Aula1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);  
      String name, op;
      Double num1, num2, result;
      System.out.println("Hi! What's your name?");
      name = sc.nextLine();
      System.out.println("Hello, "+ name +"!");
      System.out.println("Enter the first number");
      num1 = sc.nextDouble();
      System.out.println("Enter the second number");
      num2 = sc.nextDouble();
      System.out.println("What is the operation? (+, -, *, /)");
      op = sc.next();
      if(null == op) {
          result = 0.0;
      } else result = switch (op) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> num1 + num2;
        };
      System.out.println("The result of the operation is: " + result);
    }
    
}
