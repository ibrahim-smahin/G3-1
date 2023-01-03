package com;

import java.util.Scanner;

public class LexicalAnalysis {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
String input = sc.nextLine();


  String[] tokens = input.split(" ");
  for (String token : tokens) {
     if (token.matches("[0-9]+")) {
        System.out.println("Number: " + token);
     } else if (token.matches("[a-zA-Z]+")) {
        System.out.println("Identifier: " + token);
     } else {
        System.out.println("Special character: " + token);
     }
  }
}
}