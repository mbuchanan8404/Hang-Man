import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Dictionary {
    private String[] dictionary;
    private static final int NUMBER_OF_WORDS = 81452;
    private static final String FILE_NAME = "dictionarycleaned.txt";
    
    Dictionary() throws FileNotFoundException{
        Scanner myScanner = new Scanner(new File(FILE_NAME));
        dictionary = new String[NUMBER_OF_WORDS];
        for(int i = 0; i < NUMBER_OF_WORDS; i++){
            this.dictionary[i] = myScanner.nextLine();
        }
    }
    
    public String getRandomWord(){
        Random rand = new Random();
        return this.dictionary[rand.nextInt(NUMBER_OF_WORDS + 1)];
    }
    
}
