import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MeetingTest {

    @Test
    public void shouldMatchWhenQueryIsInTopic() {
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
    public void shouldMatchWhenQueryIsInProject() {
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
    public void shouldNotMatchWhenQueryIsAbsent() {
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