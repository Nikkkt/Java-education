package Task2;

import org.junit.Test;
import static org.junit.Assert.*;

public class CurrencyConverterTest {

    @Test
    public void testDollarToEuro() {
        double result = CurrencyConverter.convert(100, Currency.DOLLAR, Currency.EURO);
        assertEquals(4000 / 45.0, result, 0.001);
    }

    @Test
    public void testEuroToPound() {
        double result = CurrencyConverter.convert(100, Currency.EURO, Currency.POUND);
        assertEquals(4500 / 50.0, result, 0.001);
    }

    @Test
    public void testYenToDollar() {
        double result = CurrencyConverter.convert(1100, Currency.YEN, Currency.DOLLAR);
        assertEquals(330 / 40.0, result, 0.001);
    }

    @Test
    public void testHryvnaToDollar() {
        double result = CurrencyConverter.convert(1000, Currency.HRYVNA, Currency.DOLLAR);
        assertEquals(1000 / 40.0, result, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativeAmount() {
        CurrencyConverter.convert(-100, Currency.DOLLAR, Currency.EURO);
    }
}