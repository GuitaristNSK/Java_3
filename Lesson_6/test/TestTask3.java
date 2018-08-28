import Lesson_6.HomeWork.Main;
import org.junit.Assert;
import org.junit.Test;

public class TestTask3 {
    @Test
    public void testTask3() {
        Assert.assertEquals("2", Main.task3_read("SELECT * FROM students WHERE id = '2'"));
        Assert.assertEquals(1,Main.task3_update("INSERT INTO students VALUES ('4','user4','4')"));
        Assert.assertEquals(1,Main.task3_update("UPDATE students SET ball = 5 where id = 1"));
    }
}
