public class Todos {
    private Task[] tasks = new Task[0];

    public void add(Task task) {
        Task[] tmp = new Task[tasks.length + 1];

        for (int i = 0; i < tasks.length; i++) {
            tmp[i] = tasks[i];
        }

        tmp[tmp.length - 1] = task;
        tasks = tmp;
    }

    public Task[] findAll() {
        return tasks;
    }

    public Task[] search(String query) {
        Task[] result = new Task[0];

        for (Task task : tasks) {
            if (task.matches(query)) {
                Task[] tmp = new Task[result.length + 1];

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