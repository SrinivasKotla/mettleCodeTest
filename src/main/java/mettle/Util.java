package mettle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int mid = -1;
        int ans = -1;
        while(left <= right) {
            mid = left + (right-left)/2;
            if(nums[mid] == target) {
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

    public int[] findTargetIndicies(int[] nums, int target) {
        List<Integer> indicies = new ArrayList<>();
        Arrays.sort(nums);
        int firstOccurence = binarySearch(nums, target);
        if(firstOccurence < 0) {
            return new int[]{};
        }
        while(firstOccurence < nums.length && nums[firstOccurence] == target) {
            indicies.add(firstOccurence);
            firstOccurence++;
        }
        return indicies.stream().mapToInt(i -> i).toArray();
    }
}