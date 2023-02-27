package calculation;

import com.sun.jdi.connect.Connector;
import hillel.calculator.Calculation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class ParamTest {

    private Calculation calculator = new Calculation();

    @ParameterizedTest
    @MethodSource("divisionStreamProvider")
    public void divisionTestWithParams (int a, int b, int result) {
        System.out.println("a: " + a + " b: " + b + " result: " + result);
        int actual = calculator.division(a, b);
        Assertions.assertEquals (result, actual);
    }

    public static Stream<Arguments> divisionStreamProvider() {
        return Stream.of(
                Arguments.arguments(10, 5, 2),
                Arguments.arguments(8, 2, 4));
    }

    @ParameterizedTest
    @MethodSource("multiplyStreamProvider")
    public void multiplyTestWithParams (int a, int b, int result) {
        System.out.println("a: " + a + " b: " + b + " result: " + result);
        int actual = calculator.multiply(a, b);
        Assertions.assertEquals (result, actual);
    }

    public static Stream<Arguments> multiplyStreamProvider() {
        return Stream.of(
                Arguments.arguments(2, 3, 6),
                Arguments.arguments(4, 5, 20));
    }

    @ParameterizedTest
    @MethodSource("additionStreamProvider")
    public void additionTestWithParams (int a, int b, int result) {
        System.out.println("a: " + a + " b: " + b + " result: " + result);
        int actual = calculator.addition(a, b);
        Assertions.assertEquals (result, actual);
    }

    public static Stream<Arguments> additionStreamProvider() {
        return Stream.of(
                Arguments.arguments(2, 2, 4),
                Arguments.arguments(51, 49, 100));
    }

    @ParameterizedTest
    @MethodSource("subtractionStreamProvider")
    public void subtractionTestWithParams (int a, int b, int result) {
        System.out.println("a: " + a + " b: " + b + " result: " + result);
        int actual = calculator.subtraction(a, b);
        Assertions.assertEquals (result, actual);
    }

    public static Stream<Arguments> subtractionStreamProvider() {
        return Stream.of(
                Arguments.arguments(10, 4, 6),
                Arguments.arguments(51, 49, 2));
    }

}
