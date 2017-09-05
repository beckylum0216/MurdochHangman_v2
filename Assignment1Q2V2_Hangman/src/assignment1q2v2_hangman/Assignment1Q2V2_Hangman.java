/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1q2v2_hangman;

import java.util.Scanner;

/**
 *
 * @author rebecca
 */
public class Assignment1Q2V2_Hangman {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        char theFlag = 'y';
        Scanner theKB = new Scanner(System.in);
        int theTries;
        
        do{
            Hangman gameOne = new Hangman();
            gameOne.setGameStr("what does the fox say");
            System.out.println("Let's play a round of hangman");
            System.out.println("We are playing hangman.");
            theTries = 0;
            
            do
            {   
                gameOne.getDisguisedWord();
                theTries = theTries + 1;
                gameOne.setGameTries(theTries);
                gameOne.makeGuess();
            }while(!gameOne.isFound());
            
            System.out.println("Congratulations, you found the secret word: "
            + gameOne.getGameStr());
            
            Hangman gameTwo = new Hangman();
            gameTwo.setGameStr("jazz");
            System.out.println("Let's play another round of hangman");
            System.out.println("We are playing hangman.");
            theTries = 0;
            do
            {   
                gameTwo.getDisguisedWord();
                theTries = theTries + 1;
                gameTwo.setGameTries(theTries);
                
                gameTwo.makeGuess();
                
                
                System.out.println("Correct. Guesses made "+ 
                                gameTwo.getGameTries() + " with " 
                                + gameTwo.getGameWrong()+ " wrong.");
            }while(!gameTwo.isFound());
            
            System.out.println("Congratulations, you found the secret word: "
            + gameTwo.getGameStr());
            
            Hangman gameThree = new Hangman();
            gameThree.setGameStr("quick");
            System.out.println("Let's play the final round of hangman");
            System.out.println("We are playing hangman.");
            theTries = 0;
            do
            {   
                gameThree.getDisguisedWord();
                theTries = theTries + 1;
                gameThree.setGameTries(theTries);
                gameThree.makeGuess();
                
                System.out.println("Correct. Guesses made "+ 
                                gameThree.getGameTries() + " with " 
                                + gameThree.getGameWrong()+ " wrong.");
            }while(!gameThree.isFound());
            
            System.out.println("Congratulations, you found the secret word: "
            + gameThree.getGameStr());
            
            System.out.println("Would you like to continue? (Y/N)");
            theFlag = theKB.next().charAt(0);
            
        }while(theFlag == 'y');
    }
    
}
