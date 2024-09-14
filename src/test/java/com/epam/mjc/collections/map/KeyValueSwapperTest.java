package com.epam.mjc.collections.map;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Map;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class KeyValueSwapperTest {

    public static Stream<Arguments> testCases() {
        return Stream.of(
                // Пустая карта
                Arguments.of("EmptyMap",
                        Map.of(),
                        Map.of()),

                // Карта с уникальными значениями
                Arguments.of("NonEmptyMap",
                        Map.of(1, "Monday",
                                2, "Tuesday",
                                3, "Wednesday",
                                4, "Thursday",
                                5, "Friday",
                                6, "Saturday",
                                7, "Sunday"),
                        Map.of("Monday", 1,
                                "Tuesday", 2,
                                "Wednesday", 3,
                                "Thursday", 4,
                                "Friday", 5,
                                "Saturday", 6,
                                "Sunday", 7)),

                // Карта с дублирующимися значениями
                Arguments.of("MapWithSameValues",
                        Map.of(1, "Monday",
                                2, "Tuesday",
                                3, "Wednesday",
                                4, "Thursday",
                                5, "Friday",
                                6, "Saturday",
                                7, "Sunday",
                                10, "Friday"),  // Дублируем "Friday"
                        Map.of("Monday", 1,
                                "Tuesday", 2,
                                "Wednesday", 3,
                                "Thursday", 4,
                                "Friday", 5,  // Должен выбрать меньший ключ (5 вместо 10)
                                "Saturday", 6,
                                "Sunday", 7)),

                // Карта с одним элементом
                Arguments.of("SingleEntryMap",
                        Map.of(1, "One"),
                        Map.of("One", 1)),

                // Карта с несколькими одинаковыми значениями
                Arguments.of("MapWithDuplicateValuesAndDifferentKeys",
                        Map.of(1, "duplicate",
                                2, "duplicate",
                                3, "unique",
                                4, "duplicate"),
                        Map.of("duplicate", 1,  // Должен выбрать меньший ключ (1)
                                "unique", 3))
        );
    }

    @ParameterizedTest(name = "swapMap_{0}_Test")
    @MethodSource(value = "testCases")
    void swapMapTest(String name,
                     Map<Integer, String> sourceMap,
                     Map<String, Integer> expectedSwappedMap) {

        KeyValueSwapper swapper = new KeyValueSwapper();
        Map<String, Integer> actualSwappedMap = swapper.swap(sourceMap);
        assertEquals(expectedSwappedMap, actualSwappedMap);
    }
}
