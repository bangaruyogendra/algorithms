import java.util.Scanner;

public class Longest_Common_Sequence{
    public static void main(String[] args) {
    
        String name1 = "stone";
        String name2 = "longest";
        int r = name1.length();
        int c = name2.length();
        int[][] matrix =new int[r+1][c+1];
        int num =  lcs(name1,name2,matrix);
        System.out.println(num);
    }
    static int lcs(String str1,String str2,int dp[][]){
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        

        return dp[str1.length()][str2.length()];
    }

}