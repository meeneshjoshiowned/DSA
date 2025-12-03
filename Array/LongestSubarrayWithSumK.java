public class LongestSubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr={1,8,3,2,0,3,1,1,2,2,2,1,4,1,1};
        int k=9;
        System.out.println(longestSubarrayWithSumk(arr,k));
    }

    public static int longestSubarrayWithSumk(int[] nums,int k){
         int left=0;
         int right=0;
         int sum=0;
         int len=0,maxLen=0;
         while(right<nums.length){
             if(nums[right]+sum<=k){
                 sum+=nums[right];
             } else if (nums[right]+sum>k) {
                 while(nums[right]+sum>=k) {
                     sum -= nums[left];
                     left++;
                 }
                 sum+=nums[right];
             }
             if(sum==k) {
                 len = right - left + 1;
                 maxLen = Math.max(len, maxLen);
             }
             right++;
         }
         return maxLen;
    }
}
