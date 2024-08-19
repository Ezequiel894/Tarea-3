import java.util.ArrayList;
import java.util.List;

public class GenericList<T> {
    private List<T> items;

    public GenericList() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public void remove(T item) {
        items.remove(item);
    }

    public T find(int id, FindFunction<T> findFunction) {
        for (T item : items) {
            if (findFunction.find(item) == id) {
                return item;
            }
        }
        return null;
    }

    public int size() {
        return items.size();
    }

    public List<T> getItems() {
        return items;
    }

    @FunctionalInterface
    public interface FindFunction<T> {
        int find(T item);
    }
}
