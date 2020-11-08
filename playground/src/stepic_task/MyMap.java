package stepic_task;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyMap<T> extends HashMap<String, List<T>> {

    @Override
    public List<T> get(Object key){
        return super.get(key) == null ? Collections.emptyList() : super.get(key);
    }
}
