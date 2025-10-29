import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(LCS("ace","abcde"));
    }

    public static int LCS(String text1, String text2) {
        int lcsUsingRecursion= LCS1(text1, text2,0,0,text1.length(),text2.length());

        int[][] dp= new int[text1.length()][text2.length()];
        for(int[] rows:dp){
            Arrays.fill(rows,-1);
        }
        int lcsUsingDPMemo= LCS2(text1, text2,0,0,text1.length(),text2.length(),dp);

        System.out.println(lcsUsingDPMemo);
        System.out.println(lcsUsingRecursion);
        return  lcsUsingDPMemo;
    }

    // using recursion

    public static int LCS1(String text1, String text2, int i, int j, int m, int n) {
         if(i== text1.length() || j==text2.length()) return 0;
         if(text1.charAt(i)==text2.charAt(j)) {
             return 1 + LCS1(text1,text2,i+1,j+1,m,n);
         }
         else{
             return Math.max(LCS1(text1,text2,i+1,j,m,n),LCS1(text1,text2,i,j+1,m,n));
         }
    }

    // using DP -- memoization
    public static int LCS2(String text1, String text2, int i, int j, int m, int n, int[][] dp) {
        if(i== text1.length() || j==text2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j)) {
            return dp[i][j]=1 + LCS2(text1,text2,i+1,j+1,m,n, dp);
        }
        else{
            return dp[i][j]=Math.max(LCS2(text1,text2,i+1,j,m,n, dp),LCS2(text1,text2,i,j+1,m,n, dp));
        }
    }
}
