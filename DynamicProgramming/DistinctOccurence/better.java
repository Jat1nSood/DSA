*You are required to complete this method*/

class Solution
{
    int MOD = 1000000000 + 7;
    int helper(String s, String t, int i, int j, int[][] dp) {
        if(j < 0)
            return 1;
        if(i < 0)
            return 0;
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] =(((helper(s, t, i-1, j-1, dp) % MOD) + (helper(s, t, i-1, j, dp)% MOD)) % MOD);
        }
        return dp[i][j] = (helper(s, t, i-1, j, dp) % MOD);
        
    }
    int  subsequenceCount(String s, String t)
    {
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n + 1][m + 1];
        
        for(int i = 0; i <= n; i++){
            dp[i][0] = 1;
         }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                     dp[i][j] = ((dp[i-1][j-1] % MOD) + (dp[i-1][j] % MOD)) % MOD;
                }
                else{
                   dp[i][j] = dp[i-1][j] % MOD;
                }
            }
        }
        
        return dp[n][m];
    }
}