package p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleTest {
    private static final int[] NUMBERS = {5, 47, 69, 58, 69, 71, 56, -88};
    private static final int[] SORTED_NUMBERS = {-88, 5, 47, 56, 58, 69, 69, 71};

    @Test
    public void testNumbersAreSortedCorrectly() {
        Bubble.sort(NUMBERS);
        Assert.assertArrayEquals(NUMBERS, SORTED_NUMBERS);
    }

    @Test
    public void untouchedSortedCollectionAfterSortAlgorithm() {
        int[] beforeSort = Arrays.copyOf(SORTED_NUMBERS, 8);
        Bubble.sort(beforeSort);
        Assert.assertArrayEquals(SORTED_NUMBERS, beforeSort);
    }
}