package cc.robotdreams.utils;

import java.util.HashMap;
import java.util.Map;

public enum KeyValueStore {
    INSTANCE;

    private Map<String, Object> store;

    KeyValueStore() {
        store = new HashMap<>();
    }

    public void put(String key, Object value) {
        store.put(key, value);
    }

    public Object get(String key) {
        return store.get(key);
    }

    public boolean containsKey(String key) {
        return store.containsKey(key);
    }

    public void remove(String key) {
        store.remove(key);
    }
}
