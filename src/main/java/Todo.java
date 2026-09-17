import java.util.Objects;

public class Todo {
    protected int id;

    public Todo(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public boolean matches(String query) {
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo task = (Todo) o;
        return id == task.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}