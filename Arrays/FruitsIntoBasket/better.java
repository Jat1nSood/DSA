class Solution {
    public static int totalFruits(int n, int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int r = 0;
        int maxi = 0;
        
        while(r < n){
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);
           
            
            if(map.size() > 2){
                map.put(arr[l], map.getOrDefault(arr[l], 0) - 1);
                if(map.get(arr[l]) == 0)
                    map.remove(arr[l]);
                l++;
                
            }
            if(map.size() <= 2)
                maxi = Math.max(maxi, r - l + 1);
            r++;
        }
        return maxi;
    }
}