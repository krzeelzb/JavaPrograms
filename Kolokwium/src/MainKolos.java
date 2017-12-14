import java.io.FileNotFoundException;
import java.util.Stack;

public class MainKolos {

    public static void main(String[] argv) throws FileNotFoundException {
//        String odczyt;
//        File plik=new File("path");
//        Scanner scan= new Scanner(plik);
//        odczyt=scan.nextLine();
        Stack<Operator> st= new Stack();

        String tmp= "11+2*"; //Zmiast tmp to co w pliku 
        for(int i=0;i<tmp.length();i++){
            if(Character.isDigit(tmp.charAt(i))){
            Stała _stała = new Stała(Character.toString(tmp.charAt(i)));
            st.push(_stała);
            }
            if(Character.toString(tmp.charAt(i))=="+"){
               Dodawanie mn=new Dodawanie(Character.toString(tmp.charAt(i)));
                st.push(mn);
            }
            if(Character.toString(tmp.charAt(i))=="*"){
                Mnożenie mn=new Mnożenie((Character.toString(tmp.charAt(i))));
                st.push(mn);
            }
            if(Character.toString(tmp.charAt(i))=="!"){
                Silnia mn=new Silnia ((Character.toString(tmp.charAt(i))));
                st.push(mn);
            }
            if(Character.toString(tmp.charAt(i))=="/"){
               Dzielenie mn=new Dzielenie ((Character.toString(tmp.charAt(i))));
                st.push(mn);
            }


        }


        int stSize=st.size();
        Operator x= st.pop();
        x.oblicz(st);




    }
}
