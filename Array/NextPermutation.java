public class NextPermutation {

    public static void main(String[] args) {
        int[] arr = {2,3,1};
        nextPermutation(arr);
        for(int i=0;i< arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    // step 1: traverse from last index, find 1st element which has next
    // element greater than the element

    // step 2: again traverse from last index, find the 1st element which is greater
    // than the bp and reverse the array from bp to that element

    public static void nextPermutation(int[] nums ){
        int bp=Integer.MIN_VALUE;
        for(int i= nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1])
            {
                 bp=i;
                System.out.println("bp"+bp);
                break;
            }
        }

        if(bp==Integer.MIN_VALUE){
            reverseArray(nums,0,nums.length-1);
            return;
        }

        int rp=Integer.MIN_VALUE;

        for(int i= nums.length-1;i>bp;i--){
            if(nums[i]>nums[bp])
            {
                 rp=i;
                break;
            }
        }

        int temp=nums[bp];
        nums[bp]=nums[rp];
        nums[rp]=temp;
        reverseArray(nums,bp+1,nums.length-1);
    }

    public static void reverseArray(int[] nums,int i, int j){
        while(i<=j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }
}
