public class AssignCookies {

    public static void main(String[] args) {
        int[] g = {1,5,7,13};
        int[] s = {1,2,3,13,19};

        System.out.println(assignCookies(g,s));
    }

    public static int assignCookies(int[] g,int[] s) {
        int m=g.length;
        int n=s.length;
        int i=0,j=0;
        while(i<m && j<n){
            if(g[i]<=s[j]){
                i++;
            }
            j++;
        }
        return i;
    }

}
