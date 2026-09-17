import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        Todos todos = new Todos();

        SimpleTask simpleTask = new SimpleTask(
                1,
                "Позвонить родителям"
        );

        String[] subtasks = {
                "Купить молоко",
                "Позвонить родителям",
                "Сделать домашнее задание"
        };
        Epic epic = new Epic(2, subtasks);

        Meeting meeting = new Meeting(
                3,
                "Обсуждение проекта",
                "Нетология",
                "10:00"
        );

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchSimpleTask() {
        Todos todos = new Todos();

        SimpleTask task1 = new SimpleTask(1, "Позвонить родителям");
        SimpleTask task2 = new SimpleTask(2, "Купить молоко");

        todos.add(task1);
        todos.add(task2);

        Task[] expected = {task1};
        Task[] actual = todos.search("родителям");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchEpic() {
        Todos todos = new Todos();

        String[] subtasks = {
                "Купить молоко",
                "Позвонить родителям",
                "Сделать домашнее задание"
        };

        Epic epic = new Epic(3, subtasks);

        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("домашнее");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldSearchMeeting() {
        Todos todos = new Todos();

        Meeting meeting = new Meeting(
                4,
                "Обсуждение проекта",
                "Нетология",
                "10:00"
        );

        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("Нетология");

        assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnEmptyArrayWhenNothingFound() {
        Todos todos = new Todos();

        SimpleTask task = new SimpleTask(1, "Позвонить родителям");
        todos.add(task);

        Task[] expected = {};
        Task[] actual = todos.search("магазин");

        assertArrayEquals(expected, actual);
    }
}