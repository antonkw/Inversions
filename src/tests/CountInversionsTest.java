package tests;

import by.kovalevsky.CountInversions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.InputMismatchException;

import static org.junit.Assert.assertEquals;

/**
 * Created by antonkw on 13.07.2015.
 */
public class CountInversionsTest {
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Test
    public void test1() {
        int[] testArray1 = {2, 4, 1, 3, 5};
        CountInversions countInversions = new CountInversions();
        countInversions.countInversions(testArray1);
        assertEquals(3, countInversions.getCounter());
    }

    @Test
    public void test2() {
        int[] testArray2 = {4, 3, 2, 1};
        CountInversions countInversions = new CountInversions();
        countInversions.countInversions(testArray2);
        assertEquals(6, countInversions.getCounter());
    }

    @Test
    public void test3() {
        int[] testArray3 = {1, 2, 3, 4};
        CountInversions countInversions = new CountInversions();
        countInversions.countInversions(testArray3);
        assertEquals(0, countInversions.getCounter());
    }

    @Test
    public void test4() {
        int[] testArray4 = {3, 3, 3, 3};
        CountInversions countInversions = new CountInversions();
        exception.expect(InputMismatchException.class);
        countInversions.countInversions(testArray4);
    }

    @Test
    public void test5() {
        int[] testArray5 = {5, 2, 10, 8, 1, 9, 4, 3, 6, 7};
        CountInversions countInversions = new CountInversions();
        countInversions.countInversions(testArray5);
        assertEquals(22, countInversions.getCounter());
    }
}
