package mettle;

import java.util.ArrayList;
import java.util.List;

public class Util {

    /**
     * Swaps values at indices i,j in the given input array 
     * @param nums Input array
     * @param i First index
     * @param j Second index
     */
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * Partition the array using the starting element as pivot
     * @param nums Array to be sorted
     * @param start Starting index of the subarray 
     * @param end Last index of the subarray
     * @return partition index of the subarray
     */
    public int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        int i = start+1;
        int j = start+1;
        while(i <= end) {
            if(nums[i] <= pivot && i!=j ) {
                swap(nums, i,j);
                j++;
            }
            i++;
        }
        swap(nums, start, j-1);
        return j-1;
    }

    /**
     * Sorts the given input array
     * @param nums Array to be sorted
     * @param start Start index
     * @param end Last index
     */
    public void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            int pi = partition(nums, start, end);
            quickSort(nums, start, pi - 1);
            quickSort(nums, pi + 1, end);
        }
    }

    /**
     * Searches the target in the input array
     * @param nums Array to search
     * @param target Target to search
     * @return index of the first occurence of the target element if present else -1
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = -1;
        int ans = -1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /**
     * Sorts the given input array and return the array of indices of the given target in the sorted array
     * @param nums - Array of numbers to be sorted and searched for target
     * @param target - Number to be searched
     * @return Array of indicies
     */
    public int[] findTargetIndicies(int[] nums, int target) throws NullPointerException {
        if(nums == null) {
            throw new NullPointerException();
        }
        List<Integer> indicies = new ArrayList<>();
        quickSort(nums, 0, nums.length-1);
        int firstOccurence = binarySearch(nums, target);
        if (firstOccurence < 0) {
            return new int[] {};
        }
        while (firstOccurence < nums.length && nums[firstOccurence] == target) {
            indicies.add(firstOccurence);
            firstOccurence++;
        }
        return indicies.stream().mapToInt(i -> i).toArray();
    }
}