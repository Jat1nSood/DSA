
class Solution {
    public int helper(int i, int j, String s, String t, int[][] dp){
        
        if(i < 0)
            return j+1;
        if(j<0)
            return i+1;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s.charAt(i) == t.charAt(j))
            return dp[i][j] = 0 + helper(i-1, j-1, s, t, dp);
        
        return dp[i][j] = 1 + Math.min(Math.min(helper(i-1, j-1, s, t, dp), helper(i, j-1, s, t, dp)), helper(i-1, j, s, t, dp));
    }
    public int editDistance(String s, String t) {
        // Code here
        int n = s.length();
        int m = t.length();
        int[][] dp= new int[n + 1][m+1];
        
        for(int i=0; i<=n; i++){
            dp[i][0] = i;
        }
        for(int i = 0; i <= m; i++){
            dp[0][i] = i;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 0 + dp[i-1][j-1];
                else
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]);
            }
        }
        
        return dp[n][m];
    }
}