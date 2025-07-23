package com.demo.utils;

import java.util.HashMap;
import java.util.Map;

public class SharedContext {
    private static Map<String, String> context = new HashMap<>();

    public static synchronized void setContext(String key, String value) {
        context.put(key, value);
    }

    public static synchronized  String getContext(String key) {
        return context.get(key);
    }

    public synchronized static void clear() {
        context.clear();
    }
}


