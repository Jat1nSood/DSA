//TC of the below solution is O(nlogn) + O(n^2)
//SC is O(x) where x = number of triplets

import java.util.*;

public class optimised {

    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        int i = 0;
        int k;
        int j;

        List<List<Integer>>ans = new ArrayList<>();
        Set<List<Integer>>set = new HashSet<>();
        Arrays.sort(nums);
        for(i = 0; i < n-2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            j = i + 1;
            k = n - 1;
            while( j < k){

                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer>triplet = new ArrayList<>();
                    triplet.add(nums[i]);
                    triplet.add(nums[j]);
                    triplet.add(nums[k]);
                    triplet.sort(null);
                    set.add(triplet);
                    j++;
                    k--;
                    while(j < k && nums[j] == nums[j - 1]) j++;
                    while(j < k && nums[k] == nums[k + 1]) k--;         
                }

                else if(sum < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        
        ans.addAll(set);
        return ans;
    }
    
}
