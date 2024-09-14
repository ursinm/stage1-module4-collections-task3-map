package com.epam.mjc.collections.map;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FunctionValueFinderTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                // Пустой список, не может содержать значение
                Arguments.of("EmptySourceList",
                        List.of(),
                        52,
                        false),

                // Значение не присутствует среди результатов функции
                Arguments.of("ValueNotPresent",
                        List.of(2, -6, 19, 55, 11),
                        52,
                        false),

                // Значение присутствует среди результатов функции
                Arguments.of("ValuePresent",
                        List.of(2, -6, 10, 19, 55, 11),
                        52,
                        true),

                // Проверка нуля
                Arguments.of("ZeroValue",
                        List.of(0, 1, -1),
                        2,
                        true),

                // Проверка отрицательных значений
                Arguments.of("NegativeValuePresent",
                        List.of(-10, -20, -30),
                        -48,
                        true),

                // Проверка большого диапазона
                Arguments.of("LargeValuePresent",
                        List.of(1000000, 2000000, 3000000),
                        5000002,
                        true)
        );
    }

    @ParameterizedTest(name = "isFunctionValuePresent_{0}_Test")
    @MethodSource(value = "testCases")
    void isFunctionValuePresentTest(String name,
                                    List<Integer> sourceList,
                                    int requiredValue,
                                    boolean isValuePresent) {

        FunctionValueFinder finder = new FunctionValueFinder();
        assertEquals(isValuePresent, finder.isFunctionValuePresent(sourceList, requiredValue));
    }
}
