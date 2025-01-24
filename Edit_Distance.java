public class Edit_Distance {
// Given two strings s1 and s2 of lengths m and n respectively and below operations that can be performed on s1. Find the minimum number of edits (operations) to convert ‘s1‘ into ‘s2‘.  

// Insert: Insert any character before or after any index of s1
// Remove: Remove a character of s1
// Replace: Replace a character at any index of s1 with some other character.

//It is used in many applications, such as text comparison and spell checking.
    public static void main(String[] args) {
        String name1 = "greek";
        String name2 = "grcck";
        int[][] matrix = new int[name1.length()+1][name2.length()+1];
        int ans = edit_Distance(name1,name2,matrix);
        System.out.println(ans);
        

    }
    static int edit_Distance(String name1,String name2,int[][] matrix){
        int m = name1.length();
        int n = name2.length();
        for (int i = 0; i <= m; i++) {
            matrix[i][0] = i; 
        }
        for (int j = 0; j <= n; j++) {
            matrix[0][j] = j; 
        }
         for(int i =1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(name1.charAt(i-1) == name2.charAt(j-1)){
                    matrix[i][j] = matrix[i-1][j-1];
                }
                else{
                    matrix[i][j] = 1 + Math.min(
                        matrix[i - 1][j], // Deletion
                        Math.min(matrix[i][j - 1], // Insertion
                                 matrix[i - 1][j - 1]) // Replacement
                    );
                }
            }
         }
        return matrix[m][n];
    }
    
}
