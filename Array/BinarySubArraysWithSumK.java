import java.util.HashMap;

public class BinarySubArraysWithSumK {

    public static void main(String[] args) {

        int[] nums = {1,0,1,0,1};
        System.out.println(numSubarraysWithSum(nums,2));

    }
    //  Approach :   try to find number of subarrays with sum <= target
    // then use same function to find subarrays with sum <= target-1
    // and subtract them
    private static int atMost(int[] nums, int k) {
        // No valid subarray for negative sum
        if (k < 0) return 0;

        int left = 0;
        int sum = 0;
        int count = 0;

        // Traverse array using right pointer
        for (int right = 0; right < nums.length; right++) {
            // Add current element to sum
            sum += nums[right];

            // Shrink window if sum exceeds k
            while (sum > k) {
                sum -= nums[left];
                left++;
            }

            // Add number of valid subarrays ending at right
            count += (right - left + 1);
        }

        return count;
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        // Return difference between atMost(goal) and atMost(goal - 1)
        return atMost(nums, goal) - atMost(nums, goal - 1);
    }
}
