import java.util.*;

public class better {

    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        Set<List<Integer>>set = new HashSet<>();

        for(int i = 0; i < n - 1; i++){
            Set<Integer>elements = new HashSet<>();

            for(int j = i + 1; j < n; j++){
                int third = - (nums[i] + nums[j]);
                if(elements.contains(third)){
                    List<Integer> triplets = new ArrayList<>();
                    triplets.add(nums[i]);
                    triplets.add(nums[j]);
                    triplets.add(third);
                    triplets.sort(null);
                    set.add(triplets);
                }
                elements.add(nums[j]);
        }
    }

    ans.addAll(set);
    return ans;

    }
    
}
