package p05;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            int value = map.get(key);
            map.remove(key);
            map.put(key,value);
            return value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            map.remove(key);
        } else {
            if (map.size() == capacity) {
                int firstKey = map.keySet().iterator().next();
                map.remove(firstKey);
            }
        }
        map.put(key,value);
    }
}
