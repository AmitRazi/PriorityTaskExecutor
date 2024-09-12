
/**
 * This class represents a task that implements Runnable and can be executed by a thread.
 * It also implements Taskable and Comparable to allow task prioritization.
 */
public class RunnableTask implements Taskable, Runnable, Comparable<Taskable> {

    private final Runnable op;
    private final TaskType type;

    /**
     * Constructor to create a RunnableTask with a default TaskType of OTHER.
     * @param op the Runnable operation.
     */
    public RunnableTask(Runnable op) {
        this.op = op;
        type = TaskType.OTHER;
        type.setTypePriority(3);
    }

    /**
     * Constructor to create a RunnableTask with a specified TaskType.
     * @param op the Runnable operation.
     * @param type the type of task.
     */
    public RunnableTask(Runnable op, TaskType type) {
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
     * Calculates the hash code for this task based on its priority, type, and operation.
     * @return the hash code as an integer.
     */
    public int hashCode() {
        int result = (getTaskPriority() ^ (getTaskPriority() >>> 32));
        result = 31 * result + type.hashCode();
        result = 31 * result + op.hashCode();
        return result;
    }

    /**
     * Executes the Runnable operation associated with this task.
     */
    @Override
    public void run() {
        this.op.run();
    }
}
