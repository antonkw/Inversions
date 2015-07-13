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
        int[] a1 = {2, 4, 1, 3, 5};
        CountInversions countInversions = new CountInversions();
        countInversions.countInversions(a1);

        assertEquals(3, countInversions.getCounter());
    }

    @Test
    public void testTwo() {
        int[] a2 = {4, 3, 2, 1};
        CountInversions countInversions = new CountInversions();
        countInversions.countInversions(a2);

        assertEquals(6, countInversions.getCounter());
    }

    @Test
    public void testThree() {
        int[] a3 = {1, 2, 3, 4};
        CountInversions countInversions = new CountInversions();
        countInversions.countInversions(a3);
        assertEquals(0, countInversions.getCounter());
    }

    @Test
    public void testFour() {
        int[] a3 = {3, 3, 3, 3};
        CountInversions countInversions = new CountInversions();
        exception.expect(InputMismatchException.class);
        countInversions.countInversions(a3);
    }
}
