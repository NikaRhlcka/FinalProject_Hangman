package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Methods methods = new Methods();

        Scanner scanUser = new Scanner(System.in);

        String userInput = "";

        do{
            System.out.println("Do you want to ...");
            System.out.println("""
                    1.Play game
                    2.Exit game
                    """);
            userInput = scanUser.nextLine();
            switch (userInput){
                case "1":
                    methods.play();
                    break;
                case "2":
                    System.out.println("Exiting game!");
                    break;
            }
        }while (!userInput.equalsIgnoreCase("2"));

    }

}
