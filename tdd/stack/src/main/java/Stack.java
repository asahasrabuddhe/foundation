import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<Integer> elements;

    public Stack() {
        this.elements = new ArrayList<>();
    }

    public boolean isEmpty() {
       return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public void push(int element) {
        elements.addFirst(element);
    }

    public int peek() {
        return elements.getFirst();
    }
}
