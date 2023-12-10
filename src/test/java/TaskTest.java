import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class TaskTest {

    @Test
    public void simpleTaskHasMatches() {
        SimpleTask task = new SimpleTask(5, "Позвонить маме");

        boolean expected = true;
        boolean actual = task.matches("Позвонить");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void simpleTaskHasNoMatches() {
        SimpleTask task = new SimpleTask(5, "Позвонить маме");

        boolean expected = false;
        boolean actual = task.matches("Папе");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicSubtasksHasMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(1, subtasks);

        boolean expected = true;
        boolean actual = epic.matches("Хлеб");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void epicSubtasksHasNoMatches() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(1, subtasks);

        boolean expected = false;
        boolean actual = epic.matches("Пиво");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingTopicHasMatches() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("версии");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingProjectHasMatches() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = true;
        boolean actual = meeting.matches("НетоБанка");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void meetingHasNoMatches() {
        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        boolean expected = false;
        boolean actual = meeting.matches("вторник");

        Assertions.assertEquals(expected, actual);
    }
}