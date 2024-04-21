class Solution
{
    
    public int helper(int i, int j, String S1, String S2, int[][] dp){
        
        if(i < 0 || j < 0){
            return 0;
        }
        
        if(dp[i][j] != -1){
            
            return dp[i][j];
        }

        if(S1.charAt(i) == S2.charAt(j)){
            
            return dp[i][j] =  1  + helper(i - 1, j - 1, S1, S2, dp);
        }
        
        return dp[i][j] =  Math.max(helper(i - 1, j, S1, S2, dp), helper(i, j - 1, S1, S2, dp));
    }
    public int longestPalinSubseq(String S1)
    {
        StringBuilder sb = new StringBuilder(S1);
        sb.reverse();
        String S2 = sb.toString();
        int n = S1.length();
        int[][] dp = new int[n + 1][n + 1];
        
        for(int i = 0; i <= n; i++){
            dp[0][i] = 0;
            dp[i][0] = 0;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1;  j <= n; j++){
                
                if(S1.charAt(i - 1) == S2.charAt(j - 1)){
                    dp[i][j] = 1 +  dp[i - 1][j - 1];
                }
                
                else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        return dp[n][n];

    }
}