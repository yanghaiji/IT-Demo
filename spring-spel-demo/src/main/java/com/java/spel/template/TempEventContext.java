package com.java.spel.template;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Chen Tao
 * @date 2021/7/5 16:24
 */
public class TempEventContext extends HashMap<String, Object> {
    private static final String DEMO = "demo";

    public String getDemo(){
        return this.get(DEMO) == null ? "" : String.valueOf(this.get(DEMO));
    }
    public void setDemo(String name){
        this.put(DEMO,name);
    }

    public void putProperty(String key, Object value){
        this.put(key, value);
    }
    public void putProperties(Map<String, Object> properties){
        this.putAll(properties);
    }
}
