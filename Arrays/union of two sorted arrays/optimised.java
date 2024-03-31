import java.util.*;

public class optimised {

    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        
        ArrayList<Integer>ans = new ArrayList<>();
        
        int i = 0;
        int j = 0;
        if(arr1[0] < arr2[0]){
            ans.add(arr1[0]);
            i += 1;
        }
        else{
            ans.add(arr2[0]);
            j += 1;
        }
        
        
        while(i < n  && j < m){
            
            int top = ans.get(ans.size()  - 1);
            
            if(arr1[i] == top) i+= 1;
            else if(arr2[j] == top) j+= 1;
            
            else if(arr1[i] < arr2[j]){
                ans.add(arr1[i]);
                i += 1;
            }
            
            else{
                ans.add(arr2[j]);
                j+=1;
            }
            
            
        }
        
        if(i == n  && j != m){
            while(j < m){
                int top = ans.get(ans.size()  - 1);
                if(arr2[j] == top){
                    j += 1;
                    continue;
                }
                ans.add(arr2[j]);
                j += 1;
            }
            
            return ans;
        }
        
        if(j == m && i != n){
            while(i < n){
                int top = ans.get(ans.size()  - 1);
                if(arr1[i] == top){
                    i += 1;
                    continue;
                }
                ans.add(arr1[i]);
                i += 1;
                
            }
            
            return ans;
        }
        
        
        return ans;
    }
    
}
