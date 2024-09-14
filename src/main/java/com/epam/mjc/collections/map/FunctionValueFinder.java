package com.epam.mjc.collections.map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FunctionValueFinder {

    public boolean isFunctionValuePresent(List<Integer> sourceList, int requiredValue) {
        Map<Integer, Integer> functionMap = calculateFunctionMap(sourceList);
        
        // Проверяем, есть ли среди значений искомое значение
        return functionMap.containsValue(requiredValue);
    }

    private Map<Integer, Integer> calculateFunctionMap(List<Integer> sourceList) {
        Map<Integer, Integer> functionMap = new HashMap<>();
        
        // Вычисляем значения функции для каждого элемента списка
        for (Integer x : sourceList) {
            functionMap.put(x, 5 * x + 2);
        }
        
        return functionMap;
    }
}
