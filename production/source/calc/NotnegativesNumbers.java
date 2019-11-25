package calc;

import java.util.ArrayList;

public class NotnegativesNumbers extends Exception {
    NotnegativesNumbers(ArrayList<String> c){
        System.out.println("Nella stringa ci sono numeri negativi, cioè i seguenti ");
        for(int i=0;i<c.size();i++){
            if(c.get(i).substring(0,1).equals("-")){
                System.out.println(c.get(i));
            }
            else{continue;}
        }
    }
}
