public class WordHider {
    private String hiddenWord;
    private String partiallyFoundWord;
    
    WordHider(String s){
        this.hiddenWord = s;
        this.partiallyFoundWord = "*";
        for(int i = 1; i < s.length(); i++){
            this.partiallyFoundWord += "*";
        }
    }
    
    public int revealLetter(String letter){
        int letterCount = 0;
        char letterTemp;
        StringBuilder myStringBuilder = new StringBuilder(partiallyFoundWord);
        if(letter.length() > 1 || letter.length() < 1){
            return 0;
        }
        letterTemp = letter.charAt(0);
        for(int i = 0; i < hiddenWord.length(); i++){
            if(hiddenWord.charAt(i) == letterTemp){
                letterCount++;
                myStringBuilder.replace(i, i + 1, letter);
            }
        }
        partiallyFoundWord = myStringBuilder.toString();
        return letterCount;
    }
    
    public boolean wordFound(){
        return partiallyFoundWord.equals(hiddenWord);
    }
    
    public void hideWord(){
        this.partiallyFoundWord = "*";
        for(int i = 1; i < hiddenWord.length(); i++){
            this.partiallyFoundWord += "*";
        }
    }
    
    public String getPartiallyFoundWord(){
        return partiallyFoundWord;
    }
    
    public String getHiddenWord(){
        return hiddenWord;
    }
}
