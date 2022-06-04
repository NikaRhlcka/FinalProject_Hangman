package com.company;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Methods {

    Scanner scanner = new Scanner(System.in);

    //selecting random word
    String[] randWords = new String[]{"dog", "window",
            "nose", "book", "summer",
            "mango", "pen", "lake" };


    public void play() {
        String secretWord = randWords[(int) (Math.random() * randWords.length)];
        System.out.println(secretWord);

        System.out.println("Welcome to Hangman game!");
        System.out.println();
        System.out.println("Secret word has " + secretWord.length() + " letters.");
        System.out.println("You are able to make 5 mistakes. Good luck!");

        //keep letters of a secret word
        char[] lettersOfSecretWord = new char[secretWord.length()];

        //creates blank spaces in places where letters should go
        Arrays.fill(lettersOfSecretWord, '_');

       /* for (int i = 0; i < lettersOfSecretWord.length; i++) {
            lettersOfSecretWord[i] = '_';
        }*/ //initially wanted to use: for(...), java suggested: Arrays.fill(...)

        //create max errors player can make
        int error = 0;
        String wrongLetters ="";

        StringBuilder sbf = new StringBuilder("");


        while (error < 5 && !Arrays.toString(lettersOfSecretWord).equalsIgnoreCase(secretWord)) {

          /*
           //moved at the end - looks like it works

           String a ="";
            for (int i = 0; i < lettersOfSecretWord.length; i++) {
                a=a+lettersOfSecretWord[i];
            }
            if (a.equalsIgnoreCase(secretWord)){
                System.out.println("\n");
                System.out.println("You won!");
                System.out.println();
                return;
            }*/

            //players input
            System.out.println();
            System.out.println(".............................");
            System.out.println("Input letter:");
            String input = scanner.nextLine();
            char inputLetter = input.charAt(0);
            int strike = 0;

            //check if input is small alphabet letters
            if (input.matches("[a-z]")) {

                if (Arrays.toString(lettersOfSecretWord).contains(input)) {
                    System.out.println("This letter already been used!\n");
                }

                //checking letters provided by player
                for (int i = 0; i < secretWord.length(); i++) {

                    //each letter in secret word
                    char eachLetter = secretWord.charAt(i);

                    if (inputLetter == eachLetter) {
                        lettersOfSecretWord[i] = inputLetter;

                    } else {
                        strike++;
                    }
                }

                if (strike == secretWord.length()) {
                    error++;
                    int left = 5 - error;
                    System.out.println("Secret word does not contain this letter.");
                    System.out.println("You have " + left + " attempts left to guess a word!\n");

                    //prints wrongly guessed letters
                    wrongLetters = wrongLetters + inputLetter;
                    System.out.println("Wrong letters you already tried: " + wrongLetters + "\n");

                    //ends game when error=5
                    if (error == 5) {
                        System.out.println("Game over." + "\nSecret word was: " + secretWord);
                        System.out.println("Good luck next time!");
                        System.out.println();
                        return;
                    }
                }

                //blank spaces that player needs to guess
                System.out.println("Word you are guessing: ");
                for (int i = 0; i < lettersOfSecretWord.length; i++) {
                    System.out.print(lettersOfSecretWord[i]);
                }

                String a = "";

                for (int i = 0; i < lettersOfSecretWord.length; i++) {
                    a = a + lettersOfSecretWord[i];
                }

                if (a.equalsIgnoreCase(secretWord)) {
                    System.out.println("\n");
                    System.out.println("You won!");
                    System.out.println();
                    return;
                }

            }else{
                System.out.println("Invalid input!");
                System.out.println("Enter only: a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z");
            }

        } //end of while loop

    } //end of play method

}
