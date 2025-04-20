package z_others.demo;

import algorithm_template.LRUCache;

public class LRUCacheTest {
    public static void main(String[] args) {
        LRUCache<String, Integer> cache = new LRUCache<>(3);
        cache.put("test1", 1);
        cache.put("test2", 2);
        System.out.println(cache.get("tes"));
    }
}
