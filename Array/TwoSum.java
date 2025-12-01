import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        System.out.println(twoSum(arr,9)[0]);
        System.out.println(twoSum(arr,9)[1]);

    }

    public static int[] twoSum(int[] nums,int target){
          int[] result = new int[2];
          HashMap<Integer,Integer> storeSum= new HashMap<>();
          for(int i=0;i<nums.length;i++){
              if(storeSum.keySet().contains(target-nums[i])){
                 result[0]=i;
                 result[1]=storeSum.get(target-nums[i]);
              }
              else{
                  storeSum.put(nums[i],i);
              }
          }
          return result;
    }

}
