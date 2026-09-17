import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleTaskTest {

    @Test
    public void shouldMatchWhenQueryIsInTitle() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");

        boolean actual = task.matches("родителям");

        assertTrue(actual);
    }

    @Test
    public void shouldNotMatchWhenQueryIsNotInTitle() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");

        boolean actual = task.matches("магазин");

        assertFalse(actual);
    }
}