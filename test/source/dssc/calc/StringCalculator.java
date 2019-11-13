//package dssc.calc;

public class StringCalculator {
    private String stringa;

    public StringCalculator(String str){
        this.stringa = str;
    }

    public StringCalculator() {}

    public String get_stringa(){
        return stringa;
    }

    public int add(){
        if(this.stringa==""){return 0;}
        else if(verifica()==true){return Integer.parseInt(get_stringa());}
        else{
            int[] list = crea_lista();
            int somma = 0;
            for(int i = 0;i<list.length;i++){
                somma = somma + list[i];
            }
            return somma;
        }
    }


   public int[] crea_lista(){
        String[] lista = this.stringa.split(",");
        int[] risultato = new int[lista.length];
        for(int i = 0;i<lista.length;i++){
            risultato[i]=Integer.parseInt(lista[i]);
            }
        return risultato;
   }


    public boolean verifica() {
        int n = 0;
        try{
            n=Integer.parseInt(get_stringa());
        }catch(NumberFormatException e){}
        if(n==0){return false;}
        else{return true;}
    }


    public static void main(String[] args){
        StringCalculator p = new StringCalculator("12,10,10,10");
        System.out.println(p.add());
    }


}
