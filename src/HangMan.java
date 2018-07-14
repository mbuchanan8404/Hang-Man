import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Matthew Buchanan
 * Program 5
 * CS 150 Mr. Klein
 */

public class HangMan {

    static final int NUMBER_MISSES = 5;
    
    public static void main(String[] args) throws FileNotFoundException {
        
        while(true){
            Dictionary myDictionary = new Dictionary();
            WordHider myWordHider = new WordHider(myDictionary.getRandomWord());
            int temp = 0;
            int count = 0;
            String s;
            String lettersGuessed = "";
            Scanner myScanner = new Scanner(System.in);
            while(count < NUMBER_MISSES){
                System.out.println("Word: " + myWordHider.getPartiallyFoundWord() + 
                        " Guesses Left: " + (NUMBER_MISSES - count) + " Letters Guessed: "
                        + lettersGuessed);
                System.out.println("Enter your guess: ");
                s = myScanner.next();
                lettersGuessed += s;
                temp = myWordHider.revealLetter(s);
                if(temp == 0){
                    count++;
                    System.out.println("Miss!");
                }
                if(myWordHider.wordFound()){
                    System.out.println("Word: " + myWordHider.getHiddenWord());
                    System.out.println("Yay! You got it!");
                    System.out.println();
                    break;
                }
                else if(count == 5){
                    System.out.println("Oh No!");
                    System.out.println("The Word Was: " + myWordHider.getHiddenWord());
                    System.out.println();
                }
            }
        }
    }
}
