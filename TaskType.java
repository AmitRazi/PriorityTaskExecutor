
/**
 * Enum representing the different types of tasks that can be executed.
 * Each task type has an associated priority, which is used to determine its execution order.
 */
enum TaskType {
    COMPUTATIONAL(1), IO(2), OTHER(3);

    private int TypePriority;

    /**
     * Constructor for TaskType. Validates the priority and assigns it to the task type.
     * @param priority the priority of the task type.
     */
    TaskType(int priority) {
        if (validatePriority(priority)) TypePriority = priority;
        else {
            throw new IllegalArgumentException("Not a valid priority");
        }
    }

    /**
     * Sets the priority for the task type. Validates the priority before assignment.
     * @param priority the new priority of the task type.
     */
    public void setTypePriority(int priority) {
        if (validatePriority(priority)) TypePriority = priority;
        else {
            throw new IllegalArgumentException("Not a valid priority");
        }
    }

    /**
     * Returns the priority of the task type.
     * @return the priority as an integer.
     */
    public int getTypePriority() {
        return this.TypePriority;
    }

    /**
     * Returns the type of task.
     * @return the task type.
     */
    public TaskType getType() {
        return this;
    }

    /**
     * Validates the priority value. The priority should be between 1 and 10.
     * @param priority the priority value to validate.
     * @return true if valid, false otherwise.
     */
    private boolean validatePriority(int priority) {
        if (priority < 1 || priority > 10) return false;
        return true;
    }
}
