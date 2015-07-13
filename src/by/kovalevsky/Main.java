package by.kovalevsky;

import com.google.common.primitives.Ints;
import org.junit.runner.JUnitCore;
import tests.CountInversionsTest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        JUnitCore junit = new JUnitCore();
        StringBuilder finalResult = new StringBuilder("Counts of merge sort test`s fails: ");
        finalResult.append(junit.run(CountInversionsTest.class).getFailureCount());
        System.out.println(finalResult);
        File file = new File("W:\\Coursera\\IntegerArray.txt");
        List<Integer> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                list.add(Integer.parseInt(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        int[] arrayToCountInversion = Ints.toArray(list); //guava 1.8 library used
        CountInversions countInversions = new CountInversions();
        countInversions.countInversions(arrayToCountInversion);
        System.out.println(countInversions.getCounter());
    }
}
