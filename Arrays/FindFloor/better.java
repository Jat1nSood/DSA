
public class better {

    static int findFloor(long arr[], int n, long x)
    {
        if( x < arr[0]) return -1;
        
        
        int left = 0;
        int right = n - 1;
        long minDiff = x;
        int minEl = -1;
        while(left <= right){
            int mid = (right + left) /2;
            long diff;
            if(arr[mid] == x){
                return mid;
            }
            
            else if(arr[mid] < x){
                minEl = mid; 
                left = mid + 1;
            }
            
            else{
                
                right = mid -1;
            }
            
        }
        
        return minEl;
        
    }
    
}
