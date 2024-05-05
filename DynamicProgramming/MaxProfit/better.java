
class Solution {
    static int helper(int ind, int buy, int[] a, int cap, int n, int[][][] dp){
        
        if(ind == n || cap == 0)
            return 0;
            
        if(dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];
        if(buy == 1){
            return dp[ind][buy][cap] =  Math.max(-a[ind] + helper(ind+1, 0, a, cap, n, dp), 0 + helper(ind+1, 1, a, cap, n, dp));
        }
        
        return dp[ind][buy][cap] = Math.max(a[ind] + helper(ind+1, 1, a, cap-1, n, dp), 0 + helper(ind+1, 0, a, cap, n, dp));
    }
    static int maxProfit(int K, int N, int a[]) {
        // code here
        int[][][] dp = new int[N+1][2][K+1];
        // for(int i = 0; i < N; i++){
        //     for(int j = 0; j < 2; j++){
        //         Arrays.fill(dp[i][j], -1);
        //     }
            
        // }
            
        for(int ind = N-1; ind >=0; ind--){
            for(int buy = 0; buy<= 1; buy++){
                for(int cap = 1; cap <= K; cap++){
                    if(buy == 1){
                        dp[ind][buy][cap] =  Math.max(-a[ind] + dp[ind+1][0][cap], 0 + dp[ind+1][1][cap]);
                    }
                    else{
                        dp[ind][buy][cap] = Math.max(a[ind] + dp[ind+1][1][cap-1], 0 + dp[ind+1][0][cap] );
                    }
                    
                }
            }
        }
        
        return dp[0][1][K];
    }
}