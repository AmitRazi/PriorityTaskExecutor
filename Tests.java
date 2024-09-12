
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import java.util.concurrent.*;

/**
 * This class contains unit tests for the custom task execution system.
 * It uses JUnit for testing various task execution scenarios.
 */
public class Tests {

    // Logger for logging test outputs
    public static final Logger logger = LoggerFactory.getLogger(Tests.class);

    /**
     * A test method to validate task execution, using CustomExecutor.
     */
    @Test
    public void partialTest() {
        // Create a custom executor instance
        CustomExecutor customExecutor = new CustomExecutor();

        // Define a computational task that calculates the sum of numbers 1 to 10
        var task = Task.createTask(() -> {
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            return sum;
        }, TaskType.COMPUTATIONAL);

        // Submit the task to the executor
        var sumTask = customExecutor.submit(task);
        final int sum;
        try {
            // Attempt to get the result within 1 millisecond
            sum = sumTask.get(1, TimeUnit.MILLISECONDS);
        } catch (InterruptedException | ExecutionException | TimeoutException e) {
            throw new RuntimeException(e);
        }

        // Log the result of the sum task
        logger.info(() -> "Sum of 1 through 10 = " + sum);
        
        // Define additional tasks and test them...
    }
}
