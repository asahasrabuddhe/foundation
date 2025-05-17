import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackTest {
    @Test
    void aNewStackIsEmpty() {
        Stack stack = new Stack();
        assertTrue(stack.isEmpty());
    }

    @Test
    void aNewStackHasSizeZero() {
        Stack stack = new Stack();
        assertEquals(0, stack.size());
    }
}
