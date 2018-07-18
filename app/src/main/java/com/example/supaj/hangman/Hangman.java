package com.example.supaj.hangman;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.Vector;

import static java.util.logging.Logger.global;


public class Hangman extends Fragment {


    public Hangman() {
        // Required empty public constructor
    }

    mainValues hangman = new mainValues();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hangman, container, false);
    }

    //defining new object


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

        //defining new Hangman object
        /* This is for the input */


        final EditText editText = (EditText) view.findViewById(R.id.letter);
        final TextView mainPrint = (TextView) getActivity().findViewById(R.id.hangmanbody);
        mainPrint.setText(hangman.mainPrinting(hangman.guesses, hangman.guessList, hangman.mainWord, hangman.charsGuessed));
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                //mainValues hangmanObj = new mainValues();
                //variables
/*
                 int guesses = 0;
                 final String[] words = {"time", "person", "year", "way", "day", "thing", "man", "world", "life", "hand", "be", "good", "new", "first", "last", "long", "great"};
                 final int size = words.length;

                Random r = new Random();
                 String mainWord = words[r.nextInt(size-1)];

                //technically replace with object variable
                 boolean lose = false;
                boolean isOne = false;

                char guess = 0;

                String guessLetter = "";

                // list for the characters guessed
                Vector<Character> guessList=new Vector<>();


                // list for characters guessed correctly in string
                Vector<Character> charsGuessed = new Vector<>();
                */

                boolean handled = false;
                hangman.guess = 0;
                hangman.setIsOne(false);

                if (hangman.lose == false) {
                    mainPrint.setText(hangman.mainPrinting(hangman.guesses, hangman.guessList, hangman.mainWord, hangman.charsGuessed));
                    if (actionId == EditorInfo.IME_ACTION_SEND) {
                        if (editText.getText().toString().length() > 1) {
                            Toast.makeText(getActivity(), "Error: The input needs to be more than one letter.", Toast.LENGTH_SHORT).show();
                            hangman.setIsOne(false);
                        } else {
                            hangman.setGuessLetter(editText.getText().toString());
                            hangman.setIsOne(true);
                        }
                    }
                    boolean same = false;
                    if (hangman.getIsOne() == true) {

                        hangman.setGuess(hangman.guessLetter.charAt(0));
                        for (int i = 0; i < hangman.guessList.size(); i++) {
                            if (hangman.getGuess() == hangman.guessList.get(i)) {
                                Toast.makeText(getActivity(), "You entered something the same as your gueeses noob", Toast.LENGTH_SHORT).show();
                                same = true;
                            }
                        }
                        for (int i = 0; i < hangman.charsGuessed.size(); i++) {
                            if (hangman.getGuess() == hangman.charsGuessed.get(i)) {
                                Toast.makeText(getActivity(), "You entered something the same as your guesses noob", Toast.LENGTH_SHORT).show();
                                same = true;

                            }
                        }
                    }
                    if (hangman.isOne == true && same == false) {
                        Toast.makeText(getActivity(), "Success", Toast.LENGTH_SHORT).show();
                        boolean correct = false;
                        for (int i = 0; i < hangman.mainWord.length(); i++) {
                            if (hangman.guess == hangman.mainWord.charAt(i)) {
                                hangman.charsGuessed.add(hangman.guess);
                                correct = true;
                                break;
                            }
                        }
                        //check that word was filled or not
                        int numCorrect = 0;
                        for (int i = 0; i < hangman.mainWord.length(); i++) {
                            for (int j = 0; j < hangman.charsGuessed.size(); j++) {
                                if (hangman.charsGuessed.get(j) == hangman.mainWord.charAt(i)) {
                                    numCorrect = numCorrect + 1;
                                }
                            }
                        }


                        TextView mainPrint2 = (TextView) getActivity().findViewById(R.id.end);
                        // if true, win
                        if (numCorrect == hangman.mainWord.length()) {
                            mainPrint2.setText("\nThe word you made was: " + hangman.mainWord + "\nCongrats!!! You Win!!!");

                            Toast.makeText(getActivity(), "End of Program", Toast.LENGTH_SHORT).show();
                            //break;
                            hangman.lose = true;

                        }

                        // add to guesses, check to see if guesses if over amount
                        if (correct == false) {
                            hangman.guesses = hangman.guesses + 1;
                            hangman.guessList.add(hangman.guess);
                        }
                        // if guesses > 5, break loop and say game over
                        if (hangman.guesses > 4) {
                            mainPrint2.setText("\nGAME OVER!! Try again!" + "The word was " + hangman.mainWord);

                            Toast.makeText(getActivity(), "End of Program", Toast.LENGTH_SHORT).show();
                            hangman.lose = true;
                            //break;
                        }
                        mainPrint.setText(hangman.mainPrinting(hangman.guesses, hangman.guessList, hangman.mainWord, hangman.charsGuessed));

                    }
                }


                //end code
                handled = true;
                return handled;
            }

        });

    }


}
