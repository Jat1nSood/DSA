class Solution
{
    //Function to find the minimum number of platforms required at the
    //railway station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n)
    {
        Arrays.sort(arr);
        Arrays.sort(dep);
        
        int maxPlat = 1;
        int curr = 1;
        int i = 1;
        int j = 0;
        
        while(i < n && j < n){
            
            if(arr[i] <= dep[j]){
                curr += 1;
                i += 1;
            }
            
            else if(arr[i] > arr[j]){
                
                curr -= 1;
                j++;
            }
            
            maxPlat = Math.max(maxPlat, curr);
            
        }
        
        return maxPlat;
       
    }
    
}
