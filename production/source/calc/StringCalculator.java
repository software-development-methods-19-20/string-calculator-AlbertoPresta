package calc;




import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;






public class StringCalculator {
    private String numbers;
    private String delimiter = ",";


    public StringCalculator(String str) {
        if (str.startsWith("//")) {
            this.delimiter = str.substring(str.indexOf("[") + 1, str.indexOf("]"));
            this.numbers = str.substring(str.indexOf("\n") + 1);
        } else {
            numbers = str;
        }

    }

    public String getNumbers(){return numbers;}
    public String getDelimiter(){return delimiter;}


    public String remove_dulicate_from_delimiter(){
        String res = this.delimiter;
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



    public int add(){
        if (this.numbers.equals("")) {
            return 0;
        } else if (!this.numbers.contains(this.delimiter)) {
            return Integer.parseInt(this.numbers);
        }
        else if(this.delimiter==","){
            String[] lista = this.numbers.split("[,\n]");
            return Arrays.stream(lista).mapToInt(Integer::parseInt).reduce(0, Integer::sum);
        }
        else {
            String numeri = this.numbers;
            String del = "\n" + remove_dulicate_from_delimiter();

            while(del.length()>1){
                String[] lista = numeri.split("["+del.charAt(0)+"]");
                String t = Arrays.stream(lista).collect(Collectors.joining( "" ));
                numeri = t;
                del = del.substring(1);
            }
            String[] res = numeri.split("["+del.charAt(0)+"]"); // ora sono solo numeri

            String [] items = remove_empty_element(res);

            return Arrays.stream(items).mapToInt(Integer::parseInt).reduce(0, Integer::sum);

        }
    }
}







