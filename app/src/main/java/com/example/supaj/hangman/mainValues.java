package com.example.supaj.hangman;

import java.util.Random;
import java.util.Vector;

public class mainValues {

    //contructor with nothing in it
    public mainValues(){
    }

    //variables

    public static int guesses = 0;
    public static final String[] words = {"time", "person", "year", "way", "day", "thing", "man", "world", "life", "hand", "be", "good", "new", "first", "last", "long", "great"};
    public static final int size = words.length;

    Random r = new Random();
    public final String mainWord = words[r.nextInt(size-1)];

    public static boolean lose = false;
    public static boolean isOne = false;

    public char guess = 0;

    public static String guessLetter;

    // list for the characters guessed
    Vector<Character> guessList=new Vector<>();


    // list for characters guessed correctly in string
    Vector<Character> charsGuessed = new Vector<>();

    // methods to get variables
    public static int getGuesses(){
        return guesses;
    }

    public static String[] getWords(){
        return words;
    }

    public static int getSize(){
        return size;
    }

    public static boolean getLose(){
        return lose;
    }

    public String getMainWord() {
        return mainWord;
    }
    public String getGuessLetter(){
        return guessLetter;
    }
    public boolean getIsOne(){
        return isOne;
    }

    public Vector<Character> getCharsGuessed() {
        return charsGuessed;
    }

    public Vector<Character> getGuessList() {
        return guessList;
    }

    public char getGuess(){
        return guess;
    }

    //set values
    public static void setGuessLetter(String guessLetter1){
        guessLetter = guessLetter1;
    }

    public void setGuess(char guess1){
        guess = guess1;
    }

    public static void setGuesses(int guessVal){
        guesses = guessVal;
    }
    public static void setLose(boolean loseVal){
        lose = loseVal;
    }

    public static void setIsOne(boolean isOne1){
        isOne = isOne1;
    }

    //Actual code

    public static String mainPrinting(int guessesP, Vector<Character> guessList, String mainWordP, Vector<Character> charsGuessed) {
        //deciding which hangman to print
        String printing = "";
        printing += "\n";
        printing += guessesP;
        printing += "\n";
        switch(guessesP) {
            case 0:
                printing += printFullHangman();
                break;
            case 1:
                printing += printHangman1();
                break;
            case 2:
                printing += printHangman2();
                break;
            case 3:
                printing += printHangman3();
                break;
            case 4:
                printing += printHangman4();
                break;
        }
        //printing the list of guesses
        printing += "\n\nYour guesses so far have been the following: [";
        for(int i = 0; i < guessList.size(); i++) {
            if(i > 0)
                printing+= ", ";
            printing += (guessList.get(i));

        }
        printing += "]\n";

        //printing the word and how many blanks
        for (int i = 0; i < mainWordP.length(); i++) {
            // boolean to see if print char or print "_"
            boolean printChar = false;
            for (int j = 0; j < charsGuessed.size(); j++) {
                if(charsGuessed.get(j) == mainWordP.charAt(i)) {
                    printing += charsGuessed.get(j) + " ";
                    printChar = true;
                }
            }
            if(printChar == false) {
                printing += "_ ";
            }
        }
        printing += "\n";

        return printing;
    }
    //hangman stages

    //printing the full hangman
    public static String printFullHangman() {
        return "     ------------------\n     |         |\n     |         |\n     |        O\n     |        -|-\n     |         |\n     |        ( )\n     |\n     |";
    }
    public static String printHangman1() {
       return "     ------------------\n     |         |\n     |         |\n     |        O\n     |        -|-\n     |         |\n     |        (\n     |\n     |";
    }
    public static String printHangman2() {
        return "     ------------------\n     |         |\n     |         |\n     |        O\n     |        -|-\n     |         |\n     |         \n     |\n     |";
    }
    public static String printHangman3() {
        return "     ------------------\n     |         |\n     |         |\n     |        O\n     |         |-\n     |         |\n     |\n     |\n     |                 ";

    }
    public static String printHangman4() {
        return "     ------------------\n     |         |\n     |         |\n     |        O\n     |         |\n     |         |\n     |\n     |\n     |";
    }


}
