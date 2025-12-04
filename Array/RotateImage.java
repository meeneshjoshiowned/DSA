public class RotateImage {
    public static void main(String[] args) {
        int[][] arr={{1,2,3},{4,5,6},{7,8,9}};
        rotateImage(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.println(arr[i][j]);
            }
        }

    }

    public static void rotateImage(int[][] matrix){
        for(int i=0;i<matrix.length;i++){
            for(int j=i+1;j<matrix[0].length;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }

        int len;
        if(matrix[0].length%2==0)   len=matrix[0].length/2;
        else  len=matrix[0].length/2 +1;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<len;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[i][matrix[0].length-1-j];
                matrix[i][matrix[0].length-1-j]=temp;
            }
        }
    }

}
