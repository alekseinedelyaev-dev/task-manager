public class Todos {
    private Todo[] tasks = new Todo[0];

    public void add(Todo task) {
        Todo[] tmp = new Todo[tasks.length + 1];

        for (int i = 0; i < tasks.length; i++) {
            tmp[i] = tasks[i];
        }

        tmp[tmp.length - 1] = task;
        tasks = tmp;
    }

    public Todo[] getTasks() {
        return tasks;
    }

    public Todo[] search(String query) {
        Todo[] result = new Todo[0];

        for (Todo task : tasks) {
            if (task.matches(query)) {
                Todo[] tmp = new Todo[result.length + 1];

                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }

                tmp[tmp.length - 1] = task;
                result = tmp;
            }
        }

        return result;
    }
}
