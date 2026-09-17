import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTodoTest {

    @Test
    public void shouldMatchWhenQueryIsInTitle() {
        SimpleTodo task = new SimpleTodo(1, "Позвонить родителям");

        boolean actual = task.matches("родителям");

        assertTrue(actual);
    }

    @Test
    public void shouldNotMatchWhenQueryIsNotInTitle() {
        SimpleTodo task = new SimpleTodo(1, "Позвонить родителям");

        boolean actual = task.matches("магазин");

        assertFalse(actual);
    }
}