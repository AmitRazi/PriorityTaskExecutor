
/**
 * This interface defines a contract for any task class. 
 * It includes a method to get the task's priority, which will be used to determine the order of task execution.
 */
public interface Taskable {
    /**
     * Returns the priority of the task.
     * @return the task's priority as an integer.
     */
    int getTaskPriority();
}
