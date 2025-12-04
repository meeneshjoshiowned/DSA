public class SetMatrixZeros {

    public static void main(String[] args) {
        int[][] arr={{1,1,1},{1,0,1},{1,1,1}};
        setZeros(arr);
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.println(arr[i][j]);
            }
        }
    }

    public static void setZeros(int[][] matrix){
        boolean firstRowZeros=false,firstColZeros=false;
        for(int i=0;i< matrix.length;i++){
            if(matrix[i][0]==0){
                firstColZeros=true;
                break;
            }
        }
        for(int i=0;i< matrix[0].length;i++){
            if(matrix[0][i]==0){
                firstRowZeros=true;
                break;
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j< matrix[0].length;j++){
                if(matrix[i][j]==0) {
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }

        for(int i=matrix.length-1;i>=1;i--){
            for(int j= matrix[0].length-1;j>=1;j--){
                if(matrix[i][0]==0 || matrix[0][j]==0) matrix[i][j]=0;
            }
        }

        if(firstColZeros==true){
            for(int i=0;i< matrix.length;i++){
                matrix[i][0]=0;
            }
        }

        if(firstRowZeros==true){
            for(int i=0;i< matrix[0].length;i++){
                matrix[0][i]=0;
            }
        }
    }
}
