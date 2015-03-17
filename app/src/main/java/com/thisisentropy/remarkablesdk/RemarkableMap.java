package com.thisisentropy.remarkablesdk;

import android.util.Log;

import java.util.ArrayList;
import java.util.Map;

public class RemarkableMap<K,V> {

    private Map<K, V> map;
    private String stringMap = null;

    /**
     * This constructor is used when the data is a standard object of type MAP
     * @param map Generic Map Type
     */
    public RemarkableMap(Map<K,V> map)
    {
        this.map = map;
    }

    /**
     * This constructor is used when item is in ArrayList and does have a key
     * @param value Plain String value in ArrayList
     */
    public RemarkableMap(String value)
    {
        this.stringMap = value;
    }

    /**
     * Get JSON Object for Key, Will return an ArrayList if object is an array
     * @param key JSON objects Key
     * @return Map of Objects or ArrayList
     */
    public RemarkableMap getObject(String key)
    {

        System.out.println(map);
        Log.e("LOL", ":L:LL");
        if(map.get(key) instanceof ArrayList)
        {
            Log.e("LOL", "a");
            return new RemarkableMap<String, ArrayList>(((Map<String, ArrayList>)((Map<String, Object>) map.get(key)).get(key)));
        }
        else if(map.get(key) instanceof Map){
            Log.e("LOL", "b");
            return new RemarkableMap((Map<String, Object>)map.get(key));
        }
        else
        {
            Log.e("LOL", "h");
            return null;
        }

    }

    /**
     * Attempt to retrieve a value for key from JSON object {"Key":"Value"}
     *
     * @param key JSON object values key
     * @return String in map for key if available
     */
    public String get(String key)
    {
        if(stringMap != null){
            return stringMap;
        }
        else
        {
            if(map != null && (String)map.get(key) != null){
                return (String) map.get(key);
            }
            else {
                throw new RuntimeException("Couldn't find an item for key: " + key );
            }
        }
    }

    /**
     * RemarkableMap can also contain a plain String, used when accessing an Array of items without keys
     *
     * @return Plain String If stringMap set
     */
    public String get()
    {
        if(stringMap != null)
        {
            return stringMap;
        }
        else
        {
            throw new RuntimeException("Couldn't find any strings");
        }

    }

    /**
     * Attempt to get Array from JSON object at KEY {"sections":[{"title":"title","description":"desc","image":"img"}]}
     * @param key JSON Array Key
     * @return ArrayList of Strings for key
     */
    public RemarkableArrayList<String> getArray(String key)
    {
        if(map != null && (ArrayList<String>)map.get(key) != null){
            return new RemarkableArrayList<String>(((ArrayList<String>)map.get(key)));
        }
        else {
            throw new RuntimeException("Couldn't find an item for key: " + key );
        }

    }
}