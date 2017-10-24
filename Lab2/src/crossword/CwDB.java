package crossword;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class CwDB  {

    protected LinkedList<Entry>  dict= new LinkedList<>();



    public CwDB(String filename){
        File file = new File(filename);
    }

    public void add(String word, String clue){
        Entry new_word= new Entry(word,clue);
        dict.push(new_word);
    }


    public Entry get(String word){
        for(int i=0;i<dict.size();i++){
            System.out.println(dict.get(i).getWord());
            if(dict.get(i).getWord().equals(word)){
                System.out.println(dict.get(i).getWord());
                System.out.println(dict.get(i).getClue());
                return dict.get(i);
            }
            else {
                return new Entry("","");
            }
        }
        return new Entry("","");
    }

    public void remove(String word){
        for(int i=0;i<dict.size();i++){
            if(dict.get(i).getWord()==word){
                dict.remove(dict.get(i));
                dict.remove(dict.get(i+1));
            }
        }
    }

    public void saveDB(String filename){
        try {
            PrintWriter out = new PrintWriter(filename);
            for( int i=0;i<dict.size();i++){
                out.write(dict.get(i).getWord());
                out.write("\n");
                out.write(dict.get(i).getClue());
                out.write("\n");
            }
            out.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Niestety, nie mogę utworzyć pliku!");
        }
    }


    public int getSize(){
        return dict.size();
    }


    public void createDB(String filename){
        File file = new File(filename);

        try {

            Scanner sc = new Scanner(file);

            while (sc.hasNextLine()) {
                String _word = sc.nextLine();
                String _clue = sc.nextLine();
                Entry new_word= new Entry(_word,_clue);
                dict.add(new_word);
            }
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
