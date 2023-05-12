package mettle;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class UtilTest {
    Util util = new Util();

    /**
     * Test for unsorted input
     */
    @Test
    public void unSortedInput1() {
        int[] intArray = {1, 6, 2, 1, 4, 8, 5, 10, 2, 4};
        assertArrayEquals(new int[]{0,1}, util.findTargetIndicies(intArray, 1));
    }

    /**
     * Test for single occurence of target in input array
     */
    @Test
    public void singleOccurence() {
        int[] intArray = {1,2,3,7,8,9,10};
        assertArrayEquals(new int[]{2}, util.findTargetIndicies(intArray, 3));
    }

    /**
     * Test for multiple occurence of target in the middle of the array
     */
    @Test
    public void multipleOccurence1() {
        int[] intArray = {1,2,3,3,3,3,7,8,9,10};
        assertArrayEquals(new int[]{2,3,4,5}, util.findTargetIndicies(intArray, 3));
    }

    /**
     * Test for multiple occurence of target at the end of the array
     */
    @Test
    public void multipleOccurence2() {
        int[] intArray = {1,2,3,3,3,3,7,8,9,10,10,10};
        assertArrayEquals(new int[]{9,10,11}, util.findTargetIndicies(intArray, 10));
    }

    /**
     * Test for multiple occurence of target in the start of the array
     */
    @Test
    public void multipleOccurence3() {
        int[] intArray = {1,1,1,2,3,3,3,3,7,8,9,10};
        assertArrayEquals(new int[]{0,1,2}, util.findTargetIndicies(intArray, 1));
    }

    /**
     * Test for target not in input array and target greater than max element in array
     */
    @Test
    public void noOccurenceAtEnd() {
        int[] intArray = {1,2,3,3,3,3,7,8,9,10};
        assertArrayEquals(new int[]{}, util.findTargetIndicies(intArray, 11));
    }

    /**
     * Test for target not in input array and target less than min element in array
     */
    @Test
    public void noOccurenceAtStart() {
        int[] intArray = {1,2,3,3,3,3,7,7,8,9,10};
        assertArrayEquals(new int[]{}, util.findTargetIndicies(intArray, 0));
    }

    /**
     * Test for empty input array
     */
    @Test
    public void emptyInput() {
        int[] intArray = {};
        assertArrayEquals(new int[]{}, util.findTargetIndicies(intArray, 0));
    }

    /**
     * Test for input array with elements as target
     */
    @Test
    public void allMatch() {
        int[] intArray = {1,1,1,1,1};
        assertArrayEquals(new int[]{0,1,2,3,4}, util.findTargetIndicies(intArray, 1));
    }

    /**
     * Test for input with all negative numbers and no match for target
     */
    @Test
    public void allNegative() {
        int[] intArray = {-1, -41, -44, -75, -37, -48, -35, -46, -100, -25};
        assertArrayEquals(new int[]{}, util.findTargetIndicies(intArray, 1));
    }

    /**
     * Tests array with integer limit values
     */
    @Test
    public void limitsOfInteger() {
        int[] intArray = {Integer.MAX_VALUE, -1, 0, 1, Integer.MIN_VALUE};
        assertArrayEquals(new int[]{2}, util.findTargetIndicies(intArray, 1));
    }

    /**
     * Tests if method throws excepton if input is null
     */
    @Test
    public void isInputNull() {
        assertThrows(NullPointerException.class, () -> { util.findTargetIndicies(null, 1); });
    }
}

