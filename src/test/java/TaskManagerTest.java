import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskManagerTest {

    @Test
    public void shouldAddTasks() {
        TaskManager manager = new TaskManager();

        SimpleTask task1 = new SimpleTask(1, "Позвонить родителям");
        SimpleTask task2 = new SimpleTask(2, "Купить молоко");

        manager.add(task1);
        manager.add(task2);

        Task[] expected = {task1, task2};
        Task[] actual = manager.getTasks();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSimpleTask() {
        TaskManager manager = new TaskManager();

        SimpleTask task1 = new SimpleTask(1, "Позвонить родителям");
        SimpleTask task2 = new SimpleTask(2, "Купить молоко");

        manager.add(task1);
        manager.add(task2);

        Task[] expected = {task1};
        Task[] actual = manager.search("родителям");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchEpic() {
        TaskManager manager = new TaskManager();

        String[] subtasks = {
                "Купить молоко",
                "Позвонить родителям",
                "Сделать домашнее задание"
        };

        Epic epic = new Epic(3, subtasks);

        manager.add(epic);

        Task[] expected = {epic};
        Task[] actual = manager.search("домашнее");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeeting() {
        TaskManager manager = new TaskManager();

        Meeting meeting = new Meeting(
                4,
                "Обсуждение проекта",
                "Нетология",
                "10:00"
        );

        manager.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = manager.search("Нетология");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayWhenNothingFound() {
        TaskManager manager = new TaskManager();

        SimpleTask task = new SimpleTask(1, "Позвонить родителям");
        manager.add(task);

        Task[] expected = {};
        Task[] actual = manager.search("магазин");

        assertArrayEquals(expected, actual);
    }
}