import java.util.ArrayList;

public class WordSearch {
    public static void main(String[] args) {
        String[][] board = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
        String word = "ABCCFDEES";
        System.out.println(wordSearch(board,word));
    }

    public static boolean wordSearch(String board[][], String word){
        int m = board.length;
        int n = board[0].length;
        int index=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j].equals(String.valueOf(word.charAt(i)))){
                   if(nextSearch(index,board,word,i,j,m,n)) return true;
                }
            }
        }
        return false;
    }

    public static boolean nextSearch(int index,String[][] board,String word,int i,int j,int m,int n){
        if(index == word.length()) return true;
        if(i<0 || j<0 || i == m || j == n || !board[i][j].equals(String.valueOf(word.charAt(index))) || board[i][j].equals("!")) return false;

        String temp= board[i][j];
        board[i][j]="!";

        boolean left = nextSearch(index+1,board,word,i,j-1,m,n);
        boolean right = nextSearch(index+1,board,word,i,j+1,m,n);
        boolean bottom = nextSearch(index+1,board,word,i+1,j,m,n);
        boolean top = nextSearch(index+1,board,word,i-1,j,m,n);

        board[i][j]=temp;

        return left || top || bottom || right;

    }
}
