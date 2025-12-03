public class PrintArrayWithMaxSubarraySum {

    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};

        System.out.println(printMaxSubarraySum(arr)[0]);
        System.out.println(printMaxSubarraySum(arr)[1]);

    }

    public static int[] printMaxSubarraySum(int[] nums) {
        int sum=0;
        int maxSum=nums[0];
        int[] result= new int[2];

        for(int i=0;i<nums.length;i++){
            if(nums[i]+sum < 0){
                sum=0;
                result[0]=i+1;
                maxSum=Math.max(nums[i],maxSum);
                if(maxSum<0) {
                    result[0]=result[1]=i;
                }
            }
            else{
                sum+=nums[i];
                maxSum=Math.max(sum,maxSum);
                if(maxSum==sum) result[1]=i;
            }
        }
        return  result;
    }
}
