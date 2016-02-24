import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by ma on 15.02.2016.
 */
public class Main {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(Vector2DTest.class);
        for (Failure f : result.getFailures()) {
            System.out.println(f.toString());
        }
    }
}
