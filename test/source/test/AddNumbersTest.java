package test.StringCalculator;



import calc.StringCalculator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AddNumbersTest {


    @Test
    void EmptyIsZero()  {
        check(0,"");
    }

    @Test
    void singleStringIsSame()  {
        check(5,"5");
    }

    @Test
    void DoubleIsSum()  {
        check(8,"5,3");
    }

    @Test
    void MultipleIsSum() {
        check(8,"5,4,1,-2");
    }




    @Test
    void MultipleLinesIsSum() {
        check(8,"5\n4,1\n-2");
    }

    @Test
    void RandomDelimiter() {
        check(12,"//[::;]\n5::;4::;1::;2");
    }

    //@Test
    //void Morethanonedelimiter(){check(10,"//[::],[!:]\n5::4!:1")}




    public void check(int decimal,String st)  {
        StringCalculator c = new StringCalculator(st);

        assertEquals(c.add(),decimal);
    }
}