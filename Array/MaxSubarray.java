public class MaxSubarray {
    public static void main(String[] args) {
        int[] arr = {-1};

        System.out.println(maxSubarraySum(arr));
    }


    // Kadane's Algo

    public static int maxSubarraySum(int[] nums) {
        int sum=0;
        int maxSum=nums[0];

        for(int i=0;i<nums.length;i++){
            if(nums[i]+sum < 0){
                sum=0;
                maxSum=Math.max(nums[i],maxSum);
            }
            else{
                sum+=nums[i];
                maxSum=Math.max(sum,maxSum);
            }
        }
        return  maxSum;
    }
}
