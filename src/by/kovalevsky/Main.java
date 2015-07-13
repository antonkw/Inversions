package by.kovalevsky;

import org.junit.runner.JUnitCore;
import tests.CountInversionsTest;

public class Main {

    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();
        StringBuilder finalResult = new StringBuilder("Counts of merge sort test`s fails: ");
        finalResult.append(junit.run(CountInversionsTest.class).getFailureCount());
        System.out.print(finalResult);
	// write your code here
    }
}
