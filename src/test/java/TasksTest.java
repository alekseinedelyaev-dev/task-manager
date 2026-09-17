import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TasksTest {

    @Test
    public void shouldSimpleTaskMatchWhenQueryIsInTitle() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");

        boolean actual = task.matches("родителям");

        assertTrue(actual);
    }

    @Test
    public void shouldSimpleTaskNotMatchWhenQueryIsNotInTitle() {
        SimpleTask task = new SimpleTask(1, "Позвонить родителям");

        boolean actual = task.matches("магазин");

        assertFalse(actual);
    }

    @Test
    public void shouldEpicMatchWhenQueryIsInSubtask() {
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
    public void shouldEpicNotMatchWhenQueryIsNotInSubtasks() {
        String[] subtasks = {
                "Купить молоко",
                "Позвонить родителям",
                "Сделать домашнее задание"
        };

        Epic epic = new Epic(1, subtasks);

        boolean actual = epic.matches("машина");

        assertFalse(actual);
    }

    @Test
    public void shouldMeetingMatchWhenQueryIsInTopic() {
        Meeting meeting = new Meeting(
                1,
                "Обсуждение проекта",
                "Нетология",
                "10:00"
        );

        boolean actual = meeting.matches("проекта");

        assertTrue(actual);
    }

    @Test
    public void shouldMeetingMatchWhenQueryIsInProject() {
        Meeting meeting = new Meeting(
                1,
                "Обсуждение проекта",
                "Нетология",
                "10:00"
        );

        boolean actual = meeting.matches("Нетология");

        assertTrue(actual);
    }

    @Test
    public void shouldMeetingNotMatchWhenQueryIsAbsent() {
        Meeting meeting = new Meeting(
                1,
                "Обсуждение проекта",
                "Нетология",
                "10:00"
        );

        boolean actual = meeting.matches("магазин");

        assertFalse(actual);
    }
}