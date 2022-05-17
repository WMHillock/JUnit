import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.IOException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class РexahedronCalcsTests {
    РexahedronCalcs sut;

    @BeforeEach
    public void init() {
        sut = new РexahedronCalcs();
    }

    @BeforeAll
    public static void start() {
        System.out.println("Начинаем тест");
    }

    @AfterAll
    public static void finish() {
        System.out.printf("Заканчиваем тест");
    }

    @ParameterizedTest
    @MethodSource("source")
    public void testpexahedronArea(double lengthA, double heightB, double widthC, double expected) {

        double result = sut.pexahedronArea(lengthA,heightB, widthC);

        Assertions.assertEquals(expected, result);
    }

    private static Stream<Arguments> source() {
        return Stream.of(Arguments.of(2, 6, 9, 168.0), Arguments.of(3, 8, 12, 312.0));
    }

    @Test
    public void testisThis3D() {

        double lengthA = 0;
        double heigthB = 1;
        double widthC = 5;

        boolean result = sut.isThis3D(lengthA, heigthB, widthC);

        Assertions.assertFalse(result);
    }

    @Test
    void testsaveInFile() throws IOException {

        double lengthA = 0;
        double heigthB = 1;
        double widthC = 5;

        Throwable thrown = assertThrows(IOException.class, () -> РexahedronCalcs.saveInFile(lengthA, heigthB, widthC));

        assertFalse(thrown.getMessage().contains("IOException"));
    }

}
