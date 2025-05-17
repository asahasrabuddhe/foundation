import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackTest {
    @Test
    void aNewStackIsEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
    }
}
