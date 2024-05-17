class Solution {
    
    // Function to find first occurence of x
    public long findFirst(long v[], long x){
        
        int left = 0;
        int right = v.length -1;
        
        int index = -1;
        while(left <= right){
            
            int mid = left + (right - left)/2;
            
            if(v[mid] == x){
                
                index = mid;
                right = mid -1; 
            }
            else if(v[mid] > x){
                right = mid - 1;
            }
            else{
                left = mid +1;
            }
        }
        return index;
    }
    
    // Function to find last occurence of x
    public long findLast(long v[], long x){
        
        int left = 0;
        int right = v.length -1;
        
        int index = -1;
        while(left <= right){
            
            int mid = left + (right - left)/2;
            
            if(v[mid] == x){
                
                index = mid;
                left = mid +1; 
            }
            else if(v[mid] < x){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return index;
    }
    
    public pair indexes(long v[], long x)
    {
        long first = findFirst(v, x);
        long last = findLast(v, x);
        
        return new pair(first, last);
    }
}