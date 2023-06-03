import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class sayNumberTest {

    @Test
    public void test1(){
        assertEquals(Main.sayNumber(0), "Zero");
        assertEquals(Main.sayNumber(11), "eleven");
        assertEquals(Main.sayNumber(14), "fourteen");
        assertEquals(Main.sayNumber(15), "fifteen");
        assertEquals(Main.sayNumber(43), "forty three");
        assertEquals(Main.sayNumber(50), "fifty");
        assertEquals(Main.sayNumber(51), "fifty one");
        assertEquals(Main.sayNumber(1001), "one thousand one");
        assertEquals(Main.sayNumber(20000), "twenty thousand");
        assertEquals(Main.sayNumber(1033286), "one million thirty three thousand two hundred eighty six");
        assertEquals(Main.sayNumber(12000013), "twelve million thirteen");
        assertEquals(Main.sayNumber(90376000010012L), "ninety trillion three hundred seventy six billion ten thousand twelve");

    }




}
