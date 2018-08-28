import Lesson_6.HomeWork.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestTask1_1 {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 3, 4, 2, 6, 5, 3}, new int[]{2, 6, 5, 3}},
                {new int[]{1, 4, 4, 4, 4, 3}, new int[]{3}},
                {new int[]{1, 3, 4, 2, 6, 5, 4}, new int[0]},
                {new int[]{4, 2, 6, 5, 3}, new int[]{2, 6, 5, 3}}
        });
    }

    private int[] in;
    private int[] out;

    public TestTask1_1(int[] in, int[] out) {
        this.in = in;
        this.out = out;
    }

    @Test
    public void testTask1_1() {
        Assert.assertArrayEquals(out, Main.task1(in));
    }
}
