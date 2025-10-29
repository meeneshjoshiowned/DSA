import java.util.Arrays;

public class MaxSumNonAdj {
    public static void main(String[] args) {
        int[] nums={1,2,4};
        System.out.println(maxSumNonAdj(nums));
    }

    public static int maxSumNonAdj(int[] nums){
        if(nums.length==0) return 0;
        int[] dp= new int[nums.length];
        Arrays.fill(dp,-1);
        return maxSumNonAdj(nums,0,0,dp);

    }

    public static int maxSumNonAdj(int[] nums, int i, int sum, int[] dp){
        if(i>= nums.length) return sum;
        if(dp[i]!=-1) return dp[i];
        return dp[i]=Math.max(maxSumNonAdj(nums,i+2,sum+nums[i],dp),maxSumNonAdj(nums,i+1,sum,dp));
    }
}
