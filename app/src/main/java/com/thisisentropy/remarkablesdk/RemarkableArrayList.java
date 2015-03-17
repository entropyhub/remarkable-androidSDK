package com.thisisentropy.remarkablesdk;

import java.util.ArrayList;
import java.util.Map;

public class RemarkableArrayList<K> {

    private ArrayList<K> list;

    public RemarkableArrayList(ArrayList<K> map)
    {
        this.list = map;
    }

    /**
     * Get item from JSON array
     * @param position Position in ArrayList
     * @return Return a plain string if object is instance of String or a String,Object map if standard JSON object
     */
    public RemarkableMap get(int position)
    {

            if(list != null ) {
                if(list.get(position) != null) {
                    if (list.get(position) instanceof String) {
                        return new RemarkableMap((String) list.get(position));
                    } else {
                        return new RemarkableMap((Map<String, Object>) list.get(position));
                    }
                }
                else
                {
                    throw new RuntimeException("Couldn't find an item at position: " + String.valueOf(position) );
                }
            }
            else
            {
                throw new RuntimeException("Couldn't find an item at position: " + String.valueOf(position) );
            }


    }


}