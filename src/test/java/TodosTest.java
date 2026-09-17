import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TodosTest {

    @Test
    public void shouldAddTasks() {
        Todos manager = new Todos();

        SimpleTodo task1 = new SimpleTodo(1, "Позвонить родителям");
        SimpleTodo task2 = new SimpleTodo(2, "Купить молоко");

        manager.add(task1);
        manager.add(task2);

        Todo[] expected = {task1, task2};
        Todo[] actual = manager.getTasks();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSimpleTask() {
        Todos manager = new Todos();

        SimpleTodo task1 = new SimpleTodo(1, "Позвонить родителям");
        SimpleTodo task2 = new SimpleTodo(2, "Купить молоко");

        manager.add(task1);
        manager.add(task2);

        Todo[] expected = {task1};
        Todo[] actual = manager.search("родителям");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchEpic() {
        Todos manager = new Todos();

        String[] subtasks = {
                "Купить молоко",
                "Позвонить родителям",
                "Сделать домашнее задание"
        };

        Epic epic = new Epic(3, subtasks);

        manager.add(epic);

        Todo[] expected = {epic};
        Todo[] actual = manager.search("домашнее");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeeting() {
        Todos manager = new Todos();

        Meeting meeting = new Meeting(
                4,
                "Обсуждение проекта",
                "Нетология",
                "10:00"
        );

        manager.add(meeting);

        Todo[] expected = {meeting};
        Todo[] actual = manager.search("Нетология");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayWhenNothingFound() {
        Todos manager = new Todos();

        SimpleTodo task = new SimpleTodo(1, "Позвонить родителям");
        manager.add(task);

        Todo[] expected = {};
        Todo[] actual = manager.search("магазин");

        assertArrayEquals(expected, actual);
    }
}