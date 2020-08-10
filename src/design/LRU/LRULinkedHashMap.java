package design.LRU;

import java.util.LinkedHashMap;

public class LRULinkedHashMap extends LinkedHashMap {
    private static final long serialVersionUID = 1L;
    protected int maxElements;

    public LRULinkedHashMap(int size) {
        super(size, 0.75F, true);
        maxElements = size;
    }

    protected boolean removeEldestEntry(java.util.Map.Entry eldest) {
        return size() > maxElements;
    }
}
