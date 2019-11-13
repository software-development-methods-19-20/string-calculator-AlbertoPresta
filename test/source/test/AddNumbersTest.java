package test.StringCalculator;


import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AddNumbersTest {


    @Test
    void emptyis0(){
        StringCalculator strcalc = new StringCalculator("");
        assertEquals(0,"");
    }

}
