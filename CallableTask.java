
/**
 * A class representing a task that implements Callable.
 * It wraps a Callable operation and allows task prioritization based on TaskType.
 * @param <T> the result type of the Callable.
 */
public class CallableTask<T> implements Taskable, Callable<T>, Comparable<Taskable> {

    private final Callable<T> op;
    private final TaskType type;

    /**
     * Constructor to create a CallableTask with a specified Callable operation.
     * @param op the Callable operation to be executed.
     */
    public CallableTask(Callable<T> op) {
        this.op = op;
        this.type = TaskType.OTHER;
        this.type.setTypePriority(3);
    }

    /**
     * Constructor to create a CallableTask with a specified Callable operation and TaskType.
     * @param op the Callable operation to be executed.
     * @param type the type of task.
     */
    public CallableTask(Callable<T> op, TaskType type) {
        this.op = op;
        this.type = type;
    }

    /**
     * Returns the priority of the task.
     * @return the task's priority based on its TaskType.
     */
    @Override
    public int getTaskPriority() {
        return type.getTypePriority();
    }

    /**
     * Compares this task with another task based on their priority.
     * @param o the other task to compare with.
     * @return a negative integer, zero, or a positive integer as this task's priority is less than, equal to, or greater than the specified task.
     */
    @Override
    public int compareTo(Taskable o) {
        return Integer.compare(this.getTaskPriority(),o.getTaskPriority());
    }

    /**
     * Executes the Callable operation and returns the result.
     * @return the result of the Callable operation.
     * @throws Exception if unable to compute the result.
     */
    @Override
    public T call() throws Exception {
        return op.call();
    }
}
