/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment1q2v2_hangman;

import java.util.Random;
import java.util.Scanner;

/**
 * @title Bank Loan
 * @filename Hangman.java
 * @purpose This class contains exclusively methods that operate or support the 
 * running of the hangman program
 * @assumptions the inputs will only take in strings and do error checking on 
 * the input
 * @author rebecca
 * 
 * @author rebecca
 */
public class Hangman {
    
    private String gameStr;
    private StringBuilder gameAns = new StringBuilder();
    private int gameTries;
    private int gameWrong;
    private String gameSet;
   
    Scanner theKB = new Scanner(System.in);
    private Random theRnd = new Random(); //to generate a psudorandom number
    private int rndNum;
    
    /**
     * Constructor for the application, takes the input string and sets the 
     * secret word.
     * @param inputStr the secret word
     */
    public Hangman(String inputStr)
    {
        this.gameStr = inputStr;
        this.gameSet = this.gameSetOps();
        this.gameTries = 0;
        this.rndNum = theRnd.nextInt();
    }

    public int getGameTries() {
        return gameTries;
    }
    
    public String getGameStr() {
        return gameStr;
    }

    public StringBuilder getGameAns() {
        return gameAns;
    }

    public int getGameWrong() {
        return gameWrong;
    }
    
    
    public void StudentInfo()
    {
        System.out.println("Name:               Rebecca Lim");
        System.out.println("Student Number:     33111264");
        System.out.println("Enrolment:          Internal");
        System.out.println("Tutor:              Mark Abernethy");
        System.out.println("Tutorial:           Thursday, 10.30am");
    }
    
    /**
     * This method that checks the answer against the secret word and masks the 
     * rest. 
     */
    public void makeGuess()
    {
        String tempAns;      
      
        System.out.println("Guess a letter:");
        tempAns = theKB.nextLine().toLowerCase();
        //tempTest = Character.toString(tempAns);

        if(tempAns.isEmpty())
        {
            System.out.println("You have entered an empty string. "
                    + "Please enter something!");
        }
        else 
            if (tempAns.length() > 1 )
            {
                System.out.println("Sorry, bad guess. Need a single letter.");
            }
            else
                if(Character.isDigit(tempAns.charAt(0)))
                {
                    System.out.println("Sorry, your guess must be an alphabet "
                            + "character from a to z.");
                }
                else
                {
                    if((this.gameStr.contains(tempAns)))
                    {
                        if(this.gameAns.toString().contains(tempAns))
                        {
                            System.out.println("You have made this guess already!");
                        }
                        else
                        {
                            this.gameAns.append(tempAns);
                            System.out.println("Correct. Guesses made "+ 
                                    this.getGameTries() + " with " 
                                    + this.getGameWrong()+ " wrong.");
                        }
                    }
                    else
                    {
                        gameWrong = gameWrong + 1;
                        System.out.println("Incorrect. Guesses made "+ 
                                    this.getGameTries() + " with " 
                                    + this.getGameWrong()+ " wrong.");
                    }

                }
    }    
       
    
    /**
     * This method masks each letter in the word with questions marks for the 
     * user to guess. 
     */
    public void getDisguisedWord()
    {
        boolean found = false;
        int j = 0;
        
        System.out.print("The disguised word is <");
        
        if(this.gameAns.length() == 0)
        {
            for(int i = 0; i < this.gameStr.length(); i +=1)
            {
                System.out.print("?");
            }

        }
        else
        {
            
            for(int i = 0; i < this.gameStr.length(); i++)
            {
                while(found == false && j < this.gameAns.length())
                {
                    if(this.gameAns.charAt(j) == this.gameStr.charAt(i))
                    {
                        System.out.print(this.gameStr.charAt(i));
                        found = true;
                    }
                    j++;
                }

                if (found == false)
                {
                    System.out.print("?");
                }
                found = false;
                j = 0;
            }
            
            
        }
            
        System.out.print("> \n");
    }

    public void setGameTries(int gameTries) {
        this.gameTries = gameTries;
    }

    public void setGameWrong(int gameWrong) {
        this.gameWrong = gameWrong;
    }

    public void setGameStr(String gameStr) {
        this.gameStr = gameStr;
    }
    
    // Second attempt at masking the method does not work for all cases
    /*
    public void getDisguisedWord2()
    {
        StringBuilder theMask = new StringBuilder();
        int showIndex;
        
       
        for(int i = 0; i < this.gameStr.length(); i +=1)
        {
            theMask.append("?");
        }
        if(this.gameAns.length() > 0)
        {
            for (int i = 0; i < this.gameAns.length(); i++)
            {
                showIndex = this.gameStr.indexOf(this.gameAns.charAt(i));
                theMask.setCharAt(showIndex, this.gameAns.charAt(i));
            }
            
        }
        
        System.out.printf("The disguised word is <%s> \n", theMask);
    }
    */
    
    /**
     * This method compares the hashed answer and hashed secret word to return
     * whether the answer has been found.
     * @return theFlag a boolean of whether the word is found
     */
    public boolean isFound()
    {
        boolean theFlag = false;
        int hashedStr;
        int hashedAns;
        hashedStr  = HashItem(this.gameSet);
        hashedAns = HashItem(this.gameAns.toString());
        if(hashedStr == hashedAns)
        {
            theFlag = true;
        }
               
        return theFlag;
    }
    
    /**
     * This method hashes the item with a pseudorandom number  
     * @param inputStr
     * @return
     */
    public int HashItem(String inputStr)
    {
        int hashTot = 0;
        int hash  = 0;
        
        char str;
        
        
        for(int i = 0; i < inputStr.length(); i+=1)
        {
            str = inputStr.charAt(i);
            hash =  rndNum * str;
            hashTot += hash;
        }
        return hashTot;
    }
    
    /**
     *  This method returns the secret word for comparison without duplicate 
     *  characters. This method would create pseudo-set capabilities for the class
     * @return
     */
    public String gameSetOps()
    {
        String setResults = "";
        for(int i = 0; i < this.gameStr.length(); i+=1)
        {
            if(!setResults.contains(String.valueOf(this.gameStr.charAt(i))))
            {
                setResults += String.valueOf(this.gameStr.charAt(i));
            }
        }
        return setResults;
    }
    
    
    public void setGameAns(StringBuilder gameAns) {
        this.gameAns = gameAns;
    }
}
