// TC of this code is O(n^3) 
// SC is O(x) x = Number of triplets

import java.util.*;
public class brute {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Set<List<Integer>> set = new HashSet<>();
        for(int i = 0; i < n - 2; i++){
            for(int j = i + 1; j < n - 1; j++){
                for(int k = j + 1; k < n; k++){
                    

                    if(nums[i] + nums[j] + nums[k] == 0){
                        List<Integer> triplets = new ArrayList<>();
                        triplets.add(nums[i]);
                        triplets.add(nums[j]);
                        triplets.add(nums[k]);
                        triplets.sort(null);
                        set.add(triplets);
                    }
            }
        }
        
    }

     ans.addAll(set);
    return ans;

    }
    
}
