package test.StringCalculator;




import calc.NotnegativesNumbers;
import calc.StringCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class AddNumbersTest {


    @Test
    void EmptyIsZero() throws calc.NotnegativesNumbers {
        check(0,"");
    }

    @Test
    void singleStringIsSame() throws calc.NotnegativesNumbers {
        check(5,"5");
    }

    @Test
    void DoubleIsSum() throws calc.NotnegativesNumbers {
        check(8,"5,3");
    }

    @Test
    void MultipleIsSum() throws calc.NotnegativesNumbers {
        check(12,"5,4,1,2");
    }




    @Test
    void MultipleLinesIsSum() throws calc.NotnegativesNumbers {
        check(12,"5\n4,1\n2");
    }

    @Test
    void RandomDelimiter() throws calc.NotnegativesNumbers {
        check(12,"//[::;]\n5::;4::;1::;2");
    }


    @Test
    void IgnoreMoreThanThousand() throws calc.NotnegativesNumbers{
        check(2,"//[:;]\n1001:;2");
    }


    @Test
    void Morethanonedelimiter() throws calc.NotnegativesNumbers{
        check(10,"//[::][!:][*]\n5::2!:1*2");
    }

    @Test
    void NegativesNumbersNotAllowed() throws  calc.NotnegativesNumbers{
        StringCalculator c = new StringCalculator("//[::][!]\n2::-1!4::5");
        Assertions.assertThrows(NotnegativesNumbers.class, ()->  c.add());
    }






    public void check(int decimal,String st) throws calc.NotnegativesNumbers {
        StringCalculator c = new StringCalculator(st);

        assertEquals(c.add(),decimal);
    }
}