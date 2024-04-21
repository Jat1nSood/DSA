class Solve {
    // m is maximum of number zeroes allowed to flip
    int findZeroes(int arr[], int n, int m) {
        // code here
        
        int l = 0;
        int r = 0;
        int maxLen = 0;
        int zero = 0;
        
        
        while(r < n){
            
            if(arr[r] == 0){
                zero++;
            }
            
            if(zero > m){
                if(arr[l] == 0){
                    zero--;
                }
                l++;
            }
            
            if(zero <= m)
                maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        
        return maxLen;
    }
}