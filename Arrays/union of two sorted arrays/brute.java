import java.util.*;

public class brute {

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        Map<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer>ans = new ArrayList<>();
        for(int i = 0; i < n; i++){
            
            if(map.containsKey(arr1[i])) continue;
            ans.add(arr1[i]);
            map.put(arr1[i], 1);
        }
        for(int i = 0; i < m; i++){
            
            if(map.containsKey(arr2[i])) continue;
            map.put(arr2[i], 1);
            ans.add(arr2[i]);
        }
        
        Collections.sort(ans);
        return ans;
    }
    
}
