import Lesson_6.HomeWork.Main;
import org.junit.Test;

public class TestTask1_2 {
    @Test(expected = RuntimeException.class)
    public void testTask1_1() {
        Main.task1(new int[]{2, 5, 7, 9});
    }
}
