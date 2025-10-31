import java.util.HashMap;

public class CountSubArraysWithSumK {

    public static void main(String[] args) {

        int[] nums = {1,1,1};
        System.out.println(countSubArrays(nums,2));

    }
   //  Approach :   prefix sum algo and hashmap
    public static int countSubArrays(int[] nums, int target){
        HashMap<Integer,Integer> prefixSumMap= new HashMap<Integer, Integer>();
        int sum=0;
        int count=0;
        prefixSumMap.put(0,1);
        for(int i:nums){
            sum+=i;
            prefixSumMap.put(sum,prefixSumMap.containsKey(sum) ? prefixSumMap.get(sum)+1 : 1);
            if(prefixSumMap.containsKey(sum-target)) count+=prefixSumMap.get(sum-target);
        }
        return count;
    }
}
