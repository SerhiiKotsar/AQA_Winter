package calculation;

import hillel.calculator.Calculation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculationTest {

    private static Calculation calculator;

    @BeforeAll
    public static void init () {
        calculator = new Calculation();
    }

    @Test
    @DisplayName("Multiply Test (2 * 3)")
    public void multiplyTest () {
        int expected = 6;
        int actual = calculator.multiply(2, 3);
        Assertions.assertEquals(expected, actual, "Wrong actual result");
    }

    @Test
    @DisplayName("Division Test (25 / 5)")
    public void divisionTest () {
        int expected = 5;
        int actual = calculator.division(25, 5);
        Assertions.assertEquals(expected, actual, "Wrong actual result");
    }

    @Test
    @DisplayName("Addition Test (51 + 49)")
    public void additionTest () {
        int expected = 100;
        int actual = calculator.addition(51, 49);
        Assertions.assertEquals(expected, actual, "Wrong actual result");
    }

    @Test
    @DisplayName("Subtraction Test (10 - 9)")
    public void subtractionTest () {
        int expected = 1;
        int actual = calculator.subtraction(10, 9);
        Assertions.assertEquals(expected, actual, "Wrong actual result");
    }



}
