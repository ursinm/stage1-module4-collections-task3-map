package com.epam.mjc.collections.map;

import java.util.HashMap;
import java.util.Map;

public class KeyValueSwapper {

    public Map<String, Integer> swap(Map<Integer, String> sourceMap) {
        Map<String, Integer> swappedMap = new HashMap<>();
        
        for (Map.Entry<Integer, String> entry : sourceMap.entrySet()) {
            String value = entry.getValue();
            Integer key = entry.getKey();
            
            // Если уже есть такое значение, сохраняем минимальный ключ
            if (!swappedMap.containsKey(value) || key < swappedMap.get(value)) {
                swappedMap.put(value, key);
            }
        }
        
        return swappedMap;
    }
}
