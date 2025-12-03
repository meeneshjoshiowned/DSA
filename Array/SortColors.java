public class SortColors {

    public static void main(String[] args) {
        int[] arr = {2,0,2,1,1,0};
        sortColors(arr);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public static void sortColors(int[] nums){
        int low=0,mid=0,high=nums.length-1;
        while(mid<=high){
            if(nums[mid]==0){
                swap(low,mid,nums);
                low++;
                mid++;
            } else if (nums[mid]==1) {
                mid++;
            }else {
                swap(mid,high,nums);
                high--;
            }
        }


    }


    public static void swap(int num1,int num2,int[] nums){
        int sum=nums[num1]+nums[num2];
        nums[num2]=sum-nums[num2];
        nums[num1]=sum-nums[num2];
    }

}
