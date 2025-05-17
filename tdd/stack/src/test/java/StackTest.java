import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void testPushElementIntoStack() {
        Stack stack = new Stack();
        stack.push(1);
        assertEquals(1, stack.size());
        assertFalse(stack.isEmpty());
    }
}
