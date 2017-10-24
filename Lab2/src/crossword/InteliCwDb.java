package crossword;

import java.util.LinkedList;
import java.util.Random;

public class InteliCwDb extends CwDB {


    public InteliCwDb(String filename) {
        super(filename);
    }


    public LinkedList<Entry> findAll(String pattern){
        LinkedList<Entry> found= new LinkedList<>();

        Entry tocheck=getRandom(pattern);
        if(tocheck.getClue().equals("") &tocheck.getWord().equals(""))
            return  found;
        else
            found.push(tocheck);
        return found;
    }


    public Entry getRandom(String pattern) {
        for (int i = 0; i < dict.size(); i++) {
            String temp = dict.get(i).getClue();
            String _tempword = dict.get(i).getWord();
            String _pattern = "";
            //System.out.println(temp.charAt(0));
            if (temp.charAt(0) == '[') {
                for (int j = 1; j < dict.size(); j++) {
                    if (temp.charAt(j) == (']')) {
                        j = dict.size();
                    } else {
                        //System.out.print(Character.toString(temp.charAt(j)));
                        _pattern+=Character.toString(temp.charAt(j));
                    }
                }
                if (_pattern.equals(pattern)) {
                    System.out.println(_tempword);
                    System.out.println(temp);
                    return (new Entry(_tempword, temp));
                }
            }
        }
        return new Entry("", "");
    }



    public Entry getRandom(){
        Random r=new Random();
        int a=r.nextInt(dict.size());
        return dict.get(a);
    }

    public Entry getRandom(int length){
        for(int i=0;i<dict.size();i++){
            if(dict.get(i).getWord().length()==length){
                System.out.println(dict.get(i).getWord());
                return dict.get(i);
            }
        }
        return new Entry("","");
    }


    @Override
    public void add(String word, String clue) {
        super.add(word, clue);

        for(int i=0;i<dict.size();i++){
            if((int)dict.get(i).getWord().charAt(0) <(int)word.charAt(0)){
                dict.add(i,new Entry(word,clue));
                this.saveDB("/home/ela/Pulpit/cwdb1.txt");
            }
        }
    }
}
