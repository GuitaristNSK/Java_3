import Lesson_6.HomeWork.Main;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class TestIsOnlyOneAndFour {
    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 1, 4, 4}, true},
                {new int[]{1, 1}, false},
                {new int[]{1, 1, 4, 4, 5}, false},
                {new int[]{4, 4}, false}
        });
    }

    private int[] in;
    private boolean out;

    public TestIsOnlyOneAndFour(int[] in, boolean out) {
        this.in = in;
        this.out = out;
    }

    @Test
    public void testIsOnlyOneAndFour() {
        Assert.assertEquals(out, Main.isOnlyOneAndFour(in));
    }
}