import java.util.ArrayList;
import java.util.List;

public class Subset_Sum {
    public static void main(String[] args) {
        //String name = "123";
        //int numbers[] = {5,10,12,13,15,18};
        //int maximum =30;
        //sum of all elements in array
        //int max = 73;
        //subsets_sum(numbers, maximum,0,0,new ArrayList<>());
        //subset("",name);
        //subset problem using tablation
        
        int[] arr = {2,3,5,7,10};
        int sum =14;
       
        if(isSubsetSum(arr, sum)){
            System.out.println("Subset Exist");
        }
        else{
            System.out.println("Subset Not Exists");
        }
    }

    //it is brute force method to select and deselect
    // static void subset(String up,String name){
    //     int sum=0;
    //     if (name.isEmpty()){
    //         for(int i=0;i<up.length();i++){
    //             sum += up.charAt(i)-'0';
    //         }
    //         System.out.println(sum);
    //         System.out.println(up);
    //         return;
    //     }
    //     char ch = name.charAt(0);
    //     subset(up+ch, name.substring(1));
    //     subset(up, name.substring(1));
    // }



    // static void subsets_sum(int[] numbers,int limit,int currsum,int index,List<Integer> subsets){
    //     if(index==numbers.length){
    //         return;
    //     }
    //     if(currsum>limit){
    //         return;
    //     }
    //     if(currsum == limit){
    //         System.out.println(subsets);
    //         return;
    //     }
    //     subsets.add(numbers[index]);
    //     subsets_sum(numbers, limit, currsum+numbers[index],index+1,subsets);
    //     subsets.remove(subsets.size()-1);
    //     subsets_sum(numbers, limit, currsum, index+1,subsets);
    // }


    static boolean isSubsetSum(int[] arr, int sum) {
        int n = arr.length;

    
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

    
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j < arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                }
                else {
                    dp[i][j] = dp[i - 1][j]
                               || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        return dp[n][sum];
    }



}
