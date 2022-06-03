package com.company;

import java.io.StringWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Methods {

    Scanner scanner = new Scanner(System.in);

    //selecting random word
    String[] randWords = new String[]{"dog", "elephant", "window",
            "nose", "telephone","book", "summer",
            "mango", "pen", "lake", "connection"};


    public void play() {
        String secretWord = randWords[(int) (Math.random() * randWords.length)];
        System.out.println(secretWord);

        System.out.println("Welcome to Hangman game!");
        System.out.println();
        System.out.println("Secret word has " + secretWord.length() + " letters.");
        System.out.println("You are able to make 5 mistakes. Good luck!");

        //keep letters of a secret word
        char[] lettersOfSecretWord = new char[secretWord.length()];
        //System.out.println("letters of a secret word: "+ Arrays.toString(lettersOfSecretWord));

        //creates blank spaces in places where letters should go
        Arrays.fill(lettersOfSecretWord, '_');

       /* for (int i = 0; i < lettersOfSecretWord.length; i++) {
            lettersOfSecretWord[i] = '_';
        }*/ //initially wanted to use: for(...), java suggested: Arrays.fill(...)

        //create max errors player can make
        int error = 0;

        //StringWriter guessedWord = null;

        while (error < 5) {
            //players input
            if (Arrays.toString(lettersOfSecretWord).equalsIgnoreCase(secretWord)){
                System.out.println("end game");
            }

            System.out.println("\nInput letter:");
            String input = scanner.nextLine();
            char inputLetter = input.charAt(0);
            int strike = 0;

            //StringBuilder guessedWord = new StringBuilder();
            //guessedWord = "";

            //checking letters provided by player
            for (int i = 0; i < secretWord.length(); i++) {

                //each letter in secret word
                char eachLetter = secretWord.charAt(i);

                if (inputLetter == eachLetter) {
                    lettersOfSecretWord[i] = inputLetter;

                    //guessedWord.append(inputLetter);
                    //guessedWord = guessedWord + input;
                    //guessedWord.append(input);
                    //System.out.println("string of guessed letters: " + guessedWord);

                } else {
                    strike++;
                }
            }

            if (strike == secretWord.length()) {
                error++;
                int left = 5-error;
                System.out.println("You have " + left + " attempts left to guess a word.");
            }

            //blank spaces that player needs to guess
            System.out.println("Word you are guessing:");
            for (int i = 0; i < lettersOfSecretWord.length; i++) {
                System.out.print(lettersOfSecretWord[i]);
            }

        } //end of while loop


        if (error == 5) {
            System.out.println("\nGame over." + "\nSecret word was: " + secretWord);
            System.out.println();
        }else if(lettersOfSecretWord.length == secretWord.length()){
            System.out.println("You won");
        }

    } //end of play method

}
