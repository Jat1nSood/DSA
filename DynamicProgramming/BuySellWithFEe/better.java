class Solution {
    
    public long helper(int i, int buy, long[] arr, int fee){
        
        if(i == arr.length){
            
            return 0;
        }
        
        if(buy == 1){
            return Math.max(-arr[i] + helper(i + 1, 0, arr, fee), 0 + helper(i + 1, 1, arr, fee));
        }
        
        
        return Math.max(arr[i] + helper(i + 1, 1, arr, fee) - fee, 0 + helper(i + 1, 0, arr, fee));
    }
    public long maximumProfit(long arr[], int n, int fee) {
        // Code here
        long dp[][] = new long[n+1][2];
        
        
        for(int i = n-1; i >= 0; i--){
            for(int buy = 0; buy < 2; buy++){
                if(buy == 1){
                    dp[i][buy] =  Math.max( -arr[i] + dp[i+1][0], 0 + dp[i+1][1] );
                }
                else{
                    dp[i][buy] =  Math.max( arr[i] + dp[i+1][1] - fee, 0 + dp[i+1][0]);
                }
                
            }
        }
        return dp[0][1];
        
    }
}