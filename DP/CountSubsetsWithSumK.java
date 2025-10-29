public class CountSubsetsWithSumK {

    public static void main(String[] args) {
        int[] arr={2,3,5,16,8,10};
        int k=10;
        System.out.println(countSubsetsWithSumK(k,arr,0));
    }

    public static int countSubsetsWithSumK(int k,int[] arr,int i){
        if(k==0) return 1;
        if(k<0 || i>arr.length-1) return 0;
        int leftCount = countSubsetsWithSumK(k-arr[i],arr,i+1);
        int rightCount = countSubsetsWithSumK(k,arr,i+1);
        return leftCount+rightCount;
    }
}
