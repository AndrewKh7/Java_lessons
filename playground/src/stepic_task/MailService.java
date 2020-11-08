package stepic_task;

import java.util.*;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<T> {
    private Map<String, List<T>> map = new MyMap<>();

    public void add(String key, T val){
        if(!this.map.containsKey(key)){
            this.map.put(key, new ArrayList<T>());
        }
        this.map.get(key).add(val);
    }

    public List<T> get(String key){
        return this.map.get(key) == null ? Collections.emptyList() : this.map.get(key);
    }

    public Map<String, List<T>> getMailBox(){
        return Collections.unmodifiableMap(map);
    }

    @Override
    public void accept(T t) {

    }
}
