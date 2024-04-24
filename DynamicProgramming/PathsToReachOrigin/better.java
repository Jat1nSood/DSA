
class Solution
{   
    public static int helper(int n, int m, int[][] dp){
        
        // if(n < 0 || m < 0){
        //     return 0;
        // }
        if(n == 0 && m == 0){
            return 1;
        }
        
        if(dp[n][m] != -1){
            
            return dp[n][m];
        }
        
        int left = 0;
        if(m - 1 >= 0)
            left = helper(n, m - 1, dp);
        
        int up = 0;
        if(n - 1 >= 0)
            up = helper(n - 1, m, dp);
        
        return dp[n][m] = (up + left) %  1000000007;
    }
    public static int ways(int n, int m)
    {
        int [][] dp = new int[n + 1][m + 1];
        
       
        
        for(int i = 0; i < n + 1; i++){
            
            dp[i][0] = 1;
        }
        
        for(int i = 0; i < m + 1; i++){
            
            dp[0][i] = 1;
        }
        
        for(int i = 1; i < n + 1; i++){
            
            for(int j = 1; j < m + 1; j++){
                
                dp[i][j] = ((dp[i - 1][j] % 1000000007) + (dp[i][j - 1] % 1000000007)) % 1000000007;
                
            }
        }
        
        return dp[n][m];
    }
}