package crossword;

public class Entry {
    private String word;
    private String clue;

    public Entry(String word, String clue){
        this.word=word;
        this.clue=clue;
    }

    public String getWord() {
        return word;
    }

    public String getClue() {
        return clue;
    }

    public Entry getEntry(){
        return new Entry(word,clue);
    }

    public void setWord(String word) {
        this.word = word;
    }
    public void setClue(String clue) {

        this.clue = clue;
    }
}
