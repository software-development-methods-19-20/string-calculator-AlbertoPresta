package test.StringCalculator;


import dssc.calc.StringCalculator;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddNumbersTest {


    @Test
    void emptyis0(){
        check("",0);
    }

    @Test
    void onlyonenumber() {
        StringCalculator s = new StringCalculator();
        if(s.verifica()==true){
            assertEquals(Integer.parseInt(s.get_stringa()),s.add());
        }
    }







    private void check(String stringa,int expected){
        StringCalculator strcalc = new StringCalculator(stringa);
        assertEquals(expected,strcalc.add());
    }



}
