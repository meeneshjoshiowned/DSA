public class MajorityElement {

    public static void main(String[] args) {
        int[] arr = {10,9,9,9,10};
        System.out.println(majorityElement(arr));
    }

    // more than n/2 times

    public static int majorityElement(int[] arr){
        int count=0;
        int curr=arr[0];
        for(int i=0;i<arr.length;i++){
            if(curr==arr[i]) count++;
            if(curr!=arr[i]) count--;
            if(count<0){
                curr=arr[i];
                count=1;
            }
        }
        return curr;
    }
}
