package by.kovalevsky;

import java.util.InputMismatchException;

/**
 * Created by antonkw on 13.07.2015.
 */
public class CountInversions {
    private long counter = 0;

    public long getCounter() {
        return counter;
    }

    public int[] countInversions(int[] arrayForSort) {
        if (arrayForSort.length <= 1)   // end of recursion
            return arrayForSort;

        int[] firstHalf = new int[arrayForSort.length / 2];
        int[] secondHalf = new int[arrayForSort.length - firstHalf.length];
        System.arraycopy(arrayForSort, 0, firstHalf, 0, firstHalf.length);
        System.arraycopy(arrayForSort, firstHalf.length, secondHalf, 0, secondHalf.length);

        countInversions(firstHalf);
        countInversions(secondHalf);   //go recursion!

        merge(firstHalf, secondHalf, arrayForSort);    //and merge it
        return arrayForSort;
    }

    private void merge(int[] firstHalf, int[] secondHalf, int[] result) {
        int currentPosOfFirstHalf = 0, currentPosOfSecondHalf = 0, currentPosOfResult = 0;
        while (currentPosOfFirstHalf < firstHalf.length && currentPosOfSecondHalf < secondHalf.length) {
            if (firstHalf[currentPosOfFirstHalf] < secondHalf[currentPosOfSecondHalf]) {
                result[currentPosOfResult] = firstHalf[currentPosOfFirstHalf];
                ++currentPosOfFirstHalf;
            } else if (firstHalf[currentPosOfFirstHalf] > secondHalf[currentPosOfSecondHalf]) {
                result[currentPosOfResult] = secondHalf[currentPosOfSecondHalf];
                ++currentPosOfSecondHalf;
                counter = counter + firstHalf.length - currentPosOfFirstHalf;
            } else if (firstHalf[currentPosOfFirstHalf] == secondHalf[currentPosOfSecondHalf] ) {
                throw new InputMismatchException("number must be unique!");
            }
                ++currentPosOfResult;
        }
        while (currentPosOfFirstHalf != firstHalf.length) {    //yes, i wanna copy it myself
            result[currentPosOfResult] = firstHalf[currentPosOfFirstHalf];
            ++currentPosOfFirstHalf;
            ++currentPosOfResult;
        }
        while (currentPosOfSecondHalf != secondHalf.length) {    //and one more time
            result[currentPosOfResult] = secondHalf[currentPosOfSecondHalf];
            ++currentPosOfSecondHalf;
            ++currentPosOfResult;
        }
    }

}
