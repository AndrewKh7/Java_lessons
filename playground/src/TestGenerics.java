import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

public class TestGenerics {
    public static void main(String[] args) {
        Collection<?> collection = null;
        Object object = new Object();

        collection.size();
        collection.iterator();
//        collection.add(object);
        collection.toArray();
        collection.clear();
        collection.remove(object);
//        collection.addAll(Arrays.asList(object));
        collection.contains(object);
    }

}