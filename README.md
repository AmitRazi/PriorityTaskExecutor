
# Priority Task Executor

This project provides a custom task execution framework that allows for prioritization of tasks. It supports both `Callable` and `Runnable` tasks, and uses a custom executor to handle task scheduling based on their priority levels.

## Features

- **Task Prioritization**: Tasks can be assigned different priorities based on their type (e.g., computational, IO, or other).
- **Custom Executor**: A custom `ExecutorService` that manages the execution of tasks, ensuring higher-priority tasks are executed first.
- **Supports Runnable and Callable**: Tasks can be created as either `Runnable` or `Callable` with flexible task creation.
- **Unit Tests**: JUnit tests are provided to validate the functionality of the task execution system.

## Components

1. **Taskable Interface**: Defines the contract for any task, ensuring it provides a priority.
2. **TaskType Enum**: Defines different task types (COMPUTATIONAL, IO, OTHER) with priority validation.
3. **RunnableTask and CallableTask**: Classes that represent tasks, implementing prioritization logic.
4. **CustomExecutor**: A custom thread pool executor that manages tasks and executes them based on priority.
5. **Tests**: Unit tests using JUnit to verify the correct execution and prioritization of tasks.

## How to Use

1. **Creating a Task**:  
   Use the `Task.createTask` method to create `Runnable` or `Callable` tasks with or without specifying a `TaskType` (priority).

   ```java
   Task.createTask(() -> {
       // task logic here
   }, TaskType.COMPUTATIONAL);
   ```

2. **Submitting Tasks**:  
   Submit tasks using the `CustomExecutor` class. The executor will handle prioritization automatically.

   ```java
   CustomExecutor customExecutor = new CustomExecutor();
   customExecutor.submit(myTask);
   ```

3. **Shutting Down the Executor**:  
   After submitting all tasks, make sure to shut down the executor.

   ```java
   customExecutor.shutdown();
   ```

## Testing

Run the unit tests to validate the functionality:

```bash
mvn test
```

## License

This project is open-source and available under the [MIT License](LICENSE).
