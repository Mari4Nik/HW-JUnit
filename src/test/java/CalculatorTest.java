import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculatorTest {

    public Calculator calculator;

    @BeforeAll
    public static void beforeAll() {
        System.out.println("Running CalculatorTests");
    }

    @AfterAll
    public static void afterAll() {
        System.out.println("CalculatorTests completed");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Test started");
        calculator = new Calculator();
    }

    @AfterEach
    public void afterEach() {
        System.out.println("Test finished");
    }

    @Test
    @DisplayName("Проверяем сложение")
    void plus() {
        int a = 10;
        int b = 5;
        int expected = 15;
        final int result = calculator.plus.apply(a, b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверяем вычитание")
    void minus() {
        int a = 100;
        int b = 99;
        int expected = 1;
        final int result = calculator.minus.apply(a, b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверяем деление")
    void devide() {
        int a = 30;
        int b = 5;
        final int expected = 6;
        final int result = calculator.devide.apply(a, b);
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testAbs() {
        int a = -1, trueExpected = 1, falseExpected = -1;
        int trueResult = calculator.abs.apply(a);
        int falseResult = calculator.abs.apply(a);
        Assertions.assertEquals(trueExpected, trueResult);
        Assertions.assertNotEquals(falseExpected, falseResult);
    }

    @Test
    @DisplayName("Проверяем логическое выражение")
    void isPositive() {
        int a = 10;
        final boolean expected = true;
        boolean result = calculator.isPositive.test(a);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("sourse")
    public void testIsPositive(int a) {
        boolean expected = calculator.isPositive.test(a);
        Assertions.assertTrue(expected);
    }

    public static Stream<Arguments> sourse() {
        return Stream.of(
                Arguments.of(6), Arguments.of(15), Arguments.of(87),
                Arguments.of(20, 60, 100));
    }
}