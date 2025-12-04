public class ReArrangeArrayElementsBySign {

    public static void main(String[] args) {
        int[] arr={3,1,-2,5,-2,-4};
        for(int i=0;i< arr.length;i++){
            System.out.println(rearrangeArrayElements(arr)[i]);
        }
    }

    public static int[] rearrangeArrayElements(int[] arr){
        int pos=0,neg=1;
        int[] result= new int[arr.length];
        for(int i=0;i< arr.length;i++){
            if(arr[i]>0){
                result[pos]=arr[i];
                pos+=2;
            }
            else{
                result[neg]=arr[i];
                neg+=2;
            }
        }
        return result;
    }
}
