import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EpicTest {

    @Test
    public void shouldMatchWhenQueryIsInSubtask() {
        String[] subtasks = {
                "Купить молоко",
                "Позвонить родителям",
                "Сделать домашнее задание"
        };

        Epic epic = new Epic(1, subtasks);

        boolean actual = epic.matches("родителям");

        assertTrue(actual);
    }

    @Test
    public void shouldNotMatchWhenQueryIsNotInSubtasks() {
        String[] subtasks = {
                "Купить молоко",
                "Позвонить родителям",
                "Сделать домашнее задание"
        };

        Epic epic = new Epic(1, subtasks);

        boolean actual = epic.matches("машина");

        assertFalse(actual);
    }
}