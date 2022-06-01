package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Hangman game!");

        //selecting random word
        String[] randWords = new String[]{"dog", "elephant", "window",
                "nose", "telephone","book", "summer",
                "mango", "pen", "lake", "connection"};

        //gets random integer value of array = random word of array
        String secretWord = randWords[(int) (Math.random()*randWords.length)];
        //System.out.println(secretWord);

        //to keep letters of a secret word
        String[] lettersOfSecretWord = new String[secretWord.length()];

        //creates blank spaces in places where letters should go
        for (int i = 0; i < lettersOfSecretWord.length; i++) {
            lettersOfSecretWord[i] = "_";
        }
        //create max errors player can make
        int error = 0;

        while (error <5){
            //players input
            System.out.println( "\n" + "Input letter: ");
            String input = scanner.nextLine();
            char letter = input.charAt(0);

        //blank spaces that player needs to guess
            System.out.println("Word you are guessing: ");
            for (int i = 0; i < lettersOfSecretWord.length; i++) {
                System.out.print(lettersOfSecretWord[i]);
            }


        }

    }
}
