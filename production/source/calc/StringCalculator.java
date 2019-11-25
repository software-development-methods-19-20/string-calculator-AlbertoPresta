package calc;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;





public class StringCalculator {
    private String numbers;
    private ArrayList<String> delimiter = new ArrayList<String>();


    public StringCalculator(String str) {
        if (str.startsWith("//")) {
            String temp = str.substring(str.indexOf("/")+2); // serve per capire quando sono finiti i delimiter
            while(!temp.startsWith("\n")) {
                this.delimiter.add(temp.substring(temp.indexOf("[") + 1, temp.indexOf("]")));
                temp = temp.substring(temp.indexOf("]") + 1);
            }
            this.numbers = str.substring(str.indexOf("\n") + 1);
        }
        else {
            this.delimiter.add(","); // default delimiter
            numbers = str;
        }

    }

    public String getNumbers(){return numbers;}
    public ArrayList<String> getDelimiter(){return delimiter;}


    public String remove_duplicate_from_delimiter(String res){
        String[] temp = new String[res.length()];
        for(int i = 0; i<res.length();i++){
            temp[i]=res.substring(i,i+1);;
        }
        String t  = Arrays.stream(temp).distinct().collect(Collectors.joining( "" ));
        return t;
    }

    public String[] remove_empty_element(String[] input){
        List<String> y = Arrays.stream(input).filter(x->x.length()>0).collect(Collectors.toList());
        String[] items = new String[y.size()];
        return y.toArray(items);
    }

    public String join_delimiters_simbols(){
        ArrayList<String> temp = new ArrayList<String>();
        for(int i=0;i<this.delimiter.size();i++){
            String t = this.delimiter.get(i);
            for(int j=0;j<t.length();j=j+1){
                temp.add(t.substring(j,j+1));
            }
        }
        String [] temporaneo = from_Arraylist_to_Array(temp);
        for(int i= 0;i<temp.size();i++){temporaneo[i]=temp.get(i);}
        String res  = Arrays.stream(temporaneo).distinct().collect(Collectors.joining( "" ));
        return res;
    }

    private String[] from_Arraylist_to_Array(ArrayList<String> temp) {
        String[] temporaneo = new String[temp.size()];
        for(int i= 0;i<temp.size();i++){temporaneo[i]=temp.get(i);}
        return temporaneo;
    }


    public int add() throws NotnegativesNumbers {
        ArrayList<String> negatives = check_negatives();
        if(negatives.size()>0){
            throw new NotnegativesNumbers(negatives);
        }
        else if (this.numbers.equals("")) {
            return 0;
        } else if (!this.numbers.contains(this.delimiter.get(0))) {
            return Integer.parseInt(this.numbers);
        } else if (this.delimiter.get(0) == ",") {
            String[] lista = this.numbers.split("[,\n]");
            return Arrays.stream(lista).mapToInt(Integer::parseInt).filter(x -> x < 1000).reduce(0, Integer::sum);
        }
        else if (this.delimiter.size() == 1) {
            String numeri = this.numbers;
            String del = "\n" + remove_duplicate_from_delimiter(this.delimiter.get(0));
            System.out.println(del);
            while (del.length() > 1) {
                String[] lista = numeri.split("[" + del.charAt(0) + "]");
                String t = Arrays.stream(lista).collect(Collectors.joining(""));
                numeri = t;
                del = del.substring(1);
            }
            String[] res = numeri.split("[" + del.charAt(0) + "]"); // ora sono solo numeri
            String[] items = remove_empty_element(res);
            return Arrays.stream(items).mapToInt(Integer::parseInt).filter(x -> x < 1000).reduce(0, Integer::sum);
        }
        else{
            String numeri = this.numbers;
            String del =  join_delimiters_simbols();
            while (del.length() > 1) {
                String[] lista = numeri.split("[" + del.charAt(0) + "]");
                for(int i=0;i<lista.length;i++){lista[i]=lista[i]+ del.charAt(del.length()-1);}
                String t = Arrays.stream(lista).collect(Collectors.joining(""));
                numeri = t;
                del = del.substring(1);
            }
            String[] res = numeri.split("[" + del.charAt(0) + "]"); // ora sono solo numeri
            String[] items = remove_empty_element(res);
            return Arrays.stream(items).mapToInt(Integer::parseInt).filter(x -> x < 1000).reduce(0, Integer::sum);
        }





        }

    private ArrayList<String> check_negatives() {
        ArrayList<String> res = new ArrayList<String>();
        for(int i=0;i<this.numbers.length();i++){
            if(this.numbers.substring(i,i+1).equals("-")){
                res.add(this.numbers.substring(i,i+2));
                }
                else continue;
            }
        return res;
    }




}
















