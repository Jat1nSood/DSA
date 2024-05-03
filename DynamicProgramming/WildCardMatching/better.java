
class Solution
{
    boolean helper(String pattern, String str, int i, int j, boolean[][] dp){
        
        if(i < 0 && j >= 0)
            return false;
        if(j < 0 && i < 0)
            return true;
        if(j < 0 && i >= 0 && pattern.charAt(i) == '*'){
            for(int k = 0; k <= i; k++){
                if(pattern.charAt(k) != '*')
                    return false;
            }
            return true;
        }
        
        if(dp[i][j])
            return dp[i][j];
        
        if(pattern.charAt(i) == str.charAt(j) || pattern.charAt(i) == '?')
            return dp[i][j] =  helper(pattern, str, i - 1, j - 1, dp);
        
        if(pattern.charAt(i) == '*'){
            return dp[i][j] =  helper(pattern, str, i-1, j, dp) || helper(pattern, str, i, j-1, dp);
        }
        return false;
    }
    int wildCard(String pattern, String str)
    {
        int n = pattern.length();
        int m = str.length();
        boolean[][] dp = new boolean [n + 1][m + 1];
       
        dp[0][0] = true;
        for(int j = 1; j <= m; j++){
            dp[0][j] = false;
        }
        for(int i = 1; i <= n; i++){
            boolean flag = true;
            for(int ii = 1; ii <= i; ii++){
                if(pattern.charAt(ii - 1) != '*')
                    flag = false;
            }
            dp[i][0] = flag;
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(pattern.charAt(i-1) == str.charAt(j-1) || pattern.charAt(i -1) == '?')
                    dp[i][j] = dp[i-1][j-1];
                else if(pattern.charAt(i-1) == '*')
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                
            }
        }
        
        boolean ans = dp[n][m];
        if(ans)
            return 1;
        return 0;
        
    }
}