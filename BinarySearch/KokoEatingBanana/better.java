
class Solution {
    
    // O(n)
    public static int findMaxBananasKokoCanEat(int[] arr, int n){
         int max = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
    
    //O(n)
    public static int totalHourTaken(int bananas, int[] arr, int n){
        
        double total = 0;
        for(int i = 0; i < n; i++){
            
            total += Math.ceil((double)arr[i]/(double)bananas);
        }
        
        return (int) total;
    }
    public static int Solve(int n, int[] arr, int h) {
        
        int max = findMaxBananasKokoCanEat(arr, n);
        int left = 1;
        int right = max;
        int ans = max;
        
        //O(log max)
        while(left <= right){
            
            int mid = left + (right - left)/2;
            int totalHours = totalHourTaken(mid, arr, n);
            
            if(totalHours <= h){
                ans = mid;
                right = mid -1; 
            }
            else{
                left = mid +1;
            }
            
        }
       return ans;
    }
}